/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.dao;

import FabricaDeConexao.ConexaoFireBird;
import FabricaDeConexao.EfetuaConeccao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.bean.Combinacoes;
import modelo.bean.CombinacoesDTO;
import modelo.bean.FifteenPoints;

/**
 *
 * @author Pituba
 */
public class TotalProbabilidadeDAO {

    int quantidade = 0;

    Connection con = ConexaoFireBird.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public PreparedStatement getStmt() {
        return stmt;
    }

    public void setStmt(PreparedStatement stmt) {
        this.stmt = stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public void salvar_probabilidades(String probabilidade) {

        Connection con = ConexaoFireBird.getConnection();
        PreparedStatement stmt = null;
        Combinacoes combinacoes = new Combinacoes();
        
        try {
            stmt = con.prepareStatement("INSERT INTO TB_COMBINATIONS(COMBINATION) VALUES(?)");
            stmt.setString(1, probabilidade.trim());
            stmt.executeUpdate();
            quantidade += 1;
            //combinacoes.setTotal(quantidade);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro:\n" + ex + "\n ao tentar salvar probabilidades");
            //"Bingo", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (quantidade == 3268760) {
                ConexaoFireBird.closeConnection(con, stmt);
            }
            if (quantidade % 6499 == 0) {
                ConexaoFireBird.closeConnection(con, stmt);
                try {
                    ConexaoFireBird conectar = new ConexaoFireBird();
                    conectar.getConnection();
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "ERRO: " + ex + " ao reconectar", "Bingo",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERRO: " + ex + " ao reconectar", "Bingo",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }

        }

    }

    public List<Combinacoes> TotalCombinacoes() {
     
        List<Combinacoes> todasascombinacoes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from TB_COMBINATIONS order by ID_COMBINATION");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Combinacoes combinacoes = new Combinacoes();
                combinacoes.setIdcombinacao(rs.getInt("ID_COMBINATION"));
                combinacoes.setCombinacao(rs.getString("COMBINATION"));
                todasascombinacoes.add(combinacoes);
            }
            }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex, "Bingo", JOptionPane.ERROR_MESSAGE);
        }
            return todasascombinacoes;
        }
    
    public List<Combinacoes> CombinacoesSelecionadas(int idinicial, int idfinal){
        
        List<Combinacoes> combinacoesselecionadas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from TB_COMBINATIONS CB " +
                                        "where CB.ID_COMBINATION \n" +
                                        "between ? and ? order by CB.ID_COMBINATION");
            stmt.setInt(1, idinicial);
            stmt.setInt(2, idfinal);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Combinacoes combinacoes = new Combinacoes();
                combinacoes.setIdcombinacao(rs.getInt("ID_COMBINATION"));
                combinacoes.setCombinacao(rs.getString("COMBINATION"));
                combinacoesselecionadas.add(combinacoes);
            }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex, "Bingo", JOptionPane.ERROR_MESSAGE);
        }
        
        return combinacoesselecionadas;
    }

   public CombinacoesDTO CombinacaoUltimoSorteio(){
       CombinacoesDTO combinacaoultimosorteio = new CombinacoesDTO();
       
        try {
            stmt = con.prepareStatement("select CB.ID_COMBINATION, CB.COMBINATION, FF.ID_COMB_FIFTEEN, " +
                      "FF.QTD_FIFTEENPOINTS, QF.QTDE_FOURTEENPOINTS" +
                      " from TB_COMBINATIONS CB\n" +
                      "join TB_FIFTEENPOINTS FF on FF.REF_COMB_FIFTEEN = CB.ID_COMBINATION\n" +
                      "join TB_QTDE_FOURTEENPOINTS QF on QF.REF_TB_FIFTEEN = FF.ID_COMB_FIFTEEN\n" +
                      "where FF.ID_COMB_FIFTEEN = (select max(FF.ID_COMB_FIFTEEN) from TB_FIFTEENPOINTS FF)");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){;
                combinacaoultimosorteio.setIdcombinacao(rs.getInt("ID_COMBINATION"));
                combinacaoultimosorteio.setCombinacao(rs.getString("COMBINATION"));
                combinacaoultimosorteio.setRefcombfifteen(rs.getString("ID_COMB_FIFTEEN"));
                combinacaoultimosorteio.setQtdfifteenpoints(rs.getInt("QTD_FIFTEENPOINTS"));
                combinacaoultimosorteio.setQtdeFourteenPoints(rs.getInt("QTDE_FOURTEENPOINTS"));
            }
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex, "Bingo", JOptionPane.ERROR_MESSAGE);
        }
        return combinacaoultimosorteio;
   }
   
      public FifteenPoints IdUltimoSorteio(){
       FifteenPoints idUltimoSorteio = new FifteenPoints();
       
        try {
            stmt = con.prepareStatement("select max(ID_COMB_FIFTEEN) from TB_FIFTEENPOINTS)");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){;
                idUltimoSorteio.setIdcombfifteen(rs.getInt("ID_COMB_FIFTEEN"));
                
            }
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex, "Bingo", JOptionPane.ERROR_MESSAGE);
        }
        return idUltimoSorteio;
   }
    
    public List<Combinacoes> TotalCombinacoesEmOrdem() {
     
        List<Combinacoes> todasascombinacoes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select COMBINATION from TB_COMBINATIONS order by COMBINATION");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Combinacoes combinacoes = new Combinacoes();
                combinacoes.setCombinacao(rs.getString("COMBINATION"));
                todasascombinacoes.add(combinacoes);
            }
            }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex, "Bingo", JOptionPane.ERROR_MESSAGE);
        }
            return todasascombinacoes;
        }
    
    public List<Combinacoes> CombinacoesSelecionadasContendoDezenas(int idinicial, int idfinal, String dez1, String dez2, String dez3, String dez4,
            String dez5, String dez6, String dez7, String dez8, String dez9, String dez10, String dez11, String dez12, String dez13, String dez14
            , String dez15, String dez16, String dez17, String dez18, String dez19, String dez20){
        
        List<Combinacoes> combinacoesSelecionadasContendoDezenas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from TB_COMBINATIONS TC\n" +
                    "where TC.ID_COMBINATION between ? and ?\n" +
                    "and TC.COMBINATION containing ?\n" +
                    "and TC.COMBINATION containing ?\n" +
                    "and TC.COMBINATION containing ?\n" +
                    "and TC.COMBINATION containing ?\n" +
                    "and TC.COMBINATION containing ?\n" +
                    "and TC.COMBINATION containing ?\n" +
                    "and TC.COMBINATION containing ?\n" +
                    "and TC.COMBINATION containing ?\n" +
                    "and TC.COMBINATION containing ?\n" +
                    "and TC.COMBINATION containing ?\n" +
                    "and TC.COMBINATION not containing ?\n" +
                    "and TC.COMBINATION not containing ?\n" +
                    "and TC.COMBINATION not containing ?\n" +
                    "and TC.COMBINATION not containing ?\n" +
                    "and TC.COMBINATION not containing ?\n" +
                    "and TC.COMBINATION not containing ?\n" +
                    "and TC.COMBINATION not containing ?\n" +
                    "and TC.COMBINATION not containing ?\n" +
                    "and TC.COMBINATION not containing ?\n" +
                    "and TC.COMBINATION not containing ?");
            
            stmt.setInt(1, idinicial);
            stmt.setInt(2, idfinal);
            stmt.setString(3, dez1);
            stmt.setString(4, dez2);
            stmt.setString(5, dez3);
            stmt.setString(6, dez4);
            stmt.setString(7, dez5);
            stmt.setString(8, dez6);
            stmt.setString(9, dez7);
            stmt.setString(10, dez8);
            stmt.setString(11, dez9);
            stmt.setString(12, dez10);
            stmt.setString(13, dez11);
            stmt.setString(14, dez12);
            stmt.setString(15, dez13);
            stmt.setString(16, dez14);
            stmt.setString(17, dez15);
            stmt.setString(18, dez16);
            stmt.setString(19, dez17);
            stmt.setString(20, dez18);
            stmt.setString(21, dez19);
            stmt.setString(22, dez20);
         
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Combinacoes combinacoes = new Combinacoes();
                combinacoes.setIdcombinacao(rs.getInt("ID_COMBINATION"));
                combinacoes.setCombinacao(rs.getString("COMBINATION"));
                combinacoesSelecionadasContendoDezenas.add(combinacoes);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex, "Bingo", JOptionPane.ERROR_MESSAGE);
        }
        return combinacoesSelecionadasContendoDezenas;
    }
    
    public void FecharConeccao() {
        ConexaoFireBird.closeConnection(con, stmt, rs);
    }

}

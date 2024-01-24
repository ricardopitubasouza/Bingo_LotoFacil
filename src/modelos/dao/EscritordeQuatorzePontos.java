/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.dao;

import FabricaDeConexao.ConexaoFireBird;
import static ViewBingo.frmSalvarTrezeeQuatorzePontos.lblPercentual;
import static ViewBingo.frmSalvarTrezeeQuatorzePontos.lblProcessando;
import static ViewBingo.frmSalvarTrezeeQuatorzePontos.pgbProcessando;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.bean.Combinacoes;
import modelo.bean.FifteenPoints;
import modelo.bean.FourteenPoints;
import modelo.bean.TotaldeRepeticoes;

/**
 *
 * @author Pituba
 */
public class EscritordeQuatorzePontos {

    String retorno;
    int retornoid;

    Connection con = ConexaoFireBird.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public int getRetornoid() {
        return retornoid;
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
    
    public List<FourteenPoints> CombinacoesQuatorzePontos(Integer idinicial, Integer idfinal) {
        
        List<FourteenPoints> combinacoesquatorzepontos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from TB_FOURTEENPOINTS "
                    + " where ID_COMB_FOURTEEN between ? and ? order by ID_COMB_FOURTEEN");
            stmt.setInt(1, idinicial);
            stmt.setInt(2, idfinal);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                FourteenPoints fourteenpoints = new FourteenPoints();
                fourteenpoints.setIdcombfourteen(rs.getInt("ID_COMB_FOURTEEN"));
                fourteenpoints.setRefcombfourteen(rs.getInt("REF_COMB_FOURTEEN"));
                fourteenpoints.setQtdefourteenpoints(rs.getInt("QTD_FOURTEENPOINTS"));
                combinacoesquatorzepontos.add(fourteenpoints);
                //JOptionPane.showMessageDialog(null, fifteenpoints.getRefcombfifteen());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex + "/n ao buscar a lista de sorteios!",
                    "Bingo", JOptionPane.ERROR_MESSAGE);
        } finally {
            return combinacoesquatorzepontos;
        }

    }
    
    public List<FourteenPoints> CombinacoesQuatorzePorParte(Integer idinicial, Integer idfinal){
    
        List<FourteenPoints> combinacoesquatorzepoporparte = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from TB_FOURTEENPOINTS "
                    + " where REF_COMB_FOURTEEN between ? and ? order by REF_COMB_FOURTEEN");
            stmt.setInt(1, idinicial);
            stmt.setInt(2, idfinal);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                FourteenPoints fourteenpoints = new FourteenPoints();
                fourteenpoints.setIdcombfourteen(rs.getInt("ID_COMB_FOURTEEN"));
                fourteenpoints.setRefcombfourteen(rs.getInt("REF_COMB_FOURTEEN"));
                fourteenpoints.setQtdefourteenpoints(rs.getInt("QTD_FOURTEENPOINTS"));
                combinacoesquatorzepoporparte.add(fourteenpoints);
                //JOptionPane.showMessageDialog(null, fifteenpoints.getRefcombfifteen());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex + "/n ao buscar a lista de sorteios!",
                    "Bingo", JOptionPane.ERROR_MESSAGE);
        } finally {
            return combinacoesquatorzepoporparte;
        }
    }
    
    public void EscritordeQuatorzePontosTexto(File fourteenpointsfile, String fourteenpoints){
        try(FileWriter fourteenpointsfilewriter = new FileWriter(fourteenpointsfile, true)){
                      fourteenpointsfilewriter.write(fourteenpoints.trim()+"\n");
                 }catch(IOException e)
                      {
                          JOptionPane.showMessageDialog(null, "Erro: " + e + ", ao tentar "
                                                     + "salvar quatorze pontos!", "Salvando quatorze pontos",
                                                     JOptionPane.ERROR_MESSAGE);
                      }
    }

    public void EscritordeQuatorzePontos(Integer fourteenpoints, int qtde) {

        try {
            stmt = con.prepareStatement("INSERT INTO TB_FOURTEENPOINTS(REF_COMB_FOURTEEN, QTD_FOURTEENPOINTS ) VALUES (?,?)");
            stmt.setInt(1, fourteenpoints);
            stmt.setInt(2, qtde);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            /*
            JOptionPane.showMessageDialog(null, "Erro: " + ex + ", ao tentar "
                    + "salvar quatorze pontos!", "Bingo",
                    JOptionPane.ERROR_MESSAGE);
            */
            retornoid =  ex.getErrorCode();
            
        } finally {
            //ConexaoFireBird.closeConnection(con, stmt);
        }

    }

    public Integer BuscaQtdedeQuatorzepontos(String fourteenpoints) {

        try {
            stmt = con.prepareStatement("select FT.QTD_FOURTEENPOINTS from TB_FOURTEENPOINTS FT\n"
                    + "join TB_COMBINATIONS CB on FT.REF_COMB_FOURTEEN = CB.ID_COMBINATION \n"
                    + "where CB.COMBINATION = ?");
            stmt.setString(1, fourteenpoints);
            rs = stmt.executeQuery();
            while (rs.next()) {
                retornoid = rs.getInt("QTD_FOURTEENPOINTS");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex + "/n ao buscar a quantidade de 14 pontos!", "Bingo",
                    JOptionPane.ERROR_MESSAGE);
        } finally {

            return retornoid;

        }
    }
    
    public FourteenPoints BuscadeQuatorzepontos(int sorteio) {
       FourteenPoints fourteenpoints = new FourteenPoints();
        try {
            stmt = con.prepareStatement("select FT.ID_COMB_FOURTEEN, QTD_FOURTEENPOINTS from TB_FOURTEENPOINTS FT\n"
                    + "where FT.REF_COMB_FOURTEEN = ?");
            stmt.setInt(1, sorteio);
            rs = stmt.executeQuery();
            while (rs.next()) {
                fourteenpoints.setIdcombfourteen(rs.getInt("ID_COMB_FOURTEEN"));
                fourteenpoints.setQtdefourteenpoints(rs.getInt("QTD_FOURTEENPOINTS"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex + "/n ao buscar a quantidade de 14 pontos!", "Bingo",
                    JOptionPane.ERROR_MESSAGE);
        } finally {

            return fourteenpoints;

        }
    }
    
        public FourteenPoints BuscaCombinacaoDeQuatorzepontos(String fourteenpoints) {
        
        FourteenPoints combfourteen = new FourteenPoints();
        try {
            stmt = con.prepareStatement("select CB.ID_COMBINATION, FR.ID_COMB_FOURTEEN from TB_COMBINATIONS CB\n"
                    + "join TB_FOURTEENPOINTS FR on FR.REF_COMB_FOURTEEN = CB.ID_COMBINATION \n"
                    + "where CB.COMBINATION = ?");
            stmt.setString(1, fourteenpoints);
            rs = stmt.executeQuery();

            while (rs.next()) {
                combfourteen.setIdcombfourteen(Integer.parseInt(rs.getString("ID_COMB_FOURTEEN")));               
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex + "/n ao buscar a combinação!", "Bingo",
                    JOptionPane.ERROR_MESSAGE);
        } finally {

            return combfourteen;

        }
    }
        /*
        public List<Combinacoes> totalDeCombinacoesQuatorzePontos() {
        List<Combinacoes> totalDeCombinacoesQuatorzepontos = new ArrayList<>();
        
        //int count = 0;
        try {
            stmt = con.prepareStatement("select CB.COMBINATION from TB_COMBINATIONS CB "
                    + "join TB_FOURTEENPOINTS FT on FT.REF_COMB_FOURTEEN = CB.ID_COMBINATION "
                    + "order by FT.ID_COMB_FOURTEEN");
            
            rs = stmt.executeQuery();
           
            while (rs.next()) {
                Combinacoes combinacoes = new Combinacoes();
                combinacoes.setCombinacao(rs.getString("COMBINATION"));
                totalDeCombinacoesQuatorzepontos.add(combinacoes);
                //JOptionPane.showMessageDialog(null, todascombinacoesquinzepontos.get(count)+" count");
                //count++;
                //JOptionPane.showMessageDialog(null, combinacoes);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex + "/n ao buscar a lista de sorteios!",
                    "Bingo", JOptionPane.ERROR_MESSAGE);
        }finally {
            return totalDeCombinacoesQuatorzepontos;
        }

    }
    */
        
        public List<Combinacoes> totalDeCombinacoesQuatorzePontos() {
        List<Combinacoes> totalDeCombinacoesQuatorzepontos = new ArrayList<>();
        
        //int count = 0;
        try {
            stmt = con.prepareStatement("select CB.COMBINATION from TB_COMBINATIONS CB "
                    + "join TB_FOURTEENPOINTS FT on FT.REF_COMB_FOURTEEN = CB.ID_COMBINATION "
                    + "where FT.QTD_FOURTEENPOINTS > 1 "
                    + "order by FT.ID_COMB_FOURTEEN");
            
            rs = stmt.executeQuery();
           
            while (rs.next()) {
                Combinacoes combinacoes = new Combinacoes();
                combinacoes.setCombinacao(rs.getString("COMBINATION"));
                totalDeCombinacoesQuatorzepontos.add(combinacoes);
                //JOptionPane.showMessageDialog(null, todascombinacoesquinzepontos.get(count)+" count");
                //count++;
                //JOptionPane.showMessageDialog(null, combinacoes);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex + "/n ao buscar a lista de sorteios!",
                    "Bingo", JOptionPane.ERROR_MESSAGE);
        }finally {
            return totalDeCombinacoesQuatorzepontos;
        }

    }
        
    public void atualizarQtdedeQuatorzepontos(int idfourteen, int qtdefourteenpoints){

           try{
               stmt = con.prepareStatement("update TB_FOURTEENPOINTS FT set FT.QTD_FOURTEENPOINTS = ?"
                                           + "where FT.ID_COMB_FOURTEEN = ?");
               stmt.setInt(1, qtdefourteenpoints);
               stmt.setInt(2, idfourteen);
               stmt.executeUpdate();
           }catch(SQLException ex){
               JOptionPane.showMessageDialog(null, "Erro: " + ex + " ao tentar\n"
                                             + " atualizar quantidade de quatorze pontos!");
           }finally{
           }
      }
    
    public void FecharConeccao() {
        ConexaoFireBird.closeConnection(con, stmt);
    }
    
}

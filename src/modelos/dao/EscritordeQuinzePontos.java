/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.dao;

import FabricaDeConexao.ConexaoFireBird;
import FabricaDeConexao.EfetuaConeccao;
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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.bean.Combinacoes;
import modelo.bean.CombinacoesDTO;
import modelo.bean.FifteenPoints;
import modelo.bean.TotaldeRepeticoes;

/**
 *
 * @author Pituba
 */
public class EscritordeQuinzePontos {

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
    
    public List<CombinacoesDTO> todasCombinacoesQuinzePontos(int idinicial, int idfinal) {
    
        List<CombinacoesDTO> todascombinacoesquinzepontos = new ArrayList<>();
        
        //int count = 0;
        try {
            stmt = con.prepareStatement("select CB.COMBINATION from TB_COMBINATIONS CB "
                    + "join TB_FIFTEENPOINTS FF on CB.ID_COMBINATION = FF.REF_COMB_FIFTEEN "
                    + "where FF.ID_COMB_FIFTEEN between ? and ? order by FF.ID_COMB_FIFTEEN");
            
            stmt.setInt(1, idinicial);
            stmt.setInt(2, idfinal);
            rs = stmt.executeQuery();
           
            while (rs.next()) {
                CombinacoesDTO combinacoes = new CombinacoesDTO();
                combinacoes.setCombinacao(rs.getString("COMBINATION"));
                todascombinacoesquinzepontos.add(combinacoes);
                //JOptionPane.showMessageDialog(null, todascombinacoesquinzepontos.get(count)+" count");
                //count++;
                //JOptionPane.showMessageDialog(null, combinacoes);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex + "/n ao buscar a lista de sorteios!",
                    "Bingo", JOptionPane.ERROR_MESSAGE);
        }finally {
            return todascombinacoesquinzepontos;
        }

    }
    
    public List<CombinacoesDTO> todasCombinacoesQuinzePontosPorPartes(int idinicial, int idfinal) {
    
        List<CombinacoesDTO> todascombinacoesquinzepontos = new ArrayList<>();
        
        //int count = 0;
        try {
            stmt = con.prepareStatement("select CB.COMBINATION from TB_COMBINATIONS CB "
                    + "join TB_FIFTEENPOINTS FF on CB.ID_COMBINATION = FF.REF_COMB_FIFTEEN "
                    + "where CB.ID_COMBINATION between ? and ? order by FF.ID_COMB_FIFTEEN");
            
            stmt.setInt(1, idinicial);
            stmt.setInt(2, idfinal);
            rs = stmt.executeQuery();
           
            while (rs.next()) {
                CombinacoesDTO combinacoes = new CombinacoesDTO();
                combinacoes.setCombinacao(rs.getString("COMBINATION"));
                todascombinacoesquinzepontos.add(combinacoes);
                //JOptionPane.showMessageDialog(null, todascombinacoesquinzepontos.get(count)+" count");
                //count++;
                //JOptionPane.showMessageDialog(null, combinacoes);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex + "/n ao buscar a lista de sorteios!",
                    "Bingo", JOptionPane.ERROR_MESSAGE);
        }finally {
            return todascombinacoesquinzepontos;
        }

    }
    public List<CombinacoesDTO> combinacoesSelecionadasPorPartes(int idinicial, int idfinal){
    
        List<CombinacoesDTO> combinacoesselecionadasporpartes = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("select ID_COMB_FIFTEEN, ID_COMBINATION, COMBINATION from TB_COMBINATIONS TC \n" +
                                        "join TB_FIFTEENPOINTS TF on TC.ID_COMBINATION\n" +
                                        "= TF.REF_COMB_FIFTEEN where TF.REF_COMB_FIFTEEN\n" +
                                        "between ? and ? order by ID_COMB_FIFTEEN \n" +
                                        "desc");
            
            stmt.setInt(1, idinicial);
            stmt.setInt(2, idfinal);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                CombinacoesDTO combinacoesdto = new CombinacoesDTO();
                combinacoesdto.setIdCombinacaoFifteen(rs.getInt("ID_COMB_FIFTEEN"));
                combinacoesdto.setIdcombinacao(rs.getInt("ID_COMBINATION"));
                combinacoesdto.setCombinacao(rs.getString("COMBINATION"));
                combinacoesselecionadasporpartes.add(combinacoesdto);
                //JOptionPane.showMessageDialog(null, todascombinacoesquinzepontos.get(count)+" count");
                //count++;
                //JOptionPane.showMessageDialog(null, combinacoes);
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro: " + ex + "/n ao buscar a lista de sorteios!",
                    "Bingo", JOptionPane.ERROR_MESSAGE);
        } finally {
            return combinacoesselecionadasporpartes;
        }   
    }
    
    public List<CombinacoesDTO> combinacoesSelecionadasPorPartesAsc(int idinicial, int idfinal){
    
        List<CombinacoesDTO> combinacoesselecionadasporpartes = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("select ID_COMB_FIFTEEN, ID_COMBINATION, COMBINATION from TB_COMBINATIONS TC \n" +
                                        "join TB_FIFTEENPOINTS TF on TC.ID_COMBINATION\n" +
                                        "= TF.REF_COMB_FIFTEEN where TF.ID_COMB_FIFTEEN\n" +
                                        "between ? and ? order by ID_COMB_FIFTEEN \n" +
                                        "asc");
            
            stmt.setInt(1, idinicial);
            stmt.setInt(2, idfinal);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                CombinacoesDTO combinacoesdto = new CombinacoesDTO();
                combinacoesdto.setIdCombinacaoFifteen(rs.getInt("ID_COMB_FIFTEEN"));
                combinacoesdto.setIdcombinacao(rs.getInt("ID_COMBINATION"));
                combinacoesdto.setCombinacao(rs.getString("COMBINATION"));
                combinacoesselecionadasporpartes.add(combinacoesdto);
                //JOptionPane.showMessageDialog(null, todascombinacoesquinzepontos.get(count)+" count");
                //count++;
                //JOptionPane.showMessageDialog(null, combinacoes);
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro: " + ex + "/n ao buscar a lista de sorteios!",
                    "Bingo", JOptionPane.ERROR_MESSAGE);
        } finally {
            return combinacoesselecionadasporpartes;
        }   
    }
    
    public String ultimaCombinacaoSelecaoPorPartes(int idinicial, int idfinal){
    
        String ultimacombinacaoselecaoporpartes = "";
        
        try{
            stmt = con.prepareStatement("select first 1 COMBINATION from TB_COMBINATIONS TC \n" +
                                        "join TB_FIFTEENPOINTS TF on TC.ID_COMBINATION\n" +
                                        "= TF.REF_COMB_FIFTEEN where TF.REF_COMB_FIFTEEN\n" +
                                        "between ? and ? order by ID_COMB_FIFTEEN \n" +
                                        "desc");
            
            stmt.setInt(1, idinicial);
            stmt.setInt(2, idfinal);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                CombinacoesDTO combinacoesdto = new CombinacoesDTO();
                combinacoesdto.setCombinacao(rs.getString("COMBINATION"));
                ultimacombinacaoselecaoporpartes = combinacoesdto.getCombinacao();
                //JOptionPane.showMessageDialog(null, todascombinacoesquinzepontos.get(count)+" count");
                //count++;
                //JOptionPane.showMessageDialog(null, combinacoes);
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro: " + ex + "/n ao buscar a lista de sorteios!",
                    "Bingo", JOptionPane.ERROR_MESSAGE);
        } finally {
            return ultimacombinacaoselecaoporpartes;
        }   
    }
    
     public List<Combinacoes> totalDeCombinacoesQuinzePontos() {
         
         List<Combinacoes> totalDeCombinacoesQuinzepontos = new ArrayList<>();
        
        //int count = 0;
        try {
            stmt = con.prepareStatement("select CB.COMBINATION from TB_COMBINATIONS CB "
                    + "join TB_FIFTEENPOINTS FF on FF.REF_COMB_FIFTEEN = CB.ID_COMBINATION "
                    + "order by FF.ID_COMB_FIFTEEN");
            
            rs = stmt.executeQuery();
           
            while (rs.next()) {
                Combinacoes combinacoes = new Combinacoes();
                combinacoes.setCombinacao(rs.getString("COMBINATION"));
                totalDeCombinacoesQuinzepontos.add(combinacoes);
                //JOptionPane.showMessageDialog(null, todascombinacoesquinzepontos.get(count)+" count");
                //count++;
                //JOptionPane.showMessageDialog(null, combinacoes);
            }
            JOptionPane.showMessageDialog(null, totalDeCombinacoesQuinzepontos.size());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex + "/n ao buscar a lista de sorteios!",
                    "Bingo", JOptionPane.ERROR_MESSAGE);
        }finally {
            return totalDeCombinacoesQuinzepontos;
        }

    }
    

    public FifteenPoints BuscadeQuinzepontos(String fifteenpoints) {
        FifteenPoints combfifteen = new FifteenPoints();
        try {
            stmt = con.prepareStatement("select CB.ID_COMBINATION, FF.QTD_FIFTEENPOINTS from TB_COMBINATIONS CB\n"
                    + "join TB_FIFTEENPOINTS FF on FF.REF_COMB_FIFTEEN = CB.ID_COMBINATION \n"
                    + "where CB.COMBINATION = ?");
            stmt.setString(1, fifteenpoints);
            rs = stmt.executeQuery();

            while (rs.next()) {
                combfifteen.setRefcombfifteen(rs.getString("ID_COMBINATION"));
                combfifteen.setQtdfifteenpoints(rs.getInt("QTD_FIFTEENPOINTS"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex + "/n ao buscar a combinação!", "Bingo",
                    JOptionPane.ERROR_MESSAGE);
        } finally {

            return combfifteen;

        }
    }

    public Integer BuscaIdCombination(String fifteenpoints) {
        
        try {
            stmt = con.prepareStatement("select ID_COMBINATION from TB_COMBINATIONS \n"
                    + "where COMBINATION = ?");
            stmt.setString(1, fifteenpoints);
            rs = stmt.executeQuery();
            while (rs.next()) {
                retornoid = rs.getInt("ID_COMBINATION");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex + "\n ao buscar a combinação!", "Bingo",
                    JOptionPane.ERROR_MESSAGE);
        }

        return retornoid;

    }

    public List<FifteenPoints> CombinacoesQuinzePontos(Integer idinicial, Integer idfinal) {
        
        List<FifteenPoints> combinacoesquinzepontos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from TB_FIFTEENPOINTS "
                    + " where ID_COMB_FIFTEEN between ? and ? order by ID_COMB_FIFTEEN");
            stmt.setInt(1, idinicial);
            stmt.setInt(2, idfinal);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                FifteenPoints fifteenpoints = new FifteenPoints();
                fifteenpoints.setIdcombfifteen(rs.getInt("ID_COMB_FIFTEEN"));
                fifteenpoints.setRefcombfifteen(rs.getString("REF_COMB_FIFTEEN"));
                fifteenpoints.setQtdfifteenpoints(rs.getInt("QTD_FIFTEENPOINTS"));
                combinacoesquinzepontos.add(fifteenpoints);
                //JOptionPane.showMessageDialog(null, fifteenpoints.getRefcombfifteen());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex + "/n ao buscar a lista de sorteios!",
                    "Bingo", JOptionPane.ERROR_MESSAGE);
        } finally {
            return combinacoesquinzepontos;
        }

    }

    public Integer BuscaIdQuinzePontos(Integer fifteenpoints) {
        try {
            stmt = con.prepareStatement("select QZ.ID_COMB_FIFTEEN from TB_FIFTEENPOINTS QZ\n"
                    + "where QZ.REF_COMB_FIFTEEN = ?");
            stmt.setInt(1, fifteenpoints);
            rs = stmt.executeQuery();
            while (rs.next()) {
                retornoid = rs.getInt("ID_COMB_FIFTEEN");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex + "/n ao buscar a combinação!", "Bingo",
                    JOptionPane.ERROR_MESSAGE);
        } finally {

            return retornoid;

        }

    }

    public void EscritordeQuinzepontos(int fifteenpoints, int qtde) {

        try {
            stmt = con.prepareStatement("INSERT INTO TB_FIFTEENPOINTS(REF_COMB_FIFTEEN, QTD_FIFTEENPOINTS ) VALUES (?,?)");
            stmt.setInt(1, fifteenpoints);
            stmt.setInt(2, qtde);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar combinação com 15 pontos! " + ex,
                    "Bingo", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexaoFireBird.closeConnection(con, stmt);
        }
    }

    public void EscritorQtdeQuatorze(int fourteenpoints, int qtde) {

        try {
            stmt = con.prepareStatement("INSERT INTO TB_QTDE_FOURTEENPOINTS(REF_TB_FIFTEEN, QTDE_FOURTEENPOINTS ) VALUES (?,?)");
            stmt.setInt(1, fourteenpoints);
            stmt.setInt(2, qtde);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar quantidade de 14 pontos! " + ex,
                    "Bingo", JOptionPane.ERROR_MESSAGE);
        } finally {
            //ConexaoFireBird.closeConnection(con, stmt);
        }
    }

    public void AtualizarEscritordeQuinzePontos(int id, int quantidade) {

        try {
            stmt = con.prepareStatement("update TB_FIFTEENPOINTS ff set ff.QTD_FIFTEENPOINTS = ?"
                    + "where FF.ID_COMB_FIFTEEN = ?");
            stmt.setInt(1, quantidade);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex + " ao tentar\n"
                    + " atualizar contagem de clientes!", "Bingo",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
        }
    }

    public void FecharConeccao() {
        ConexaoFireBird.closeConnection(con, stmt);
    }
    
     public void EscritordeQuinzePontosTexto(File fifteenpointsfile, String fifteenpoints){
        try(FileWriter fifteenpointsfilewriter = new FileWriter(fifteenpointsfile, true)){
                      fifteenpointsfilewriter.write(fifteenpoints.trim()+"\n");
                 }catch(IOException e)
                      {
                          JOptionPane.showMessageDialog(null, "Erro: " + e + ", ao tentar "
                                                     + "salvar quinze pontos!", "Salvando quinze pontos texto",
                                                     JOptionPane.ERROR_MESSAGE);
                      }
    }


}

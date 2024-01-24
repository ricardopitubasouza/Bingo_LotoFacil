/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewBingo;

import FabricaDeConexao.EfetuaConeccao;
import Util.OrganizadordeSequencias;
import static ViewBingo.frmDezenasMaisFortes.txtSorteioFinal;
import static ViewBingo.frmDezenasMaisFortes.txtSorteioInicial;
import com.sun.glass.events.KeyEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.bean.BuscarNaLista;
import modelo.bean.BuscarNaTabela;
import modelo.bean.CalculaDezenasMaisSorteadas;
import modelo.bean.Combinacoes;
import modelo.bean.CombinacoesDTO;
import modelo.bean.CombinacoesSelecionadas;
import modelo.bean.DezenasMaisSorteadas;
import modelo.bean.DezenasSelecionadas;
import modelo.bean.GraficoPontosDezenas;
import modelo.bean.ListaDezenasMaisSorteadas;
import modelo.bean.Pontuacao;
import modelo.bean.SalvarEmOrdem;
import modelo.bean.SelecaoDeDezenas;
import modelo.bean.SelecaoPorPontos;
import modelo.bean.SelecaodeQuatorzePontos;
import modelo.bean.Selecaodequinzepontos;
import modelo.bean.SomaPontos;
import modelos.dao.EscritordeQuatorzePontos;
import modelos.dao.EscritordeQuinzePontos;
import modelos.dao.TotalProbabilidadeDAO;

/**
 *
 * @author ricar
 */
public class frmSelecionarCombinacao extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmSelecionarCombinacao
     */
    public frmSelecionarCombinacao() {
        initComponents();
        Dimension dimensao = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(((dimensao.width)-1300)/2,
                               ((dimensao.height)-850)/2,
                               1050,
                               720);  
        this.setMaximizable(false);
        
        EfetuaConeccao efetuarconeccao = new EfetuaConeccao();
        efetuarconeccao.EfetuaConeccao();

        TotalProbabilidadeDAO totalprobabilidadedao1 = new TotalProbabilidadeDAO();
        CombinacoesDTO ultimosorteio = totalprobabilidadedao1.CombinacaoUltimoSorteio();
        txtCombinacaoparacomparar.setText(ultimosorteio.getCombinacao());
        txtIdCombinacao.setText(String.valueOf(ultimosorteio.getIdcombinacao()));
        txtQtdQuinze.setText(String.valueOf(ultimosorteio.getQtdfifteenpoints()));
        txtQtdQuatorze.setText(String.valueOf(ultimosorteio.getQtdeFourteenPoints()));
        txtId.setText(ultimosorteio.getRefcombfifteen());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCombinacaoparacomparar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtIdinicial = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdfinal = new javax.swing.JTextField();
        btnSelecionarCombinacoes = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSorteioAnterior = new javax.swing.JTextField();
        txtDezenasMaisSorteadas = new javax.swing.JTextField();
        txtCombinacaoParaBusca = new javax.swing.JTextField();
        btnPontuacao = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPontuacao = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtDezenasIncluidas = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtDezenasExcluidas = new javax.swing.JTextField();
        txtIdCombinacao = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();
        txtQuantidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbCombinacoesSorteadas = new javax.swing.JTable();
        txtQtdQuatorze = new javax.swing.JTextField();
        txtQtdQuinze = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCombinacaoparacomparar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCombinacaoparacomparar.setPreferredSize(new java.awt.Dimension(8, 20));
        getContentPane().add(txtCombinacaoparacomparar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 310, 25));
        txtCombinacaoparacomparar.getAccessibleContext().setAccessibleName("");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(txtIdinicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 76, -1));

        jLabel2.setText("ID Final:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));
        jPanel2.add(txtIdfinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 73, -1));

        btnSelecionarCombinacoes.setText("Selecionar Combinações");
        btnSelecionarCombinacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarCombinacoesActionPerformed(evt);
            }
        });
        jPanel2.add(btnSelecionarCombinacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 310, 42));

        jLabel4.setText("ID Inicial:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 10));

        jLabel6.setText("Pontos no sort. anterior:");
        jLabel6.setAutoscrolls(true);
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        jLabel7.setText("Pontos nas dezenas:");
        jLabel7.setAutoscrolls(true);
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, 20));

        txtSorteioAnterior.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtSorteioAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 55, -1));

        txtDezenasMaisSorteadas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtDezenasMaisSorteadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 55, -1));

        txtCombinacaoParaBusca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtCombinacaoParaBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 310, 25));

        btnPontuacao.setText("Pontuação");
        btnPontuacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPontuacaoActionPerformed(evt);
            }
        });
        jPanel2.add(btnPontuacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 150, 40));

        txtPontuacao.setColumns(20);
        txtPontuacao.setRows(5);
        txtPontuacao.setPreferredSize(new java.awt.Dimension(164, 98));
        jScrollPane1.setViewportView(txtPontuacao);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 300, 170));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Sorteio Atual");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 120, -1));

        jLabel13.setText("Pontos por partes:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, 20));

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 55, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dezenas"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setText("Incluídas");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 21, -1, -1));

        txtDezenasIncluidas.setPreferredSize(new java.awt.Dimension(270, 20));
        jPanel3.add(txtDezenasIncluidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 40, 270, 25));

        jLabel16.setText("Excluídas");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        txtDezenasExcluidas.setPreferredSize(new java.awt.Dimension(270, 20));
        jPanel3.add(txtDezenasExcluidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 100, 270, 25));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 300, 140));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 360, 630));

        txtIdCombinacao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtIdCombinacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 80, 25));
        txtIdCombinacao.getAccessibleContext().setAccessibleName("");

        btnSair.setText("Sair");
        btnSair.setName("btnSair"); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 650, -1, -1));

        txtQuantidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, 110, -1));

        jLabel5.setText("Quantidade:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 70, 20));

        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 60, 25));

        jLabel1.setText("Id:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel3.setText("Posição:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jLabel8.setText("Combinação:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseClicked(evt);
            }
        });

        jtbCombinacoesSorteadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Combinações"
            }
        ));
        jtbCombinacoesSorteadas.setName("jtbCombinacoesSorteadas"); // NOI18N
        jtbCombinacoesSorteadas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtbCombinacoesSorteadasFocusGained(evt);
            }
        });
        jtbCombinacoesSorteadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbCombinacoesSorteadasMouseClicked(evt);
            }
        });
        jtbCombinacoesSorteadas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtbCombinacoesSorteadasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtbCombinacoesSorteadasKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jtbCombinacoesSorteadas);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 650, 500));

        txtQtdQuatorze.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtQtdQuatorze, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 70, 25));

        txtQtdQuinze.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtQtdQuinze, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 70, 25));

        jLabel9.setText(" 14 pontos");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, -1, -1));

        jLabel10.setText(" 15 pontos");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Último Sorteio");
        jPanel1.add(jLabel11);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 650, 80));

        txtBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaActionPerformed(evt);
            }
        });
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaKeyReleased(evt);
            }
        });
        getContentPane().add(txtBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 310, 25));

        jLabel14.setText("Busca:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 40, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSelecionarCombinacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarCombinacoesActionPerformed

        EfetuaConeccao efetuarconeccao = new EfetuaConeccao();
        efetuarconeccao.EfetuaConeccao();  
        
       int sorteioAnterior = 0, dezenasMaisSorteadas = 0, pontosPorPartes = 0, idinicial = 0, idfinal = 0;
       
        if(!txtSorteioAnterior.getText().equals(""))
           sorteioAnterior = Integer.parseInt(txtSorteioAnterior.getText());
        
        
        if(!txtDezenasMaisSorteadas.getText().equals(""))
           dezenasMaisSorteadas = Integer.parseInt(txtDezenasMaisSorteadas.getText());
       
        if(!jTextField1.getText().equals(""))
           pontosPorPartes = Integer.parseInt(jTextField1.getText());
        
        if(!txtIdinicial.getText().equals(""))
            idinicial = Integer.parseInt(txtIdinicial.getText());
        
        if(!txtIdfinal.getText().equals(""))
            idfinal = Integer.parseInt(txtIdfinal.getText());
        
        SelecaoDeDezenas selecaodedezenas = new SelecaoDeDezenas(txtDezenasIncluidas.getText(), txtDezenasExcluidas.getText(), 
               idinicial, idfinal, dezenasMaisSorteadas, sorteioAnterior, pontosPorPartes); 
        /*
        CombinacoesSelecionadas combinacoesSelecionadas = new CombinacoesSelecionadas();
        combinacoesSelecionadas.CombinacoesSelecionadas(Integer.parseInt(txtIdinicial.getText()), Integer.parseInt(txtIdfinal.getText()),
                dezenasMaisSorteadas, sorteioAnterior, pontosPorPartes, dezenasselecionadas.getDez1(), 
                dezenasselecionadas.getDez2(),dezenasselecionadas.getDez3(), dezenasselecionadas.getDez4(), 
                dezenasselecionadas.getDez5(), dezenasselecionadas.getDez6(),dezenasselecionadas.getDez7(),
                dezenasselecionadas.getDez8(), dezenasselecionadas.getDez9(), dezenasselecionadas.getDez10(), 
                dezenasselecionadas.getDez11(), dezenasselecionadas.getDez12(), dezenasselecionadas.getDez13(),
                dezenasselecionadas.getDez14(), dezenasselecionadas.getDez15(), dezenasselecionadas.getDez16(), 
                dezenasselecionadas.getDez17(),dezenasselecionadas.getDez18(), dezenasselecionadas.getDez19(), 
                dezenasselecionadas.getDez20());
       */         
    }//GEN-LAST:event_btnSelecionarCombinacoesActionPerformed

    private void btnPontuacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPontuacaoActionPerformed
        int[] total = new int[10];
        
        BuscarNaLista buscarnalista = new BuscarNaLista();
        buscarnalista.BuscarNaLista(txtCombinacaoParaBusca.getText());
        
        SomaPontos somaPontos = new SomaPontos(); 
        total = somaPontos.SomaPontos(txtCombinacaoParaBusca.getText());
        //JOptionPane.showMessageDialog(null, somaPontos.SomaPontos(txtCombinacaoParaBusca.getText()));
         txtPontuacao.setText("6 Pontos: " + total[0]+" Combinacões\n" + "7 Pontos: " + total[1]+"\n" + 
                              "8 Pontos: " + total[2]+"\n" + "9 Pontos: " + total[3]+"\n" + "10 Pontos: " + total[4]+"\n" + 
                              "11 Pontos: " + total[5]+"\n" + "12 Pontos: " + total[6]+"\n" + "13 Pontos: " + total[7]+"\n" + 
                              "14 Pontos: " + total[8]+"\n" + "15 Pontos: " + total[9]);
    }//GEN-LAST:event_btnPontuacaoActionPerformed

    private void jScrollPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseClicked
       
    }//GEN-LAST:event_jScrollPane3MouseClicked

    private void jtbCombinacoesSorteadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCombinacoesSorteadasMouseClicked
        DefaultTableModel mdlCombinacoesSelecionadas = (DefaultTableModel) jtbCombinacoesSorteadas.getModel();
        int selectedRowIndex = jtbCombinacoesSorteadas.getSelectedRow();
        
        Pontuacao pontuacao = new Pontuacao();
        txtPontuacao.setText("Posição: "+ (selectedRowIndex + 1) + "\n" + String.valueOf(pontuacao.Pontuacao(mdlCombinacoesSelecionadas.getValueAt(selectedRowIndex, 0).toString(),txtCombinacaoParaBusca.getText()) + " Pontos."));
        
        
    }//GEN-LAST:event_jtbCombinacoesSorteadasMouseClicked

    private void jtbCombinacoesSorteadasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtbCombinacoesSorteadasFocusGained
        
    }//GEN-LAST:event_jtbCombinacoesSorteadasFocusGained

    private void jtbCombinacoesSorteadasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbCombinacoesSorteadasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbCombinacoesSorteadasKeyPressed

    private void jtbCombinacoesSorteadasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbCombinacoesSorteadasKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_DOWN || evt.getKeyCode()==KeyEvent.VK_UP){
            DefaultTableModel mdlCombinacoesSelecionadas = (DefaultTableModel) jtbCombinacoesSorteadas.getModel();
        int selectedRowIndex = jtbCombinacoesSorteadas.getSelectedRow();
        
        Pontuacao pontuacao = new Pontuacao();
        txtPontuacao.setText("Posição: "+ (selectedRowIndex + 1) + "\n" + String.valueOf(pontuacao.Pontuacao(mdlCombinacoesSelecionadas.getValueAt(selectedRowIndex, 0).toString(),txtCombinacaoParaBusca.getText()) + " Pontos."));
        }
    }//GEN-LAST:event_jtbCombinacoesSorteadasKeyReleased

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
      
        BuscarNaTabela buscar = new BuscarNaTabela();
        buscar.BuscarNaTabela(txtBusca.getText());
        
        /*
        DefaultTableModel obj = (DefaultTableModel) jtbCombinacoesSorteadas.getModel();
        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(obj);
        jtbCombinacoesSorteadas.setRowSorter(obj1);
        obj1.setRowFilter(RowFilter.regexFilter(txtBusca.getText()));
        */
    }//GEN-LAST:event_txtBuscaKeyReleased

    private void txtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPontuacao;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSelecionarCombinacoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTable jtbCombinacoesSorteadas;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtCombinacaoParaBusca;
    private javax.swing.JTextField txtCombinacaoparacomparar;
    private javax.swing.JTextField txtDezenasExcluidas;
    private javax.swing.JTextField txtDezenasIncluidas;
    private javax.swing.JTextField txtDezenasMaisSorteadas;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdCombinacao;
    private javax.swing.JTextField txtIdfinal;
    private javax.swing.JTextField txtIdinicial;
    private javax.swing.JTextArea txtPontuacao;
    private javax.swing.JTextField txtQtdQuatorze;
    private javax.swing.JTextField txtQtdQuinze;
    public static javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtSorteioAnterior;
    // End of variables declaration//GEN-END:variables
}

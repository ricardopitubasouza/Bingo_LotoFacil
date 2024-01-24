/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewBingo;

import FabricaDeConexao.EfetuaConeccao;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.bean.Combinacoes;
import modelo.bean.CombinacoesDTO;
import modelo.bean.Dezenas;
import modelo.bean.DezenasMaisSorteadas;
import modelo.bean.LimpaTableGrid;
import modelos.dao.EscritordeQuinzePontos;

/**
 *
 * @author ricar
 */
public class frmDezenasMaisFortes extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmDezenasMaisFortes
     */
    public frmDezenasMaisFortes() {
        initComponents();
        
        DefaultTableModel dtmDezenas = (DefaultTableModel) jtbDezenas.getModel();
        jtbDezenas.setRowSorter(new TableRowSorter(dtmDezenas));
        
        Dimension dimensao = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(((dimensao.width) - 711) / 2,
                ((dimensao.height) - 480) / 2,
                711,
                580);
        this.setMaximizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txtTotalCombinacoes = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbDezenas = new javax.swing.JTable();
        txtSorteioInicial = new javax.swing.JTextField();
        txtSorteioFinal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        btnContaCombinacoesporpartes = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Contar Combinações");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 200, 48));

        txtTotalCombinacoes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTotalCombinacoes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtTotalCombinacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 31, 106, 29));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Total combinações");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 11, -1, -1));

        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        jtbDezenas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Dezenas", "Quantidade", "Percentual"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbDezenas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbDezenas);
        if (jtbDezenas.getColumnModel().getColumnCount() > 0) {
            jtbDezenas.getColumnModel().getColumn(0).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 11, 257, 448));
        getContentPane().add(txtSorteioInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 65, -1));
        getContentPane().add(txtSorteioFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 61, -1));

        jLabel2.setText("Sort. inicial");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 15, -1, -1));

        jLabel3.setText("Sort. final");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 15, -1, -1));

        btnLimpar.setText("Limpar");
        btnLimpar.setToolTipText("");
        btnLimpar.setName(""); // NOI18N
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 200, 48));

        btnContaCombinacoesporpartes.setText("Contar Combinacões por partes");
        btnContaCombinacoesporpartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContaCombinacoesporpartesActionPerformed(evt);
            }
        });
        getContentPane().add(btnContaCombinacoesporpartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 200, 48));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        List<CombinacoesDTO> todascombinacoesquinzepontos = new ArrayList<>();
         
        EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();
        todascombinacoesquinzepontos = escritordequinzepontos.todasCombinacoesQuinzePontos(Integer.parseInt(txtSorteioInicial.getText()), Integer.parseInt(txtSorteioFinal.getText()));
        
        DezenasMaisSorteadas dezenasmaissorteadas = new DezenasMaisSorteadas();  
        dezenasmaissorteadas.DezenasMaisSorteadas(Integer.parseInt(txtSorteioInicial.getText()), Integer.parseInt(txtSorteioFinal.getText()), todascombinacoesquinzepontos);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        
        LimpaTableGrid limpatabela = new LimpaTableGrid();      
        limpatabela.limpatablegrid();
        txtTotalCombinacoes.setText("");
        txtSorteioInicial.setText("");
        txtSorteioFinal.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnContaCombinacoesporpartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContaCombinacoesporpartesActionPerformed
        
        EfetuaConeccao efetuarconeccao = new EfetuaConeccao();
        efetuarconeccao.EfetuaConeccao();
        
        List<CombinacoesDTO> todascombinacoesquinzepontos = new ArrayList<>();
         
        EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();
        todascombinacoesquinzepontos = escritordequinzepontos.combinacoesSelecionadasPorPartes(Integer.parseInt(txtSorteioInicial.getText()), Integer.parseInt(txtSorteioFinal.getText()));
        
        DezenasMaisSorteadas dezenasmaissorteadas = new DezenasMaisSorteadas();  
        dezenasmaissorteadas.DezenasMaisSorteadas(Integer.parseInt(txtSorteioInicial.getText()), Integer.parseInt(txtSorteioFinal.getText()), todascombinacoesquinzepontos);
    }//GEN-LAST:event_btnContaCombinacoesporpartesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContaCombinacoesporpartes;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jtbDezenas;
    public static javax.swing.JTextField txtSorteioFinal;
    public static javax.swing.JTextField txtSorteioInicial;
    public static javax.swing.JTextField txtTotalCombinacoes;
    // End of variables declaration//GEN-END:variables
}

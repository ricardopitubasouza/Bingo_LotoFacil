/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewBingo;

import FabricaDeConexao.ConexaoFireBird;
import FabricaDeConexao.EfetuaConeccao;
import Util.OrganizadordeSequencias;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.bean.Combinacoes;
import modelo.bean.FourteenPoints;
import modelo.bean.GraficoDePontos;
import modelo.bean.GraficoNivel;
import modelo.bean.GraficoPorPartes;
import modelo.bean.GraficoQuatorzePontos;
import modelo.bean.GraficoQuinzePontos;
import modelo.bean.PontosNaAnterior;
import modelo.bean.SelecaodeQuatorzePontos;
import modelo.bean.Selecaodequinzepontos;
import modelos.dao.EscritordeQuatorzePontos;
import modelos.dao.EscritordeQuinzePontos;
import modelos.dao.TotalProbabilidadeDAO;
import modelos.dao.TotalProbabilidadesTextoDAO;

/**
 *
 * @author Pituba
 */
public class frmSalvarTrezeeQuatorzePontos extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmSalvarquatorzeequinzepontos
     */
    File lotofacil = new File("C:\\Meusbd\\bingo.txt");
    EfetuaConeccao efetuarconeccao = new EfetuaConeccao();

    public frmSalvarTrezeeQuatorzePontos() {
        initComponents();

        Dimension dimensao = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(((dimensao.width) - 711) / 2,
                ((dimensao.height) - 480) / 2,
                751,
                380);
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

        btnSair = new javax.swing.JButton();
        pgbProcessando = new javax.swing.JProgressBar();
        lblProcessando = new javax.swing.JLabel();
        lblPercentual = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        txtCombinacao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSalvarQuinzePontos = new javax.swing.JButton();
        txtNumerodoSorteio = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Selecionador de Treze  e Quatorze Pontos Loto Fácil");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ark2.png"))); // NOI18N

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lblProcessando.setText("Processando ...");

        lblPercentual.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPercentual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPercentual.setText("%");

        btnCancelar.setText("Cancelar");
        btnCancelar.setMaximumSize(new java.awt.Dimension(235, 33));
        btnCancelar.setMinimumSize(new java.awt.Dimension(235, 33));
        btnCancelar.setPreferredSize(new java.awt.Dimension(235, 33));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtCombinacao.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setText("Sorteio nº: ");

        btnSalvarQuinzePontos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ark2.png"))); // NOI18N
        btnSalvarQuinzePontos.setText("Salvar quinze pontos e selecionar quatorze");
        btnSalvarQuinzePontos.setMaximumSize(new java.awt.Dimension(191, 33));
        btnSalvarQuinzePontos.setMinimumSize(new java.awt.Dimension(191, 33));
        btnSalvarQuinzePontos.setOpaque(false);
        btnSalvarQuinzePontos.setPreferredSize(new java.awt.Dimension(191, 33));
        btnSalvarQuinzePontos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarQuinzePontosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pgbProcessando, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(234, 234, 234)
                                .addComponent(lblPercentual, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblProcessando, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(txtNumerodoSorteio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCombinacao, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSalvarQuinzePontos, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 129, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumerodoSorteio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1)))
                .addGap(15, 15, 15)
                .addComponent(txtCombinacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(lblProcessando)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(pgbProcessando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lblPercentual, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvarQuinzePontos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 156, Short.MAX_VALUE)
                        .addComponent(btnSair)
                        .addGap(23, 23, 23))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarQuinzePontosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarQuinzePontosActionPerformed
        File fourteenpointsfile = new File("C:\\Meusbd\\" + txtNumerodoSorteio.getText() + ".txt");
        if (fourteenpointsfile.exists()) {
            JOptionPane.showMessageDialog(null, "Este sorteio já foi computado!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            fourteenpointsfile.createNewFile();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível criar o arquivo de texto! Erro: " + ex);
        }

        OrganizadordeSequencias organizadordesequencias = new OrganizadordeSequencias();
        txtCombinacao.setText(organizadordesequencias.Organizadordesequencias(lotofacil).get(0));

        Selecaodequinzepontos selecaodequinzepontos = new Selecaodequinzepontos();
        SelecaodeQuatorzePontos selecaodequatorzepontos = new SelecaodeQuatorzePontos();
        for (int x = 0; x >= 0; x -= 1) {
            selecaodequinzepontos.selecaodequinzepontos(organizadordesequencias.Organizadordesequencias(lotofacil).get(x).trim());
            selecaodequatorzepontos.SelecaodeQuatorzePontos(organizadordesequencias.Organizadordesequencias(lotofacil).get(x).trim(), fourteenpointsfile);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarQuinzePontosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvarQuinzePontos;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel lblPercentual;
    public static javax.swing.JLabel lblProcessando;
    public static javax.swing.JProgressBar pgbProcessando;
    private javax.swing.JTextField txtCombinacao;
    private javax.swing.JTextField txtNumerodoSorteio;
    // End of variables declaration//GEN-END:variables
}
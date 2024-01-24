/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewBingo;

import FabricaDeConexao.EfetuaConeccao;
import static ViewBingo.frmGerarCombinacoes.lblCarregando;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.bean.Combinacoes;
import modelo.bean.FifteenPoints;
import modelos.dao.EscritordeQuinzePontos;

/**
 *
 * @author ricar
 */
public class frmTables extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmTables
     */
    public frmTables(int entinicial, int entfinal) {
        initComponents();
        
        Dimension dimensao = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(((dimensao.width)-711)/2,
                               ((dimensao.height)-480)/2,
                               711,
                               665);
        this.setMaximizable(false);
        
        populartabela(entinicial, entfinal);
        
    }
    
    void populartabela(int idinicial, int idfinal){
        
        EfetuaConeccao efetuarconeccao = new EfetuaConeccao();
        efetuarconeccao.EfetuaConeccao();
        List<FifteenPoints>combinacoes = new ArrayList<>();
        DefaultTableModel modelo = (DefaultTableModel) jtbCombinacoes.getModel();
        modelo.setNumRows(0);
        EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();
        combinacoes = escritordequinzepontos.CombinacoesQuinzePontos(idinicial, idfinal);
        for (FifteenPoints comb : combinacoes) {
           
                modelo.addRow(new Object[]{
                comb.getIdcombfifteen(),
                comb.getRefcombfifteen()
                });
        }  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCombinacoes = new javax.swing.JTable();

        setClosable(true);
        setName("frmTables"); // NOI18N

        jtbCombinacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ID", "COMBINAÇÕES", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtbCombinacoes);

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbCombinacoes;
    // End of variables declaration//GEN-END:variables
}
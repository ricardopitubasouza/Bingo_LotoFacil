/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import javax.swing.table.DefaultTableModel;
import static ViewBingo.frmSelecionarCombinacao.jtbCombinacoesSorteadas;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author ricar
 */
public class BuscarNaLista {
    
    public void BuscarNaLista(String combinacao){
               
        if(!combinacao.equals(" ")){
            for(int i = 0; i < jtbCombinacoesSorteadas.getRowCount(); i++){
               if(combinacao.equals(jtbCombinacoesSorteadas.getValueAt(i, 0))){   
                   JOptionPane.showMessageDialog(null, jtbCombinacoesSorteadas.getValueAt(i, 0)+" na linha: "+ (i + 1));
                   break;
               }                   
            }
        }     
    }
}

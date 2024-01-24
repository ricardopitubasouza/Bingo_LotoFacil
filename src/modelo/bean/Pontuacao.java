/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import static ViewBingo.frmSelecionarCombinacao.jtbCombinacoesSorteadas;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ricar
 */
public class Pontuacao {
    
    public int Pontuacao(String combinacao, String sorteio){
        
        DefaultTableModel mdlCombinacoesSelecionadas = (DefaultTableModel) jtbCombinacoesSorteadas.getModel();
        //int selctedRowIndex = jtbCombinacoesSorteadas.getSelectedRow();
        int compara = 0, somadequatorze = 0;
        
        
        for (String numCombinacao : combinacao.trim().split(" ")) {
                    compara = Arrays.binarySearch(sorteio.trim().split(" "), numCombinacao) >= 0 ? somadequatorze += 1 : somadequatorze;
                };
                
    
    return compara;
    }
    
}

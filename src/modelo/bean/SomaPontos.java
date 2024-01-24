/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import static ViewBingo.frmSelecionarCombinacao.jtbCombinacoesSorteadas;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author ricar
 */
public class SomaPontos {
    
    public int[] SomaPontos(String combinacao){
        int compara = 0, somadequatorze = 0;
        int[] total = new int[10];
        
        if(!combinacao.equals(" ")){
            for(int i = 0; i < jtbCombinacoesSorteadas.getRowCount(); i++){     
                for (String numCombinacao : jtbCombinacoesSorteadas.getValueAt(i, 0).toString().trim().split(" ")) {
                    compara = (Arrays.binarySearch(combinacao.trim().split(" "), numCombinacao) >= 0) ? somadequatorze += 1 : 0;
                };
                switch(somadequatorze){
                    case 6:
                        total[0] += 1;
                        break;
                    
                    case 7:
                        total[1] += 1;
                        break;
                        
                    case 8:
                        total[2] += 1;
                        break;
                    
                    case 9:
                        total[3] += 1;
                        break;
                        
                    case 10:
                        total[4] += 1;
                        break;
                        
                    case 11:
                        total[5] += 1;
                        break;
                        
                    case 12:
                        total[6] += 1;
                        break;
                        
                    case 13:
                        total[7] += 1;
                        break;
                        
                    case 14:
                        total[8] += 1;
                        break;
                        
                    case 15:
                        total[9] += 1;
                        break;    
                }
                    compara = 0;
                    somadequatorze = 0;
                   
                   //break;
               //}                   
            }
            JOptionPane.showMessageDialog(null, total[1]);
        }  
        return total;
    }
}

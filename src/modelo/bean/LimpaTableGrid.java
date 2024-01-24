/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import static ViewBingo.frmDezenasMaisFortes.jtbDezenas;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ricar
 */
public class LimpaTableGrid {
    public void limpatablegrid(){
        
        DefaultTableModel dtmDezenas = (DefaultTableModel) jtbDezenas.getModel(); 
        
            jtbDezenas.removeAll();
                    
        for(int i = 24; i >= 0; i--){
            dtmDezenas.removeRow(i);             
        } 
       //dtmDezenas.setRowCount(24);
        //jtbDezenas.setModel(new DefaultTableModel(null, new String[]{"Dezenas", "Quantidade", "Percentual"}));
    }
}

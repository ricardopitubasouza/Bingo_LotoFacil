/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import static ViewBingo.frmSelecionarCombinacao.jtbCombinacoesSorteadas;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ricar
 */
public class BuscarNaTabela {
    
    public void BuscarNaTabela(String dezenas){
         DefaultTableModel obj = (DefaultTableModel) jtbCombinacoesSorteadas.getModel();
        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(obj);
        jtbCombinacoesSorteadas.setRowSorter(obj1);
        obj1.setRowFilter(RowFilter.regexFilter(dezenas));

    }
    
}

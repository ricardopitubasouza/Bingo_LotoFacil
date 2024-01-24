/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.dao.EscritordeQuinzePontos;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ricar
 */
public class ProximoNaLista {
    
    public void ProximoNaLista(int idInicial, int idFinal, int nivelcombinacao){
        
        int inicioDoNivel = 0, fimDoNivel = 0, contador = 0;
        int[] nivel = new int[5];
        String refDaCombinacao = "", idcombinacao = "";
        List<FifteenPoints>listadequinzepontos = new ArrayList<>();
    
        EscritordeQuinzePontos escritorDeQuinzePontos = new EscritordeQuinzePontos();
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        listadequinzepontos = escritorDeQuinzePontos.CombinacoesQuinzePontos(idInicial, idFinal);
        
        switch(nivelcombinacao) {
       
           case 2:
               inicioDoNivel = 1;
               fimDoNivel = 653752;
               break;
           case 1:
               inicioDoNivel = 653753;
               fimDoNivel = 1307504;
               break;
           case 0:
               inicioDoNivel = 1307505;
               fimDoNivel = 1961256;
               break;
           case -1:
               inicioDoNivel = 1961257;
               fimDoNivel = 2615008;
               break;
           case -2:
               inicioDoNivel = 2615009;
               fimDoNivel = 3268760;
               break;
         }
        
        for(FifteenPoints refcombquinzepontos : listadequinzepontos){
            contador += 1;
            if (Integer.parseInt(refcombquinzepontos.getRefcombfifteen()) >= inicioDoNivel && Integer.parseInt(refcombquinzepontos.getRefcombfifteen()) <= fimDoNivel && contador < listadequinzepontos.size()){
                refDaCombinacao = listadequinzepontos.get(contador).getRefcombfifteen();
                //JOptionPane.showMessageDialog(null, refDaCombinacao);
                if (Integer.parseInt(refDaCombinacao) <= 653752) {
                    nivel[0] += 1;
                } else if (Integer.parseInt(refDaCombinacao) > 653752 && Integer.parseInt(refDaCombinacao) <= 1307504) {
                    nivel[1] += 1;
                } else if (Integer.parseInt(refDaCombinacao) > 1307504 && Integer.parseInt(refDaCombinacao) <= 1961256) {
                    nivel[2] += 1;
                } else if (Integer.parseInt(refDaCombinacao) > 1961256 && Integer.parseInt(refDaCombinacao) <= 2615008) {
                    nivel[3] += 1;
                } else if (Integer.parseInt(refDaCombinacao) > 2615008) {
                    nivel[4] += 1;
                }
            }
        }
        
        dataset.setValue(nivel[0], ">=1 && <=653752", "");
        dataset.setValue(nivel[1], "> 653752 && <= 1307504", "");
        dataset.setValue(nivel[2], "> 1307504 && <= 1961256", "");
        dataset.setValue(nivel[3], "1961256 && <= 2615008", "");
        dataset.setValue(nivel[4], "> 2615008 && <=3268760", "");
        
        refDaCombinacao = "";
        contador = 0;
        
        nivel[0] = 0;
        nivel[1] = 0;
        nivel[2] = 0;
        nivel[3] = 0;
        nivel[4] = 0;
        
        JFreeChart chart = ChartFactory.createBarChart("Níveis dos sorteios",
                "Sorteios", "Níveis", dataset, PlotOrientation.VERTICAL, true, true, false);

        ChartFrame Frame1 = new ChartFrame("Gráfico de Barra", chart);
        Frame1.setVisible(true);
        Frame1.setSize(1960, 900);
        
    }
}

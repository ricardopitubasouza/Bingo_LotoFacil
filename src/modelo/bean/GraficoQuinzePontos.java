/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import FabricaDeConexao.EfetuaConeccao;
import java.util.ArrayList;
import java.util.List;
import modelos.dao.EscritordeQuatorzePontos;
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
public class GraficoQuinzePontos {
    
        public void GraficoQuinzePontos(int idinicial, int idfinal) {
        List<FifteenPoints> listadequinzepontos = new ArrayList<>();
        int[] pontonograficolevel = new int[5];

        EfetuaConeccao efetuarconeccao = new EfetuaConeccao();
        efetuarconeccao.EfetuaConeccao();
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();
        
        //dataset.setValue(-2, "", "");
        //dataset.setValue(2, "", "");
        
        listadequinzepontos = escritordequinzepontos.CombinacoesQuinzePontos(idinicial, idfinal);
 
        for (FifteenPoints refcombfifteen : listadequinzepontos) {
            //JOptionPane.showMessageDialog(null, refcombfifteen.getRefcombfifteen());
            if (Integer.parseInt(refcombfifteen.getRefcombfifteen()) <= 653752) {
                pontonograficolevel[0] += refcombfifteen.qtdfifteenpoints;
            } else if (Integer.parseInt(refcombfifteen.getRefcombfifteen()) > 653752 && Integer.parseInt(refcombfifteen.getRefcombfifteen()) <= 1307504) {
                pontonograficolevel[1] += refcombfifteen.qtdfifteenpoints;
            } else if (Integer.parseInt(refcombfifteen.getRefcombfifteen()) > 1307504 && Integer.parseInt(refcombfifteen.getRefcombfifteen()) <= 1961256) {
                pontonograficolevel[2] += refcombfifteen.qtdfifteenpoints;
            } else if (Integer.parseInt(refcombfifteen.getRefcombfifteen()) > 1961256 && Integer.parseInt(refcombfifteen.getRefcombfifteen()) <= 2615008) {
                pontonograficolevel[3] += refcombfifteen.qtdfifteenpoints;
            } else if (Integer.parseInt(refcombfifteen.getRefcombfifteen()) > 2615008) {
                pontonograficolevel[4] += refcombfifteen.qtdfifteenpoints;
            }
            //dataset.addValue(pontonograficolevel, "Nível", String.valueOf(refcombfourteen.getRefcombfourteen()));
        }
        
        dataset.setValue(pontonograficolevel[0], "<=653752", "");
        dataset.setValue(pontonograficolevel[1], "> 653752 && <= 1307504", "");
        dataset.setValue(pontonograficolevel[2], "> 1307504 && <= 1961256", "");
        dataset.setValue(pontonograficolevel[3], "1961256 && <= 2615008", "");
        dataset.setValue(pontonograficolevel[4], "> 2615008", "");
        
        JFreeChart chart = ChartFactory.createBarChart("Níveis dos sorteios",
                "Sorteios", "Níveis", dataset, PlotOrientation.VERTICAL, true, true, false);

        ChartFrame Frame1 = new ChartFrame("Gráfico de Barra", chart);
        Frame1.setVisible(true);
        Frame1.setSize(1960, 900);
    }
}

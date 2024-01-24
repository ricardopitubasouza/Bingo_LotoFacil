/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import FabricaDeConexao.EfetuaConeccao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.dao.EscritordeQuatorzePontos;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ricar
 */
public class GraficoPorPartes {
    
        public void GraficoPorPartes(int idinicial, int idfinal) {
        List<FourteenPoints> listadequatorzepontosporparte = new ArrayList<>();
        int[] pontonograficolevel = new int[5];

        EfetuaConeccao efetuarconeccao = new EfetuaConeccao();
        efetuarconeccao.EfetuaConeccao();
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        EscritordeQuatorzePontos escritordequatorzepontos = new EscritordeQuatorzePontos();
        
        //dataset.setValue(-2, "", "");
        //dataset.setValue(2, "", "");
        
        listadequatorzepontosporparte = escritordequatorzepontos.CombinacoesQuatorzePorParte(idinicial, idfinal);
        int totalcombinacoes = listadequatorzepontosporparte.size();
        JOptionPane.showMessageDialog(null, listadequatorzepontosporparte.size());
        for (FourteenPoints refcombfourteen : listadequatorzepontosporparte) {
            if (refcombfourteen.getRefcombfourteen() <= idinicial + ((idfinal - idinicial)/5)) {
                pontonograficolevel[0] += refcombfourteen.qtdefourteenpoints;
            } else if (refcombfourteen.getRefcombfourteen() > idinicial + ((idfinal - idinicial)/5) 
                    && refcombfourteen.getRefcombfourteen() <= idinicial + ((idfinal - idinicial)/2.5)) {
                pontonograficolevel[1] += refcombfourteen.qtdefourteenpoints;
            } else if (refcombfourteen.getRefcombfourteen() > idinicial + ((idfinal - idinicial)/2.5)
                    && refcombfourteen.getRefcombfourteen() <= idinicial + ((idfinal - idinicial)/1.666666666666667)) {
                pontonograficolevel[2] += refcombfourteen.qtdefourteenpoints;
            } else if (refcombfourteen.getRefcombfourteen() > idinicial + ((idfinal - idinicial)/1.666666666666667)
                    && refcombfourteen.getRefcombfourteen() <= idinicial + ((idfinal - idinicial)/1.25)) {
                pontonograficolevel[3] += refcombfourteen.qtdefourteenpoints;
            } else if (refcombfourteen.getRefcombfourteen() > idinicial + ((idfinal - idinicial)/1.25)) {
                pontonograficolevel[4] += refcombfourteen.qtdefourteenpoints;
            }
            //dataset.addValue(pontonograficolevel, "Nível", String.valueOf(refcombfourteen.getRefcombfourteen()));
        }
        
        dataset.setValue(pontonograficolevel[0], "<= " + (idinicial + ((idfinal - idinicial)/5)), "");
        dataset.setValue(pontonograficolevel[1], "> " + (idinicial + ((idfinal - idinicial)/5)) + " && <= " + (idinicial + ((idfinal - idinicial)/2.5)), "");
        dataset.setValue(pontonograficolevel[2], "> " + (idinicial + ((idfinal - idinicial)/2.5) + " && <= " + (idinicial + ((idfinal - idinicial)/1.666666666666667))), "");
        dataset.setValue(pontonograficolevel[3], "> " + (idinicial + ((idfinal - idinicial)/1.666666666666667)) + " && <= " + (idinicial + ((idfinal - idinicial)/1.25)), "");
        dataset.setValue(pontonograficolevel[4], "> " + (idinicial + ((idfinal - idinicial)/1.25)), "");
        
        JFreeChart chart = ChartFactory.createBarChart("Níveis dos sorteios",
                "Sorteios", "Níveis", dataset, PlotOrientation.VERTICAL, true, true, false);

        ChartFrame Frame1 = new ChartFrame("Gráfico de Barra", chart);
        Frame1.setVisible(true);
        Frame1.setSize(1960, 900);
    }
}

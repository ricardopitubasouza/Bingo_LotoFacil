/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import FabricaDeConexao.EfetuaConeccao;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import modelos.dao.EscritordeQuatorzePontos;
import modelos.dao.EscritordeQuinzePontos;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ricar
 */
public class GraficoQuatorzePontos {
    
    public void GraficoQuatorzePontos(int idinicial, int idfinal) {
        List<FourteenPoints> listadequatorzepontos = new ArrayList<>();
        int[] pontonograficolevel = new int[5];
        int totalcombinacoes = 0;
        
        EfetuaConeccao efetuarconeccao = new EfetuaConeccao();
        efetuarconeccao.EfetuaConeccao();
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        EscritordeQuatorzePontos escritordequatorzepontos = new EscritordeQuatorzePontos();
        
        //dataset.setValue(-2, "", "");
        //dataset.setValue(2, "", "");
        totalcombinacoes = idfinal - idinicial;
        listadequatorzepontos = escritordequatorzepontos.CombinacoesQuatorzePorParte(idinicial, idfinal);
 
        for (FourteenPoints refcombfourteen : listadequatorzepontos) {
            //JOptionPane.showMessageDialog(null, refcombfifteen.getRefcombfifteen());
            /*
            if (refcombfourteen.getRefcombfourteen() <= 653752) {
                pontonograficolevel[0] += refcombfourteen.qtdefourteenpoints;
            } else if (refcombfourteen.getRefcombfourteen() > 653752 && refcombfourteen.getRefcombfourteen() <= 1307504) {
                pontonograficolevel[1] += refcombfourteen.qtdefourteenpoints;
            } else if (refcombfourteen.getRefcombfourteen() > 1307504 && refcombfourteen.getRefcombfourteen() <= 1961256) {
                pontonograficolevel[2] += refcombfourteen.qtdefourteenpoints;
            } else if (refcombfourteen.getRefcombfourteen() > 1961256 && refcombfourteen.getRefcombfourteen() <= 2615008) {
                pontonograficolevel[3] += refcombfourteen.qtdefourteenpoints;
            } else if (refcombfourteen.getRefcombfourteen() > 2615008) {
                pontonograficolevel[4] += refcombfourteen.qtdefourteenpoints;
            }
            */
            if (refcombfourteen.getRefcombfourteen() <= (totalcombinacoes/5)+idinicial) {
                pontonograficolevel[0] += refcombfourteen.qtdefourteenpoints;
            } else if (refcombfourteen.getRefcombfourteen() > totalcombinacoes/5+(1 + idinicial) && refcombfourteen.getRefcombfourteen() <= (totalcombinacoes/5)*2+(1 + idinicial)) {
                pontonograficolevel[1] += refcombfourteen.qtdefourteenpoints;
            } else if (refcombfourteen.getRefcombfourteen() > (totalcombinacoes/5)*2+(2 + idinicial) && refcombfourteen.getRefcombfourteen() <= (totalcombinacoes/5)*3+(2 + idinicial)) {
                pontonograficolevel[2] += refcombfourteen.qtdefourteenpoints;
            } else if (refcombfourteen.getRefcombfourteen() > (totalcombinacoes/5)*3+(3 + idinicial) && refcombfourteen.getRefcombfourteen() <= (totalcombinacoes/5)*4+(3 + idinicial)) {
                pontonograficolevel[3] += refcombfourteen.qtdefourteenpoints;
            } else if (refcombfourteen.getRefcombfourteen() > (totalcombinacoes/5)*4+(4 +idinicial)) {
                pontonograficolevel[4] += refcombfourteen.qtdefourteenpoints;
            }
            //dataset.addValue(pontonograficolevel, "Nível", String.valueOf(refcombfourteen.getRefcombfourteen()));
        }
        
        dataset.setValue(pontonograficolevel[0], "<= "+((totalcombinacoes/5)+idinicial)+" ", "");
        dataset.setValue(pontonograficolevel[1], "> "+(totalcombinacoes/5+(1 + idinicial))+" && <= "+((totalcombinacoes/5)*2+(1 + idinicial))+" ", "");
        dataset.setValue(pontonograficolevel[2], "> "+((totalcombinacoes/5)*2+(2 + idinicial))+" && <= "+((totalcombinacoes/5)*3+(2 + idinicial))+" ", "");
        dataset.setValue(pontonograficolevel[3], "> "+((totalcombinacoes/5)*3+(3 + idinicial))+" && <= "+((totalcombinacoes/5)*4+(3 + idinicial))+" ", "");
        dataset.setValue(pontonograficolevel[4], "> "+((totalcombinacoes/5)*4+(4 + idinicial))+" ", "");
        
        JFreeChart chart = ChartFactory.createBarChart("Níveis dos sorteios",
                "Sorteios", "Níveis", dataset, PlotOrientation.VERTICAL, true, true, false);

        ChartFrame Frame1 = new ChartFrame("Gráfico de Barra", chart);
        Frame1.setVisible(true);
        Frame1.setSize(1960, 900);
    }
}

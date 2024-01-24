/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import FabricaDeConexao.EfetuaConeccao;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.dao.EscritordeQuinzePontos;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.xy.XYSeries;

/**
 *
 * @author Pituba
 */
public class GraficoNivel {

    public void GraficoNivel(int idinicial, int idfinal) {
        List<FifteenPoints> listadequinzepontos = new ArrayList<>();
        int pontonograficolevel = 0;

        EfetuaConeccao efetuarconeccao = new EfetuaConeccao();
        efetuarconeccao.EfetuaConeccao();
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();
        
        dataset.setValue(-2, "", "");
        dataset.setValue(2, "", "");
        listadequinzepontos = escritordequinzepontos.CombinacoesQuinzePontos(idinicial, idfinal);
 
        for (FifteenPoints refcombfifteen : listadequinzepontos) {
            //JOptionPane.showMessageDialog(null, refcombfifteen.getRefcombfifteen());
            if (Integer.parseInt(refcombfifteen.getRefcombfifteen()) <= 653752) {
                pontonograficolevel = 2;
            } else if (Integer.parseInt(refcombfifteen.getRefcombfifteen()) > 653752 && Integer.parseInt(refcombfifteen.getRefcombfifteen()) <= 1307504) {
                pontonograficolevel = 1;
            } else if (Integer.parseInt(refcombfifteen.getRefcombfifteen()) > 1307504 && Integer.parseInt(refcombfifteen.getRefcombfifteen()) <= 1961256) {
                pontonograficolevel = 0;
            } else if (Integer.parseInt(refcombfifteen.getRefcombfifteen()) > 1961256 && Integer.parseInt(refcombfifteen.getRefcombfifteen()) <= 2615008) {
                pontonograficolevel = -1;
            } else if (Integer.parseInt(refcombfifteen.getRefcombfifteen()) > 2615008) {
                pontonograficolevel = -2;
            }
            dataset.addValue(pontonograficolevel, "Nível", String.valueOf(Integer.parseInt(refcombfifteen.getRefcombfifteen())));
        }
        
        JFreeChart chart = ChartFactory.createLineChart("Níveis dos sorteios",
                "Sorteios", "Níveis", dataset, PlotOrientation.VERTICAL, true, true, false);

        chart.setBackgroundPaint(Color.WHITE);
        chart.getTitle().setPaint(Color.BLUE);
        CategoryPlot p = chart.getCategoryPlot();
        p.setForegroundAlpha(0.9f);
        p.setRangeGridlinePaint(Color.black);
        p.setDomainGridlinesVisible(true);
        p.setDomainGridlinePaint(Color.BLACK);
        CategoryItemRenderer renderer = p.getRenderer();
        renderer.setSeriesPaint(1, Color.RED);
        renderer.setSeriesPaint(0, Color.WHITE);
        ChartFrame Frame1 = new ChartFrame("Gráfico de Linha", chart);
        Frame1.setVisible(true);
        Frame1.setSize(1360, 300);
    }
}

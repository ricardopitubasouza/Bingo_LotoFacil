/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import FabricaDeConexao.EfetuaConeccao;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ricar
 */
public class GraficoPontosAnterioresPorPartes {
    
     public void GraficoDePontosAnterioresPorPartes(int idinicial, int idfinal){
    
        EfetuaConeccao efetuarconeccao = new EfetuaConeccao();
        efetuarconeccao.EfetuaConeccao();
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        PontosNasAnterioresSorteiosPorPartes pontosnasanteriores = new PontosNasAnterioresSorteiosPorPartes();
        pontosnasanteriores.PontosNasAnteriores(idinicial, idfinal);
        dataset.setValue(pontosnasanteriores.pontos[0], "5 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[1], "6 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[2], "7 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[3], "8 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[4], "9 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[5], "10 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[6], "11 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[7], "12 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[8], "13 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[9], "14 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[10], "15 Pontos", "");
        
        JFreeChart chart = ChartFactory.createBarChart("Gráfico da pontuação",
                "Quantidade de Pontos", "Pontos", dataset, PlotOrientation.VERTICAL, true, true, false);

        ChartFrame Frame1 = new ChartFrame("Gráfico de Barra", chart);
        Frame1.setVisible(true);
        Frame1.setSize(1960, 900);
          
    }
     
     public void GraficoDePontosAnterioresPorPartes(int idinicial, int idfinal, 
             String combinacao){
    
        EfetuaConeccao efetuarconeccao = new EfetuaConeccao();
        efetuarconeccao.EfetuaConeccao();
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        PontosNasAnterioresSorteiosPorPartes pontosnasanteriores = new PontosNasAnterioresSorteiosPorPartes();
        pontosnasanteriores.PontosNasAnteriores(idinicial, idfinal, combinacao);
        dataset.setValue(pontosnasanteriores.pontos[0], "5 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[1], "6 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[2], "7 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[3], "8 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[4], "9 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[5], "10 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[6], "11 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[7], "12 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[8], "13 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[9], "14 Pontos", "");
        dataset.setValue(pontosnasanteriores.pontos[10], "15 Pontos", "");
        
        JFreeChart chart = ChartFactory.createBarChart("Gráfico da pontuação",
                "Quantidade de Pontos", "Pontos", dataset, PlotOrientation.VERTICAL, true, true, false);

        ChartFrame Frame1 = new ChartFrame("Gráfico de Barra", chart);
        Frame1.setVisible(true);
        Frame1.setSize(1960, 900);
          
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import FabricaDeConexao.EfetuaConeccao;
import java.util.ArrayList;
import java.util.List;
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
public class GraficoPontosDezenas {
    public void GraficoPontosDezenas(int idinicial, int idfinal){
    
        EfetuaConeccao efetuarconeccao = new EfetuaConeccao();
        efetuarconeccao.EfetuaConeccao();
        
        List<CombinacoesDTO> todascombinacoesquinzepontos = new ArrayList<>();
        EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();
        todascombinacoesquinzepontos = escritordequinzepontos.todasCombinacoesQuinzePontos(idinicial, idfinal);
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ListaDezenasMaisSorteadas listaDezenasMaisSorteadas = new ListaDezenasMaisSorteadas();
        listaDezenasMaisSorteadas.ListaDezenasMaisSorteadas(idinicial, idfinal, todascombinacoesquinzepontos);
        dataset.setValue(listaDezenasMaisSorteadas.pontos[0], "5 Pontos", "");
        dataset.setValue(listaDezenasMaisSorteadas.pontos[1], "6 Pontos", "");
        dataset.setValue(listaDezenasMaisSorteadas.pontos[2], "7 Pontos", "");
        dataset.setValue(listaDezenasMaisSorteadas.pontos[3], "8 Pontos", "");
        dataset.setValue(listaDezenasMaisSorteadas.pontos[4], "9 Pontos", "");
        dataset.setValue(listaDezenasMaisSorteadas.pontos[5], "10 Pontos", "");
        dataset.setValue(listaDezenasMaisSorteadas.pontos[6], "11 Pontos", "");
        dataset.setValue(listaDezenasMaisSorteadas.pontos[7], "12 Pontos", "");
        dataset.setValue(listaDezenasMaisSorteadas.pontos[8], "13 Pontos", "");
        dataset.setValue(listaDezenasMaisSorteadas.pontos[9], "14 Pontos", "");
        dataset.setValue(listaDezenasMaisSorteadas.pontos[10], "15 Pontos", "");
        
        JFreeChart chart = ChartFactory.createBarChart("Gráfico da pontuação",
                "Quantidade de Pontos", "Pontos", dataset, PlotOrientation.VERTICAL, true, true, false);

        ChartFrame Frame1 = new ChartFrame("Gráfico de Barra", chart);
        Frame1.setVisible(true);
        Frame1.setSize(1960, 900);
          
    }
}

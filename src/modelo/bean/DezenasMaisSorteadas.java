/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import FabricaDeConexao.EfetuaConeccao;
import ViewBingo.frmDezenasMaisFortes;
import static ViewBingo.frmDezenasMaisFortes.jtbDezenas;
import static ViewBingo.frmDezenasMaisFortes.txtTotalCombinacoes;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.dao.EscritordeQuinzePontos;

/**
 *
 * @author ricar
 */
public class DezenasMaisSorteadas {
    //frmDezenasMaisFortes frmdezenasmaisfortes;
    
    public void DezenasMaisSorteadas(int idinicial, int idfinal, List combinacoesSorteadas){
        EfetuaConeccao efetuarconeccao = new EfetuaConeccao();
        efetuarconeccao.EfetuaConeccao();
        DefaultTableModel dtmDezenas = (DefaultTableModel) jtbDezenas.getModel();
        List<CombinacoesDTO> todascombinacoesquinzepontos = new ArrayList<>();
        List<Dezenas> dezenasmaissorteadas = new ArrayList<>();
        int[] tabeladezena = new int[26];
        boolean contem;
        String dezena;
        CalculaDezenasMaisSorteadas calculadezenasmaissorteadas = new CalculaDezenasMaisSorteadas();
        //EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();
        //todascombinacoesquinzepontos = escritordequinzepontos.todasCombinacoesQuinzePontosPorPartes(idinicial, idfinal);
        
                txtTotalCombinacoes.setText(Integer.toString(combinacoesSorteadas.size()));
                dezenasmaissorteadas = calculadezenasmaissorteadas.DezenasMaisSorteadas(idinicial, idfinal, combinacoesSorteadas);
                
        for(Dezenas dezenasemordem : dezenasmaissorteadas){
            Object[] dadosDezenas = {dezenasemordem.getDezena(), dezenasemordem.getQuantidade(), String.format("%.1f",dezenasemordem.getPercentual())+ "%"};
            dtmDezenas.addRow(dadosDezenas);
        }
  
            dtmDezenas.removeRow(0);
    
        //todascombinacoesquinzepontos = null;
        dezenasmaissorteadas = null;
    }
 
}

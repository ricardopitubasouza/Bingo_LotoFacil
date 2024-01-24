/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import FabricaDeConexao.EfetuaConeccao;
import static ViewBingo.frmDezenasMaisFortes.jtbDezenas;
import static ViewBingo.frmDezenasMaisFortes.txtTotalCombinacoes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelos.dao.EscritordeQuinzePontos;

/**
 *
 * @author ricar
 */
public class CalculaDezenasMaisSorteadas {
    
        public List<Dezenas> DezenasMaisSorteadas(int idinicial, int idfinal, List combinacoesSorteadas){
        EfetuaConeccao efetuarconeccao = new EfetuaConeccao();
        efetuarconeccao.EfetuaConeccao();
        List<CombinacoesDTO> todascombinacoesquinzepontos = new ArrayList<>();
        List<Dezenas> dezenasmaissorteadas = new ArrayList<>();
        int[] tabeladezena = new int[26];
        boolean contem;
        String dezena;
        //EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();
        //todascombinacoesquinzepontos = escritordequinzepontos.todasCombinacoesQuinzePontos(idinicial, idfinal);
        todascombinacoesquinzepontos = combinacoesSorteadas;
        for(CombinacoesDTO combinacao : todascombinacoesquinzepontos){
                
                for(int i = 1; i <= 25; i++){
         
                    dezena = i < 10? dezena = "0" + Integer.toString(i):Integer.toString(i);
                    contem = combinacao.getCombinacao().contains(dezena);         
                    tabeladezena[i] = contem? tabeladezena[i]+= 1: tabeladezena[i];
                }       
        }
        for(int i = 1; i <= 25; i++){
            
                    //double percentual = (tabeladezena[i] / (double)todascombinacoesquinzepontos.size()) * 100;
                    double percentual = ((tabeladezena[i] * 100) / (double)todascombinacoesquinzepontos.size());
                    dezena = i < 10? dezena = "0" + Integer.toString(i):Integer.toString(i);
                    dezenasmaissorteadas.add(new Dezenas(dezena, tabeladezena[i], percentual));
                }
        
        Collections.sort(dezenasmaissorteadas, new ComparatorDozens());
    
        todascombinacoesquinzepontos = null;
        
        return dezenasmaissorteadas;
    }
}

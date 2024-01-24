/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import java.util.ArrayList;
import java.util.List;
import modelos.dao.EscritordeQuinzePontos;

/**
 *
 * @author ricar
 */
public class PontosNaAnteriorSorteiosPorPartes {
    int[] pontos = new int[11];
    public void PontosNaAnterior(int idinicial, int idfinal){
        
        List<CombinacoesDTO> pontosNaAnterior = new ArrayList<>();
        
          EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();
          pontosNaAnterior = escritordequinzepontos.combinacoesSelecionadasPorPartes(idinicial, idfinal);  
        
        PontosNaAnterior listaPontosNaAnterior = new PontosNaAnterior();
        listaPontosNaAnterior.PontosNaAnterior(pontosNaAnterior);
        pontos[0] = listaPontosNaAnterior.pontos[0];
        pontos[1] = listaPontosNaAnterior.pontos[1];
        pontos[2] = listaPontosNaAnterior.pontos[2];
        pontos[3] = listaPontosNaAnterior.pontos[3];
        pontos[4] = listaPontosNaAnterior.pontos[4];
        pontos[5] = listaPontosNaAnterior.pontos[5];
        pontos[6] = listaPontosNaAnterior.pontos[6];
        pontos[7] = listaPontosNaAnterior.pontos[7];
        pontos[8] = listaPontosNaAnterior.pontos[8];
        pontos[9] = listaPontosNaAnterior.pontos[9];
        pontos[10] = listaPontosNaAnterior.pontos[10];
    }
    
    public void PontosNaAnterior(int idinicial, int idfinal, String combinacao){
        
        List<CombinacoesDTO> pontosNaAnterior = new ArrayList<>();
        
          EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();
          pontosNaAnterior = escritordequinzepontos.combinacoesSelecionadasPorPartes(idinicial, idfinal);  
        
        PontosNaAnterior listaPontosNaAnterior = new PontosNaAnterior();
        listaPontosNaAnterior.PontosNaAnterior(pontosNaAnterior, combinacao);
        pontos[0] = listaPontosNaAnterior.pontos[0];
        pontos[1] = listaPontosNaAnterior.pontos[1];
        pontos[2] = listaPontosNaAnterior.pontos[2];
        pontos[3] = listaPontosNaAnterior.pontos[3];
        pontos[4] = listaPontosNaAnterior.pontos[4];
        pontos[5] = listaPontosNaAnterior.pontos[5];
        pontos[6] = listaPontosNaAnterior.pontos[6];
        pontos[7] = listaPontosNaAnterior.pontos[7];
        pontos[8] = listaPontosNaAnterior.pontos[8];
        pontos[9] = listaPontosNaAnterior.pontos[9];
        pontos[10] = listaPontosNaAnterior.pontos[10];
    }
}

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
public class PontosNasAnterioresSorteiosPorPartes {
     int[] pontos = new int[11];
    public void PontosNasAnteriores(int idinicial, int idfinal){
        
        List<CombinacoesDTO> pontosNasAnteriores = new ArrayList<>();
        
          EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();
          pontosNasAnteriores = escritordequinzepontos.combinacoesSelecionadasPorPartesAsc(idinicial, idfinal);  
        
        PontosNasAnteriores listaPontosNasAnteriores = new PontosNasAnteriores();
        listaPontosNasAnteriores.PontosNasAnteriores(pontosNasAnteriores);
        pontos[0] = listaPontosNasAnteriores.pontos[0];
        pontos[1] = listaPontosNasAnteriores.pontos[1];
        pontos[2] = listaPontosNasAnteriores.pontos[2];
        pontos[3] = listaPontosNasAnteriores.pontos[3];
        pontos[4] = listaPontosNasAnteriores.pontos[4];
        pontos[5] = listaPontosNasAnteriores.pontos[5];
        pontos[6] = listaPontosNasAnteriores.pontos[6];
        pontos[7] = listaPontosNasAnteriores.pontos[7];
        pontos[8] = listaPontosNasAnteriores.pontos[8];
        pontos[9] = listaPontosNasAnteriores.pontos[9];
        pontos[10] = listaPontosNasAnteriores.pontos[10];
    }
    
     public void PontosNasAnteriores(int idinicial, int idfinal, String combinacao){
        
        List<CombinacoesDTO> pontosNasAnteriores = new ArrayList<>();
        
          EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();
          pontosNasAnteriores = escritordequinzepontos.combinacoesSelecionadasPorPartesAsc(idinicial, idfinal);  
        
        PontosNasAnteriores listaPontosNasAnteriores = new PontosNasAnteriores();
        listaPontosNasAnteriores.PontosNasAnteriores(pontosNasAnteriores, combinacao);
        pontos[0] = listaPontosNasAnteriores.pontos[0];
        pontos[1] = listaPontosNasAnteriores.pontos[1];
        pontos[2] = listaPontosNasAnteriores.pontos[2];
        pontos[3] = listaPontosNasAnteriores.pontos[3];
        pontos[4] = listaPontosNasAnteriores.pontos[4];
        pontos[5] = listaPontosNasAnteriores.pontos[5];
        pontos[6] = listaPontosNasAnteriores.pontos[6];
        pontos[7] = listaPontosNasAnteriores.pontos[7];
        pontos[8] = listaPontosNasAnteriores.pontos[8];
        pontos[9] = listaPontosNasAnteriores.pontos[9];
        pontos[10] = listaPontosNasAnteriores.pontos[10];
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.dao.EscritordeQuinzePontos;

/**
 *
 * @author ricar
 */
public class GraficoProbabilidadeNivel {
    
    public void GraficoProbabilidadeNivel(String combinacaoSorteada, int idInicial, int idFinal){
       
        int pontonograficolevel = 0;
        EscritordeQuinzePontos escritorDeQuinzePontos = new EscritordeQuinzePontos();
        int idCombinacaoSorteada = escritorDeQuinzePontos.BuscaIdCombination(combinacaoSorteada);
        
        if (idCombinacaoSorteada <= 653752) {
                pontonograficolevel = 2;
            } else if (idCombinacaoSorteada > 653752 && idCombinacaoSorteada <= 1307504) {
                pontonograficolevel = 1;
            } else if (idCombinacaoSorteada > 1307504 && idCombinacaoSorteada <= 1961256) {
                pontonograficolevel = 0;
            } else if (idCombinacaoSorteada > 1961256 && idCombinacaoSorteada <= 2615008) {
                pontonograficolevel = -1;
            } else if (idCombinacaoSorteada > 2615008) {
                pontonograficolevel = -2;
            }
        
         ProximoNaLista proximoNaLista = new ProximoNaLista();
         proximoNaLista.ProximoNaLista(idInicial, idFinal, pontonograficolevel);
        }   
}

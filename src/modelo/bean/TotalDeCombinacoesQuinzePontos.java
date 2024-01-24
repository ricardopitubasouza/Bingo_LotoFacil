/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import FabricaDeConexao.EfetuaConeccao;
import javax.swing.JOptionPane;
import modelos.dao.EscritordeQuinzePontos;

/**
 *
 * @author ricar
 */
public class TotalDeCombinacoesQuinzePontos {
    
    int totalCombinacoesDeQuinzePontos;
    
    public int TotalDeCombinacoesQuinzePontos(int idinicial, int idfinal){
        
        EscritordeQuinzePontos escritorDeQuinzePontos = new EscritordeQuinzePontos();
        totalCombinacoesDeQuinzePontos = escritorDeQuinzePontos.todasCombinacoesQuinzePontos(idinicial, idfinal).size();
        //JOptionPane.showMessageDialog(null, totalCombinacoesDeQuinzePontos);
        return totalCombinacoesDeQuinzePontos;
    }
    
}

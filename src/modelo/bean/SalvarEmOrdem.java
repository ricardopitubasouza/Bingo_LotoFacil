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
import modelos.dao.TotalProbabilidadeDAO;

/**
 *
 * @author ricar
 */
public class SalvarEmOrdem {
     
    public List<Combinacoes> SalvarEmOrdem(){
        
        EfetuaConeccao efetuarconeccao = new EfetuaConeccao();
     efetuarconeccao.EfetuaConeccao();   
       
       //TotalProbabilidadeDAO totalprobabilidadedao = new TotalProbabilidadeDAO();
       EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();
        
        List<Combinacoes>combinacoesemordem = new ArrayList<>();
        
        combinacoesemordem = escritordequinzepontos.totalDeCombinacoesQuinzePontos();
        escritordequinzepontos.FecharConeccao();
        
        return combinacoesemordem;
    }
}

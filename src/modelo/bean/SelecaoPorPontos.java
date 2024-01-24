/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import FabricaDeConexao.EfetuaConeccao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.dao.TotalProbabilidadeDAO;

/**
 *
 * @author ricar
 */
public class SelecaoPorPontos {
    
    public void SelecaoPorPontos(int idinicial, int idfinal, int pontominimo, int pontomaximo, String combinacaodecomparacao){
        
        EfetuaConeccao efetuarconeccao = new EfetuaConeccao();
        efetuarconeccao.EfetuaConeccao();
        
        int compara = 0, somadepontos = 0, pontoinicial = pontominimo, pontofinal = pontomaximo;
        //String combinacaoparacomparacao;
        List<Combinacoes> combinacoesselecionadas = new ArrayList<>();
        List<Combinacoes> combinacoespeneradas = new ArrayList<>();
        
        TotalProbabilidadeDAO totalprobabilidadedao = new TotalProbabilidadeDAO();     
        combinacoesselecionadas = totalprobabilidadedao.CombinacoesSelecionadas(idinicial, idfinal);
/*
        EfetuaConeccao efetuarconeccao1 = new EfetuaConeccao();
        efetuarconeccao1.EfetuaConeccao();
        
        combinacaoparacomparacao = combinacaodecomparacao;
*/
        for(Combinacoes combinacoes : combinacoesselecionadas){

            for (String numCombinacao : combinacoes.getCombinacao().trim().split(" ")) {
                        compara = (Arrays.binarySearch(combinacaodecomparacao.trim().split(" "), numCombinacao) >= 0) ? somadepontos += 1 : somadepontos;
                    };
;
                    if(compara == pontoinicial || compara == pontofinal)combinacoespeneradas.add(combinacoes);

                    somadepontos = 0;
        }
        JOptionPane.showMessageDialog(null, combinacoespeneradas.size(),"Penerando!",JOptionPane.QUESTION_MESSAGE);
    }
    
}

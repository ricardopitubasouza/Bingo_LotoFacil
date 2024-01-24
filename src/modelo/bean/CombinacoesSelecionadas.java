/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import FabricaDeConexao.EfetuaConeccao;
import ViewBingo.frmSelecionarCombinacao;
import static ViewBingo.frmSelecionarCombinacao.jtbCombinacoesSorteadas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import modelos.dao.EscritordeQuatorzePontos;
import modelos.dao.EscritordeQuinzePontos;
import modelos.dao.TotalProbabilidadeDAO;

/**
 *
 * @author ricar
 */
public class CombinacoesSelecionadas {
        
    public void CombinacoesSelecionadas(int idinicial, int idfinal, int pontosnasdezenasmaissorteadas, 
        int pontosnosorteioanterior, int pontosporpartes, String dez1, String dez2, String dez3, String dez4,
            String dez5, String dez6, String dez7, String dez8, String dez9, String dez10, String dez11, String dez12,
            String dez13, String dez14, String dez15, String dez16, String dez17, String dez18, String dez19, String dez20){
        frmSelecionarCombinacao frmselecionarcombinacao = null;
        int compara = 0, somadepontos = 0, contador = 0;
        String dadosDezenas = "";
        List<Combinacoes> combinacoesSelecionadas = new ArrayList<>();
        List<Dezenas> dezenasMaisSorteadas = new ArrayList<>();
        List<Combinacoes> combinacoesSelecionadasPorPontos = new ArrayList<>();
        List<Dezenas> dezenasmaissorteadas = new ArrayList<>();
        List<CombinacoesDTO> todascombinacoesquinzepontos = new ArrayList<>();
        
        EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();
        todascombinacoesquinzepontos = escritordequinzepontos.todasCombinacoesQuinzePontos(idinicial, idfinal);
        
        TotalProbabilidadeDAO totalProbabilidadeDao = new TotalProbabilidadeDAO();
        combinacoesSelecionadas = totalProbabilidadeDao.CombinacoesSelecionadasContendoDezenas(idinicial, idfinal, dez1, dez2,
        dez3, dez4, dez5, dez6, dez7, dez8, dez9, dez10, dez11, dez12, dez13, dez14, dez15, dez16, dez17, dez18, dez19, dez20);
        
        TotalProbabilidadeDAO totalProbabilidadedaoUltimoSorteio = new TotalProbabilidadeDAO();
        CombinacoesDTO ultimosorteio = totalProbabilidadedaoUltimoSorteio.CombinacaoUltimoSorteio();
        if(pontosnosorteioanterior > 0){
        for(Combinacoes combinacoes : combinacoesSelecionadas){
            for (String numCombinacao : combinacoes.getCombinacao().trim().split(" ")) {
                        compara = (Arrays.binarySearch(ultimosorteio.getCombinacao().trim().split(" "), numCombinacao) >= 0) ? somadepontos += 1 : somadepontos;
                    }
                    
                    if(compara == pontosnosorteioanterior)combinacoesSelecionadasPorPontos.add(combinacoes);
                    
                    compara = 0;
                    somadepontos = 0;
        }
        }else {
               for(Combinacoes combinacoes : combinacoesSelecionadas){
                   combinacoesSelecionadasPorPontos.add(combinacoes);
               }
        }
        //combinacoesSelecionadas.clear();

        if(pontosnasdezenasmaissorteadas > 0){
            combinacoesSelecionadas.clear();
        CalculaDezenasMaisSorteadas calculadezenasmaissorteadas = new CalculaDezenasMaisSorteadas();
        dezenasmaissorteadas = calculadezenasmaissorteadas.DezenasMaisSorteadas(1, combinacoesSelecionadasPorPontos.size(), todascombinacoesquinzepontos);
                dezenasMaisSorteadas = dezenasmaissorteadas.subList(0, 15);
                
                Collections.sort(dezenasMaisSorteadas, new ComparatorDozensCresc());
                
        for(Dezenas dezenasemordem : dezenasMaisSorteadas){
             dadosDezenas += dezenasemordem.getDezena()+" ";
             //contador += 1;
        }
       
        for(Combinacoes combinacoes : combinacoesSelecionadasPorPontos){
            for (String numCombinacao : combinacoes.getCombinacao().trim().split(" ")) {
                //JOptionPane.showMessageDialog(null, dadosDezenas.trim().split(" "));
                        compara = (Arrays.binarySearch(dadosDezenas.trim().split(" "), numCombinacao) >= 0) ? somadepontos += 1 : somadepontos;
                    }
                    //JOptionPane.showMessageDialog(null, compara);
                    if(compara == pontosnasdezenasmaissorteadas)combinacoesSelecionadas.add(combinacoes);
                    
                    compara = 0;
                    somadepontos = 0;
        }
               combinacoesSelecionadasPorPontos.clear();
               for(Combinacoes combinacoes : combinacoesSelecionadas){
                   combinacoesSelecionadasPorPontos.add(combinacoes);
               }
               //combinacoesSelecionadas.clear();
               
        }
        
        EscritordeQuinzePontos escritorDeQuinzePontos = new EscritordeQuinzePontos();
        EscritordeQuatorzePontos escritorDeQuatorzePontos = new EscritordeQuatorzePontos();
        if(pontosporpartes > 0){
            combinacoesSelecionadas.clear();
            String ultimacombinacaoporpartes = escritorDeQuinzePontos.ultimaCombinacaoSelecaoPorPartes(idinicial, idfinal);
            
            for(Combinacoes combinacoes : combinacoesSelecionadasPorPontos){
            //JOptionPane.showMessageDialog(null, combinacoes.getCombinacao());
            for (String numCombinacao : combinacoes.getCombinacao().trim().split(" ")) {
            compara = (Arrays.binarySearch(ultimacombinacaoporpartes.trim().split(" "), numCombinacao) >= 0) ? somadepontos += 1 : somadepontos;
            }
            if(compara == pontosporpartes)combinacoesSelecionadas.add(combinacoes);
            //JOptionPane.showMessageDialog(null, compara);
            compara = 0;
            somadepontos = 0;
            }
                combinacoesSelecionadasPorPontos.clear();
                for(Combinacoes combinacoes : combinacoesSelecionadas){
                   combinacoesSelecionadasPorPontos.add(combinacoes);
               } 
        }
        //combinacoesSelecionadasPorPontos.clear();
        
        List<String>todasCombinacoesComQuinzePontos = new ArrayList<>(); 
        List<String>todasCombinacoesComQuatorzePontos = new ArrayList<>();
        
        for(Combinacoes combinacoes : escritorDeQuinzePontos.totalDeCombinacoesQuinzePontos()){
            todasCombinacoesComQuinzePontos.add(combinacoes.getCombinacao());
        }
        for(Combinacoes combinacoes : escritorDeQuatorzePontos.totalDeCombinacoesQuatorzePontos()){
            todasCombinacoesComQuatorzePontos.add(combinacoes.getCombinacao());
        }
          
        //JOptionPane.showMessageDialog(null, todasCombinacoesComQuinzePontos.size());
        //JOptionPane.showMessageDialog(null, todasCombinacoesComQuatorzePontos.size());
          int conta = 0;
        for(Combinacoes combinacoes : combinacoesSelecionadas){
            //JOptionPane.showMessageDialog(null, combinacoes.getCombinacao().trim());

             if(todasCombinacoesComQuinzePontos.contains(combinacoes.getCombinacao().trim())){
              
                 combinacoesSelecionadasPorPontos.remove(combinacoes.getCombinacao());//continue;               
             }
                      
             if(todasCombinacoesComQuatorzePontos.contains(combinacoes.getCombinacao().trim())){

                 combinacoesSelecionadasPorPontos.remove(combinacoes);   
                 
             }
        }     
      
             //JOptionPane.showMessageDialog(null,"teste " +  combinacoes.getIdcombinacao());
              //combinacoesSelecionadasPorPontos.add(combinacoes);
               //combinacaoComQuinzePontos = null;
        
              /* combinacoesSelecionadasPorPontos.clear();
               for(Combinacoes combinacoes : combinacoesSelecionadas){
                   combinacoesSelecionadasPorPontos.add(combinacoes);
               }*/
        
        //JOptionPane.showMessageDialog(null, dadosDezenas);
        DefaultTableModel mdlCombinacoesSelecionadas = (DefaultTableModel) jtbCombinacoesSorteadas.getModel();
        
        for(Combinacoes combinacoes : combinacoesSelecionadasPorPontos){
            Object[] combinacoesPeneradas = {
                combinacoes.getCombinacao()
        };
            mdlCombinacoesSelecionadas.addRow(combinacoesPeneradas);
        }
        
        frmselecionarcombinacao.txtQuantidade.setText(String.valueOf(mdlCombinacoesSelecionadas.getRowCount()));
    }
    
}

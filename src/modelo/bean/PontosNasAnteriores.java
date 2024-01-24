/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ricar
 */
public class PontosNasAnteriores {
    int[] pontos = new int[11];
    public void PontosNasAnteriores(List combinacoesquinzepontos){//(int idinicial, int idfinal){
        String anterior, atual = " ", posterior;
        int somadepontos = 0, compara = 0;
        
        boolean partida = false;
        List<CombinacoesDTO> listadecombinacoes = new ArrayList<>();
        listadecombinacoes = combinacoesquinzepontos;
        
        List<CombinacoesAnterioresDTO> listadecombinacoesanteriores = new ArrayList<>();
        listadecombinacoesanteriores = combinacoesquinzepontos;
        //EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();
        //combinacoesquinzepontos = escritordequinzepontos.todasCombinacoesQuinzePontos(idinicial, idfinal);
        
        for(CombinacoesDTO combinacao : listadecombinacoes){
            //anterior = atual;
            if(partida == false){
                //atual = combinacao.getCombinacao();
                partida = true;
                continue;
            }
                
                posterior = combinacao.getCombinacao();
                for(CombinacoesDTO combinacoesanterioresdto : listadecombinacoes){
                    if(combinacoesanterioresdto.getCombinacao().equals(posterior) ) { 
                            break;
                    }
                    for (String numCombinacao : posterior.trim().split(" ")) {
                        compara = (Arrays.binarySearch(combinacoesanterioresdto.getCombinacao().trim().split(" "), numCombinacao) >= 0) ? somadepontos += 1 : somadepontos;
                    }
                    switch(compara){
                
                            case 5:
                                pontos[0] += 1;
                                break;
                            case 6:
                                pontos[1] += 1;
                                break;
                            case 7:
                                pontos[2] += 1;
                                break;
                            case 8:
                                pontos[3] += 1;
                                break;
                            case 9:
                                pontos[4] += 1;
                                break;
                            case 10:
                                pontos[5] += 1;
                                break;
                            case 11:
                                pontos[6] += 1;
                                break;
                            case 12:
                                pontos[7] += 1;
                                break;
                            case 13:
                                pontos[8] += 1;
                                break;
                            case 14:
                                pontos[9] += 1;
                                break;
                            case 15:
                                pontos[10] += 1;
                                break;
                    
                        }
                        somadepontos = 0;
                        compara = 0;
                }//atual = posterior;           
        }//JOptionPane.showMessageDialog(null, pontos[4]);
    }
   
    public void PontosNasAnteriores(List combinacoesquinzepontos, String sorteio){//(int idinicial, int idfinal){
       
        int somadepontos = 0, compara = 0;
        
        
        List<CombinacoesDTO> listadecombinacoes = new ArrayList<>();
        listadecombinacoes = combinacoesquinzepontos;
        
        for(CombinacoesDTO combinacao : listadecombinacoes){
         
                    for (String numCombinacao : sorteio.trim().split(" ")) {
                        compara = (Arrays.binarySearch(combinacao.getCombinacao().trim().split(" "), numCombinacao) >= 0) ? somadepontos += 1 : somadepontos;
                    }
                    switch(compara){
                
                            case 5:
                                pontos[0] += 1;
                                break;
                            case 6:
                                pontos[1] += 1;
                                break;
                            case 7:
                                pontos[2] += 1;
                                break;
                            case 8:
                                pontos[3] += 1;
                                break;
                            case 9:
                                pontos[4] += 1;
                                break;
                            case 10:
                                pontos[5] += 1;
                                break;
                            case 11:
                                pontos[6] += 1;
                                break;
                            case 12:
                                pontos[7] += 1;
                                break;
                            case 13:
                                pontos[8] += 1;
                                break;
                            case 14:
                                pontos[9] += 1;
                                break;
                            case 15:
                                pontos[10] += 1;
                                break;
                    
                        }
                        somadepontos = 0;
                        compara = 0;        
        }
    }
}

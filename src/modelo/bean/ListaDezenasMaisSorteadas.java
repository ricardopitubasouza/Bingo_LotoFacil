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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.dao.EscritordeQuinzePontos;

/**
 *
 * @author ricar
 */
public class ListaDezenasMaisSorteadas {
    int[] pontos = new int[11];
    public void ListaDezenasMaisSorteadas(int idinicial, int idfinal, List combinacoesquinzepontos){
       
        List<Dezenas> listadezenasmaissorteadas = new ArrayList<>();
        int limitador = 0, totalComQuinzePontos, compara = 0, somadequinze = 0;
        String dezenascombinadas = null, dezena;
        boolean contem;
        int[] tabeladezena = new int[26];
        
        List<CombinacoesDTO> todascombinacoesquinzepontos = new ArrayList<>();
        
        TotalDeCombinacoesQuinzePontos totalDeCombinacoesQuinzePontos = new TotalDeCombinacoesQuinzePontos();
        totalComQuinzePontos = totalDeCombinacoesQuinzePontos.TotalDeCombinacoesQuinzePontos(idinicial, idfinal);
        
        CalculaDezenasMaisSorteadas calculadezenasmaissorteadas = new CalculaDezenasMaisSorteadas();
        EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();
        
        for(int f = idinicial; f <= idfinal; f++){
            listadezenasmaissorteadas = calculadezenasmaissorteadas.DezenasMaisSorteadas(idinicial, f, combinacoesquinzepontos);
        
            if(f < idfinal)todascombinacoesquinzepontos = 
                    escritordequinzepontos.todasCombinacoesQuinzePontos(idinicial, 1 + f);
            //JOptionPane.showMessageDialog(null, escritordequinzepontos.todasCombinacoesQuinzePontos(idinicial, 1 + f));
        
            for(Dezenas dezenas : listadezenasmaissorteadas){
                limitador += 1;
            
                if(limitador == 16)break;
                dezenascombinadas += dezenas.getDezena() + " ";
                if(f < idfinal)
                compara = (Arrays.binarySearch(todascombinacoesquinzepontos.get(todascombinacoesquinzepontos.size()-1).getCombinacao().trim().split(" "),
                        dezenas.getDezena()) >= 0) ? somadequinze += 1 : somadequinze;
            }
        dezenascombinadas = dezenascombinadas.substring(4);
            //JOptionPane.showMessageDialog(null, compara);
            if(f <idfinal){
            //System.out.println(todascombinacoesquinzepontos.get(f).getCombinacao().trim());
            //System.out.println(dezenascombinadas.trim());
            //System.out.println(compara + "Pontos");
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
                    
                };
            }
            //JOptionPane.showMessageDialog(null, "Certo ou Errado? ","Conferindo",JOptionPane.OK_OPTION);
            dezenascombinadas = null;
            somadequinze = 0;
            compara = 0;
            limitador = 0;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import FabricaDeConexao.EfetuaConeccao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.dao.EscritordeQuinzePontos;

/**
 *
 * @author ricar
 */
public class Teste {
    public void Teste(int idinicial, int idfinal, List teste){
        
        EfetuaConeccao efetuarconeccao = new EfetuaConeccao();
        efetuarconeccao.EfetuaConeccao();
        
         List<Dezenas> listadezenasmaissorteadas = new ArrayList<>();
        int limitador = 0, totalComQuinzePontos, compara = 0, somadequinze = 0;
        String dezenascombinadas = null, dezena;
        boolean contem;
        int[] tabeladezena = new int[26];
        
        List<CombinacoesDTO> todascombinacoesquinzepontos = new ArrayList<>();
        
        //TotalDeCombinacoesQuinzePontos totalDeCombinacoesQuinzePontos = new TotalDeCombinacoesQuinzePontos();
        //totalComQuinzePontos = totalDeCombinacoesQuinzePontos.TotalDeCombinacoesQuinzePontos(idinicial, idfinal);
        
        //JOptionPane.showMessageDialog(null, totalComQuinzePontos, "Testando",JOptionPane.INFORMATION_MESSAGE);
        
        CalculaDezenasMaisSorteadas calculadezenasmaissorteadas = new CalculaDezenasMaisSorteadas();
        EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();
        
        for(int f = idinicial; f <= idfinal; f++){
            listadezenasmaissorteadas = calculadezenasmaissorteadas.DezenasMaisSorteadas(idinicial, f, teste);
            
            if(f < idfinal)todascombinacoesquinzepontos = 
                    escritordequinzepontos.todasCombinacoesQuinzePontos(idinicial, 1 + f);   
            JOptionPane.showMessageDialog(null, escritordequinzepontos.todasCombinacoesQuinzePontos(idinicial, 1 + f).size());
        }
        
    }
}

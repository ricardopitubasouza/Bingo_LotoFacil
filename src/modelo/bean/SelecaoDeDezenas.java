/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ricar
 */
public class SelecaoDeDezenas {

    public SelecaoDeDezenas(String dezenasIncluidas, String dezenasExcluidas, int idinicial, int idfinal, 
            int dezenasMaisSorteadas, int sorteioAnterior, int pontosPorPartes) {
        int indice = 0;
        DezenasSelecionadas dezenasSelecionadas = new DezenasSelecionadas();
        //List<String> dezenas = new ArrayList<>();
      if(!dezenasIncluidas.isEmpty()){  
        for(String dezena : dezenasIncluidas.split(" ")){
            if(indice == 0)dezenasSelecionadas.setDez1(dezena);
            if(indice == 1)dezenasSelecionadas.setDez2(dezena);
            if(indice == 2)dezenasSelecionadas.setDez3(dezena);
            if(indice == 3)dezenasSelecionadas.setDez4(dezena);
            if(indice == 4)dezenasSelecionadas.setDez5(dezena);
            if(indice == 5)dezenasSelecionadas.setDez6(dezena);
            if(indice == 6)dezenasSelecionadas.setDez7(dezena);
            if(indice == 7)dezenasSelecionadas.setDez8(dezena);
            if(indice == 8)dezenasSelecionadas.setDez9(dezena);
            if(indice == 9)dezenasSelecionadas.setDez10(dezena);
            //dezenas.add(dezena);
            indice +=1;
        }       
      }  
        indice = 0;
      if(!dezenasExcluidas.isEmpty()){          
        for(String dezena : dezenasExcluidas.split(" ")){
            if(indice == 0)dezenasSelecionadas.setDez11(dezena);
            if(indice == 1)dezenasSelecionadas.setDez12(dezena);
            if(indice == 2)dezenasSelecionadas.setDez13(dezena);
            if(indice == 3)dezenasSelecionadas.setDez14(dezena);
            if(indice == 4)dezenasSelecionadas.setDez15(dezena);
            if(indice == 5)dezenasSelecionadas.setDez16(dezena);
            if(indice == 6)dezenasSelecionadas.setDez17(dezena);
            if(indice == 7)dezenasSelecionadas.setDez18(dezena);
            if(indice == 8)dezenasSelecionadas.setDez19(dezena);
            if(indice == 9)dezenasSelecionadas.setDez20(dezena);
            //dezenas.add(dezena);
            indice +=1;
        }
      }  
        CombinacoesSelecionadas combinacoesSelecionadas = new CombinacoesSelecionadas();
        combinacoesSelecionadas.CombinacoesSelecionadas(idinicial, idfinal,
                dezenasMaisSorteadas, sorteioAnterior, pontosPorPartes, dezenasSelecionadas.getDez1(), 
                dezenasSelecionadas.getDez2(),dezenasSelecionadas.getDez3(), dezenasSelecionadas.getDez4(), 
                dezenasSelecionadas.getDez5(), dezenasSelecionadas.getDez6(),dezenasSelecionadas.getDez7(),
                dezenasSelecionadas.getDez8(), dezenasSelecionadas.getDez9(), dezenasSelecionadas.getDez10(), 
                dezenasSelecionadas.getDez11(), dezenasSelecionadas.getDez12(), dezenasSelecionadas.getDez13(),
                dezenasSelecionadas.getDez14(), dezenasSelecionadas.getDez15(), dezenasSelecionadas.getDez16(), 
                dezenasSelecionadas.getDez17(),dezenasSelecionadas.getDez18(), dezenasSelecionadas.getDez19(), 
                dezenasSelecionadas.getDez20());
  
    }
    
}

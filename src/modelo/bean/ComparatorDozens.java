/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 *
 * @author ricar
 */
public class ComparatorDozens implements Comparator<Dezenas>{

    @Override
    public int compare(Dezenas quantidade1, Dezenas quantidade2) {
        if(quantidade1.getQuantidade() > quantidade2.getQuantidade()){
            return -1;
        }
        return 1;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

/**
 *
 * @author ricar
 */
public class Dezenas {
    
    String dezena;
    int quantidade;
    double percentual;

    public Dezenas(){
    }
    
    public Dezenas(String dezena, int quantidade, double percentual){
        this.dezena = dezena;
        this.quantidade = quantidade;
        this.percentual = percentual;
    }
    
    public void setDezena(String dezena){
        this.dezena = dezena;
    }
    
    public String getDezena(){
        return dezena;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }
    

    @Override
    public String toString() {
        return " " + dezena + " = " + quantidade + " -> " + (int)percentual + "%";
    }
    
    
    
}

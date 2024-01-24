/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

/**
 *
 * @author Pituba
 */
public class Combinacoes {

    String combinacao, refcombfifteen;
    Integer idcombinacao;
    
    public Combinacoes() {
    }

    public Combinacoes(Integer idcombinacao, String combinacao) {
        this.idcombinacao = idcombinacao;
        this.combinacao = combinacao;
    }
    
    public String getRefcombfifteen() {
        return refcombfifteen;
    }

    public void setRefcombfifteen(String refcombfifteen) {
        this.refcombfifteen = refcombfifteen;
    }

    public Integer getIdcombinacao() {
        return idcombinacao;
    }

    public void setIdcombinacao(Integer idcombinacao) {
        this.idcombinacao = idcombinacao;
    }

    public String getCombinacao() {
        return combinacao;
    }

    public void setCombinacao(String combinacao) {
        this.combinacao = combinacao;
    }

    @Override
    public String toString() {
        return combinacao;
    }

}

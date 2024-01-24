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
public class CombinacoesAnterioresDTO {

    String combinacao, refcombfifteen;
    Integer idcombinacao, idcombinacaofifteen, qtdfifteenpoints, qtdefourteenpoints;
    
    public CombinacoesAnterioresDTO() {
    }

    public CombinacoesAnterioresDTO(Integer idcombinacao, String combinacao) {
        this.idcombinacao = idcombinacao;
        this.combinacao = combinacao;
    }
    
    public Integer getIdCombinacaoFifteen(){
        return idcombinacaofifteen;
    }
    
    public void setIdCombinacaoFifteen(Integer idcombinacaofifteen){
        this.idcombinacaofifteen = idcombinacaofifteen;
    }
    
    public String getRefcombfifteen() {
        return refcombfifteen;
    }

    public void setRefcombfifteen(String refcombfifteen) {
        this.refcombfifteen = refcombfifteen;
    }
    
    public Integer getQtdfifteenpoints() {
        return qtdfifteenpoints;
    }

    public void setQtdfifteenpoints(Integer qtdfifteenpoints) {
        this.qtdfifteenpoints = qtdfifteenpoints;
    }
    
    public Integer getQtdeFourteenPoints(){
        return qtdefourteenpoints;
    }
    
    public void setQtdeFourteenPoints(Integer qtdefourteenpoints){
        this.qtdefourteenpoints = qtdefourteenpoints;
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

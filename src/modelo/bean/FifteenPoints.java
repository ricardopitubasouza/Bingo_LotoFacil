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
public class FifteenPoints {
    
    String refcombfifteen; 
    Integer idcombfifteen, qtdfifteenpoints;

    public FifteenPoints() {
    }

    public FifteenPoints(String refcombfifteen, Integer idcombfifteen, Integer qtdfifteenpoints) {
        this.idcombfifteen = idcombfifteen;
        this.refcombfifteen = refcombfifteen;
        this.qtdfifteenpoints = qtdfifteenpoints;
    }

    public Integer getIdcombfifteen() {
        return idcombfifteen;
    }

    public void setIdcombfifteen(Integer idcombfifteen) {
        this.idcombfifteen = idcombfifteen;
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
    
    
}

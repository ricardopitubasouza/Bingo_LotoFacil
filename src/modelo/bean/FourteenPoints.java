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
public class FourteenPoints {
    
    int idcombfourteen, refcombfourteen, qtdefourteenpoints;

    public FourteenPoints() {
    }
    
    public FourteenPoints(int idcombfourteen, int refcombfourteen, int qtdefourteenpoints) {
        this.idcombfourteen = idcombfourteen;
        this.refcombfourteen = refcombfourteen;
        this.qtdefourteenpoints = qtdefourteenpoints;
    }

    public int getIdcombfourteen() {
        return idcombfourteen;
    }

    public void setIdcombfourteen(int idcombfourteen) {
        this.idcombfourteen = idcombfourteen;
    }

    public int getRefcombfourteen() {
        return refcombfourteen;
    }

    public void setRefcombfourteen(int refcombfourteen) {
        this.refcombfourteen = refcombfourteen;
    }

    public int getQtdefourteenpoints() {
        return qtdefourteenpoints;
    }

    public void setQtdefourteenpoints(int qtdefourteenpoints) {
        this.qtdefourteenpoints = qtdefourteenpoints;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

import FabricaDeConexao.EfetuaConeccao;

import static ViewBingo.frmSalvarTrezeeQuatorzePontos.lblPercentual;
import static ViewBingo.frmSalvarTrezeeQuatorzePontos.lblProcessando;
import static ViewBingo.frmSalvarTrezeeQuatorzePontos.pgbProcessando;
import modelos.dao.EscritordeQuatorzePontos;
import modelos.dao.EscritordeQuinzePontos;

/**
 *
 * @author ricar
 */
public class Selecaodequinzepontos {

    EfetuaConeccao efetuarconeccao = new EfetuaConeccao();

    public void selecaodequinzepontos(String combinacao) {

        int id;
        efetuarconeccao.EfetuaConeccao();

        EscritordeQuinzePontos escritorquinze = new EscritordeQuinzePontos();
        EscritordeQuatorzePontos escritorquatorze = new EscritordeQuatorzePontos();

        id = escritorquinze.BuscaIdCombination(combinacao);
        //jButton1.setEnabled(false);
        new Thread() {
            int quantidadeemquinze = 0, quantidadeemquatorze, idquinzepontos, percent = 0, quantidade = 0;

            @Override
            public void run() {
                if (escritorquinze.BuscadeQuinzepontos(combinacao).getRefcombfifteen() == null) {
                    quantidadeemquinze = 1;
                    quantidade += 1;
                    escritorquinze.EscritordeQuinzepontos(id, quantidadeemquinze);
                    idquinzepontos = escritorquinze.BuscaIdQuinzePontos(id);
                } else {
                    quantidade += 1;
                    idquinzepontos = escritorquinze.BuscaIdQuinzePontos(id);
                    quantidadeemquinze = (escritorquinze.BuscadeQuinzepontos(combinacao)).getQtdfifteenpoints() + 1;
                    escritorquinze.AtualizarEscritordeQuinzePontos(idquinzepontos, quantidadeemquinze);
                }
                quantidade += 1;
                quantidadeemquatorze = escritorquatorze.BuscaQtdedeQuatorzepontos(combinacao.trim());
                quantidadeemquatorze = (quantidadeemquatorze >= 1) ? quantidadeemquatorze : 0;
                escritorquinze.EscritorQtdeQuatorze(idquinzepontos, quantidadeemquatorze);
                quantidade += 1;
                
                    //percent = (quantidade * 100 / 3);
                    //lblProcessando.setText("Processando 15 pontos... " + Integer.toString(quantidade));
                    //pgbProcessando.setValue(Integer.parseInt(String.valueOf(percent)));
                    //lblPercentual.setText(String.valueOf(percent) + "%");

                escritorquinze.FecharConeccao();
                escritorquatorze.FecharConeccao();
            }
        }.start();
    }

}

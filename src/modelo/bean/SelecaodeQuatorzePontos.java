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
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.dao.EscritordeQuatorzePontos;
import modelos.dao.EscritordeQuinzePontos;
import modelos.dao.TotalProbabilidadeDAO;

/**
 *
 * @author ricar
 */
public class SelecaodeQuatorzePontos {

    EfetuaConeccao efetuarconeccao = new EfetuaConeccao();

    public void SelecaodeQuatorzePontos(String sorteio, File fourteenpointsfile) {
//JOptionPane.showMessageDialog(null, sorteio);
        efetuarconeccao.EfetuaConeccao();
        TotalProbabilidadeDAO totalprobabilidadesdao = new TotalProbabilidadeDAO();
        EscritordeQuinzePontos escritordequinzepontos = new EscritordeQuinzePontos();
        EscritordeQuatorzePontos escritordequatorzepontos = new EscritordeQuatorzePontos();
       // new Thread() {
            Integer somadequatorze = 0, id = 0;
            int compara = 0, percent, retornoid = 0, quantidade = 0;
            FourteenPoints fourteenpoints;
            List<Combinacoes> combinacao = new ArrayList<>();

           // @Override
           // public void run() {
                combinacao = totalprobabilidadesdao.TotalCombinacoes();
                for (Combinacoes combinacoes : combinacao) {
                 
                    for (String numCombinacao : combinacoes.getCombinacao().trim().split(" ")) {
                        compara = (Arrays.binarySearch(sorteio.trim().split(" "), numCombinacao) >= 0) ? somadequatorze += 1 : 0;
                    };
                    if (somadequatorze == 14) {
                        quantidade += 1;
                        escritordequatorzepontos.EscritordeQuatorzePontos(combinacoes.getIdcombinacao(), 1);
                        escritordequatorzepontos.EscritordeQuatorzePontosTexto(fourteenpointsfile, "(" + quantidade + ") - " + Integer.toString(combinacoes.getIdcombinacao()));
                        retornoid = escritordequatorzepontos.getRetornoid();
                        if (retornoid == 335544665) {
                            fourteenpoints = escritordequatorzepontos.BuscadeQuatorzepontos(combinacoes.getIdcombinacao());
                            escritordequatorzepontos.atualizarQtdedeQuatorzepontos(fourteenpoints.getIdcombfourteen(),
                                    fourteenpoints.getQtdefourteenpoints() + 1);
                            retornoid = 0;
                        } else if (retornoid != 0) {
                            JOptionPane.showMessageDialog(null, "ErrorCode: " + retornoid + ", ao tentar "
                                    + "salvar quatorze pontos!", "Bingo",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    somadequatorze = 0;
/*
                    percent = (quantidade * 100 / 3268760);
                    lblProcessando.setText("Processando 14 pontos... " + Integer.toString(quantidade));
                    pgbProcessando.setValue(Integer.parseInt(String.valueOf(percent)));
                    lblPercentual.setText(String.valueOf(percent) + "%");
              */      
                };
                //jButton1.setEnabled(true);
                escritordequatorzepontos.FecharConeccao();
                escritordequinzepontos.FecharConeccao();
                totalprobabilidadesdao.FecharConeccao();
            //}
        //}.start();
    }

}

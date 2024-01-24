/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ricar
 */
public class OrganizadordeSequencias {
    
    public List<String> Organizadordesequencias(File lotofacil) {

        String caractere[] = new String[2];
        String novasequencia = "", sequencia = "";

        List<String> sequenciaquinzepontosmaissoma = new ArrayList<>();
        List<String> sequenciatransformada = new ArrayList<>();

        try (BufferedReader bufferedfilereaderfifteenpoints = new BufferedReader(new FileReader(lotofacil))) {
            String line = bufferedfilereaderfifteenpoints.readLine();

            while (line != null) {

                sequenciaquinzepontosmaissoma.add(line.trim());
                line = bufferedfilereaderfifteenpoints.readLine();

            }
     

            for (int x = 0; x < sequenciaquinzepontosmaissoma.size(); x++) {
                sequencia += sequenciaquinzepontosmaissoma.get(x);
                //novasequencia = sequencia; //.replace(",", " ");
                //caractere = novasequencia.split(" ");
            }
                caractere = sequencia.split(" ");
                //JOptionPane.showMessageDialog(null, caractere);
                //JOptionPane.showMessageDialog(null, caractere[0]);
                //JOptionPane.showMessageDialog(null, caractere[1]);
                    //JOptionPane.showMessageDialog(null, caractere);
            //}
                caractere[0] = "";
                caractere[1] = "";
                //novasequencia = "";
                //JOptionPane.showMessageDialog(null, caractere);
                for (int y = 0; y < caractere.length; y++) {
                    novasequencia = novasequencia + caractere[y] + " ";
                }
                //JOptionPane.showMessageDialog(null, novasequencia);
                sequenciatransformada.add(novasequencia.trim());

                sequencia = "";
                novasequencia = "";

            //}

            bufferedfilereaderfifteenpoints.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro1: " + ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro2: " + ex);
        }
        //for (int x = 2682; x >= 0; x--) {
            //JOptionPane.showMessageDialog(null, sequenciatransformada.get(x));
        //}

        
        return sequenciatransformada;
    }
}

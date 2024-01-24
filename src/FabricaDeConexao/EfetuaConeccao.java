/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FabricaDeConexao;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ricar
 */
public class EfetuaConeccao {

    public void EfetuaConeccao() {
        try {
            ConexaoFireBird conectar = new ConexaoFireBird();
            conectar.getConnection();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro:\n" + ex + "\n ao tenrar conectar!", "Bingo",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:\n" + ex + "\n ao tenrar conectar!", "Bingo",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}

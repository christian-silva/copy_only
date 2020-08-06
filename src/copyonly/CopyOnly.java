/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copyonly;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Christian
 */
public class CopyOnly {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TelaCopiaArquivo tela;
        System.out.println("args.length: " + args.length);
        if (args.length <= 0) {

            try {
                UIManager.setLookAndFeel(new WindowsLookAndFeel());

                // WebLookAndFeel.install();
                //UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            } catch (UnsupportedLookAndFeelException e) {
                System.err.println("Erro ao carregar um layout. ERRO: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Erro ao carregar um layout.");
            }
            tela = new TelaCopiaArquivo();
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
            System.out.println("Iniciando sem argumento");
        } else {
            try {
                System.out.println("args[0]: " + args[0]);
                System.out.println("args[1]: " + args[1]);
                System.out.println("args[2]: " + args[2]);
                String origem = args[0];
                String destino = args[1];
                String extensao = args[2];
                if (origem.trim().toLowerCase().isEmpty() || destino.trim().toLowerCase().isEmpty() || extensao.trim().toLowerCase().isEmpty()) {
                    System.err.println("Erro nos argumentos. Digite: java -jar NOME_DO_JAR.jar origem destino extensão");
                } else {
                    tela = new TelaCopiaArquivo();
                    tela.setLocationRelativeTo(null);
                    tela.setLocalXMLOrigem(origem);
                    tela.setLabelOrigemArquivo(origem);
                    tela.setLocalArquivoDestino(destino);
                    tela.setLabelDestinoArquivo(destino);
                    tela.setExtensaoArquivo(extensao);
                    tela.setTextoExtensaoArquivo(extensao);
                    tela.CopyOnlyFiles(true);
                }

            } catch (Exception e) {
                System.err.println("\n  ERRO: " + e);
                System.err.println("Digite: java -jar NOME_DO_JAR.jar origem destino extensão");

            }
        }
    }
}

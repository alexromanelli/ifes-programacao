/*
 * Se for usar este código, cite o autor.
 */
package controleobi2;

import controleobi2.modelo.ArmazenamentoModalidade;
import controleobi2.modelo.entidade.Modalidade;
import controleobi2.visao.JFramePrincipal;
import java.util.ArrayList;

/**
 *
 * @author Alexandre Romanelli <alexandre.romanelli@ifes.edu.br>
 */
public class ControleObi2 {
    
    private static ArmazenamentoModalidade ARMAZENAMENTO_MODALIDADE;
    
    public static ArmazenamentoModalidade getArmazenamentoModalidade() {
        if (ARMAZENAMENTO_MODALIDADE == null) {
            ARMAZENAMENTO_MODALIDADE = new ArmazenamentoModalidade();
        }
        return ARMAZENAMENTO_MODALIDADE;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        ArrayList<Modalidade> listaModalidade = 
                ControleObi2.getArmazenamentoModalidade().getLista();
        listaModalidade.add(new Modalidade(1, "Iniciação", "para iniciantes"));
        listaModalidade.add(new Modalidade(2, "Programação", "para programadores"));
        listaModalidade.add(new Modalidade(3, "Universitária", "para universitários"));
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePrincipal().setVisible(true);
            }
        });
    }
    
}

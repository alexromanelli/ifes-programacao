/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledopuxafrangosg2;

import javax.swing.JOptionPane;

/**
 *
 * @author romanelli
 */
public class TelaCadastroComando extends javax.swing.JDialog {

    /**
     * Creates new form TelaCadastroComando
     */
    public TelaCadastroComando(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButtonMovimentoGarra = new javax.swing.JRadioButton();
        jRadioButtonPosicionamento = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jSpinnerAngulo = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldX = new javax.swing.JTextField();
        jTextFieldY = new javax.swing.JTextField();
        jTextFieldZ = new javax.swing.JTextField();
        jButtonIncluirComando = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inclusao de comando");

        buttonGroup1.add(jRadioButtonMovimentoGarra);
        jRadioButtonMovimentoGarra.setSelected(true);
        jRadioButtonMovimentoGarra.setText("Movimento da garra");
        jRadioButtonMovimentoGarra.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButtonMovimentoGarraStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButtonPosicionamento);
        jRadioButtonPosicionamento.setText("Posicionamento da base da garra");
        jRadioButtonPosicionamento.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButtonPosicionamentoStateChanged(evt);
            }
        });

        jLabel1.setText("Angulo:");

        jLabel2.setText("x");

        jLabel3.setText("y");

        jLabel4.setText("z");

        jTextFieldX.setEnabled(false);
        jTextFieldX.setPreferredSize(new java.awt.Dimension(50, 27));

        jTextFieldY.setEnabled(false);
        jTextFieldY.setPreferredSize(new java.awt.Dimension(50, 27));

        jTextFieldZ.setEnabled(false);
        jTextFieldZ.setPreferredSize(new java.awt.Dimension(50, 27));

        jButtonIncluirComando.setText("Incluir comando");
        jButtonIncluirComando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirComandoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonMovimentoGarra)
                    .addComponent(jRadioButtonPosicionamento)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerAngulo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonIncluirComando)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonMovimentoGarra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jSpinnerAngulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jRadioButtonPosicionamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonIncluirComando)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonMovimentoGarraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButtonMovimentoGarraStateChanged
        if (jRadioButtonMovimentoGarra.isSelected()) {
            jSpinnerAngulo.setEnabled(true);
            jTextFieldX.setEnabled(false);
            jTextFieldY.setEnabled(false);
            jTextFieldZ.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButtonMovimentoGarraStateChanged

    private void jRadioButtonPosicionamentoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButtonPosicionamentoStateChanged
        if (jRadioButtonPosicionamento.isSelected()) {
            jSpinnerAngulo.setEnabled(false);
            jTextFieldX.setEnabled(true);
            jTextFieldY.setEnabled(true);
            jTextFieldZ.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButtonPosicionamentoStateChanged

    private void jButtonIncluirComandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirComandoActionPerformed
        
        if (jRadioButtonMovimentoGarra.isSelected()) {
        
            int angulo = (int) jSpinnerAngulo.getValue();
            MovimentoGarra mv = new MovimentoGarra(0, angulo); // <--- corrigir o zero
            TelaInicial.getInstance().incluirComando(mv);
            this.setVisible(false);
        
        } else if (jRadioButtonPosicionamento.isSelected()) {
            
            int x;
            try {
                x = Integer.parseInt(jTextFieldX.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, 
                        "Coordenada x digitada incorretamente.", 
                        "Erro", 
                        JOptionPane.ERROR_MESSAGE);
                jTextFieldX.requestFocus();
                return;
            }
            int y = Integer.parseInt(jTextFieldY.getText());
            int z = Integer.parseInt(jTextFieldZ.getText());
            int s = TelaInicial.getInstance().listaComandos.size() + 1;
            PosicionamentoGarra pos = new PosicionamentoGarra(s, x, y, z);
            TelaInicial.getInstance().incluirComando(pos);
            this.setVisible(false);
            
        }
    }//GEN-LAST:event_jButtonIncluirComandoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(TelaCadastroComando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroComando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroComando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroComando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCadastroComando dialog = new TelaCadastroComando(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonIncluirComando;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButtonMovimentoGarra;
    private javax.swing.JRadioButton jRadioButtonPosicionamento;
    private javax.swing.JSpinner jSpinnerAngulo;
    private javax.swing.JTextField jTextFieldX;
    private javax.swing.JTextField jTextFieldY;
    private javax.swing.JTextField jTextFieldZ;
    // End of variables declaration//GEN-END:variables
}

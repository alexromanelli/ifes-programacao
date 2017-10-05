/*
 * Se for usar este código, cite o autor.
 */
package controleobi2.visao;

import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre Romanelli <alexandre.romanelli@ifes.edu.br>
 */
public class JFramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFramePrincipal
     */
    public JFramePrincipal() {
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

        jButtonCadastroModalidade = new javax.swing.JButton();
        jButtonCadastroNivelModalidade = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle OBI");

        jButtonCadastroModalidade.setText("Cadastro de modalidade");
        jButtonCadastroModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastroModalidadeActionPerformed(evt);
            }
        });

        jButtonCadastroNivelModalidade.setText("Cadastro de nível de modalidade");
        jButtonCadastroNivelModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastroNivelModalidadeActionPerformed(evt);
            }
        });

        jButton1.setText("Cadastro de tipo de escola");

        jButton2.setText("Cadastro de fase");

        jToggleButton1.setText("Cadastro de linguagem");

        jButton3.setText("Cadastro de nível de curso");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCadastroModalidade, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButtonCadastroNivelModalidade)
                .addContainerGap(327, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCadastroModalidade)
                    .addComponent(jButtonCadastroNivelModalidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCadastroModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastroModalidadeActionPerformed
        JFrameTabelaModalidade jFrameTabelaModalidade = new JFrameTabelaModalidade();
        jFrameTabelaModalidade.setVisible(true);
    }//GEN-LAST:event_jButtonCadastroModalidadeActionPerformed

    private void jButtonCadastroNivelModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastroNivelModalidadeActionPerformed
        JOptionPane.showMessageDialog(null, 
                "Você clicou no botão \"Cadastro de nível de modalidade\".", 
                "Utilidade pública", 
                JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jButtonCadastroNivelModalidadeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonCadastroModalidade;
    private javax.swing.JButton jButtonCadastroNivelModalidade;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledopuxafrangosg2;

import java.util.ArrayList;

/**
 *
 * @author romanelli
 */
public class TelaInicial extends javax.swing.JFrame {
    
    private static TelaInicial INSTANCE;
    public static TelaInicial getInstance() {
        if (INSTANCE == null)
            INSTANCE = new TelaInicial();
        return INSTANCE;
    }

    private ArrayList<Comando> listaComandos;
    
    public boolean incluirComando(Comando c) {
        // incluir comando na lista de comandos
        listaComandos.add(c);
        // atualizar exibiçao da lista na tela
        ((ModeloTabelaComandos)jTableComandos.getModel()).fireTableDataChanged();
        return true;
    }
    
    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() { // -----> JTable -> singleSelection, componentPopupMenu
        INSTANCE = this; // <------- precisa melhorar!!!
        initComponents();
        
        listaComandos = new ArrayList<>();
        listaComandos.add(new PosicionamentoGarra(1, 40, 35, 73));
        listaComandos.add(new MovimentoGarra(2, 160));
        listaComandos.add(new PosicionamentoGarra(3, 0, 70, 40));
        listaComandos.add(new MovimentoGarra(4, 130));
        listaComandos.add(new PosicionamentoGarra(5, -10, 50, 25));
        listaComandos.add(new MovimentoGarra(6, 150));
        listaComandos.add(new PosicionamentoGarra(7, 40, 35, 73));
        listaComandos.add(new MovimentoGarra(8, 160));
        
        ModeloTabelaComandos modelo = new ModeloTabelaComandos(listaComandos);
        
        jTableComandos.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuComandos = new javax.swing.JPopupMenu();
        jMenuItemAlterar = new javax.swing.JMenuItem();
        jMenuItemExcluir = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCarregar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonIncluirComando = new javax.swing.JButton();
        jButtonExecutarComando = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableComandos = new javax.swing.JTable();

        jMenuItemAlterar.setText("Alterar");
        jPopupMenuComandos.add(jMenuItemAlterar);

        jMenuItemExcluir.setText("Excluir");
        jPopupMenuComandos.add(jMenuItemExcluir);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle do Puxa-Frangos");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setPreferredSize(new java.awt.Dimension(80, 27));

        jButtonCarregar.setText("Carregar");
        jButtonCarregar.setPreferredSize(new java.awt.Dimension(80, 27));

        jButtonNovo.setText("Novo");
        jButtonNovo.setPreferredSize(new java.awt.Dimension(80, 27));

        jButtonIncluirComando.setText("Incluir comando");
        jButtonIncluirComando.setPreferredSize(new java.awt.Dimension(114, 27));
        jButtonIncluirComando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirComandoActionPerformed(evt);
            }
        });

        jButtonExecutarComando.setText("Executar comando");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCarregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(jButtonIncluirComando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonExecutarComando)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCarregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIncluirComando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExecutarComando))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableComandos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableComandos.setComponentPopupMenu(jPopupMenuComandos);
        jTableComandos.setName(""); // NOI18N
        jTableComandos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTableComandos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirComandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirComandoActionPerformed
        TelaCadastroComando tela = new TelaCadastroComando(this, true);
        tela.setVisible(true);
    }//GEN-LAST:event_jButtonIncluirComandoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCarregar;
    private javax.swing.JButton jButtonExecutarComando;
    private javax.swing.JButton jButtonIncluirComando;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JMenuItem jMenuItemAlterar;
    private javax.swing.JMenuItem jMenuItemExcluir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenuComandos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableComandos;
    // End of variables declaration//GEN-END:variables
}

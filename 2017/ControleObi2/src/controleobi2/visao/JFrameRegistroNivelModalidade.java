/*
 * Se for usar este código, cite o autor.
 */
package controleobi2.visao;

import controleobi2.modelo.dao.DAOFactory;
import controleobi2.modelo.dao.ModalidadeDAO;
import controleobi2.modelo.dao.NivelModalidadeDAO;
import controleobi2.modelo.entidade.Modalidade;
import controleobi2.modelo.entidade.NivelModalidade;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre Romanelli <alexandre.romanelli@ifes.edu.br>
 */
public class JFrameRegistroNivelModalidade extends javax.swing.JFrame {

    enum Estado {
        Navegando,
        Editando
    }

    private NivelModalidadeDAO nivelModalidadeDAO;
    private ArrayList<NivelModalidade> listaNivelModalidade;
    private ModalidadeDAO modalidadeDAO;
    private NivelModalidade cursor;

    private void ajustarExibicaoEstado(Estado estadoAtual) {
        switch (estadoAtual) {
            case Navegando:
                jTextFieldCodigo.setEditable(false);
                jTextFieldNivel.setEditable(false);
                jComboBoxModalidade.setEnabled(false);
                jTextFieldEligibilidade.setEditable(false);
                jButtonCancelar.setEnabled(false);
                jButtonSalvar.setEnabled(false);

                jButtonNovo.setEnabled(true);
                boolean haMaisDeUmRegistro = listaNivelModalidade.size() > 1;
                jButtonPrimeiro.setEnabled(haMaisDeUmRegistro);
                jButtonAnterior.setEnabled(haMaisDeUmRegistro);
                jButtonProximo.setEnabled(haMaisDeUmRegistro);
                jButtonUltimo.setEnabled(haMaisDeUmRegistro);
                boolean haPeloMenosUmRegistro = listaNivelModalidade.size() > 0;
                jButtonEditar.setEnabled(haPeloMenosUmRegistro);
                jButtonExcluir.setEnabled(haPeloMenosUmRegistro);
                break;

            case Editando:
                jTextFieldCodigo.setEditable(false);
                jTextFieldNivel.setEditable(true);
                jComboBoxModalidade.setEnabled(true);
                jTextFieldEligibilidade.setEditable(true);
                jButtonCancelar.setEnabled(true);
                jButtonSalvar.setEnabled(true);

                jButtonNovo.setEnabled(false);
                jButtonPrimeiro.setEnabled(false);
                jButtonAnterior.setEnabled(false);
                jButtonProximo.setEnabled(false);
                jButtonUltimo.setEnabled(false);
                jButtonEditar.setEnabled(false);
                jButtonExcluir.setEnabled(false);
                break;
        }
    }

    private void iniciarCursor() {
        cursor = null;
        if (listaNivelModalidade.size() > 0) {
            cursor = listaNivelModalidade.get(0);
        }
    }

    private void moverCursorProximo() {
        int pos = listaNivelModalidade.indexOf(cursor);
        if (pos < listaNivelModalidade.size() - 1) { // verifica se não é o último
            cursor = listaNivelModalidade.get(pos + 1);
            exibirDadosCursor();
        }
    }

    private void moverCursorAnterior() {
        int pos = listaNivelModalidade.indexOf(cursor);
        if (pos > 0) { // verifica se não é o primeiro
            cursor = listaNivelModalidade.get(pos - 1);
            exibirDadosCursor();
        }
    }

    private void moverCursorPrimeiro() {
        if (listaNivelModalidade.size() > 0) {
            cursor = listaNivelModalidade.get(0);
            exibirDadosCursor();
        }
    }

    private void moverCursorUltimo() {
        if (listaNivelModalidade.size() > 0) {
            cursor = listaNivelModalidade.get(listaNivelModalidade.size() - 1);
            exibirDadosCursor();
        }
    }

    private void exibirDadosCursor() {
        if (cursor != null) {
            jTextFieldCodigo.setText(Long.toString(cursor.getCodigo()));
            jComboBoxModalidade.setSelectedItem(cursor.getModalidade());
            jTextFieldNivel.setText(cursor.getNivel());
            jTextFieldEligibilidade.setText(cursor.getEligibilidade());
        } else {
            jTextFieldCodigo.setText("");
            jComboBoxModalidade.setSelectedIndex(-1);
            jTextFieldNivel.setText("");
            jTextFieldEligibilidade.setText("");
        }
    }

    private void iniciarComboBoxModalidade() {
        modalidadeDAO = DAOFactory.getDefaultDAOFactory().getModalidadeDAO();
        ArrayList<Modalidade> listaModalidade = modalidadeDAO.getLista();
        Modalidade[] vetorModalidades = new Modalidade[listaModalidade.size()];
        listaModalidade.toArray(vetorModalidades);
        DefaultComboBoxModel<Modalidade> modeloComboBoxModalidade
                = new DefaultComboBoxModel<>(vetorModalidades);
        jComboBoxModalidade.setModel(modeloComboBoxModalidade);
    }

    /**
     * Creates new form JFrameRegistroNivelModalidade
     *
     * @param nivelModalidadeDAO
     */
    public JFrameRegistroNivelModalidade(NivelModalidadeDAO nivelModalidadeDAO) {
        initComponents();

        iniciarComboBoxModalidade();

        this.nivelModalidadeDAO = nivelModalidadeDAO;
        listaNivelModalidade = nivelModalidadeDAO.getLista();
        iniciarCursor();
        exibirDadosCursor();

        ajustarExibicaoEstado(Estado.Navegando);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonPrimeiro = new javax.swing.JButton();
        jButtonAnterior = new javax.swing.JButton();
        jButtonProximo = new javax.swing.JButton();
        jButtonUltimo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNivel = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldEligibilidade = new javax.swing.JTextField();
        jButtonNovo = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxModalidade = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Nível de Modalidade");

        jButtonPrimeiro.setText("Primeiro");
        jButtonPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrimeiroActionPerformed(evt);
            }
        });

        jButtonAnterior.setText("Anterior");
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });

        jButtonProximo.setText("Próximo");
        jButtonProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProximoActionPerformed(evt);
            }
        });

        jButtonUltimo.setText("Último");
        jButtonUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUltimoActionPerformed(evt);
            }
        });

        jLabel1.setText("Código");

        jLabel2.setText("Nível");

        jTextFieldNivel.setToolTipText("Digite o nome da modalidade");

        jLabel3.setText("Eligibilidade");

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jLabel4.setText("Modalidade");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 378, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonPrimeiro)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButtonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButtonProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButtonUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(5, 5, 5)
                                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jTextFieldNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 433, Short.MAX_VALUE))
                                        .addComponent(jComboBoxModalidade, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldEligibilidade))))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPrimeiro)
                    .addComponent(jButtonAnterior)
                    .addComponent(jButtonProximo)
                    .addComponent(jButtonUltimo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEligibilidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNovo)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrimeiroActionPerformed
        moverCursorPrimeiro();
    }//GEN-LAST:event_jButtonPrimeiroActionPerformed

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        moverCursorAnterior();
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProximoActionPerformed
        moverCursorProximo();
    }//GEN-LAST:event_jButtonProximoActionPerformed

    private void jButtonUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUltimoActionPerformed
        moverCursorUltimo();
    }//GEN-LAST:event_jButtonUltimoActionPerformed

    protected void prepararParaNovoRegistro() {
        jTextFieldCodigo.setText("");
        jTextFieldNivel.setText("");
        jTextFieldEligibilidade.setText("");
        ajustarExibicaoEstado(Estado.Editando);
        jComboBoxModalidade.requestFocus();
    }

    protected void prepararParaAlterarRegistro(NivelModalidade registro) {
        for (NivelModalidade n : listaNivelModalidade) {
            if (n.getCodigo() == registro.getCodigo()) {
                cursor = n;
                break;
            }
        }
        exibirDadosCursor();
        ajustarExibicaoEstado(Estado.Editando);
        jComboBoxModalidade.requestFocus();
    }

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        prepararParaNovoRegistro();
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        if (JOptionPane.showConfirmDialog(null,
                "Confirmar exclusão do nível de modalidade selecionado?",
                "Exclusão", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
            int pos = listaNivelModalidade.indexOf(cursor);
            nivelModalidadeDAO.excluir(cursor);
            if (pos <= listaNivelModalidade.size() - 1) {
                cursor = listaNivelModalidade.get(pos);
            } else if (pos > 0) {
                cursor = listaNivelModalidade.get(pos - 1);
            } else {
                cursor = null;
            }
            exibirDadosCursor();
            // atualizar exibição de tabela no jFrameTabelaNivelModalidade
            JFrameTabelaNivelModalidade.getInstance().atualizarExibicaoTabela();
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        ajustarExibicaoEstado(Estado.Editando);
        jTextFieldNivel.requestFocus();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Confirmar cancelamento de edição?",
                "Cancelamento", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
            exibirDadosCursor();
            ajustarExibicaoEstado(Estado.Navegando);
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (jTextFieldCodigo.getText().isEmpty()) {
            // novo registro
            Modalidade modalidade = (Modalidade) jComboBoxModalidade.getSelectedItem();
            String nivel = jTextFieldNivel.getText();
            String eligibilidade = jTextFieldEligibilidade.getText();
            NivelModalidade novoNivelModalidade = new NivelModalidade(-1, modalidade, nivel, eligibilidade);
            nivelModalidadeDAO.inserir(novoNivelModalidade);
            moverCursorUltimo();
        } else {
            // alteração de registro
            long codigo = cursor.getCodigo();
            Modalidade modalidade = (Modalidade) jComboBoxModalidade.getSelectedItem();
            String nivel = jTextFieldNivel.getText();
            String eligibilidade = jTextFieldEligibilidade.getText();
            NivelModalidade nivelModalidade = new NivelModalidade(codigo, modalidade, nivel, eligibilidade);
            nivelModalidadeDAO.alterar(nivelModalidade);
        }
        ajustarExibicaoEstado(Estado.Navegando);
        // atualizar exibição de tabela no jFrameTabelaNivelModalidade
        JFrameTabelaNivelModalidade.getInstance().atualizarExibicaoTabela();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPrimeiro;
    private javax.swing.JButton jButtonProximo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonUltimo;
    private javax.swing.JComboBox<Modalidade> jComboBoxModalidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldEligibilidade;
    private javax.swing.JTextField jTextFieldNivel;
    // End of variables declaration//GEN-END:variables
}

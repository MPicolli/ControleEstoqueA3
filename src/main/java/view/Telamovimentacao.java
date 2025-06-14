/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
import model.TipoMovimentacao;
import service.MovimentacaoEstoqueService;
import service.ProdutoService;

/**
 *
 * @author Rodrigo
 */
public class Telamovimentacao extends javax.swing.JFrame {
    
    private MovimentacaoEstoqueService movimentacaoEstoqueService;
    private ProdutoService produtoService;

    /**
     * Creates new form Telamovimentação
     */
    public Telamovimentacao() {
        initComponents();
        movimentacaoEstoqueService = new MovimentacaoEstoqueService();
        produtoService = new ProdutoService();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        botaosair = new javax.swing.JButton();
        tfidproduto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtipo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfquantidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        botaodeletar = new javax.swing.JButton();
        botaocadastrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jmovimentacao = new javax.swing.JTable();

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movimentação");

        botaosair.setText("VOLTAR");
        botaosair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaosairActionPerformed(evt);
            }
        });

        tfidproduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfidprodutoActionPerformed(evt);
            }
        });

        jLabel1.setText("Id do Produto");

        jtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Saída" }));
        jtipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtipoActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo");

        jLabel4.setText("Quantidade");

        botaodeletar.setText("DELETE");
        botaodeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaodeletarActionPerformed(evt);
            }
        });

        botaocadastrar.setText("CADASTRAR");
        botaocadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaocadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfidproduto)
                                .addGap(81, 81, 81)
                                .addComponent(jtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(tfquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(49, 49, 49))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(botaocadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaodeletar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaosair))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaosair)
                    .addComponent(botaodeletar)
                    .addComponent(botaocadastrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfidproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jmovimentacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Produto", "Tipo", "Quantidade", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jmovimentacao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaosairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaosairActionPerformed
        // TODO add your handling code here:
        Telamenu tela1 = new Telamenu();
        tela1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaosairActionPerformed

    private void jtipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtipoActionPerformed

    private void tfidprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfidprodutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfidprodutoActionPerformed

    private void botaodeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaodeletarActionPerformed
        // TODO add your handling code here:
        int linhaSelecionada = jmovimentacao.getSelectedRow();
        if(linhaSelecionada != -1){
            DefaultTableModel tbmovimentacoes = (DefaultTableModel) jmovimentacao.getModel();
            Object idObject = tbmovimentacoes.getValueAt(linhaSelecionada, 0);
            int idInt = Integer.parseInt(String.valueOf(idObject));
            
            tbmovimentacoes.removeRow(jmovimentacao.getSelectedRow());
        }
    }//GEN-LAST:event_botaodeletarActionPerformed

    private void botaocadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaocadastrarActionPerformed
        // TODO add your handling code here:
        int idTextField = Integer.parseInt(tfidproduto.getText());
        TipoMovimentacao tipoMovimentacaoComboBox = jtipo.getSelectedIndex() == 0 ? 
                TipoMovimentacao.ENTRADA : TipoMovimentacao.SAIDA;
        int quantidadeTextField = Integer.parseInt(tfquantidade.getText());
        LocalDate dataAtual = LocalDate.now();
        
        if (tipoMovimentacaoComboBox.equals(TipoMovimentacao.ENTRADA)) {
            movimentacaoEstoqueService.registraEntrada(idTextField, quantidadeTextField, "");
        } else if (tipoMovimentacaoComboBox.equals(TipoMovimentacao.SAIDA)) {
            movimentacaoEstoqueService.registrarSaida(idTextField, quantidadeTextField, "");
        }
        
        DefaultTableModel tbjmovimentacao = (DefaultTableModel) jmovimentacao.getModel();
        Object[] dados = {tfidproduto.getText(), (String) jtipo.getSelectedItem(),tfquantidade.getText()};
        tbjmovimentacao.addRow(dados);
        
        tfidproduto.setText("");
        tfquantidade.setText("");
        jtipo.setSelectedIndex(0);
        
        
    }//GEN-LAST:event_botaocadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(Telamovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Telamovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Telamovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Telamovimentacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Telamovimentacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaocadastrar;
    private javax.swing.JButton botaodeletar;
    private javax.swing.JButton botaosair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable jmovimentacao;
    private javax.swing.JComboBox<String> jtipo;
    private javax.swing.JTextField tfidproduto;
    private javax.swing.JTextField tfquantidade;
    // End of variables declaration//GEN-END:variables
}

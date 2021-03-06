/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;

/**
 *
 * @author Vinicius
 */
public class ViewMenuCadastros extends javax.swing.JFrame {

    /**
     * Creates new form ViewMenuCadastros
     */
    public ViewMenuCadastros() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnParPer = new javax.swing.JButton();
        btnProduto = new javax.swing.JButton();
        btnEtapa = new javax.swing.JButton();
        btnRecurso = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(127, 177, 252));

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Menu de cadastros");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btnParPer.setBackground(new java.awt.Color(58, 65, 84));
        btnParPer.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnParPer.setForeground(new java.awt.Color(255, 255, 255));
        btnParPer.setText("Paradas e perdas");
        btnParPer.setBorderPainted(false);
        btnParPer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnParPer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnParPerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnParPerMouseExited(evt);
            }
        });
        btnParPer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParPerActionPerformed(evt);
            }
        });

        btnProduto.setBackground(new java.awt.Color(58, 65, 84));
        btnProduto.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnProduto.setForeground(new java.awt.Color(255, 255, 255));
        btnProduto.setText("Produtos");
        btnProduto.setBorderPainted(false);
        btnProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProdutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProdutoMouseExited(evt);
            }
        });
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });

        btnEtapa.setBackground(new java.awt.Color(58, 65, 84));
        btnEtapa.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnEtapa.setForeground(new java.awt.Color(255, 255, 255));
        btnEtapa.setText("Etapas");
        btnEtapa.setBorderPainted(false);
        btnEtapa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEtapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEtapaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEtapaMouseExited(evt);
            }
        });
        btnEtapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEtapaActionPerformed(evt);
            }
        });

        btnRecurso.setBackground(new java.awt.Color(58, 65, 84));
        btnRecurso.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnRecurso.setForeground(new java.awt.Color(255, 255, 255));
        btnRecurso.setText("Recursos");
        btnRecurso.setBorderPainted(false);
        btnRecurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRecurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRecursoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRecursoMouseExited(evt);
            }
        });
        btnRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecursoActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(217, 81, 51));
        btnVoltar.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setText("Voltar");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVoltarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVoltarMouseExited(evt);
            }
        });
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnParPer, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEtapa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnParPer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEtapaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEtapaMouseEntered
        btnEtapa.setBackground(new Color(110, 120, 149));
        btnEtapa.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnEtapaMouseEntered

    private void btnEtapaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEtapaMouseExited
        btnEtapa.setBackground(new Color(58, 65, 84));
        btnEtapa.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnEtapaMouseExited

    private void btnRecursoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecursoMouseEntered
        btnRecurso.setBackground(new Color(110, 120, 149));
        btnRecurso.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnRecursoMouseEntered

    private void btnRecursoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecursoMouseExited
        btnRecurso.setBackground(new Color(58, 65, 84));
        btnRecurso.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnRecursoMouseExited

    private void btnProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProdutoMouseEntered
        btnProduto.setBackground(new Color(110, 120, 149));
        btnProduto.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnProdutoMouseEntered

    private void btnProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProdutoMouseExited
        btnProduto.setBackground(new Color(58, 65, 84));
        btnProduto.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnProdutoMouseExited

    private void btnVoltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseEntered
            btnVoltar.setBackground(new Color(242, 148, 125));
            btnVoltar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnVoltarMouseEntered

    private void btnVoltarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseExited
        btnVoltar.setBackground(new Color(217, 81, 51));
        btnVoltar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnVoltarMouseExited

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        ViewPrincipal tela = new ViewPrincipal();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnEtapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEtapaActionPerformed
        ViewEtapas tela7 = new ViewEtapas();
        tela7.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnEtapaActionPerformed

    private void btnRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecursoActionPerformed
        ViewRecursos tela8 = new ViewRecursos();
        tela8.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRecursoActionPerformed

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        ViewProdutos tela9 = new ViewProdutos();
        tela9.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void btnParPerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParPerActionPerformed
        ViewCadastro tela6 = new ViewCadastro();
        tela6.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnParPerActionPerformed

    private void btnParPerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnParPerMouseExited
        btnParPer.setBackground(new Color(58, 65, 84));
        btnParPer.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnParPerMouseExited

    private void btnParPerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnParPerMouseEntered
        btnParPer.setBackground(new Color(110, 120, 149));
        btnParPer.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnParPerMouseEntered

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
            java.util.logging.Logger.getLogger(ViewMenuCadastros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMenuCadastros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMenuCadastros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMenuCadastros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMenuCadastros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEtapa;
    private javax.swing.JButton btnParPer;
    private javax.swing.JButton btnProduto;
    private javax.swing.JButton btnRecurso;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}

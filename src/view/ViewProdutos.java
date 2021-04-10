/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.DAOProdutos;
import conexoes.ConexaoMySql;
import controller.ControllerProdutos;
import java.awt.Color;
import java.awt.Point;
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelProdutos;
import util.BLDatas;

/**
 *
 * @author Vinicius
 */
public class ViewProdutos extends javax.swing.JFrame {

    ControllerProdutos controllerProdutos = new ControllerProdutos();
    ModelProdutos modelProdutos = new ModelProdutos();
    Boolean condicao;
    String salvarAlterar;
    List<ModelProdutos> listaModelProdutos = new ArrayList<>();
    DAOProdutos daoProdutos = new DAOProdutos();
    ConexaoMySql c = new ConexaoMySql();
    int cod = 0;

    /**
     * Creates new form ViewEtapas
     */
    public ViewProdutos() {
        initComponents();
        habilitarDesabilitarCampos(false);
        carregarCadastros();
        salvarAlterar = "salvar";
        setLocationRelativeTo(null);
        jScrollPane1.getViewport().setBackground(Color.white);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fieldCodigo = new javax.swing.JTextField();
        fieldDescricao = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(642, 569));

        jPanel1.setBackground(new java.awt.Color(127, 177, 252));

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de produtos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel2.setText("Código:");

        jLabel4.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel4.setText("Descrição do produto:");

        fieldCodigo.setEnabled(false);

        btnNovo.setBackground(new java.awt.Color(58, 65, 84));
        btnNovo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("Novo");
        btnNovo.setBorderPainted(false);
        btnNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNovoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNovoMouseExited(evt);
            }
        });
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(58, 65, 84));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("Salvar");
        btnSalvar.setBorderPainted(false);
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalvarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalvarMouseExited(evt);
            }
        });
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnAlterar.setBackground(new java.awt.Color(58, 65, 84));
        btnAlterar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterar.setText("Alterar");
        btnAlterar.setBorderPainted(false);
        btnAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAlterarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAlterarMouseExited(evt);
            }
        });
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(217, 81, 51));
        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.setBorderPainted(false);
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExcluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExcluirMouseExited(evt);
            }
        });
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(217, 81, 51));
        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127, 177, 252)));

        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição da etapa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabelaProdutos.setGridColor(new java.awt.Color(255, 255, 255));
        tabelaProdutos.setSelectionBackground(new java.awt.Color(127, 177, 252));
        tabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProdutos);
        if (tabelaProdutos.getColumnModel().getColumnCount() > 0) {
            tabelaProdutos.getColumnModel().getColumn(0).setMinWidth(100);
            tabelaProdutos.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabelaProdutos.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(91, 95, 99));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Preencha as infmações abaixo para cadastrar um novo produto no sistema.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldCodigo)
                    .addComponent(fieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(fieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(fieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoMouseEntered
        if (condicao = true) {
            btnNovo.setBackground(new Color(110, 120, 149));
            btnNovo.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_btnNovoMouseEntered

    private void btnNovoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoMouseExited
        if (condicao = true) {
            btnNovo.setBackground(new Color(58, 65, 84));
            btnNovo.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_btnNovoMouseExited

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        salvarAlterar = "salvar";
        limparCampos();
        habilitarDesabilitarCampos(true);
        btnNovo.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        buscaCodigoMaximo();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseEntered
        if (condicao = true) {
            btnSalvar.setBackground(new Color(110, 120, 149));
            btnSalvar.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_btnSalvarMouseEntered

    private void btnSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseExited
        if (condicao = true) {
            btnSalvar.setBackground(new Color(58, 65, 84));
            btnSalvar.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_btnSalvarMouseExited

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvar();
        carregarCadastros();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseEntered
        if (condicao = true) {
            btnAlterar.setBackground(new Color(242, 148, 125));
            btnAlterar.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_btnAlterarMouseEntered

    private void btnAlterarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseExited
        if (condicao = true) {
            btnAlterar.setBackground(new Color(58, 65, 84));
            btnAlterar.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_btnAlterarMouseExited

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        salvarAlterar = "altear";
        btnAlterar.setEnabled(false);
        btnNovo.setEnabled(false);
        modelProdutos = new ModelProdutos();
        int linha = tabelaProdutos.getSelectedRow();
        int codigo = 0;
        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um produto na tabela, antes de clicar em alterar!");
            limparCampos();
        } else {

            BLDatas bl = new BLDatas();

            codigo = (int) tabelaProdutos.getValueAt(linha, 0);
            modelProdutos = controllerProdutos.retornarProdutoController(codigo);

            fieldCodigo.setText(String.valueOf(modelProdutos.getIdProduto()));
            fieldDescricao.setText(modelProdutos.getDescricao());
        }

        habilitarDesabilitarCampos(true);
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseEntered
        if (condicao = true) {
            btnExcluir.setBackground(new Color(242, 148, 125));
            btnExcluir.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_btnExcluirMouseEntered

    private void btnExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseExited
        if (condicao = true) {
            btnExcluir.setBackground(new Color(217, 81, 51));
            btnExcluir.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_btnExcluirMouseExited

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // EXCLUI UM PRODUTO NO BANCO
        int linha = tabelaProdutos.getSelectedRow();
        int codigoProduto = (int) tabelaProdutos.getValueAt(linha, 0);
        if (controllerProdutos.excluirCadastroProduto(codigoProduto)) {
            JOptionPane.showMessageDialog(this, "Produto excluido com sucesso!", " ATENÇÃO", JOptionPane.WARNING_MESSAGE);;
            carregarCadastros();
            limparCampos();
            habilitarDesabilitarCampos(false);
            btnNovo.setEnabled(true);
            btnAlterar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao excluir o produto!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseEntered
        if (condicao = true) {
            btnVoltar.setBackground(new Color(235, 235, 235));
            btnVoltar.setForeground(new Color(217, 81, 51));
        }
    }//GEN-LAST:event_btnVoltarMouseEntered

    private void btnVoltarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseExited
        if (condicao = true) {
            btnVoltar.setBackground(new Color(217, 81, 51));
            btnVoltar.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_btnVoltarMouseExited

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        ViewMenuCadastros tela = new ViewMenuCadastros();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void tabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosMouseClicked
        if (evt.getClickCount() == 2) {
            salvarAlterar = "altear";
            btnAlterar.setEnabled(false);
            btnNovo.setEnabled(false);
            modelProdutos = new ModelProdutos();
            int linha = tabelaProdutos.getSelectedRow();
            int codigo = 0;
            if (linha < 0) {
                JOptionPane.showMessageDialog(this, "Selecione um produto na tabela, antes de clicar em alterar!");
                limparCampos();
            } else {

                BLDatas bl = new BLDatas();

                codigo = (int) tabelaProdutos.getValueAt(linha, 0);
                modelProdutos = controllerProdutos.retornarProdutoController(codigo);

                fieldCodigo.setText(String.valueOf(modelProdutos.getIdProduto()));
                fieldDescricao.setText(modelProdutos.getDescricao());
            }

            habilitarDesabilitarCampos(true);
        }
    }//GEN-LAST:event_tabelaProdutosMouseClicked

    public void salvar() {

        BLDatas bl = new BLDatas();

        modelProdutos = new ModelProdutos();
        modelProdutos.setDescricao(fieldDescricao.getText());

        if (fieldDescricao.getText().equals("")) {
            textonulo();
            JOptionPane.showMessageDialog(this, "Preencha a descrição do produto para realizar o cadastro!");
            return;
        }

        if (salvarAlterar.equals("salvar")) {
            if (controllerProdutos.salvarCadastroProdutos(modelProdutos) >= 0) {
                JOptionPane.showMessageDialog(this, "Cadastro de produto realizado com sucesso!", "Notificação", JOptionPane.WARNING_MESSAGE);
                limparCampos();
                habilitarDesabilitarCampos(false);
                btnNovo.setEnabled(true);
                btnAlterar.setEnabled(true);
                salvarAlterar = "salvar";
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar o produto!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            modelProdutos.setIdProduto(Integer.parseInt(fieldCodigo.getText()));
            if (controllerProdutos.atualizarProdutoController(modelProdutos)) {
                JOptionPane.showMessageDialog(this, "Produto alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
                habilitarDesabilitarCampos(false);
                btnNovo.setEnabled(true);
                btnAlterar.setEnabled(true);
                carregarCadastros();
                salvarAlterar = "alterar";
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao alterar o produto!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public void textonulo() {
        Point p = this.getLocation();
        ViewProdutos telaProduto = this;
        new Thread() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 4; i++) {
                        telaProduto.setLocation(p.x - 10, p.y - 2);
                        sleep(20);
                        telaProduto.setLocation(p.x + 10, p.y + 2);
                        sleep(20);
                    }
                    telaProduto.setLocation(p.x, p.y);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ViewLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }.start();
    }

    public void buscaCodigoMaximo() {
        DAOProdutos daoProdutos = new DAOProdutos();
        c.conectar();
        try {
            cod = daoProdutos.buscaCodigoMaximo();
        } catch (SQLException ex) {
            Logger.getLogger(ViewEtapas.class.getName()).log(Level.SEVERE, null, ex);
        }
        fieldCodigo.setText(String.valueOf(cod + 1));
    }

    private void carregarCadastros() {
        listaModelProdutos = controllerProdutos.getListaProduto();

        DefaultTableModel modelo = (DefaultTableModel) tabelaProdutos.getModel();
        modelo.setNumRows(0);
        //inserir produtos na tabela
        int cont = listaModelProdutos.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelProdutos.get(i).getIdProduto(),
                listaModelProdutos.get(i).getDescricao()
            });
        }
    }

    public void limparCampos() {
        fieldCodigo.setText("");
        fieldDescricao.setText("");
    }

    public void habilitarDesabilitarCampos(boolean condicao) {
        fieldDescricao.setEnabled(condicao);
        btnSalvar.setEnabled(condicao);
        btnExcluir.setEnabled(condicao);
    }

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JTextField fieldCodigo;
    private javax.swing.JTextField fieldDescricao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaProdutos;
    // End of variables declaration//GEN-END:variables
}

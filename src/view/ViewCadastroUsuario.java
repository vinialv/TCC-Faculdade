/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.DAOCadastroUsuarios;
import conexoes.ConexaoMySql;
import controller.ControllerCadastroUsuarios;
import java.awt.Color;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import model.ModelCadastroUsuarios;
import util.BLDatas;
import util.SomenteNumeros;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Jm.JMascara;
import java.awt.Point;
import static java.lang.Thread.sleep;
import util.formatoCPF;

/**
 *
 * @author Vinicius
 */
public class ViewCadastroUsuario extends javax.swing.JFrame {

    ControllerCadastroUsuarios controllerCadastroUsuarios = new ControllerCadastroUsuarios();
    ModelCadastroUsuarios modelCadastroUsuarios = new ModelCadastroUsuarios();
    ArrayList<ModelCadastroUsuarios> listaModelCadastroUsuarios = new ArrayList<>();
    DAOCadastroUsuarios daoCadastroUsuarios = new DAOCadastroUsuarios();
    String salvarAlterar;
    DateFormat dat = new SimpleDateFormat("dd/MM/yyyy");
    Boolean condicao;
    ConexaoMySql c = new ConexaoMySql();
    int cod = 0;

    /**
     * Creates new form cadastroUsuario
     */
    public ViewCadastroUsuario() {
        initComponents();
        habilitarDesabilitarCampos(false);
        carregarCadastros();
        salvarAlterar = "salvar";
        setLocationRelativeTo(null);
        jScrollPane1.getViewport().setBackground(Color.white);
        fieldCPF.setDocument(new formatoCPF());
        fieldTelefone.setDocument(new SomenteNumeros());

    }

    public void salvar() {
        if (fieldNome == null & fieldCPF == null & fieldUsuario == null & fieldSenha == null) {
            JOptionPane.showMessageDialog(null, "Informe pelo menos os campos obrigatórios, (Nome, CPF, Data, Usuário e Senha)");
        } else {
            BLDatas bl = new BLDatas();

            modelCadastroUsuarios = new ModelCadastroUsuarios();
            modelCadastroUsuarios.setCpf(fieldCPF.getText().toString());
            modelCadastroUsuarios.setNome(fieldNome.getText());
            modelCadastroUsuarios.setEmail(fieldEmail.getText());
            modelCadastroUsuarios.setTelefone(fieldTelefone.getText().toString());
            try {
                modelCadastroUsuarios.setDataNascimento(bl.converterDataStringParaDate(fieldDataNascimento.getText()));
            } catch (Exception ex) {
                Logger.getLogger(ViewCadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            modelCadastroUsuarios.setUsuNome(fieldUsuario.getText());
            modelCadastroUsuarios.setUsuSenha(fieldSenha.getText());

            if (salvarAlterar.equals("salvar")) {
                if (controllerCadastroUsuarios.salvarCadastroUsuariosController(modelCadastroUsuarios) >= 0) {
                    JOptionPane.showMessageDialog(this, "Cadastro de usuário realizado com sucesso!", "Notificação", JOptionPane.WARNING_MESSAGE);
                    limparCampos();
                    habilitarDesabilitarCampos(false);
                    salvarAlterar = "salvar";
                    btnNovo.setEnabled(true);
                    btnAlterar.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao cadastrar o usuário!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                modelCadastroUsuarios.setCodigo(Integer.parseInt(fieldCodigo.getText()));
                if (controllerCadastroUsuarios.atualizarCadastroUsuariosController(modelCadastroUsuarios)) {
                    JOptionPane.showMessageDialog(this, "Cadastro alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    limparCampos();
                    habilitarDesabilitarCampos(false);
                    btnNovo.setEnabled(true);
                    btnAlterar.setEnabled(true);
                    carregarCadastros();
                    salvarAlterar = "alterar";
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao alterar o cadastro!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void carregarCadastros() {
        listaModelCadastroUsuarios = controllerCadastroUsuarios.getListaCadastroUsuariosController();

        DefaultTableModel modelo = (DefaultTableModel) tabelaConsultaUsuarios.getModel();
        modelo.setNumRows(0);
        //inserir produtos na tabela
        int cont = listaModelCadastroUsuarios.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelCadastroUsuarios.get(i).getCodigo(),
                listaModelCadastroUsuarios.get(i).getNome(),
                listaModelCadastroUsuarios.get(i).getEmail(),
                listaModelCadastroUsuarios.get(i).getTelefone()
            });
        }
    }

    public void buscaCodigoMaximo() {
        DAOCadastroUsuarios daoCadastroUsuarios = new DAOCadastroUsuarios();
        c.conectar();
        try {
            cod = daoCadastroUsuarios.buscaCodigoMaximo();
        } catch (SQLException ex) {
            Logger.getLogger(ViewEtapas.class.getName()).log(Level.SEVERE, null, ex);
        }
        fieldCodigo.setText(String.valueOf(cod + 1));
    }

    public void limparCampos() {
        fieldCodigo.setText("");
        fieldCPF.setText("");
        fieldNome.setText("");
        fieldEmail.setText("");
        fieldTelefone.setText("");
        fieldDataNascimento.setText("");
        fieldUsuario.setText("");
        fieldSenha.setText("");
    }

    public void habilitarDesabilitarCampos(boolean condicao) {
        fieldCodigo.setEnabled(false);
        fieldCPF.setEnabled(condicao);
        fieldNome.setEnabled(condicao);
        fieldEmail.setEnabled(condicao);
        fieldTelefone.setEnabled(condicao);
        fieldDataNascimento.setEnabled(condicao);
        fieldUsuario.setEnabled(condicao);
        fieldSenha.setEnabled(condicao);
        btnExcluir.setEnabled(condicao);
        btnSalvar.setEnabled(condicao);
    }

    public void textonulo() {
        Point p = this.getLocation();
        ViewCadastroUsuario telaCadastroUsuario = this;
        new Thread() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 4; i++) {
                        telaCadastroUsuario.setLocation(p.x - 10, p.y - 2);
                        sleep(20);
                        telaCadastroUsuario.setLocation(p.x + 10, p.y + 2);
                        sleep(20);
                    }
                    telaCadastroUsuario.setLocation(p.x, p.y);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ViewLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }.start();
    }

    public void validaCadastroUsuario() {
        if (fieldCPF.getText().equals("") || fieldNome.getText().equals("") || fieldUsuario.getText().equals("")
                || fieldSenha.getText().equals("") || fieldDataNascimento.getText().equals("")) {
            textonulo();
            JOptionPane.showMessageDialog(this, "Preencha pelo menos os campos obrigatórios para realizar o cadastro (CPF,Nome, Data de nascimento, Usuário e Senha).");
        } else {
            salvar();
        }
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fieldNome = new javax.swing.JTextField();
        fieldEmail = new javax.swing.JTextField();
        fieldUsuario = new javax.swing.JTextField();
        fieldTelefone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaConsultaUsuarios = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        fieldCPF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fieldCodigo = new javax.swing.JTextField();
        fieldSenha = new javax.swing.JPasswordField();
        fieldDataNascimento = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(127, 177, 252));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Usuários");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127, 177, 252)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(91, 95, 99));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Preencha as infmações abaixo para cadastrar um novo colobarodor ao sistema.");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nome completo:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Data de nascimento:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("E-mail:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Telefone:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Usuário:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Senha:");

        fieldNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        fieldTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldTelefoneKeyReleased(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(127, 177, 252)));

        tabelaConsultaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "E-mail", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaConsultaUsuarios.setGridColor(new java.awt.Color(255, 255, 255));
        tabelaConsultaUsuarios.setSelectionBackground(new java.awt.Color(127, 177, 252));
        tabelaConsultaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaConsultaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaConsultaUsuarios);

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("CPF:");

        fieldCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCPFActionPerformed(evt);
            }
        });
        fieldCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCPFKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Código interno:");

        fieldCodigo.setEditable(false);

        try {
            fieldDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fieldDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDataNascimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(fieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(fieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(fieldCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                        .addComponent(fieldDataNascimento)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(fieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(94, 94, 94))))))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(fieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(fieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(fieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(fieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
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
        validaCadastroUsuario();
        carregarCadastros();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseEntered
        if (condicao = true) {
            btnAlterar.setBackground(new Color(110, 120, 149));
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
        modelCadastroUsuarios = new ModelCadastroUsuarios();
        int linha = tabelaConsultaUsuarios.getSelectedRow();
        int codigo = 0;
        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um produto na tabela, antes de clicar em alterar!");
            limparCampos();
        } else {

            BLDatas bl = new BLDatas();

            codigo = (int) tabelaConsultaUsuarios.getValueAt(linha, 0);
            modelCadastroUsuarios = controllerCadastroUsuarios.retornarCadastroUsuariosController(codigo);

            fieldCodigo.setText(String.valueOf(modelCadastroUsuarios.getCodigo()));
            fieldCPF.setText(String.valueOf(modelCadastroUsuarios.getCpf()));
            fieldNome.setText(modelCadastroUsuarios.getNome());
            fieldEmail.setText(modelCadastroUsuarios.getEmail());
            fieldTelefone.setText(String.valueOf(modelCadastroUsuarios.getTelefone()));
            try {
                fieldDataNascimento.setText(bl.converterDataUSParaDateString(modelCadastroUsuarios.getDataNascimento()));
            } catch (Exception ex) {
                Logger.getLogger(ViewCadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            fieldUsuario.setText(modelCadastroUsuarios.getUsuNome());
            fieldSenha.setText(modelCadastroUsuarios.getUsuSenha());
        }

        habilitarDesabilitarCampos(true);

    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseEntered
        if (condicao = true) {
            btnExcluir.setBackground(new Color(242, 148, 125));
            btnExcluir.setForeground(new Color(217, 81, 51));
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
        int linha = tabelaConsultaUsuarios.getSelectedRow();
        int codigoCadastro = (int) tabelaConsultaUsuarios.getValueAt(linha, 0);
        if (controllerCadastroUsuarios.excluirCadastroUsuariosController(codigoCadastro)) {
            JOptionPane.showMessageDialog(this, "Cadastro excluido com sucesso!", " ATENÇÃO", JOptionPane.WARNING_MESSAGE);;
            carregarCadastros();
            limparCampos();
            habilitarDesabilitarCampos(false);
            btnNovo.setEnabled(true);
            btnAlterar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao excluir o cadastro!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnVoltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseEntered
        if (condicao = true) {
            btnVoltar.setBackground(new Color(235, 235, 235));
            btnVoltar.setBackground(new Color(242, 148, 125));
        }
    }//GEN-LAST:event_btnVoltarMouseEntered

    private void btnVoltarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseExited
        if (condicao = true) {
            btnVoltar.setBackground(new Color(217, 81, 51));
            btnVoltar.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_btnVoltarMouseExited

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        ViewLogin tela = new ViewLogin();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void tabelaConsultaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaConsultaUsuariosMouseClicked
        if (evt.getClickCount() == 2) {

            salvarAlterar = "alterar";
            btnAlterar.setEnabled(false);
            btnNovo.setEnabled(false);
            modelCadastroUsuarios = new ModelCadastroUsuarios();
            int linha = tabelaConsultaUsuarios.getSelectedRow();
            int codigo = 0;
            if (linha < 0) {
                JOptionPane.showMessageDialog(this, "Selecione um produto na tabela, antes de clicar em alterar!");
                limparCampos();
            } else {

                BLDatas bl = new BLDatas();

                codigo = (int) tabelaConsultaUsuarios.getValueAt(linha, 0);
                modelCadastroUsuarios = controllerCadastroUsuarios.retornarCadastroUsuariosController(codigo);

                fieldCodigo.setText(String.valueOf(modelCadastroUsuarios.getCodigo()));
                fieldCPF.setText(String.valueOf(modelCadastroUsuarios.getCpf()));
                fieldNome.setText(modelCadastroUsuarios.getNome());
                fieldEmail.setText(modelCadastroUsuarios.getEmail());
                fieldTelefone.setText(String.valueOf(modelCadastroUsuarios.getTelefone()));
                try {
                    fieldDataNascimento.setText(bl.converterDataUSParaDateString(modelCadastroUsuarios.getDataNascimento()));
                } catch (Exception ex) {
                    Logger.getLogger(ViewCadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                fieldUsuario.setText(modelCadastroUsuarios.getUsuNome());
                fieldSenha.setText(modelCadastroUsuarios.getUsuSenha());
            }

            habilitarDesabilitarCampos(true);

        }
    }//GEN-LAST:event_tabelaConsultaUsuariosMouseClicked

    private void fieldCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCPFActionPerformed

    private void fieldDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldDataNascimentoActionPerformed

    private void fieldCPFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCPFKeyReleased
        fieldCPF.setText(JMascara.GetJmascaraCpfCnpj(fieldCPF.getText()));
    }//GEN-LAST:event_fieldCPFKeyReleased

    private void fieldTelefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTelefoneKeyReleased
        fieldTelefone.setText(JMascara.GetJmascaraFone(fieldTelefone.getText()));
    }//GEN-LAST:event_fieldTelefoneKeyReleased

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
            java.util.logging.Logger.getLogger(ViewCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    public void limpaCampos() {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JTextField fieldCPF;
    private javax.swing.JTextField fieldCodigo;
    private javax.swing.JFormattedTextField fieldDataNascimento;
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JTextField fieldNome;
    private javax.swing.JPasswordField fieldSenha;
    private javax.swing.JTextField fieldTelefone;
    private javax.swing.JTextField fieldUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaConsultaUsuarios;
    // End of variables declaration//GEN-END:variables
}

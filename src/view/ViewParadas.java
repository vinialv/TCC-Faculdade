/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.DAOCadastroGeral;
import DAO.DAOCadastroUsuarios;
import DAO.DAOEtapas;
import DAO.DAOParadas;
import DAO.DAOProdutos;
import DAO.DAORecursos;
import conexoes.ConexaoMySql;
import controller.ControllerParadas;
import java.awt.Color;
import java.awt.Point;
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ModelCadastroGeral;
import model.ModelCadastroUsuarios;
import model.ModelEtapas;
import model.ModelParadas;
import model.ModelProdutos;
import model.ModelRecursos;
import util.BLDatas;

/**
 *
 * @author Vinicius
 */
public class ViewParadas extends javax.swing.JFrame {

    List<ModelEtapas> lista_etapas = new ArrayList<>();
    List<ModelRecursos> lista_recursos = new ArrayList<>();
    List<ModelCadastroGeral> lista_motivos = new ArrayList<>();
    List<ModelProdutos> lista_produtos = new ArrayList<>();
    List<ModelCadastroUsuarios> lista_usuarios = new ArrayList<>();
    ControllerParadas controllerParadas = new ControllerParadas();
    ModelParadas modelParadas = new ModelParadas();
    ConexaoMySql c = new ConexaoMySql();
    DAOParadas daoParadas = new DAOParadas();
    int cod = 0, codP = 0;
    String alterarSalvar = "salvar";
    ViewConsulta viewConsulta;
    boolean todos = false;

    /**
     * Creates new form paradas
     */
    public ViewParadas() {
        initComponents();
        preencher_comboBox();
        preencher_comboBoxRecurso();
        preencher_comboBoxMotivo();
        preencher_comboBoxProduto();
        preencher_comboBoxOperador();
        limpaTela();
        buscaCodigoMaximo();
        habilitarDesabilitarCampos(false);

    }

    public ViewParadas(ModelParadas modelParadas, ViewConsulta viewConsulta, boolean todos, int codParadas) {
        initComponents();
        preencher_comboBox();
        preencher_comboBoxRecurso();
        preencher_comboBoxMotivo();
        preencher_comboBoxProduto();
        preencher_comboBoxOperador();
        limpaTela();
        buscaCodigoMaximo();
        limpaTela();
        this.viewConsulta = viewConsulta;
        this.todos = todos;
        this.codP = codParadas;
        habilitarDesabilitarCampos(false);

        BLDatas bl = new BLDatas();

        alterarSalvar = "alterar";

        fieldCodigo.setText(String.valueOf(modelParadas.getIdCodigo()));
        comboProduto.setSelectedItem(modelParadas.getDescProduto());
        comboEtapa.setSelectedItem(modelParadas.getDescEtapa());
        comboRecurso.setSelectedItem(modelParadas.getDescRecurso());
        try {
            dataInicio.setText(bl.converterDataUSParaDateString(modelParadas.getDataInicio()));
            dataTermino.setText(bl.converterDataUSParaDateString(modelParadas.getDataTermino()));
        } catch (Exception ex) {
            Logger.getLogger(ViewParadas.class.getName()).log(Level.SEVERE, null, ex);
        }
        horaInicio.setText(modelParadas.getHoraInicio().toString());
        horaTermino.setText(modelParadas.getHoraTermino().toString());
        comboMotivo.setSelectedItem(String.valueOf(modelParadas.getMotivo()));
        comboOperador.setSelectedItem(modelParadas.getOperador());

    }

    public void textonulo() {
        Point p = this.getLocation();
        ViewParadas telaParadas = this;
        new Thread() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 4; i++) {
                        telaParadas.setLocation(p.x - 10, p.y - 2);
                        sleep(20);
                        telaParadas.setLocation(p.x + 10, p.y + 2);
                        sleep(20);
                    }
                    telaParadas.setLocation(p.x, p.y);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ViewLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }.start();
    }

    public void validacao() {
        if (comboProduto.getSelectedIndex() == -1 || comboEtapa.getSelectedIndex() == -1 || comboRecurso.getSelectedIndex() == -1
                || dataInicio.getText().equals("") || horaInicio.getText().equals("") || dataTermino.getText().equals("")
                || horaTermino.getText().equals("") || comboMotivo.getSelectedIndex() == -1 || comboOperador.getSelectedIndex() == -1) {
            textonulo();
            JOptionPane.showMessageDialog(this, "Preencha todos os campos para realizar o cadastro.");
        } else {
            salvar();
        }
    }

    public void habilitarDesabilitarCampos(boolean condicao) {
        comboProduto.setEnabled(condicao);
        comboEtapa.setEnabled(condicao);
        comboRecurso.setEnabled(condicao);
        dataInicio.setEnabled(condicao);
        horaInicio.setEnabled(condicao);
        dataTermino.setEnabled(condicao);
        horaTermino.setEnabled(condicao);
        comboMotivo.setEnabled(condicao);
        comboOperador.setEnabled(condicao);
        btnSalvar.setEnabled(condicao);
        btnExcluir.setEnabled(condicao);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboProduto = new componentes.UJComboBox();
        comboEtapa = new componentes.UJComboBox();
        comboRecurso = new componentes.UJComboBox();
        comboMotivo = new componentes.UJComboBox();
        comboOperador = new componentes.UJComboBox();
        jLabel9 = new javax.swing.JLabel();
        fieldCodigo = new javax.swing.JTextField();
        dataInicio = new javax.swing.JFormattedTextField();
        dataTermino = new javax.swing.JFormattedTextField();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        horaInicio = new javax.swing.JFormattedTextField();
        horaTermino = new javax.swing.JFormattedTextField();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 650));

        jPanel1.setBackground(new java.awt.Color(127, 177, 252));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Apontamento de Paradas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(25, 25, 25))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Produto:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Etapa:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Recurso:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Data de início:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Motivo da Parada:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Data de término:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Operador:");

        comboProduto.setAutocompletar(true);
        comboProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProdutoActionPerformed(evt);
            }
        });

        comboEtapa.setAutocompletar(true);
        comboEtapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEtapaActionPerformed(evt);
            }
        });

        comboRecurso.setAutocompletar(true);

        comboMotivo.setAutocompletar(true);

        comboOperador.setAutocompletar(true);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Código:");

        fieldCodigo.setEditable(false);

        dataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        dataTermino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

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

        horaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));

        horaTermino.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9)))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldCodigo)
                            .addComponent(comboProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboEtapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(horaTermino, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(horaInicio)))
                            .addComponent(comboRecurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboMotivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboOperador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(fieldCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horaTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void preencher_comboBox() {
        try {

            DAOEtapas daoEtapas = new DAOEtapas();
            lista_etapas = daoEtapas.busca();

            for (int i = 0; i < lista_etapas.size(); i++) {

                comboEtapa.addItem(
                        String.valueOf(lista_etapas.get(i).getDescricao())
                );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na busca");
        }
    }

    public void preencher_comboBoxRecurso() {
        try {

            DAORecursos daoRecursos = new DAORecursos();
            lista_recursos = daoRecursos.busca();

            for (int i = 0; i < lista_recursos.size(); i++) {

                comboRecurso.addItem(
                        String.valueOf(lista_recursos.get(i).getDescricao())
                );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na busca");
        }
    }

    public void preencher_comboBoxMotivo() {
        try {

            DAOCadastroGeral daoCadastroGeral = new DAOCadastroGeral();
            lista_motivos = daoCadastroGeral.busca();

            for (int i = 0; i < lista_motivos.size(); i++) {

                comboMotivo.addItem(
                        String.valueOf(lista_motivos.get(i).getDescricao())
                );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na busca");
        }
    }

    public void preencher_comboBoxProduto() {
        try {

            DAOProdutos daoProdutos = new DAOProdutos();
            lista_produtos = daoProdutos.busca();

            for (int i = 0; i < lista_produtos.size(); i++) {

                comboProduto.addItem(
                        String.valueOf(lista_produtos.get(i).getDescricao())
                );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na busca");
        }
    }

    public void preencher_comboBoxOperador() {
        try {

            DAOCadastroUsuarios daoCadastroUsuarios = new DAOCadastroUsuarios();
            lista_usuarios = daoCadastroUsuarios.busca();

            for (int i = 0; i < lista_usuarios.size(); i++) {

                comboOperador.addItem(
                        String.valueOf(lista_usuarios.get(i).getNome())
                );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na busca");
        }
    }

    public void buscaCodigoMaximo() {
        DAOParadas daoParadas = new DAOParadas();
        c.conectar();
        try {
            cod = daoParadas.buscaCodigoMaximo();
        } catch (SQLException ex) {
            Logger.getLogger(ViewEtapas.class.getName()).log(Level.SEVERE, null, ex);
        }
        fieldCodigo.setText(String.valueOf(cod + 1));
    }

    public void limpaTela() {

        comboProduto.setSelectedIndex(-1);
        comboEtapa.setSelectedIndex(-1);
        comboRecurso.setSelectedIndex(-1);
        dataInicio.setText(null);
        dataTermino.setText(null);
        comboMotivo.setSelectedIndex(-1);
        comboOperador.setSelectedIndex(-1);
        horaInicio.setText(null);
        horaTermino.setText(null);
    }

    public void salvar() {

        BLDatas bl = new BLDatas();

        modelParadas.setDescProduto(String.valueOf(comboProduto.getSelectedItem()));
        modelParadas.setDescEtapa(String.valueOf(comboEtapa.getSelectedItem()));
        modelParadas.setDescRecurso(String.valueOf(comboRecurso.getSelectedItem()));
        try {
            modelParadas.setDataInicio(bl.converterDataStringParaDate(dataInicio.getText()));
            modelParadas.setDataTermino(bl.converterDataStringParaDate(dataTermino.getText()));
            try {
                SimpleDateFormat horaMinutos = new SimpleDateFormat("HH:mm");
                java.util.Date data = horaMinutos.parse(horaInicio.getText());
                Time time1 = new Time(data.getTime());
                modelParadas.setHoraInicio(time1);
            } catch (ParseException ex) {
                Logger.getLogger(ViewParadas.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                SimpleDateFormat horaMinutos = new SimpleDateFormat("HH:mm");
                java.util.Date data = horaMinutos.parse(horaTermino.getText());
                Time time2 = new Time(data.getTime());
                modelParadas.setHoraTermino(time2);
            } catch (ParseException ex) {
                Logger.getLogger(ViewParadas.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(ViewParadas.class.getName()).log(Level.SEVERE, null, ex);
        }

        modelParadas.setMotivo(String.valueOf(comboMotivo.getSelectedItem()));
        modelParadas.setOperador(String.valueOf(comboOperador.getSelectedItem()));

        if (alterarSalvar.equals("salvar")) {
            if (controllerParadas.salvarCadastroParada(modelParadas) > 0) {
                JOptionPane.showMessageDialog(this, "Parada cadastrada com sucesso!", "Notificação", JOptionPane.WARNING_MESSAGE);
                buscaCodigoMaximo();
                habilitarDesabilitarCampos(false);
                limpaTela();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar a parada!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            modelParadas.setIdCodigo(Integer.parseInt(fieldCodigo.getText()));
            if (controllerParadas.atualizarParadasController(modelParadas)) {
                JOptionPane.showMessageDialog(this, "Parada alterada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                limpaTela();
                //habilitarDesabilitarCampos(false);
                btnNovo.setEnabled(true);
                alterarSalvar = "alterar";
                dispose();
                if (this.todos == true) {
                    viewConsulta.carregarTodos();
                } else {
                    viewConsulta.carregarParadas(!todos);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Erro ao alterar a parada!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private void comboEtapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEtapaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEtapaActionPerformed

    private void comboProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProdutoActionPerformed

    private void btnNovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoMouseEntered
        btnNovo.setBackground(new Color(110, 120, 149));
        btnNovo.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnNovoMouseEntered

    private void btnNovoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoMouseExited
        btnNovo.setBackground(new Color(58, 65, 84));
        btnNovo.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnNovoMouseExited

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limpaTela();
        habilitarDesabilitarCampos(true);
        btnNovo.setEnabled(false);
        btnExcluir.setEnabled(false);
        buscaCodigoMaximo();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseEntered
        btnSalvar.setBackground(new Color(110, 120, 149));
        btnSalvar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnSalvarMouseEntered

    private void btnSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseExited
        btnSalvar.setBackground(new Color(58, 65, 84));
        btnSalvar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnSalvarMouseExited

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        validacao();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseEntered
        btnExcluir.setBackground(new Color(242, 148, 125));
        btnExcluir.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnExcluirMouseEntered

    private void btnExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseExited
        btnExcluir.setBackground(new Color(217, 81, 51));
        btnExcluir.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnExcluirMouseExited

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // EXCLUI UMA PARADA NO BANCO
        if (controllerParadas.excluirCadastroParadas(codP)) {
            JOptionPane.showMessageDialog(this, "Parada excluida com sucesso!", " ATENÇÃO", JOptionPane.WARNING_MESSAGE);;
            limpaTela();
            btnNovo.setEnabled(false);
            dispose();
            if (this.todos == true) {
                viewConsulta.carregarTodos();
            } else {
                viewConsulta.carregarParadas(!todos);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao excluir a parada!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(ViewParadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewParadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewParadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewParadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewParadas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private componentes.UJComboBox comboEtapa;
    private componentes.UJComboBox comboMotivo;
    private componentes.UJComboBox comboOperador;
    private componentes.UJComboBox comboProduto;
    private componentes.UJComboBox comboRecurso;
    private javax.swing.JFormattedTextField dataInicio;
    private javax.swing.JFormattedTextField dataTermino;
    private javax.swing.JTextField fieldCodigo;
    private javax.swing.JFormattedTextField horaInicio;
    private javax.swing.JFormattedTextField horaTermino;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}

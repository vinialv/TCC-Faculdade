/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import controller.ControllerParadas;
import controller.ControllerPerdas;
import controller.ControllerProducao;
import java.awt.Color;
import java.awt.Desktop;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.ModelEtapas;
import model.ModelParadas;
import model.ModelPerdas;
import model.ModelProducao;
import model.ModelRecursos;
import org.apache.poi.hssf.util.HSSFRegionUtil;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import util.BLDatas;

/**
 *
 * @author Vinicius
 */
public class ViewConsulta extends javax.swing.JFrame {

    List<ModelEtapas> lista_etapas = new ArrayList<>();
    List<ModelRecursos> lista_recursos = new ArrayList<>();
    ArrayList<ModelParadas> listaModelParadas = new ArrayList<>();
    ArrayList<ModelParadas> listaModelParadasGeral = new ArrayList<>();
    ControllerParadas controllerParadas = new ControllerParadas();
    ModelParadas modelParadas = new ModelParadas();
    ArrayList<ModelPerdas> listaModelPerdas = new ArrayList<>();
    ArrayList<ModelPerdas> listaModelPerdasGeral = new ArrayList<>();
    ControllerPerdas controllerPerdas = new ControllerPerdas();
    ModelPerdas modelPerdas = new ModelPerdas();
    ArrayList<ModelProducao> listaModelProducao = new ArrayList<>();
    ArrayList<ModelProducao> listaModelProducaoGeral = new ArrayList<>();
    ControllerProducao controllerProducao = new ControllerProducao();
    ModelProducao modelProducao = new ModelProducao();
    ViewProducao viewProducao = new ViewProducao();
    ViewParadas viewParadas = new ViewParadas();
    ViewPerdas viewPerdas = new ViewPerdas();
    String salvarAlterar;

    /**
     * Creates new form consulta
     */
    public ViewConsulta() {
        initComponents();
        salvarAlterar = "salvar";
        setLocationRelativeTo(null);
        jLabel1.setVisible(false);
        jLabel5.setVisible(false);
        jLabel7.setVisible(false);
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
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaConsulta = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        confirmaConsulta = new javax.swing.JButton();
        voltaConsulta = new javax.swing.JButton();
        tipoConsulta = new componentes.UJComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fieldRecurso = new javax.swing.JTextField();
        fieldEtapa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(127, 177, 252));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Consulta de Apontamentos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(25, 25, 25))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        listaConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Etapa", "Recurso", "Tipo Apont.", "Data Início", "Data de Término", "Peso", "Operador", "Motivo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaConsulta.setGridColor(new java.awt.Color(255, 255, 255));
        listaConsulta.setRowHeight(20);
        listaConsulta.setSelectionBackground(new java.awt.Color(127, 177, 252));
        listaConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaConsultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaConsulta);
        if (listaConsulta.getColumnModel().getColumnCount() > 0) {
            listaConsulta.getColumnModel().getColumn(0).setMinWidth(0);
            listaConsulta.getColumnModel().getColumn(0).setPreferredWidth(0);
            listaConsulta.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Etapa:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Recurso:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tipo de consulta:");

        confirmaConsulta.setBackground(new java.awt.Color(58, 65, 84));
        confirmaConsulta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        confirmaConsulta.setForeground(new java.awt.Color(255, 255, 255));
        confirmaConsulta.setText("Consultar");
        confirmaConsulta.setBorderPainted(false);
        confirmaConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmaConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmaConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmaConsultaMouseExited(evt);
            }
        });
        confirmaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmaConsultaActionPerformed(evt);
            }
        });

        voltaConsulta.setBackground(new java.awt.Color(217, 81, 51));
        voltaConsulta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        voltaConsulta.setForeground(new java.awt.Color(255, 255, 255));
        voltaConsulta.setText("Voltar ao menu");
        voltaConsulta.setBorderPainted(false);
        voltaConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        voltaConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                voltaConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                voltaConsultaMouseExited(evt);
            }
        });
        voltaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltaConsultaActionPerformed(evt);
            }
        });

        tipoConsulta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Produção", "Paradas", "Perdas" }));
        tipoConsulta.setAutocompletar(true);
        tipoConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoConsultaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Relatórios disponíveis para salvar em sua máquina:");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excelExited.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pdfVermelhoExited.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fieldEtapa, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(fieldRecurso, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                            .addGap(136, 136, 136)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(confirmaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(voltaConsulta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(confirmaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(voltaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(tipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(fieldEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(fieldRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void carregarParadas(boolean clear) {
        listaModelParadas = controllerParadas.retornarListaParadasController(fieldEtapa.getText(), fieldRecurso.getText());

        DefaultTableModel modelo = (DefaultTableModel) listaConsulta.getModel();
        if (clear == true) {
            modelo.setNumRows(0);
        }
        //inserir produtos na tabela
        int cont = listaModelParadas.size();
        BLDatas bl = new BLDatas();
        for (int i = 0; i < cont; i++) {
            try {
                modelo.addRow(new Object[]{
                    listaModelParadas.get(i).getIdCodigo(),
                    listaModelParadas.get(i).getDescEtapa(),
                    listaModelParadas.get(i).getDescRecurso(),
                    listaModelParadas.get(i).getTipo(),
                    bl.converterDataUSParaDateString(listaModelParadas.get(i).getDataInicio()) + " " + listaModelParadas.get(i).getHoraInicio(),
                    bl.converterDataUSParaDateString(listaModelParadas.get(i).getDataTermino()) + " " + listaModelParadas.get(i).getHoraTermino(),
                    listaModelParadas.get(i).getExtra(),
                    listaModelParadas.get(i).getOperador(),
                    listaModelParadas.get(i).getMotivo()
                });
            } catch (Exception ex) {
                Logger.getLogger(ViewConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void carregarPerdas(boolean clear) {
        listaModelPerdas = controllerPerdas.retornarListaPerdasController(fieldEtapa.getText(), fieldRecurso.getText());

        DefaultTableModel modelo = (DefaultTableModel) listaConsulta.getModel();
        if (clear == true) {
            modelo.setNumRows(0);
        }
        //inserir produtos na tabela
        int cont = listaModelPerdas.size();
        BLDatas bl = new BLDatas();
        for (int i = 0; i < cont; i++) {
            try {
                modelo.addRow(new Object[]{
                    listaModelPerdas.get(i).getIdCodigo(),
                    listaModelPerdas.get(i).getDescEtapa(),
                    listaModelPerdas.get(i).getDescRecurso(),
                    listaModelPerdas.get(i).getTipo(),
                    bl.converterDataUSParaDateString(listaModelPerdas.get(i).getDataPerda()) + " " + listaModelPerdas.get(i).getHoraPerda(),
                    bl.converterDataUSParaDateString(listaModelPerdas.get(i).getDataPerda()) + " " + listaModelPerdas.get(i).getHoraPerda(),
                    listaModelPerdas.get(i).getPesoPerda(),
                    listaModelPerdas.get(i).getOperador(),
                    listaModelPerdas.get(i).getMotivo()
                });
            } catch (Exception ex) {
                Logger.getLogger(ViewConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void carregarProducao(boolean clear) {

        listaModelProducao = controllerProducao.retornarListaProducaoController(fieldEtapa.getText(), fieldRecurso.getText());

        DefaultTableModel modelo = (DefaultTableModel) listaConsulta.getModel();
        if (clear == true) {
            modelo.setNumRows(0);
        }

        //inserir produtos na tabela
        int cont = listaModelProducao.size();
        BLDatas bl = new BLDatas();
        for (int i = 0; i < cont; i++) {
            try {
                modelo.addRow(new Object[]{
                    listaModelProducao.get(i).getIdCodigo(),
                    listaModelProducao.get(i).getDescEtapa(),
                    listaModelProducao.get(i).getDescRecurso(),
                    listaModelProducao.get(i).getTipo(),
                    bl.converterDataUSParaDateString(listaModelProducao.get(i).getDataInicio()) + " " + listaModelProducao.get(i).getHoraInicio(),
                    bl.converterDataUSParaDateString(listaModelProducao.get(i).getDataTermino()) + " " + listaModelProducao.get(i).getHoraTermino(),
                    listaModelProducao.get(i).getPesoProducao(),
                    listaModelProducao.get(i).getOperador(),
                    listaModelProducao.get(i).getExtra()
                });
            } catch (Exception ex) {
                Logger.getLogger(ViewConsulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void carregarTodos() {

        DefaultTableModel modelo = (DefaultTableModel) listaConsulta.getModel();
        modelo.setNumRows(0);

        carregarProducao(false);
        carregarPerdas(false);
        carregarParadas(false);

    }

    public void filtroTipoConsulta() {
        if (tipoConsulta.getSelectedItem().equals("Paradas")) {
            carregarParadas(true);
        }
        if (tipoConsulta.getSelectedItem().equals("Perdas")) {
            carregarPerdas(true);
        }
        if (tipoConsulta.getSelectedItem().equals("Produção")) {
            carregarProducao(true);
        }
        if (tipoConsulta.getSelectedItem().equals("Todos")) {
            carregarTodos();
        }
    }


    private void confirmaConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmaConsultaMouseEntered
        confirmaConsulta.setBackground(new Color(110, 120, 149));
        confirmaConsulta.setForeground(Color.WHITE);
    }//GEN-LAST:event_confirmaConsultaMouseEntered

    private void confirmaConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmaConsultaMouseExited
        confirmaConsulta.setBackground(new Color(58, 65, 84));
        confirmaConsulta.setForeground(Color.WHITE);
    }//GEN-LAST:event_confirmaConsultaMouseExited

    private void voltaConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltaConsultaMouseEntered
        voltaConsulta.setBackground(new Color(242, 148, 125));
        voltaConsulta.setForeground(Color.WHITE);
    }//GEN-LAST:event_voltaConsultaMouseEntered

    private void voltaConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltaConsultaMouseExited
        voltaConsulta.setBackground(new Color(217, 81, 51));
        voltaConsulta.setForeground(Color.WHITE);
    }//GEN-LAST:event_voltaConsultaMouseExited

    private void voltaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltaConsultaActionPerformed
        ViewPrincipal tela = new ViewPrincipal();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_voltaConsultaActionPerformed

    private void confirmaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmaConsultaActionPerformed
        filtroTipoConsulta();
        jLabel1.setVisible(true);
        jLabel5.setVisible(true);
        jLabel7.setVisible(true);
    }//GEN-LAST:event_confirmaConsultaActionPerformed

    private void listaConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaConsultaMouseClicked
        if (evt.getClickCount() == 2) {
            salvarAlterar = "alterar";
            modelParadas = new ModelParadas();
            modelPerdas = new ModelPerdas();
            modelProducao = new ModelProducao();
            int linha = listaConsulta.getSelectedRow();
            int tipo = 0;
            int codigo = 0;
            String tipoApontamento;

            BLDatas bl = new BLDatas();

            //verifica o tipo do apontamento, producao, parada ou perda
            tipoApontamento = (String) listaConsulta.getValueAt(linha, 3);
            codigo = (int) listaConsulta.getValueAt(linha, 0);
            boolean todos = tipoConsulta.getSelectedIndex() == 0 ? true : false;

            switch (tipoApontamento) {
                case "Produção":
                    modelProducao = controllerProducao.retornarListaProducaoController(codigo);
                    ViewProducao viewProducao = new ViewProducao(modelProducao, this, todos, codigo);
                    viewProducao.habilitarDesabilitarCampos(true);
                    viewProducao.setVisible(true);
                    break;
                case "Paradas":
                    modelParadas = controllerParadas.retornarListaParadasController(codigo);
                    ViewParadas viewParadas = new ViewParadas(modelParadas, this, todos, codigo);
                    viewParadas.setVisible(true);
                    viewParadas.habilitarDesabilitarCampos(true);
                    break;
                case "Perdas":
                    modelPerdas = controllerPerdas.retornarListaPerdasController(codigo);
                    ViewPerdas viewPerdas = new ViewPerdas(modelPerdas, this, todos, codigo);
                    viewPerdas.setVisible(true);
                    viewPerdas.habilitarDesabilitarCampos(true);
                    break;
                default:

                    break;
            }

        }

           

    }//GEN-LAST:event_listaConsultaMouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        ImageIcon imgEntered = (new ImageIcon("D:/Desenvolvimento Java/(Trabalho) Vinicius Alves/src/imagens/excelSelected.png"));
        jLabel5.setIcon(imgEntered);
        jLabel5.setToolTipText("Excel");
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        ImageIcon imgExited = (new ImageIcon("D:/Desenvolvimento Java/(Trabalho) Vinicius Alves/src/imagens/excelExited.png"));
        jLabel5.setIcon(imgExited);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        ImageIcon imgEntered = (new ImageIcon("D:/Desenvolvimento Java/(Trabalho) Vinicius Alves/src/imagens/pdfVermelhoSelected.png"));
        jLabel7.setIcon(imgEntered);
        jLabel7.setToolTipText("PDF");
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        ImageIcon imgExited = (new ImageIcon("D:/Desenvolvimento Java/(Trabalho) Vinicius Alves/src/imagens/pdfVermelhoExited.png"));
        jLabel7.setIcon(imgExited);
    }//GEN-LAST:event_jLabel7MouseExited

    private void tipoConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoConsultaActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExporter = null;

        //Escolha o local para salvar o arquivo .xlsm
        JFileChooser excelFileChooser = new JFileChooser("D:\\Desenvolvimento Java\\(Trabalho) Vinicius Alves");
        //Altere a tela de salvar
        excelFileChooser.setDialogTitle("Salvar como");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("Arquivo Excel", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(null);

        //Checar se o botão foi clicado
        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                excelJTableExporter = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExporter.createSheet("Base de dados");
                //Cria uma linha na Planilha.
                XSSFRow linha = excelSheet.createRow(1);
                //Cria as células na linha                
                Cell cell;
                linha.createCell(1).setCellValue("Etapa");
                linha.createCell(2).setCellValue("Recurso");
                linha.createCell(3).setCellValue("Tipo Apont.");
                linha.createCell(4).setCellValue("Data Início");
                linha.createCell(5).setCellValue("Data Término");
                linha.createCell(6).setCellValue("Peso");
                linha.createCell(7).setCellValue("Operador");
                linha.createCell(8).setCellValue("Motivo");

                XSSFCellStyle style = excelJTableExporter.createCellStyle();
                style.setBorderTop(BorderStyle.THIN);
                style.setBorderBottom(BorderStyle.THIN);
                style.setBorderLeft(BorderStyle.THIN);
                style.setBorderRight(BorderStyle.THIN);

                linha.getCell(1).setCellStyle(style);
                linha.getCell(2).setCellStyle(style);
                linha.getCell(3).setCellStyle(style);
                linha.getCell(4).setCellStyle(style);
                linha.getCell(5).setCellStyle(style);
                linha.getCell(6).setCellStyle(style);
                linha.getCell(7).setCellStyle(style);
                linha.getCell(8).setCellStyle(style);

                //Repetições para receber todas linhas e colunas da tabela.
                for (int i = 2; i < listaConsulta.getRowCount() + 2; i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    String valor = "";
                    for (int j = 1; j < listaConsulta.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        valor = String.valueOf(listaConsulta.getValueAt(i - 2, j));
                        excelCell.setCellValue(!valor.equals("null") ? valor : "");
                        excelCell.setCellStyle(style);
                    }
                }

                excelSheet.autoSizeColumn(1);
                excelSheet.autoSizeColumn(2);
                excelSheet.autoSizeColumn(3);
                excelSheet.autoSizeColumn(4);
                excelSheet.autoSizeColumn(5);
                excelSheet.autoSizeColumn(6);
                excelSheet.autoSizeColumn(7);
                excelSheet.autoSizeColumn(8);
                excelSheet.autoSizeColumn(9);

                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExporter.write(excelBOU);
                JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso!");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();
                    }
                    if (excelJTableExporter != null) {
                        excelJTableExporter.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked

        Document document = new Document();

        //Cria uma instância da classe Calendar com a data atual
        Calendar dataAtual = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH-mm");

        try {
            PdfWriter.getInstance(document, new FileOutputStream("D:\\Desenvolvimento Java\\(Trabalho) Vinicius Alves\\ " + sdf.format(dataAtual.getTime()) + ".pdf"));
            document.setPageSize(PageSize.A4.rotate());
            document.open();
            Paragraph p = new Paragraph("Consulta de apontamentos");
            p.setAlignment(1);
            document.add(p);
            p = new Paragraph("  ");
            document.add(p);

            PdfPTable tbl = new PdfPTable(8);

            tbl.addCell("Etapa");
            tbl.addCell("Recurso");
            tbl.addCell("Tipo Apont.");
            tbl.addCell("Data Início");
            tbl.addCell("Data Término");
            tbl.addCell("Peso");
            tbl.addCell("Operador");
            tbl.addCell("Motivo");

            for (int i = 0; i < listaConsulta.getRowCount(); i++) {

                String Etapa = String.valueOf(listaConsulta.getValueAt(i, 1));
                String Recurso = String.valueOf(listaConsulta.getValueAt(i, 2));
                String TipoApont = String.valueOf(listaConsulta.getValueAt(i, 3));
                String DataInicio = String.valueOf(listaConsulta.getValueAt(i, 4));
                String DataTermino = String.valueOf(listaConsulta.getValueAt(i, 5));
                String Peso = String.valueOf(listaConsulta.getValueAt(i, 6));
                String Operador = String.valueOf(listaConsulta.getValueAt(i, 7));
                String Motivo = String.valueOf(listaConsulta.getValueAt(i, 8));

                tbl.addCell(Etapa != null ? Etapa : "");
                tbl.addCell(Recurso != null ? Recurso : "");
                tbl.addCell(TipoApont != null ? TipoApont : "");
                tbl.addCell(DataInicio != null ? DataInicio : "");
                tbl.addCell(DataTermino != null ? DataTermino : "");
                tbl.addCell(!Peso.equals("null") ? Peso : "");
                tbl.addCell(!Operador.equals("null") ? Operador : "");
                tbl.addCell(!Motivo.equals("null") ? Motivo : "");

            }
            document.add(tbl);
            JOptionPane.showMessageDialog(null, "PDF gerado com sucesso!");

        

} catch (FileNotFoundException ex) {
            Logger.getLogger(ViewConsulta.class
.getName()).log(Level.SEVERE, null, ex);
        

} catch (DocumentException ex) {
            Logger.getLogger(ViewConsulta.class
.getName()).log(Level.SEVERE, null, ex);
        } finally {
            document.close();
        }

        try {
            Desktop.getDesktop().open(new File("D:\\Desenvolvimento Java\\(Trabalho) Vinicius Alves\\ " + sdf.format(dataAtual.getTime()) + ".pdf"));
        

} catch (IOException ex) {
            Logger.getLogger(ViewConsulta.class
.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

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
            java.util.logging.Logger.getLogger(ViewConsulta.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewConsulta.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewConsulta.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewConsulta.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmaConsulta;
    private javax.swing.JTextField fieldEtapa;
    private javax.swing.JTextField fieldRecurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaConsulta;
    private componentes.UJComboBox tipoConsulta;
    private javax.swing.JButton voltaConsulta;
    // End of variables declaration//GEN-END:variables
}
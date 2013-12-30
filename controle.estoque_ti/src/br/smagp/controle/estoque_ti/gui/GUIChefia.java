//ESTA GUI ESTÁ RESPONSÁVEL POR MANTER E EXIBIR AS CHEFIAS ENCONTRADAS NO ESTOQUE DO SUPORTE DE TI
package br.smagp.controle.estoque_ti.gui;

//IMPORTES OBRIGATÓRIOS PARA REALIZAR AS TAREFAS CONTIDAS NESTE FORMULÁRIO
import br.smagp.controle.estoque_ti.dao.ChefiaDAO;
import br.smagp.controle.estoque_ti.dao.DAOFactory;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

import br.smagp.controle.estoque_ti.db.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author AllexOnRails
 */
public class GUIChefia extends javax.swing.JFrame {

    //@atributoss necessários para relizar qualquer operação 
    //com a base de dados MYSQL 
    //-> statement -result_set - SQL - conecta
    private static ResultSet result_set;
    private PreparedStatement SQL;
    private String result;
    Connection conecta = ConnectionFactory.getInstance().getConnection();

    /**
     * INICIALIZA O FORMULARIO
     */
    public GUIChefia() {
        this.initComponents();
        this.setResizable(false);
        this.setLocation(250, 100);
        this.setLocationRelativeTo(null);
        this.PreencherJTipoEquipamento();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.preencherTabela();
    }

    //COMPONENTES INICIALIZADOS PELO NET-BEANS
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbMatricula = new javax.swing.JLabel();
        jtBuscarMatricula = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jProgressBar1 = new javax.swing.JProgressBar();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jtMatricula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtSetor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        jTipoEquipamento = new javax.swing.JComboBox();
        btApagar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jtID = new javax.swing.JTextField();
        btAtualizarComboBox = new javax.swing.JButton();
        btPrimeiro = new javax.swing.JButton();
        btUltimo = new javax.swing.JButton();
        btAnterior = new javax.swing.JButton();
        btProximo = new javax.swing.JButton();
        btNovoOrgao = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableShowChefias = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuNovoOrgao = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbMatricula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbMatricula.setText("Matrícula");

        jtBuscarMatricula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtBuscarMatricula.setHighlighter(null);
        jtBuscarMatricula.setSelectionColor(new java.awt.Color(204, 204, 204));

        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-buscar.png"))); // NOI18N
        btBuscar.setText("Buscar Chefia");

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/cancel2.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setEnabled(false);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-excluir.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-editar.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Matrícula");

        jtMatricula.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nome:");

        jtNome.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Orgão: ");

        jtSetor.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Setor: ");

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-cadastrar.png"))); // NOI18N
        btNovo.setText("Nova Chefia");
        btNovo.setEnabled(false);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-cadastrar.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setEnabled(false);

        jTipoEquipamento.setEnabled(false);

        btApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/Reset.png"))); // NOI18N
        btApagar.setText("Apagar");
        btApagar.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("ID:");

        jtID.setEnabled(false);

        btAtualizarComboBox.setBackground(new java.awt.Color(204, 204, 255));
        btAtualizarComboBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-editar.png"))); // NOI18N
        btAtualizarComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAtualizarComboBox.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        btAtualizarComboBox.setEnabled(false);

        btPrimeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/First.png"))); // NOI18N

        btUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/Last.png"))); // NOI18N

        btAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/Previous.png"))); // NOI18N

        btProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/Next.png"))); // NOI18N

        btNovoOrgao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/boss.png"))); // NOI18N
        btNovoOrgao.setText("Novo Orgão");

        jTableShowChefias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableShowChefias);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8)
                                .addGap(10, 10, 10)
                                .addComponent(jtID, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4)
                                .addGap(199, 199, 199)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6)
                                .addGap(198, 198, 198)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jtSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTipoEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btAtualizarComboBox))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btCancelar)))
                        .addGap(0, 41, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbMatricula)
                                .addGap(18, 18, 18)
                                .addComponent(jtBuscarMatricula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btNovoOrgao))
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbMatricula))
                    .addComponent(jtBuscarMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btNovoOrgao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel8))
                    .addComponent(jtID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTipoEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAtualizarComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("Arquivo");

        jMenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-sair.png"))); // NOI18N
        jMenuSair.setText("Sair");
        jMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSairActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuNovoOrgao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/boss_menor.png"))); // NOI18N
        jMenuNovoOrgao.setText("Novo Orgão");
        jMenuNovoOrgao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNovoOrgaoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuNovoOrgao);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //METODO REPONSAVEL POR COLETAR TODOS OS ITENS DA BASE DE DADOS E 
    //PREENCHER A TABELA
    public void preencherTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{
            "ID", "Nome", "Matricula", "Orgão", "Setor"
        };
        ChefiaDAO data = new DAOFactory().getChefia();
        dados = data.select();
        if (dados.isEmpty()) {

        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTableShowChefias.setModel(modelo);
        jTableShowChefias.getColumnModel().getColumn(0).setPreferredWidth(120);
        jTableShowChefias.getColumnModel().getColumn(0).setResizable(false);
        jTableShowChefias.getColumnModel().getColumn(1).setPreferredWidth(120);
        jTableShowChefias.getColumnModel().getColumn(1).setResizable(false);
        jTableShowChefias.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTableShowChefias.getColumnModel().getColumn(2).setResizable(false);
        jTableShowChefias.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTableShowChefias.getColumnModel().getColumn(3).setResizable(false);
        jTableShowChefias.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTableShowChefias.getColumnModel().getColumn(4).setResizable(false);

        jTableShowChefias.getTableHeader().setReorderingAllowed(false);
        jTableShowChefias.setAutoResizeMode(jTableShowChefias.AUTO_RESIZE_OFF);
        jTableShowChefias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    //METODO REPONSAVEL POR COLETAR TODOS OS ITENS DA BASE DE DADOS E 
    //PREENCHER A TABELA COM BASE NO NUMERO DE SERIE
    public void preencherTabelaByNumeroDeSerie(String numero_de_serie_do_equipamento) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{
            "ID", "Nome", "Matricula", "Orgão", "Setor"
        };
        ChefiaDAO data = new DAOFactory().getChefia();
        dados = data.select();
        if (dados.isEmpty()) {

        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTableShowChefias.setModel(modelo);
        jTableShowChefias.getColumnModel().getColumn(0).setPreferredWidth(120);
        jTableShowChefias.getColumnModel().getColumn(0).setResizable(false);
        jTableShowChefias.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTableShowChefias.getColumnModel().getColumn(1).setResizable(false);
        jTableShowChefias.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTableShowChefias.getColumnModel().getColumn(2).setResizable(false);
        jTableShowChefias.getColumnModel().getColumn(3).setPreferredWidth(220);
        jTableShowChefias.getColumnModel().getColumn(3).setResizable(false);
        jTableShowChefias.getColumnModel().getColumn(4).setPreferredWidth(220);
        jTableShowChefias.getColumnModel().getColumn(4).setResizable(false);

        jTableShowChefias.getTableHeader().setReorderingAllowed(false);
        jTableShowChefias.setAutoResizeMode(jTableShowChefias.AUTO_RESIZE_OFF);
        jTableShowChefias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    //EVENTO GERADO PELO BOTAO CANCELAR
    //EVENTO GERADO PELO BOTAO NOVO
    //EVENTO GERADO PELO BOTAO SALVAR
    //METODO RESPONSAVEL POR PREENCHER O COMBO-BOX UTILIZADO
    private void PreencherJTipoEquipamento() {
        try {
            Connection conecta = ConnectionFactory.getInstance().getConnection(); //INICIALIZA UM NOVA CONEXAO COM A BASE DE DADOS
            PreparedStatement SQL = conecta.prepareStatement("SELECT tipo FROM tipo_equipamentos;"); //CRIA UM PREPARED STATEMENT COM O SQL

            ResultSet result_set = SQL.executeQuery(); //EXECUTA O SQL GERADO PELO PREPARED STATEMENT

            while (result_set.next()) { //COLETA O ITEM SELECIONADO  E ATRIBUI AO COMBO-BOX
                String tipo = result_set.getString("tipo");
                jTipoEquipamento.addItem(tipo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nehum item encontrado em: tipo_equipamentos", "Erro 404 - NOT FOUND", JOptionPane.WARNING_MESSAGE);
        }
    }

    //EVENTO GERADO PELO BOTAO APAGAR
    //EVENTO GERADO PELO BOTAO SAIR
    private void jMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSairActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuSairActionPerformed

    //EVENTO GERADO PELO MENU NOVO ITEM DE EQUIPAMENTO
    private void jMenuNovoOrgaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNovoOrgaoActionPerformed
        new GUINovoEquipamento().setVisible(true);
    }//GEN-LAST:event_jMenuNovoOrgaoActionPerformed


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
            java.util.logging.Logger.getLogger(GUIEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIEquipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GUIChefia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAnterior;
    private javax.swing.JButton btApagar;
    private javax.swing.JButton btAtualizarComboBox;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btNovoOrgao;
    private javax.swing.JButton btPrimeiro;
    private javax.swing.JButton btProximo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btUltimo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuNovoOrgao;
    private javax.swing.JMenuItem jMenuSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableShowChefias;
    private javax.swing.JComboBox jTipoEquipamento;
    private javax.swing.JTextField jtBuscarMatricula;
    private javax.swing.JTextField jtID;
    private javax.swing.JTextField jtMatricula;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtSetor;
    private javax.swing.JLabel lbMatricula;
    // End of variables declaration//GEN-END:variables
}

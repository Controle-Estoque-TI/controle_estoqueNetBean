/**
 * ESTA GUI ESTÁ RESPONSÁVEL POR MANTER E EXIBIR OS EQUIPAMENTOS ENCONTRADOS NO
 * ESTOQUE DO SUPORTE DE TI
 *
 */
package br.smagp.controle.estoque_ti.gui;

//IMPORTES OBRIGATÓRIOS PARA REALIZAR AS TAREFAS CONTIDAS NESTE FORMULÁRIO
import br.smagp.controle.estoque_ti.objects.ModeloTabela;
import br.smagp.controle.estoque_ti.dao.DAOFactory;
import br.smagp.controle.estoque_ti.dao.EquipamentoDAO;
import br.smagp.controle.estoque_ti.db.ConnectionFactory;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

import br.smagp.controle.estoque_ti.gui.GUIMenu;
import br.smagp.controle.estoque_ti.model.Equipamento;
import br.smagp.controle.estoque_ti.objects.Input_FieldController;
import br.smagp.controle.estoque_ti.objects.JTextFieldOnlyNumbers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author AllexOnRails
 */
public class GUITecnico extends javax.swing.JFrame {

    //atributoss necessários para relizar qualquer operação 
    //-> statement -result_set - SQL - conecta
    private static ResultSet result_set;
    private PreparedStatement SQL;
    private String result;
    Connection conecta = ConnectionFactory.getInstance().getConnection();
    MaskFormatter Mphone = new MaskFormatter();
    
    /**
     * INICIALIZA O FORMULARIO
     */
    public GUITecnico() {
        this.initComponents();
        this.setResizable(false);
        this.setLocation(250, 100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.preencherTabela();
        try{
            Mphone.setMask("##-#####-####");
            Mphone.setPlaceholder("_");
        }catch(ParseException ex){} 
    }

    //COMPONENTES INICIALIZADOS PELO NET-BEANS
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtBuscarNumeroDeSerie = new JTextFieldOnlyNumbers(20);
        btBuscar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jProgressBar1 = new javax.swing.JProgressBar();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jtMatricula = new JTextFieldOnlyNumbers(20);
        jLabel4 = new javax.swing.JLabel();
        jtNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btApagar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jtID = new javax.swing.JTextField();
        btPrimeiro = new javax.swing.JButton();
        btUltimo = new javax.swing.JButton();
        btAnterior = new javax.swing.JButton();
        btProximo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableFindTecnico = new javax.swing.JTable();
        jtSetor = new javax.swing.JTextField();
        jTCelular = new JFormattedTextField(Mphone);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Matricula:");

        jtBuscarNumeroDeSerie.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtBuscarNumeroDeSerie.setHighlighter(null);
        jtBuscarNumeroDeSerie.setSelectionColor(new java.awt.Color(204, 204, 204));

        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-buscar.png"))); // NOI18N
        btBuscar.setText("Buscar");

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
        jLabel3.setText("Matricula: ");

        jtMatricula.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nome:");

        jtNome.setEnabled(false);
        jtNome.setDocument(new Input_FieldController(20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Setor:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Celular: ");

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-cadastrar.png"))); // NOI18N
        btNovo.setText("Novo");

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-cadastrar.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setEnabled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/Reset.png"))); // NOI18N
        btApagar.setText("Apagar");
        btApagar.setEnabled(false);
        btApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btApagarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("ID:");

        jtID.setEnabled(false);

        btPrimeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/First.png"))); // NOI18N

        btUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/Last.png"))); // NOI18N

        btAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/Previous.png"))); // NOI18N

        btProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/Next.png"))); // NOI18N

        jtableFindTecnico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtableFindTecnico);

        jtSetor.setEnabled(false);
        jtSetor.setDocument(new Input_FieldController(128));

        jTCelular.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jtBuscarNumeroDeSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btBuscar)
                        .addGap(6, 6, 6)
                        .addComponent(btNovo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(jLabel5)
                        .addGap(202, 202, 202)
                        .addComponent(jLabel6))
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
                        .addComponent(btCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(474, 474, 474)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTCelular))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1))
                    .addComponent(jtBuscarNumeroDeSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btPrimeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel8))
                    .addComponent(jtID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //METODO REPONSAVEL POR COLETAR TODOS OS ITENS DA BASE DE DADOS E 
    //PREENCHER A TABELA
    public void preencherTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{
            "ID", "Nome", "Matricula", "Setor", "Celular"
        };
        EquipamentoDAO data = new DAOFactory().getEquipamento();
        dados = data.select();
        if (dados.isEmpty()) {
            
            //INICIALIZANDO O CONTEUDO DOS CAMPOS DE TEXTO
            jtNome.setText("");
            jtMatricula.setText("");
            jtSetor.setText("");
            jTCelular.setText("");
            
            //HABLITANDO OS COMPONENTES
            btSalvar.setEnabled(true);
            btApagar.setEnabled(true);
            btCancelar.setEnabled(true);
            jtNome.setEnabled(true);
            jtMatricula.setEnabled(true);
            jtSetor.setEnabled(true);
            jTCelular.setEnabled(true);
            
            //DESABILITANDO OS COMPONENTES
            jtBuscarNumeroDeSerie.setEnabled(false);
            btNovo.setEnabled(false);
            btBuscar.setEnabled(false);
            btExcluir.setEnabled(false);
            btEditar.setEnabled(false);
            btExcluir.setEnabled(false);
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jtableFindTecnico.setModel(modelo);
        jtableFindTecnico.getColumnModel().getColumn(0).setPreferredWidth(120);
        jtableFindTecnico.getColumnModel().getColumn(0).setResizable(false);
        jtableFindTecnico.getColumnModel().getColumn(1).setPreferredWidth(120);
        jtableFindTecnico.getColumnModel().getColumn(1).setResizable(false);
        jtableFindTecnico.getColumnModel().getColumn(2).setPreferredWidth(120);
        jtableFindTecnico.getColumnModel().getColumn(2).setResizable(false);
        jtableFindTecnico.getColumnModel().getColumn(3).setPreferredWidth(120);
        jtableFindTecnico.getColumnModel().getColumn(3).setResizable(false);
        jtableFindTecnico.getColumnModel().getColumn(4).setPreferredWidth(120);
        jtableFindTecnico.getColumnModel().getColumn(4).setResizable(false);
        
        jtableFindTecnico.getTableHeader().setReorderingAllowed(false);
        jtableFindTecnico.setAutoResizeMode(jtableFindTecnico.AUTO_RESIZE_OFF);
        jtableFindTecnico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    //METODO REPONSAVEL POR COLETAR TODOS OS ITENS DA BASE DE DADOS E 
    //PREENCHER A TABELA COM BASE NO NUMERO DE SERIE
    public void preencherTabelaByNumeroDeSerie(String numero_de_serie_do_equipamento) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{
            "ID", "Nome", "Matricula", "Setor", "Celular"
        };
        EquipamentoDAO data = new DAOFactory().getEquipamento();
        dados = data.selectByNumeroDeSerie(numero_de_serie_do_equipamento);
        if (dados.isEmpty()) {
            btNovo.setEnabled(false);
            btBuscar.setEnabled(true);

            jtNome.setText("");
            jtMatricula.setText("");
            jtSetor.setText("");
            jTCelular.setText("");
            

            jtBuscarNumeroDeSerie.setEnabled(false);
            jtNome.setEnabled(true);
            jtMatricula.setEnabled(true);
            jTCelular.setEnabled(true);
            jtSetor.setEnabled(true);
            
            btSalvar.setEnabled(true);
            btApagar.setEnabled(true);
            btCancelar.setEnabled(true);
            btExcluir.setEnabled(false);
            btEditar.setEnabled(false);
            btExcluir.setEnabled(false);
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jtableFindTecnico.setModel(modelo);
        jtableFindTecnico.getColumnModel().getColumn(0).setPreferredWidth(120);
        jtableFindTecnico.getColumnModel().getColumn(0).setResizable(false);
        jtableFindTecnico.getColumnModel().getColumn(1).setPreferredWidth(120);
        jtableFindTecnico.getColumnModel().getColumn(1).setResizable(false);
        jtableFindTecnico.getColumnModel().getColumn(2).setPreferredWidth(120);
        jtableFindTecnico.getColumnModel().getColumn(2).setResizable(false);
        jtableFindTecnico.getColumnModel().getColumn(3).setPreferredWidth(120);
        jtableFindTecnico.getColumnModel().getColumn(3).setResizable(false);
        jtableFindTecnico.getColumnModel().getColumn(4).setPreferredWidth(120);
        jtableFindTecnico.getColumnModel().getColumn(4).setResizable(false);

        jtableFindTecnico.getTableHeader().setReorderingAllowed(false);
        jtableFindTecnico.setAutoResizeMode(jtableFindTecnico.AUTO_RESIZE_OFF);
        jtableFindTecnico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    //EVENTO GERADO PELO BOTAO APAGAR
    private void btApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btApagarActionPerformed
        jtID.setText("");
        jtNome.setText("");
        jtMatricula.setText("");
        jTCelular.setText("");
        jtSetor.setText("_");
    }//GEN-LAST:event_btApagarActionPerformed

    //EVENTO GERADO PELO BOTAO SAIR
    private void jMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSairActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuSairActionPerformed

    //EVENTO GERADO PELO BOTAO SALVAR
    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        
    }//GEN-LAST:event_btSalvarActionPerformed


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
                new GUITecnico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAnterior;
    private javax.swing.JButton btApagar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPrimeiro;
    private javax.swing.JButton btProximo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btUltimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JFormattedTextField jTCelular;
    private javax.swing.JTextField jtBuscarNumeroDeSerie;
    private javax.swing.JTextField jtID;
    private javax.swing.JTextField jtMatricula;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtSetor;
    private javax.swing.JTable jtableFindTecnico;
    // End of variables declaration//GEN-END:variables
}

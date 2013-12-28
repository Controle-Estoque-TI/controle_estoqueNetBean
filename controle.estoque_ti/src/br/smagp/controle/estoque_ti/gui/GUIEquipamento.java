/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.smagp.controle.estoque_ti.gui;

import br.smagp.controle.estoque_ti.dao.DAOFactory;
import br.smagp.controle.estoque_ti.dao.EquipamentoDAO;
import br.smagp.controle.estoque_ti.db.ConnectionFactory;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

import br.smagp.controle.estoque_ti.gui.GUIMenu;
import br.smagp.controle.estoque_ti.model.Equipamento;
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
public class GUIEquipamento extends javax.swing.JFrame {


    GUIMenu menu_return= null;
    boolean instance_menu;
    /**
     * Creates new form GUIEquipamento
     */
    public GUIEquipamento( boolean status) {
        this.initComponents();
        this.setResizable(false);
        this.setLocation(250, 100);
        this.setLocationRelativeTo(null);
        this.PreencherJTipoEquipamento();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.instance_menu = status;
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
        jtBuscar = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableFindEquipamento = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jProgressBar1 = new javax.swing.JProgressBar();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jtEquipamento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtNumeroSerie = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtMarca = new javax.swing.JTextField();
        jtPatrimonio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTipoEquipamento = new javax.swing.JComboBox();
        btApagar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuListarTodosOsEquipamentos = new javax.swing.JMenuItem();
        jMenuNovoItemDeEquipamento = new javax.swing.JMenuItem();
        jMenuExcluirEquipamento = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Número de Série:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, -1, -1));

        jtBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtBuscar.setHighlighter(null);
        jtBuscar.setSelectionColor(new java.awt.Color(204, 204, 204));
        jPanel1.add(jtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 24, 374, 34));

        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-buscar.png"))); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 24, -1, 34));

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-excluir.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setEnabled(false);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 510, -1, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Resultado da Busca:");

        jtableFindEquipamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtableFindEquipamento);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 702, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 722, 10));
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 580, 205, 27));

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-excluir.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 510, 90, 40));

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-editar.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.setEnabled(false);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 510, 80, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Equipamento: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 700, 10));

        jtEquipamento.setEnabled(false);
        jPanel1.add(jtEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 380, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Número de série: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jtNumeroSerie.setEnabled(false);
        jPanel1.add(jtNumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 380, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Marca: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        jtMarca.setEnabled(false);
        jPanel1.add(jtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 380, 30));

        jtPatrimonio.setEnabled(false);
        jPanel1.add(jtPatrimonio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 380, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Patrimônio: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, -1, -1));

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-cadastrar.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 24, -1, 34));

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-cadastrar.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setEnabled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, -1, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Tipo: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, -1, -1));

        jTipoEquipamento.setEnabled(false);
        jPanel1.add(jTipoEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 380, 30));

        btApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-editar.png"))); // NOI18N
        btApagar.setText("Apagar");
        btApagar.setEnabled(false);
        btApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btApagarActionPerformed(evt);
            }
        });
        jPanel1.add(btApagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, -1, 40));

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

        jMenuListarTodosOsEquipamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone_lapis.png"))); // NOI18N
        jMenuListarTodosOsEquipamentos.setText("Listar Equipamentos");
        jMenu2.add(jMenuListarTodosOsEquipamentos);

        jMenuNovoItemDeEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-cadastrar.png"))); // NOI18N
        jMenuNovoItemDeEquipamento.setText("Novo tipo de equipamento");
        jMenuNovoItemDeEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNovoItemDeEquipamentoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuNovoItemDeEquipamento);

        jMenuExcluirEquipamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-excluir.png"))); // NOI18N
        jMenuExcluirEquipamento.setText("Excluir Equipamento");
        jMenu2.add(jMenuExcluirEquipamento);

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

    
    
    public void preencherTabela(String numero_de_serie_do_equipamento){
        ArrayList dados = new ArrayList();
        String [] Colunas= new String[]{
          "ID", "Número de Série", "Nome", "Tipo", "Marca", "Patrimônio"
        };
        EquipamentoDAO data= new EquipamentoDAO();
        dados = data.selectByNumeroDeSerie(numero_de_serie_do_equipamento);
        ModeloTabela modelo= new ModeloTabela(dados, Colunas);
        jtableFindEquipamento.setModel(modelo);
        jtableFindEquipamento.getColumnModel().getColumn(0).setPreferredWidth(120);
        jtableFindEquipamento.getColumnModel().getColumn(0).setResizable(false);
        jtableFindEquipamento.getColumnModel().getColumn(1).setPreferredWidth(120);
        jtableFindEquipamento.getColumnModel().getColumn(1).setResizable(false);
        jtableFindEquipamento.getColumnModel().getColumn(2).setPreferredWidth(120);
        jtableFindEquipamento.getColumnModel().getColumn(2).setResizable(false);
        jtableFindEquipamento.getColumnModel().getColumn(3).setPreferredWidth(120);
        jtableFindEquipamento.getColumnModel().getColumn(3).setResizable(false);
        jtableFindEquipamento.getColumnModel().getColumn(4).setPreferredWidth(120);
        jtableFindEquipamento.getColumnModel().getColumn(4).setResizable(false);
        jtableFindEquipamento.getColumnModel().getColumn(5).setPreferredWidth(120);
        jtableFindEquipamento.getColumnModel().getColumn(5).setResizable(false);
        
        jtableFindEquipamento.getTableHeader().setReorderingAllowed(false);
        jtableFindEquipamento.setAutoResizeMode(jtableFindEquipamento.AUTO_RESIZE_OFF);
        jtableFindEquipamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        jtNumeroSerie.setEnabled(false);
        jtEquipamento.setEnabled(false);
        jtMarca.setEnabled(false);
        jtPatrimonio.setEnabled(false);
        jTipoEquipamento.setEnabled(false);
        btSalvar.setEnabled(false);
        btCancelar.setEnabled(false);
        btNovo.setEnabled(true);
        
        if (jtBuscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o número de série que deseja buscar.");
        }
        else{ preencherTabela(jtBuscar.getText()); }    
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        jtNumeroSerie.setEnabled(false);
        jtEquipamento.setEnabled(false);
        jtMarca.setEnabled(false);
        jtPatrimonio.setEnabled(false);
        jTipoEquipamento.setEnabled(false);
        btSalvar.setEnabled(false);
        btCancelar.setEnabled(false);
        btApagar.setEnabled(false);
        btNovo.setEnabled(true);
        btBuscar.setEnabled(true);
        
        jtBuscar.setEnabled(true);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEditarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        /**
         * Aqui se encontra o start do formulário de cadastro
         */
        jtNumeroSerie.setEnabled(true);
        jtEquipamento.setEnabled(true);
        jtMarca.setEnabled(true);
        jtPatrimonio.setEnabled(true);
        jTipoEquipamento.setEnabled(true);
        
        jtNumeroSerie.setText("");
        jtEquipamento.setText("");
        jtMarca.setText("_TM");
        jtPatrimonio.setText("");
        
        btNovo.setEnabled(false);
        btSalvar.setEnabled(true);
        btApagar.setEnabled(true);
        btCancelar.setEnabled(true);
        btBuscar.setEnabled(false);
        
        jtBuscar.setEnabled(false);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // Esta Action [PROCEDIMENTO] é responsável por salvar os equipametos na base de dados.
        Equipamento equipamento = new Equipamento();
        equipamento.setN_serie_equipamento(jtNumeroSerie.getText());
        equipamento.setEquipamento(jtEquipamento.getText());
        equipamento.setMarca_equipamento(jtMarca.getText());
        equipamento.setTipo_equipamento(jTipoEquipamento.getSelectedItem().toString());
        equipamento.setPatrimonio(jtPatrimonio.getText());
        
        EquipamentoDAO dao = new DAOFactory().getEquipamento(); //Fazer isto na hora de instanciar na interface
        try {
            dao.insert(equipamento);
            System.out.println(dao.selectByNumeroDeSerie(equipamento.getN_serie_equipamento()));
            JOptionPane.showMessageDialog(null, "Equipamento registrado.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO: "+ex, "ERRO 504", JOptionPane.ERROR_MESSAGE);
        }
        
        /**
         * Logo abaixo todos os campos e botões do formulario
         * são desabilitados devido a inserção com sucesso dos
         * dados na base de dados.
         */
        
        jtNumeroSerie.setEnabled(false);
        jtEquipamento.setEnabled(false);
        jtMarca.setEnabled(false);
        jtPatrimonio.setEnabled(false);
        jTipoEquipamento.setEnabled(false);
        btSalvar.setEnabled(false);
        btCancelar.setEnabled(false);
        btApagar.setEnabled(false);
        btNovo.setEnabled(true);
        
        jtNumeroSerie.setText("");
        jtEquipamento.setText("");
        jtMarca.setText("_TM");
        jtPatrimonio.setText("");
        
        btBuscar.setEnabled(true);
        jtBuscar.setEnabled(true);
    }//GEN-LAST:event_btSalvarActionPerformed

    
    private void VerificaCampoDeTexto(){
        if(jtNumeroSerie.getText().length() > 0){
            btApagar.setEnabled(true);
        } else {
            btApagar.setEnabled(false);
        }
    }
    
    private void PreencherJTipoEquipamento(){
        try {
            Connection conecta= ConnectionFactory.getInstance().getConnection();
            String sql= "SELECT tipo FROM tipo_equipamentos;";
            PreparedStatement SQL = conecta.prepareStatement(sql);
            
            ResultSet result_set = SQL.executeQuery();
            
            while(result_set.next()){
                String tipo= result_set.getString("tipo");
                jTipoEquipamento.addItem(tipo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: "+e, "Erro" ,JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void btApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btApagarActionPerformed
        jtNumeroSerie.setText("");
        jtEquipamento.setText("");
        jtMarca.setText("_TM");
        jtPatrimonio.setText("");
    }//GEN-LAST:event_btApagarActionPerformed

    private void jMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSairActionPerformed
        dispose();
        ViewStatus viewport= new ViewStatus();
        viewport.setSTATUS(false);
        this.instance_menu = viewport.getSTATUS();
        new GUIMenu(this.instance_menu).guiEquipamento.setVisible(false);
    }//GEN-LAST:event_jMenuSairActionPerformed

    private void jMenuNovoItemDeEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNovoItemDeEquipamentoActionPerformed
        new GUINovoEquipamento().setVisible(true);
    }//GEN-LAST:event_jMenuNovoItemDeEquipamentoActionPerformed

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
            public boolean status = false;
            public void run() {
                new GUIEquipamento(status).setVisible(true);
            }
        });
    }
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btApagar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuExcluirEquipamento;
    private javax.swing.JMenuItem jMenuListarTodosOsEquipamentos;
    private javax.swing.JMenuItem jMenuNovoItemDeEquipamento;
    private javax.swing.JMenuItem jMenuSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox jTipoEquipamento;
    private javax.swing.JTextField jtBuscar;
    private javax.swing.JTextField jtEquipamento;
    private javax.swing.JTextField jtMarca;
    private javax.swing.JTextField jtNumeroSerie;
    private javax.swing.JTextField jtPatrimonio;
    private javax.swing.JTable jtableFindEquipamento;
    // End of variables declaration//GEN-END:variables
}

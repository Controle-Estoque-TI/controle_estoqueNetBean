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
import javax.swing.JOptionPane;

/**
 *
 * @author AllexOnRails
 */
public class GUIEquipamento extends javax.swing.JFrame {

    GUIMenu menu;
    /**
     * Creates new form GUIEquipamento
     */
    public GUIEquipamento() {
        this.initComponents();
        this.setResizable(false);
        this.setLocation(250, 100);
        this.setLocationRelativeTo(null);
        this.PreencherJTipoEquipamento();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        jTextField1 = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jProgressBar1 = new javax.swing.JProgressBar();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        textEquipamento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textNumeroSerie = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textMarca = new javax.swing.JTextField();
        textPatrimonio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTipoEquipamento = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Número de Série:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, -1, -1));

        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextField1.setHighlighter(null);
        jTextField1.setSelectionColor(new java.awt.Color(204, 204, 204));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 24, 374, 34));

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
        jPanel1.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, -1, 34));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "id", "n_serie", "Equipamento", "Marca", "Patrimônio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCellSelectionEnabled(true);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 255));
        jTable1.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("id");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("n_serie");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Equipamento");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Marca");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Patrimônio");
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Resultado da Busca:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 702, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 722, 10));
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 580, 205, 27));

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-excluir.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 100, 40));

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-editar.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.setEnabled(false);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Equipamento: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 700, 10));

        textEquipamento.setEnabled(false);
        jPanel1.add(textEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 370, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Número de série: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        textNumeroSerie.setEnabled(false);
        jPanel1.add(textNumeroSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 370, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Marca: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        textMarca.setEnabled(false);
        jPanel1.add(textMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 370, 30));

        textPatrimonio.setEnabled(false);
        jPanel1.add(textPatrimonio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 370, 30));

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
        jPanel1.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, -1, 34));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Tipo: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, -1, -1));

        jTipoEquipamento.setEnabled(false);
        jTipoEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTipoEquipamentoActionPerformed(evt);
            }
        });
        jPanel1.add(jTipoEquipamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 370, 30));

        jMenu1.setText("Arquivo");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-sair.png"))); // NOI18N
        jMenuItem4.setText("Sair");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone_lapis.png"))); // NOI18N
        jMenuItem1.setText("Listar Equipamentos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-editar.png"))); // NOI18N
        jMenuItem2.setText("Editar Equipamento");
        jMenu2.add(jMenuItem2);

        jMenuItem5.setText("Novo tipo de equipamento");
        jMenu2.add(jMenuItem5);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-excluir.png"))); // NOI18N
        jMenuItem3.setText("Excluir Equipamento");
        jMenu2.add(jMenuItem3);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        textNumeroSerie.setEnabled(false);
        textEquipamento.setEnabled(false);
        textMarca.setEnabled(false);
        textPatrimonio.setEnabled(false);
        jTipoEquipamento.setEnabled(false);
        btSalvar.setEnabled(false);
        btCancelar.setEnabled(false);
        btNovo.setEnabled(true);
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
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
        textNumeroSerie.setEnabled(true);
        textEquipamento.setEnabled(true);
        textMarca.setEnabled(true);
        textPatrimonio.setEnabled(true);
        jTipoEquipamento.setEnabled(true);
        btSalvar.setEnabled(true);
        btCancelar.setEnabled(true);

        textNumeroSerie.setText("");
        textEquipamento.setText("");
        textMarca.setText("_TM");
        textPatrimonio.setText("");
        
        btNovo.setEnabled(false);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // Esta Action [PROCEDIMENTO] é responsável por salvar os equipametos na base de dados.
        Equipamento equipamento = new Equipamento();
        equipamento.setNumero_Serie_Equipamento(textNumeroSerie.getText());
        equipamento.setEquipamento(textEquipamento.getText());
        equipamento.setMarca_Equipamento(textMarca.getText());
        equipamento.setTipo_Equipamento(jTipoEquipamento.getSelectedItem().toString());
        equipamento.setPatrimonio(textPatrimonio.getText());
        
        EquipamentoDAO dao = new DAOFactory().getEquipamento(); //Fazer isto na hora de instanciar na interface
        try {
            dao.insert(equipamento);
            System.out.println(dao.findByNumeroDeSerie(equipamento.getNumero_Serie_Equipamento()));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    
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
    
    
    
    private void jTipoEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTipoEquipamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTipoEquipamentoActionPerformed

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
                new GUIEquipamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox jTipoEquipamento;
    private javax.swing.JTextField textEquipamento;
    private javax.swing.JTextField textMarca;
    private javax.swing.JTextField textNumeroSerie;
    private javax.swing.JTextField textPatrimonio;
    // End of variables declaration//GEN-END:variables
}
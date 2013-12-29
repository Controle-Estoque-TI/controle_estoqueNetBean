package br.smagp.controle.estoque_ti.gui;

import br.smagp.controle.estoque_ti.dao.EquipamentoDAO;
import br.smagp.controle.estoque_ti.dao.TipoEquipamentoDAO;
import br.smagp.controle.estoque_ti.db.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author AllexOnRails
 */
public class ListEquipamentos extends javax.swing.JFrame {

    public ListEquipamentos() {
        initComponents();
        this.setLocation(250, 100);
        this.setLocationRelativeTo(null);
        this.preencherTabela();
        this.PreencherJTipoEquipamento();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelListEquipamento = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtTipoEquipamento = new javax.swing.JComboBox();
        btBuscar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        jPanelTabelaDeResultados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResultado = new javax.swing.JTable();
        btReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanelListEquipamento.setBackground(new java.awt.Color(255, 255, 255));
        jPanelListEquipamento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Tipo de Equipamento:");

        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-buscar.png"))); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/back.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        jPanelTabelaDeResultados.setBackground(new java.awt.Color(204, 204, 204));
        jPanelTabelaDeResultados.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableResultado.setCellSelectionEnabled(true);
        jTableResultado.setSelectionBackground(new java.awt.Color(204, 204, 255));
        jScrollPane1.setViewportView(jTableResultado);

        javax.swing.GroupLayout jPanelTabelaDeResultadosLayout = new javax.swing.GroupLayout(jPanelTabelaDeResultados);
        jPanelTabelaDeResultados.setLayout(jPanelTabelaDeResultadosLayout);
        jPanelTabelaDeResultadosLayout.setHorizontalGroup(
            jPanelTabelaDeResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabelaDeResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanelTabelaDeResultadosLayout.setVerticalGroup(
            jPanelTabelaDeResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTabelaDeResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
        );

        btReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/smagp/controle/estoque_ti/resources/icone-editar.png"))); // NOI18N
        btReset.setText("Resetar");
        btReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelListEquipamentoLayout = new javax.swing.GroupLayout(jPanelListEquipamento);
        jPanelListEquipamento.setLayout(jPanelListEquipamentoLayout);
        jPanelListEquipamentoLayout.setHorizontalGroup(
            jPanelListEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListEquipamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelListEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTabelaDeResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelListEquipamentoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtTipoEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btReset, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelListEquipamentoLayout.setVerticalGroup(
            jPanelListEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListEquipamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelListEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtTipoEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btReset, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanelTabelaDeResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelListEquipamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelListEquipamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //EVENTO GERADO PELO BOTAO VOLTAR
    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    //EVENTO GERADO PELO BOTAO BUSCAR
    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        this.preencherTabelaByTipo(jtTipoEquipamento.getSelectedItem().toString()); //PREENCHE A TABELA COM O ELEMENTO RETORNADO 
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetActionPerformed
       this.preencherTabela();
    }//GEN-LAST:event_btResetActionPerformed

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
            java.util.logging.Logger.getLogger(ListEquipamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListEquipamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListEquipamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListEquipamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListEquipamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btReset;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelListEquipamento;
    private javax.swing.JPanel jPanelTabelaDeResultados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResultado;
    private javax.swing.JComboBox jtTipoEquipamento;
    // End of variables declaration//GEN-END:variables

    //METODO RESPONSAVEL POR PREENCHER O COMBO-BOX UTILIZADO
    private void PreencherJTipoEquipamento() {
        try {
            Connection conecta = ConnectionFactory.getInstance().getConnection(); //INICIALIZA UM NOVA CONEXAO COM A BASE DE DADOS
            PreparedStatement SQL = conecta.prepareStatement("SELECT tipo FROM tipo_equipamentos;"); //CRIA UM PREPARED STATEMENT COM O SQL

            ResultSet result_set = SQL.executeQuery(); //EXECUTA O SQL GERADO PELO PREPARED STATEMENT

            while (result_set.next()) { //COLETA O ITEM SELECIONADO  E ATRIBUI AO COMBO-BOX
                String tipo = result_set.getString("tipo");
                jtTipoEquipamento.addItem(tipo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nehum item encontrado em: tipo_equipamentos", "Erro 404 - NOT FOUND", JOptionPane.WARNING_MESSAGE);
        }
    }

    //METODO REPONSAVEL POR COLETAR TODOS OS ITENS DA BASE DE DADOS E PREENCHER A TABELA
    public void preencherTabela() {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{
            "ID", "Número de Série", "Descrição", "Tipo", "Marca", "Patrimônio"
        };
        EquipamentoDAO data = new EquipamentoDAO();
        dados = data.select();
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        jTableResultado.setModel(modelo);
        jTableResultado.getColumnModel().getColumn(0).setPreferredWidth(120);
        jTableResultado.getColumnModel().getColumn(0).setResizable(false);
        jTableResultado.getColumnModel().getColumn(1).setPreferredWidth(120);
        jTableResultado.getColumnModel().getColumn(1).setResizable(false);
        jTableResultado.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTableResultado.getColumnModel().getColumn(2).setResizable(false);
        jTableResultado.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTableResultado.getColumnModel().getColumn(3).setResizable(false);
        jTableResultado.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTableResultado.getColumnModel().getColumn(4).setResizable(false);
        jTableResultado.getColumnModel().getColumn(5).setPreferredWidth(120);
        jTableResultado.getColumnModel().getColumn(5).setResizable(false);

        jTableResultado.getTableHeader().setReorderingAllowed(false);
        jTableResultado.setAutoResizeMode(jTableResultado.AUTO_RESIZE_OFF);
        jTableResultado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    //METODO REPONSAVEL POR COLETAR TODOS OS ITENS DA BASE DE DADOS E PREENCHER A TABELA
    private void preencherTabelaByTipo(String tipo) {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{
            "ID", "Número de Série", "Descrição", "Tipo", "Marca", "Patrimônio"
        };
        EquipamentoDAO data = new EquipamentoDAO();
        dados = data.selectByType(tipo);

        if (dados.isEmpty()) {
            preencherTabela();
        } else {

            ModeloTabela modelo = new ModeloTabela(dados, Colunas);
            jTableResultado.setModel(modelo);
            jTableResultado.getColumnModel().getColumn(0).setPreferredWidth(120);
            jTableResultado.getColumnModel().getColumn(0).setResizable(false);
            jTableResultado.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTableResultado.getColumnModel().getColumn(1).setResizable(false);
            jTableResultado.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTableResultado.getColumnModel().getColumn(2).setResizable(false);
            jTableResultado.getColumnModel().getColumn(3).setPreferredWidth(120);
            jTableResultado.getColumnModel().getColumn(3).setResizable(false);
            jTableResultado.getColumnModel().getColumn(4).setPreferredWidth(120);
            jTableResultado.getColumnModel().getColumn(4).setResizable(false);
            jTableResultado.getColumnModel().getColumn(5).setPreferredWidth(120);
            jTableResultado.getColumnModel().getColumn(5).setResizable(false);

            jTableResultado.getTableHeader().setReorderingAllowed(true);
            jTableResultado.setAutoResizeMode(jTableResultado.AUTO_RESIZE_OFF);
            jTableResultado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }
}

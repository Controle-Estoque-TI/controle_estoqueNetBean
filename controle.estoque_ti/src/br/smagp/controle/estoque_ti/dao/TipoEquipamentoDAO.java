/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.smagp.controle.estoque_ti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import br.smagp.controle.estoque_ti.db.*;
import br.smagp.controle.estoque_ti.interfaces.CRUD;
import br.smagp.controle.estoque_ti.model.Equipamento;
import br.smagp.controle.estoque_ti.model.TipoEquipamento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AllexOnRails
 */
public class TipoEquipamentoDAO implements CRUD {

    /**
     *
     */
    private static Statement statement;
    private static ResultSet result_set;
    private PreparedStatement SQL;
    private TipoEquipamento equipamento;

    /**
     * TUDO QUE POSSUIR #{
     *
     * @Override} Herda da Super classe neste caso #{
     * @SQLSyntax}
     */
    @Override
    public int create(Object object) throws SQLException {
        Connection conecta = ConnectionFactory.getInstance().getConnection();
        this.equipamento = (TipoEquipamento) object;
        SQL = conecta.prepareStatement("INSERT INTO tipo_equipamentos" + "(tipo)" + "VALUES (?);");

        SQL.setString(1, this.equipamento.getTipo_equipamento());

        int updated = SQL.executeUpdate();
        System.out.println("Padrao de retorno: " + updated + "\nTabela atualizada com um novo equipamento.");
        conecta.close();
        JOptionPane.showMessageDialog(null, "Novo tipo de equipamento registrado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        return updated;
    }

    /*
     * (non-Javadoc)
     * @see br.smagp.suporteTI.controleEstoque.database.SQLSyntax#delete(int)
     */
    @Override
    public void delete(String tipo) throws SQLException {
        Connection conecta = ConnectionFactory.getInstance().getConnection();
        try {
            SQL = conecta.prepareStatement("DELETE FROM tipo_equipamentos WHERE tipo = ?");
            SQL.setString(1, tipo);
            SQL.execute();
            SQL.close();
            System.out.println("Nº: " + tipo + " removido!");
            JOptionPane.showMessageDialog(null, "Nº: " + tipo + " removido da tabela!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Foi encontrado um erro na remoção" + JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @Override
    public int update(Object object) throws SQLException {
        this.equipamento = (TipoEquipamento) object;
        Connection conecta = ConnectionFactory.getInstance().getConnection(); //INICIA UMA NOVA CONEXAO COM A BASE DE DADOS
        SQL = conecta.prepareStatement("UPDATE tipo_equipamentos SET tipo=? WHERE id=?;"); //INICIA UM PREPARE STATEMENT COM O CODIGO SQL
        SQL.setString(1, this.equipamento.getTipo_equipamento());//NESTE PONTO COLETAMOS O CONTEUDO DO CAMPO DE TEXTO E ATRIBUIMOS O MESMO AO PREPARED STATEMENT
        SQL.setInt(2, this.equipamento.getId());
        int updated = SQL.executeUpdate(); //NESTE MOMENTO EXECUTAMOS A QUERY UPDATE
        JOptionPane.showMessageDialog(null, "Item " + this.equipamento.getId() + " atualizado com sucesso. ", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        return updated;
    }

    public void deleteFromType(String type) throws SQLException {
        Connection conecta = ConnectionFactory.getInstance().getConnection();
        try {
            SQL = conecta.prepareStatement("DELETE FROM tipo_equipamentos WHERE tipo=?");
            SQL.setString(1, type);
            SQL.execute();
            SQL.close();
            JOptionPane.showMessageDialog(null, "Item " + type + " Removido. ", "Sucesso", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Foi encontrado um erro na remoção" + JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public ArrayList selectByType(String type) {
        ArrayList dados = new ArrayList();
        ConnectionFactory con = new ConnectionFactory();
        try {
            con.conexao();
            con.executaSQL("SELECT id, tipo FROM tipo_equipamentos WHERE tipo='" + type + "';");
            con.result_set.first();
            do {
                dados.add(new Object[]{
                    con.result_set.getInt("id"),
                    con.result_set.getString("tipo")
                });
            } while (con.result_set.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum item encontrado.\nCadastre um novo tipo para preencher a tabela", "ERRO 404 - Not Found", JOptionPane.ERROR_MESSAGE);
        }
        return dados;
    }

    @Override
    public ArrayList select() {
        ArrayList dados = new ArrayList();
        ConnectionFactory con = new ConnectionFactory();
        try {
            con.conexao();
            con.executaSQL("SELECT id, tipo FROM tipo_equipamentos;");
            con.result_set.first();
            do {
                dados.add(new Object[]{
                    con.result_set.getInt("id"),
                    con.result_set.getString("tipo")
                });
            } while (con.result_set.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum item encontrado.\nCadastre um novo tipo para preencher a tabela", "ERRO 404 - Not Found", JOptionPane.ERROR_MESSAGE);
        }
        return dados;
    }
}

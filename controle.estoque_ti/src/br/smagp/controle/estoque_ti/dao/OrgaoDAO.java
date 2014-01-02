/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.smagp.controle.estoque_ti.dao;

import br.smagp.controle.estoque_ti.db.ConnectionFactory;
import br.smagp.controle.estoque_ti.interfaces.CRUD;
import br.smagp.controle.estoque_ti.model.Orgao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author AllexOnRails
 */
public class OrgaoDAO implements CRUD {

    private static Statement statement;
    private static ResultSet result_set;
    private PreparedStatement SQL;
    private Orgao orgao;

    /**
     * TUDO QUE POSSUIR #{
     *
     * @Override} Herda da Super classe neste caso #{
     * @SQLSyntax}
     */
    /*
     * (non-Javadoc)
     * @see br.smagp.suporteTI.controleEstoque.database.SQLSyntax#insert(java.lang.Object)
     */
    @Override
    public int create(Object object) throws SQLException {
        Connection conecta = ConnectionFactory.getInstance().getConnection();
        this.orgao = (Orgao) object;
        SQL = conecta.prepareStatement("INSERT INTO orgaos" + "(nome_orgao)" + "VALUES (?);");
        SQL.setString(1, this.orgao.getNome_orgao());
        int updated = SQL.executeUpdate();
        SQL.close();
        return updated;
    }

    @Override
    public int update(Object object) throws SQLException {
        Connection conecta= ConnectionFactory.getInstance().getConnection();
        this.orgao = (Orgao) object;
        String queryString = "UPDATE orgaos SET nome_orgao=? WHERE id=?";
        SQL = conecta.prepareStatement(queryString);
        SQL.setString(1, this.orgao.getNome_orgao());
        SQL.setInt(2, this.orgao.getId());
        int updated = SQL.executeUpdate();
        SQL.close();
        return updated;
    }

    @Override
    public void delete(String cod_object) throws SQLException {
        Connection conecta = new ConnectionFactory().getInstance().getConnection();
        try {
            SQL = conecta.prepareStatement("DELETE FROM orgaos WHERE id = '"+cod_object+"';");
            SQL.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Foi encontrado um erro na remoção" + JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList select(){
        ArrayList dados = new ArrayList();
        ConnectionFactory con= ConnectionFactory.getInstance();
        try {
            con.conexao();
            con.executaSQL("SELECT * FROM orgaos;");
            con.result_set.first();
            do {                
                dados.add(new Object[]{
                    con.result_set.getInt("id"), 
                    con.result_set.getString("nome_orgao")
                });
            } while (con.result_set.next());
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher a Tabela.\nNenhum orgão encontrado na base de dados.", "Erro 404 - Not Found", JOptionPane.ERROR_MESSAGE);
        }
        return dados; 
    }

    public ArrayList selectByName(String nome) {
        ArrayList dados = new ArrayList();
        ConnectionFactory con= ConnectionFactory.getInstance();
         try {
            con.conexao();
            con.executaSQL("SELECT id, nome_orgao FROM orgaos WHERE nome_orgao='"+nome+"';");
            con.result_set.first();
            do {                
                dados.add(new Object[]{
                    con.result_set.getInt("id"), 
                    con.result_set.getString("nome_orgao")
                });
            } while (con.result_set.next());
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher a Tabela.\nOrgão não encontrado.", "Erro 404 - Not Found", JOptionPane.ERROR_MESSAGE);
        }
        return dados; 
    }
}

/*
 * Classe DAO Equipamento table ou view
 * CRUD - Create, retrieve, update, delete
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
import java.util.ArrayList;
import java.util.List;


/**
 * @author AllexOnRails
 *
 */
public class EquipamentoDAO implements CRUD{
	
    /**
     * 
     */
    private static Statement statement;
    private static ResultSet result_set;
    private PreparedStatement SQL;
    private Equipamento equipamento;

    /**
     * TUDO QUE POSSUIR #{@Override}
     * Herda da Super classe neste 
     * caso #{@SQLSyntax}
     */
    
    @Override
    public int create(Object object) throws SQLException {
        Connection conecta= ConnectionFactory.getInstance().getConnection();
        this.equipamento = (Equipamento) object;
        SQL = conecta.prepareStatement("INSERT INTO equipamentos"+"(n_serie, descricao ,tipo, marca, patrimonio)"+"VALUES (?, ?, ?, ?, ?);");

        SQL.setString(1, this.equipamento.getN_serie_equipamento());
        SQL.setString(2, this.equipamento.getEquipamento());
        SQL.setString(3, this.equipamento.getTipo_equipamento());
        SQL.setString(4, this.equipamento.getMarca_equipamento());
        SQL.setString(5, this.equipamento.getPatrimonio());

        int updated = SQL.executeUpdate();
        System.out.println("Padrao de retorno: "+updated+"\nTabela atualizada com um novo equipamento.");
        SQL.close();
        return updated;
    }

    @Override
    public int update(Object object) throws SQLException {
        Connection conecta= ConnectionFactory.getInstance().getConnection();
        this.equipamento = (Equipamento) object;
        String queryString = "UPDATE equipamentos SET n_serie=?, descricao=?, tipo=?, marca=?, patrimonio=? WHERE id=?";
        SQL = conecta.prepareStatement(queryString);
        SQL.setString(1, this.equipamento.getN_serie_equipamento());
        SQL.setString(2, this.equipamento.getEquipamento());
        SQL.setString(3, this.equipamento.getTipo_equipamento());
        SQL.setString(4, this.equipamento.getMarca_equipamento());
        SQL.setString(5, this.equipamento.getPatrimonio());
        SQL.setInt(6, 	 this.equipamento.getId());
        System.out.println("Tabela Orgaos atualizada com sucesso por: "+this.equipamento);
        JOptionPane.showMessageDialog(null, "Equipamento atualizado!", "Sucesso" ,JOptionPane.INFORMATION_MESSAGE);
        int updated = SQL.executeUpdate();
        SQL.close();
        return updated;
    }

    @Override
    public void delete(String numero_de_serie) throws SQLException {
            Connection conecta= ConnectionFactory.getInstance().getConnection();
            try {
                SQL = conecta.prepareStatement("DELETE FROM equipamentos WHERE n_serie= " + numero_de_serie);
                SQL.executeUpdate();
                SQL.close();
                System.out.println("Equipamento: "+numero_de_serie+" removido!");
                JOptionPane.showMessageDialog(null, "Equipamento removido!", "Sucesso" ,JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Foi encontrado um erro na remoção"+JOptionPane.ERROR_MESSAGE);	
                e.printStackTrace();
            }
    }
    
    public ArrayList selectByNumeroDeSerie(String numero_de_serie_do_equipamento){
        ArrayList dados = new ArrayList();
        ConnectionFactory con= ConnectionFactory.getInstance();
        try {
            con.conexao();
            con.executaSQL("SELECT id, n_serie, descricao, tipo, marca, patrimonio FROM equipamentos WHERE n_serie='"+numero_de_serie_do_equipamento+"';");
            con.result_set.first();
            do {                
                dados.add(new Object[]{
                    con.result_set.getInt("id"), 
                    con.result_set.getString("n_serie"), 
                    con.result_set.getString("descricao"), 
                    con.result_set.getString("tipo"), 
                    con.result_set.getString("marca"), 
                    con.result_set.getString("patrimonio")
                });
            } while (con.result_set.next());
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher a Tabela.\nElemento não encontrado.", "Erro 404 - Not Found", JOptionPane.ERROR_MESSAGE);
        }
        return dados; 
    }
    
    @Override
    public ArrayList select(){
        ArrayList dados = new ArrayList();
        ConnectionFactory con= ConnectionFactory.getInstance();
        try {
            con.conexao();
            con.executaSQL("SELECT id, n_serie, descricao, tipo, marca, patrimonio FROM equipamentos;");
            con.result_set.first();
            do {                
                dados.add(new Object[]{
                    con.result_set.getInt("id"), 
                    con.result_set.getString("n_serie"), 
                    con.result_set.getString("descricao"), 
                    con.result_set.getString("tipo"), 
                    con.result_set.getString("marca"), 
                    con.result_set.getString("patrimonio")
                });
            } while (con.result_set.next());
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher a Tabela.\nNenhum equipamento encontrado na base de dados.", "Erro 404 - Not Found", JOptionPane.ERROR_MESSAGE);
        }
        return dados; 
    }
    
    public ArrayList selectByType(String type) {
        ArrayList dados = new ArrayList();
        ConnectionFactory con = new ConnectionFactory();
        try {
            con.conexao();
            con.executaSQL("SELECT id, n_serie, descricao, tipo, marca, patrimonio FROM equipamentos WHERE tipo='" + type + "';");
            con.result_set.first();
            do {
                dados.add(new Object[]{
                    con.result_set.getInt("id"), 
                    con.result_set.getString("n_serie"), 
                    con.result_set.getString("descricao"), 
                    con.result_set.getString("tipo"), 
                    con.result_set.getString("marca"), 
                    con.result_set.getString("patrimonio")
                });
            } while (con.result_set.next());
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum item encontrado.\nCadastre um novo tipo para preencher a tabela", "ERRO 404 - Not Found", JOptionPane.ERROR_MESSAGE);
            if(dados.isEmpty()){
                return dados;
            }
        }
        return dados;
    }
}

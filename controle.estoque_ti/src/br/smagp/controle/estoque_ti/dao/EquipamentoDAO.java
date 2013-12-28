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
import br.smagp.controle.estoque_ti.model.Equipamento;
import java.util.ArrayList;
import java.util.List;


/**
 * @author AllexOnRails
 *
 */
public class EquipamentoDAO extends SQLSyntax{
	
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

    /*
     * (non-Javadoc)
     * @see br.smagp.suporteTI.controleEstoque.database.SQLSyntax#insert(java.lang.Object)
     */

    @Override
    public int insert(Object object) throws SQLException {
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

    /**
     * ESTE MÉTHODO A BAIXO TENTA
     * RETORNAR UM OBJETO DO TIPO
     * EQUIPAMENTO PELO NUMERO DE
     * SÉRIE!
     * 
     * @param n_serie
     * @return
     * @throws SQLException
     */

    public Equipamento getEquipamento(String n_serie) throws SQLException{
        Connection conecta= ConnectionFactory.getInstance().getConnection();
        String sql = "select id, n_serie, descricao,tipo, marcca, patrimonio from equipamentos where n_serie=? order by n_serie";
        PreparedStatement selectStatement = conecta.prepareStatement(sql);
        selectStatement.setString(1, n_serie);

        ResultSet resultado = selectStatement.executeQuery();

        this.equipamento = null;

        if (resultado.next()) {
                int _id_ = resultado.getInt("id");
                String _n_serie_ = resultado.getString("n_serie");
                String _tipo_ = resultado.getString("tipo");
                String _marca_ = resultado.getString("marca");
                String _patrimonio_ = resultado.getString("patrimonio");

                this.equipamento = new Equipamento();
                this.equipamento.setN_serie_equipamento(_n_serie_);
                this.equipamento.setTipo_equipamento(_tipo_);
                this.equipamento.setMarca_equipamento(_marca_);
                this.equipamento.setPatrimonio(_patrimonio_);
        }

        resultado.close();
        selectStatement.close();

        return this.equipamento;	
    }

    /*
     * (non-Javadoc)
     * @see br.smagp.suporteTI.controleEstoque.database.SQLSyntax#update(java.lang.Object)
     */

    @Override
    public void update(Object object) throws SQLException {
        Connection conecta= ConnectionFactory.getInstance().getConnection();
        this.equipamento = (Equipamento) object;
        String queryString = "UPDATE equipamentos SET n_serie=?, descricao=?, tipo=?, marca=? patrimonio=? WHERE id=?";
        SQL = conecta.prepareStatement(queryString);
        SQL.setString(1, this.equipamento.getN_serie_equipamento());
        SQL.setString(2, this.equipamento.getEquipamento());
        SQL.setString(3, this.equipamento.getTipo_equipamento());
        SQL.setString(4, this.equipamento.getMarca_equipamento());
        SQL.setString(5, this.equipamento.getPatrimonio());
        SQL.setInt(6, 	 this.equipamento.getId());
        System.out.println("Tabela Orgaos atualizada com sucesso por: "+this.equipamento);
        JOptionPane.showMessageDialog(null, "Equipamento atualizado!", "Sucesso" ,JOptionPane.INFORMATION_MESSAGE);
        SQL.executeUpdate();
        SQL.close();
    }

    /*
     * (non-Javadoc)
     * @see br.smagp.suporteTI.controleEstoque.database.SQLSyntax#delete(int)
     */

    @Override
    public void delete(int cod_object) throws SQLException {
            Connection conecta= ConnectionFactory.getInstance().getConnection();
            try {
                SQL = conecta.prepareStatement("DELETE FROM equipamentos WHERE id = " + cod_object);
                SQL.executeUpdate();
                SQL.close();
                System.out.println("Equipamento: "+cod_object+" removido!");
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
}

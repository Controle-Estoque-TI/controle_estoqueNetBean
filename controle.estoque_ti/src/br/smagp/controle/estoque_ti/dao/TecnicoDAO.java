package br.smagp.controle.estoque_ti.dao;

import br.smagp.controle.estoque_ti.db.ConnectionFactory;
import br.smagp.controle.estoque_ti.interfaces.CRUD;
import br.smagp.controle.estoque_ti.model.Tecnico;
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
public class TecnicoDAO implements CRUD{

    /**
     * PARAMETROS PARA CONTROLAR A VIEW DO
     * TÉCNICO COM A BASE DE DADOS. 
     */
    private static Statement statement;
    private static ResultSet result_set;
    private PreparedStatement SQL;
    private Tecnico tecnico;

    /**
     * TUDO QUE POSSUIR #{@Override}
     * é implementado da INTERFACE 
     * neste caso #{@CRUD}
     */

    @Override
    public int create(Object object) throws SQLException {
        Connection conecta= new ConnectionFactory().getInstance().getConnection();
        this.tecnico = (Tecnico) object;

        SQL = conecta.prepareStatement("INSERT INTO tecnicos"+"(nome, matricula, setor, password, celular)"+"VALUES (?, ?, ?, ? ,?);");

        SQL.setString(1, this.tecnico.getNome());
        SQL.setString(2, this.tecnico.getMatricula());
        SQL.setString(3, this.tecnico.getSetor());
        SQL.setString(4, this.tecnico.getPassword());
        SQL.setString(5, this.tecnico.getCelular());

        int updated = SQL.executeUpdate();
        SQL.close();
        return updated;
    }

    
    @Override
    public int update(Object object) throws SQLException {
        Connection conecta= ConnectionFactory.getInstance().getConnection();
        this.tecnico = (Tecnico) object;
        String queryString = "UPDATE tecnicos SET nome=?, matricula=?, setor=? celular=? WHERE id="+this.tecnico.getID()+";";
        SQL = conecta.prepareStatement(queryString);
        SQL.setString(1, this.tecnico.getNome());
        SQL.setString(2, this.tecnico.getMatricula());
        SQL.setString(3, this.tecnico.getSetor());
        SQL.setString(4, this.tecnico.getCelular());
        SQL.setInt(5, this.tecnico.getID());

        int updated = SQL.executeUpdate();
        SQL.close();
        return updated;
    }

    @Override
    public ArrayList select(){
        ArrayList dados = new ArrayList();
        ConnectionFactory con= ConnectionFactory.getInstance();
        try {
            con.conexao();
            con.executaSQL("SELECT * FROM tecnicos;");
            con.result_set.first();
            do {                
                dados.add(new Object[]{
                    con.result_set.getInt("id"), 
                    con.result_set.getString("nome"),
                    con.result_set.getString("matricula"),
                    con.result_set.getString("setor")
                });
            } while (con.result_set.next());
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher a Tabela.\nNenhum tecnico encontrado na base de dados.", "Erro 404 - Not Found", JOptionPane.ERROR_MESSAGE);
        }
        return dados; 
    }
    
    public ArrayList selectByMatricula(String matricula) {
        ArrayList dados = new ArrayList();
        ConnectionFactory con = new ConnectionFactory();
        try {
            con.conexao();
            con.executaSQL("SELECT id, nome, matricula, setor FROM tecnicos " + " WHERE matricula='" + matricula + "';");
            con.result_set.first();
            do {
                dados.add(new Object[]{
                    con.result_set.getInt("id"), 
                    con.result_set.getString("nome"), 
                    con.result_set.getString("matricula"), 
                    con.result_set.getString("setor")
                });
            } while (con.result_set.next());
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Matricula não encontrada.\nCadastre um novo tecnico.", "ERRO 404 - Not Found", JOptionPane.ERROR_MESSAGE);
            if(dados.isEmpty()){
                return dados;
            }
        }
        return dados;
    }
    
    @Override
    public void delete(String cod_object) throws SQLException {
        Connection conecta = new ConnectionFactory().getInstance().getConnection();
        try {
            SQL = conecta.prepareStatement("DELETE FROM tecnicos WHERE id = '"+cod_object+"';");
            SQL.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Foi encontrado um erro na remoção" + JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
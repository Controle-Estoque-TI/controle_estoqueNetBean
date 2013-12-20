/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.smagp.controle.estoque_ti.dao;

import br.smagp.controle.estoque_ti.db.ConnectionFactory;
import br.smagp.controle.estoque_ti.db.SQLSyntax;
import br.smagp.controle.estoque_ti.model.Tecnico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author AllexOnRails
 */
public class TecnicoDAO extends SQLSyntax{

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
	 * Herda da Super classe neste 
	 * caso #{@SQLSyntax}
	 */
	
	/*
	 * (non-Javadoc)
	 * @see br.smagp.suporteTI.controleEstoque.database.SQLSyntax#insert(java.lang.Object)
	 */

	@Override
	public int insert(Object object) throws SQLException {
		Connection conecta= new ConnectionFactory().getInstance().getConnection();
		this.tecnico = (Tecnico) object;
		
		SQL = conecta.prepareStatement("INSERT INTO tecnicos"+"(nome, matricula, setor, password, celular)"+"VALUES (?, ?, ?, ? ,?);");
		
		SQL.setString(1, this.tecnico.getNome());
		SQL.setString(2, this.tecnico.getMatricula());
		SQL.setString(3, this.tecnico.getSetor());
		SQL.setString(4, this.tecnico.getPassword());
		SQL.setString(5, this.tecnico.getCelular());
		
		int updated = SQL.executeUpdate();
		System.out.println("Padrao de retorno: "+updated+"\nTabela atualizada com um novo equipamento.");
		SQL.close();
		JOptionPane.showMessageDialog(null, "Tecnico registrado!", "Sucesso" ,JOptionPane.INFORMATION_MESSAGE);
		
		return updated;
	}
	
	/**
	 * ESTE MÉTHODO A BAIXO TENTA
	 * RETORNAR UM OBJETO DO TIPO
	 * TECNICO PELO NUMERO DE
	 * SÉRIE!
	 * 
	 * @param matricula
	 * @return
	 * @throws SQLException
	 */
	
	public Tecnico getTecnico(String matricula) throws SQLException{
		Connection conecta= ConnectionFactory.getInstance().getConnection();
		String sql = "select id, nome, matricula, setor, celular from tecnicos where matricula=? order by id";
		PreparedStatement selectStatement = conecta.prepareStatement(sql);
		selectStatement.setString(1, matricula);

		ResultSet resultado = selectStatement.executeQuery();

		this.tecnico = null;

		if (resultado.next()) {
			int _id_ = resultado.getInt("id");
			String _nome_ = resultado.getString("nome");
			String _matricula_ = resultado.getString("matricula");
			String _setor_ = resultado.getString("setor");
			String _cel_ = resultado.getString("celular");

			this.tecnico = new Tecnico();
			this.tecnico.setID(_id_);
			this.tecnico.setNome(_nome_);
			this.tecnico.setMatricula(_matricula_);
			this.tecnico.setSetor(_setor_);
			this.tecnico.setCelular(_cel_);
		}

		resultado.close();
		selectStatement.close();

		return this.tecnico;	
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.smagp.suporteTI.controleEstoque.database.SQLSyntax#update(java.lang.Object)
	 */
	
	@Override
	public void update(Object object) throws SQLException {
		Connection conecta= ConnectionFactory.getInstance().getConnection();
		this.tecnico = (Tecnico) object;
		String queryString = "UPDATE tecnicos SET nome=?, matricula=?, setor=? celular=? WHERE id="+this.tecnico.getID()+";";
		SQL = conecta.prepareStatement(queryString);
        SQL.setString(1, this.tecnico.getNome());
        SQL.setString(2, this.tecnico.getMatricula());
        SQL.setString(3, this.tecnico.getSetor());
        SQL.setString(4, this.tecnico.getCelular());
        SQL.setInt(5, this.tecnico.getID());
        
        System.out.println("Tabela Orgaos atualizada com sucesso por: "+this.tecnico);
        JOptionPane.showMessageDialog(null, "Equipamento atualizado!", "Sucesso" ,JOptionPane.INFORMATION_MESSAGE);
        SQL.executeUpdate();
        SQL.close();
	}

	/*
	 * (non-Javadoc)
	 * @see br.smagp.suporteTI.controleEstoque.database.SQLSyntax#select()
	 */
	
	@Override
	public Vector select() throws SQLException{
		Connection conecta= ConnectionFactory.getInstance().getConnection();
		Vector lista = new Vector();
		try {
			SQL = conecta.prepareStatement("SELECT * FROM tecnicos t ORDER BY t.matricula;");
			result_set = SQL.executeQuery();
			while (result_set.next()) {
				Vector listas = new Vector();
				listas.add(result_set.getString("id"));
				listas.add(result_set.getString("matricula"));
				listas.add(result_set.getString("nome"));
				listas.add(result_set.getString("setor"));
				listas.add(result_set.getString("celular"));
				lista.add(listas);
			}
			return lista;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Foi encontrado um erro na busca");
			e.printStackTrace();
		}
		return lista;
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.smagp.suporteTI.controleEstoque.database.SQLSyntax#find_by_nome(java.lang.String)
	 */
	
	@Override
	public Vector find_by_nome(String nome) throws SQLException{
		Connection conecta= ConnectionFactory.getInstance().getConnection();
		Vector lista = new Vector();
		try {
			SQL = conecta.prepareStatement("SELECT * FROM tecnicos WHERE nome = '"+nome+"'");
			result_set = SQL.executeQuery();
			while (result_set.next()) {
				Vector listas = new Vector();
				listas.add(result_set.getString("id"));
				listas.add(result_set.getString("matricula"));
				listas.add(result_set.getString("nome"));
				listas.add(result_set.getString("setor"));
				listas.add(result_set.getString("celular"));
				lista.add(listas);
			}
			return lista;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Foi encontrado um erro na busca");
			e.printStackTrace();
		}
		return lista;
	}
	
	public Vector findByMatricula(String matricula) throws SQLException{
		Connection conecta= ConnectionFactory.getInstance().getConnection();
		Vector lista = new Vector();
		try {
			SQL = conecta.prepareStatement("SELECT * FROM tecnicos WHERE n_serie = '"+matricula+"'");
			result_set = SQL.executeQuery();
			while (result_set.next()) {
				Vector listas = new Vector();
				listas.add(result_set.getString("id"));
				listas.add(result_set.getString("matricula"));
				listas.add(result_set.getString("nome"));
				listas.add(result_set.getString("setor"));
				listas.add(result_set.getString("celular"));
				lista.add(listas);
			}
			return lista;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Foi encontrado um erro na busca");
			e.printStackTrace();
		}
		return lista;
	}
	
	public int selectByMat(String matricula) throws SQLException {
		int codtec = 0;
		
		Connection conecta= ConnectionFactory.getInstance().getConnection();
		
		PreparedStatement sql = conecta.prepareStatement("SELECT id FROM paciente WHERE cpf = '"+matricula+"'");
		ResultSet resultSet = sql.executeQuery();
		
		while (resultSet.next()) {
			codtec = resultSet.getInt("id");
		}
			
		return codtec;
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.smagp.suporteTI.controleEstoque.database.SQLSyntax#delete(int)
	 */
	
	@Override
	public void delete(int cod_object) throws SQLException {
		Connection conecta= new ConnectionFactory().getInstance().getConnection();
		try {
			SQL = conecta.prepareStatement("DELETE FROM tecnicos WHERE id = " + cod_object);
			SQL.executeUpdate();
			JOptionPane.showMessageDialog(null, "Técnico removido!", "Sucesso" ,JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Foi encontrado um erro na remoção"+JOptionPane.ERROR_MESSAGE);	
			e.printStackTrace();
		}	
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.smagp.controle.estoque_ti.dao;
import br.smagp.controle.estoque_ti.db.ConnectionFactory;
import br.smagp.controle.estoque_ti.db.SQLSyntax;
import br.smagp.controle.estoque_ti.model.Orgao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
/**
 *
 * @author AllexOnRails
 */
public class OrgaoDAO extends SQLSyntax{
	private static Statement statement;
	private static ResultSet result_set;
	private PreparedStatement SQL;
	private Orgao orgao;
	
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
	public int insert(Object object) throws SQLException{
		Connection conecta= ConnectionFactory.getInstance().getConnection();
		this.orgao = (Orgao) object;
		SQL = conecta.prepareStatement("INSERT INTO orgaos"+"(nome_orgao)"+"VALUES (?);");
		
		SQL.setString(1, this.orgao.getNomeOrgao());
		int updated = SQL.executeUpdate();
		System.out.println("Padrao de retorno: "+updated+"\nTabela atualizada com um novo equipamento.");
		SQL.close();
		JOptionPane.showMessageDialog(null, "Orgao registrado!", "Sucesso" ,JOptionPane.INFORMATION_MESSAGE);
		
		return updated;
	}
	
	/**
	 * ESTE MÉTHODO A BAIXO TENTA
	 * RETORNAR UM OBJETO DO TIPO
	 * ORGAO PELO NOME
	 * 
	 * @param matricula
	 * @return
	 * @throws SQLException
	 */
	
	public Orgao getOrgao(String nome_orgao) throws SQLException{
		Connection conecta= ConnectionFactory.getInstance().getConnection();
		String sql = "select id, nome_orgao from orgaos where nome_orgao=? order by id";
		PreparedStatement selectStatement = conecta.prepareStatement(sql);
		selectStatement.setString(1, nome_orgao);

		ResultSet resultado = selectStatement.executeQuery();

		this.orgao = null;

		if (resultado.next()) {
			int _id_ = resultado.getInt("id");
			String _nome_ = resultado.getString("nome_orgao");
			
			this.orgao = new Orgao();
			this.orgao.setId(_id_);
			this.orgao.setNomeOrgao(_nome_);
		}

		resultado.close();
		selectStatement.close();

		return this.orgao;	
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.smagp.suporteTI.controleEstoque.database.SQLSyntax#update(java.lang.Object)
	 */
	
	@Override
	public void update(Object object) throws SQLException {
		Connection conecta= ConnectionFactory.getInstance().getConnection();
		this.orgao = (Orgao) object;
		String queryString = "UPDATE tecnicos SET nome_orgao=? WHERE id="+this.orgao.getId()+";";
		SQL = conecta.prepareStatement(queryString);
        SQL.setString(1, this.orgao.getNomeOrgao());
        SQL.setInt(2, this.orgao.getId());
        
        System.out.println("Tabela Orgaos atualizada com sucesso por: "+this.orgao);
        JOptionPane.showMessageDialog(null, "Equipamento atualizado!", "Sucesso" ,JOptionPane.INFORMATION_MESSAGE);
        SQL.executeUpdate();
        SQL.close();
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.smagp.suporteTI.controleEstoque.database.SQLSyntax#delete(int)
	 */
	
	@Override
	public void delete(int cod_object) throws SQLException{
		Connection conecta= new ConnectionFactory().getInstance().getConnection();
		try {
			SQL = conecta.prepareStatement("DELETE FROM orgaos WHERE id = " + cod_object);
			SQL.executeUpdate();
			JOptionPane.showMessageDialog(null, "Orgao removido!", "Sucesso" ,JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Foi encontrado um erro na remoção"+JOptionPane.ERROR_MESSAGE);	
			e.printStackTrace();
		}
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
			SQL = conecta.prepareStatement("SELECT * FROM orgaos WHERE nome_orgao = '"+nome+"'");
			result_set = SQL.executeQuery();
			while (result_set.next()) {
				Vector listas = new Vector();
				listas.add(result_set.getString("id"));
				listas.add(result_set.getString("nome_orgao"));				
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
	 * @see br.smagp.suporteTI.controleEstoque.database.SQLSyntax#select()
	 */
	
	@Override
	public List select() throws SQLException {
		Connection conecta= ConnectionFactory.getInstance().getConnection();
		Vector lista = new Vector();
		try {
			SQL = conecta.prepareStatement("SELECT * FROM orgaos;");
			result_set = SQL.executeQuery();
			while (result_set.next()) {
				Vector listas = new Vector();
				listas.add(result_set.getString("id"));
				listas.add(result_set.getString("nome_orgao"));				
				lista.add(listas);
			}
			return lista;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Foi encontrado um erro na busca");
			e.printStackTrace();
		}
		return lista;
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.smagp.controle.estoque_ti.dao;
import br.smagp.controle.estoque_ti.db.ConnectionFactory;
import br.smagp.controle.estoque_ti.db.SQLSyntax;
import br.smagp.controle.estoque_ti.model.Controle;
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
public class ControleDAO extends SQLSyntax{
	
	private static Statement statement;
	private static ResultSet result_set;
	private PreparedStatement SQL;
	private Controle controle;
	
	/*
	 * (non-Javadoc)
	 * @see br.smagp.suporteTI.controleEstoque.database.SQLSyntax#insert(java.lang.Object)
	 */
	
	@Override
	public int insert(Object object) throws SQLException{
		Connection conecta= ConnectionFactory.getInstance().getConnection();
		this.controle = (Controle) object;
		SQL = conecta.prepareStatement("INSERT INTO controle"+"(cod_equipamento, cod_tecnico, cod_orgao, setor_orgao, cod_chefia)"+"VALUES (?, ?, ?, ?, ?);");
		
		SQL.setInt(1, this.controle.getEquipamento());
		SQL.setInt(2, this.controle.getTecnico());
		SQL.setInt(3, this.controle.getOrgao());
		SQL.setString(4, this.controle.getSetorOrgao());
		SQL.setInt(5, this.controle.getChefia());
		
		int updated = SQL.executeUpdate();
		System.out.println("Padrao de retorno: "+updated+"\nTabela atualizada - Controle do estoque atualizado.");
		SQL.close();
		JOptionPane.showMessageDialog(null, "Controle do estoque\natualizado!", "Sucesso" ,JOptionPane.INFORMATION_MESSAGE);
		
		return updated;
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
			SQL = conecta.prepareStatement("SELECT e.n_serie, e.tipo, e.patrimonio, t.nome, t.setor ,o.nome_orgao, x.chefia, x.setor "
											+ "FROM controle c, equipamento e, tecnico t, orgao o, chefia x "
											+ "WHERE c.cod_equipamento = e.id AND c.cod_tecnico = t.id "
											+ "AND c.cod_orgao = o.id AND c.cod_chefia = x.id;");
			result_set = SQL.executeQuery();
			while (result_set.next()) {
				Vector listas = new Vector();
				listas.add(result_set.getString("e.n_serie"));
				listas.add(result_set.getString("e.tipo"));
				listas.add(result_set.getString("e.patrimonio"));
				listas.add(result_set.getString("t.nome"));
				listas.add(result_set.getString("o.nome_orgao"));
				listas.add(result_set.getString("x.chefia"));
				listas.add(result_set.getString("x.setor"));
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
	 * @see br.smagp.suporteTI.controleEstoque.database.SQLSyntax#delete(int)
	 */
	
	@Override
	public void delete(int cod_object) throws SQLException {
		Connection conecta= ConnectionFactory.getInstance().getConnection();
		try {
			SQL = conecta.prepareStatement("DELETE FROM controle WHERE id = " + cod_object);
			SQL.executeUpdate();
			SQL.close();
			System.out.println("Ficha de Controle: "+cod_object+" removido!");
			JOptionPane.showMessageDialog(null, "Ficha de controle\nremovida!", "Sucesso" ,JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Foi encontrado um erro na remoção"+JOptionPane.ERROR_MESSAGE);	
			e.printStackTrace();
		}
	}
}

package br.smagp.controle.estoque_ti.dao;
import br.smagp.controle.estoque_ti.db.ConnectionFactory;
import br.smagp.controle.estoque_ti.interfaces.CRUD;
import br.smagp.controle.estoque_ti.model.Chefia;
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
public class ChefiaDAO implements CRUD{
    protected static Statement statement;
    protected static ResultSet result_set;
    protected PreparedStatement SQL;
    private Chefia chefia;

    /**
     * TUDO QUE POSSUIR #{@Override}
     * Herda da Super classe neste 
     * caso #{@CRUD}
     */

    @Override
    public int create(Object object) throws SQLException{
        Connection conecta= ConnectionFactory.getInstance().getConnection();
        this.chefia= (Chefia) object;
        SQL = conecta.prepareStatement("INSERT INTO chefias"+"(nome, matricula, orgao ,setor)"+"VALUES (?, ?, ?, ?);");

        SQL.setString(1, this.chefia.getNome());
        SQL.setString(2, this.chefia.getMatricula());
        SQL.setObject(3, this.chefia.getOrgao());
        SQL.setString(4, this.chefia.getSetor());

        int updated = SQL.executeUpdate();
        System.out.println("Padrao de retorno: "+updated+"\nTabela atualizada com nova chefia.");
        SQL.close();
        JOptionPane.showMessageDialog(null, "Chefia registrada!", "Sucesso" ,JOptionPane.INFORMATION_MESSAGE);

        return updated;
    }

    @Override
    public int update(Object object) throws SQLException{
        Connection conecta= ConnectionFactory.getInstance().getConnection();
        this.chefia = (Chefia) object;
        SQL = conecta.prepareStatement("UPDATE chefias SET nome_chefia=?, matricula=?, cod_orgao=?, setor=? WHERE id=?");
        SQL.setString(1, this.chefia.getNome());
        SQL.setString(2, this.chefia.getMatricula());
        SQL.setObject(3, this.chefia.getOrgao());
        SQL.setString(4, this.chefia.getSetor());
        
        SQL.setInt(5, this.chefia.getID());
        
        System.out.println("Tabela Orgaos atualizada com sucesso por: "+this.chefia);
        JOptionPane.showMessageDialog(null, "Equipamento atualizado!", "Sucesso" ,JOptionPane.INFORMATION_MESSAGE);
        int updated = SQL.executeUpdate();
        SQL.close();
        return updated;
    }

    @Override
    public void delete(String cod_object) throws SQLException{
        Connection conecta= ConnectionFactory.getInstance().getConnection();
        try {
            SQL = conecta.prepareStatement("DELETE FROM chefias WHERE id='" + cod_object+"';");
            SQL.executeUpdate();
            SQL.close();
            System.out.println("Chefia: "+cod_object+" removida!");
            JOptionPane.showMessageDialog(null, "Chefia removida!", "Sucesso" ,JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Foi encontrado um erro na remoção"+JOptionPane.ERROR_MESSAGE);	
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList select(){
        ArrayList dados = new ArrayList();
        ConnectionFactory con= ConnectionFactory.getInstance();
        try {
            con.conexao();
            con.executaSQL("SELECT * FROM chefias;");
            con.result_set.first();
            do {                
                dados.add(new Object[]{
                    con.result_set.getInt("id"), 
                    con.result_set.getString("nome_chefia"),
                    con.result_set.getString("matricula"),
                    con.result_set.getString("orgao"),
                    con.result_set.getString("setor"),
                });
            } while (con.result_set.next());
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher a Tabela.\nNenhum equipamento encontrado na base de dados.", "Erro 404 - Not Found", JOptionPane.ERROR_MESSAGE);
        }
        return dados; 
    }
}
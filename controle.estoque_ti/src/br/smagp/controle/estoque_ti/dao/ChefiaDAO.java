/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.smagp.controle.estoque_ti.dao;
import br.smagp.controle.estoque_ti.db.ConnectionFactory;
import br.smagp.controle.estoque_ti.db.SQLSyntax;
import br.smagp.controle.estoque_ti.model.Chefia;
import br.smagp.controle.estoque_ti.model.Orgao;
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
public class ChefiaDAO extends SQLSyntax{
    protected static Statement statement;
    protected static ResultSet result_set;
    protected PreparedStatement SQL;
    private Chefia chefia;

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
        this.chefia= (Chefia) object;
        SQL = conecta.prepareStatement("INSERT INTO orgaos"+"(nome, matricula, setor, orgao)"+"VALUES (?, ?, ?, ?);");

        SQL.setString(1, this.chefia.getNome());
        SQL.setString(2, this.chefia.getMatricula());
        SQL.setString(3, this.chefia.getSetor());
        SQL.setObject(4, this.chefia.getOrgao());

        int updated = SQL.executeUpdate();
        System.out.println("Padrao de retorno: "+updated+"\nTabela atualizada com nova chefia.");
        SQL.close();
        JOptionPane.showMessageDialog(null, "Chefia registrada!", "Sucesso" ,JOptionPane.INFORMATION_MESSAGE);

        return updated;
    }

    /**
     * ESTE MÉTHODO A BAIXO TENTA
     * RETORNAR UM OBJETO DO TIPO
     * ORGAO!
     * 
     * @param n_serie
     * @return
     * @throws SQLException
     */

    public Chefia getChefia(String nome) throws SQLException{
        Connection conecta= ConnectionFactory.getInstance().getConnection();
        String sql = "SELECT id, nome, matricula, setor, orgao from chefias where nome=? order by id";
        PreparedStatement selectStatement = conecta.prepareStatement(sql);
        selectStatement.setString(1, nome);

        ResultSet resultado = selectStatement.executeQuery();

        this.chefia = null;

        if (resultado.next()) {
            int _id_ = resultado.getInt("id");
            String _nome_ = resultado.getString("nome");
            String _matricula_ = resultado.getString("matricula");
            String _setor_ = resultado.getString("setor");
            Object _orgao_ = resultado.getObject("orgao");

            this.chefia = new Chefia();
            this.chefia.setID(_id_);
            this.chefia.setNome(_nome_);
            this.chefia.setMatricula(_matricula_);
            this.chefia.setSetor(_setor_);
            this.chefia.setOrgao((Orgao) _orgao_);
        }

        resultado.close();
        selectStatement.close();

        return this.chefia;	
    }

    /*
     * (non-Javadoc)
     * @see br.smagp.suporteTI.controleEstoque.database.SQLSyntax#update(java.lang.Object)
     */
    @Override
    public void update(Object object) throws SQLException{
        Connection conecta= ConnectionFactory.getInstance().getConnection();
        this.chefia = (Chefia) object;
        String queryString = "UPDATE equipamentos SET n_serie=?, tipo=?, marca=? patrimonio=? WHERE id=?";
        SQL = conecta.prepareStatement(queryString);
        SQL.setInt(1, this.chefia.getID());
        SQL.setString(2, this.chefia.getNome());
        SQL.setString(3, this.chefia.getMatricula());
        SQL.setString(4, this.chefia.getSetor());
        SQL.setObject(5, this.chefia.getOrgao());
        System.out.println("Tabela Orgaos atualizada com sucesso por: "+this.chefia);
        JOptionPane.showMessageDialog(null, "Equipamento atualizado!", "Sucesso" ,JOptionPane.INFORMATION_MESSAGE);
        SQL.executeUpdate();
        SQL.close();
    }

    @Override
    public void delete(int cod_object) throws SQLException{
        Connection conecta= ConnectionFactory.getInstance().getConnection();
        try {
            SQL = conecta.prepareStatement("DELETE FROM chefias WHERE id = " + cod_object);
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
    public Vector select() throws SQLException{
        Connection conecta= ConnectionFactory.getInstance().getConnection();
        Vector lista = new Vector();
        try {
            SQL = conecta.prepareStatement("SELECT * FROM chefias;");
            result_set = SQL.executeQuery();
            while (result_set.next()) {
                Vector listas = new Vector();
                listas.add(result_set.getString("id"));
                listas.add(result_set.getString("nome"));				
                lista.add(listas);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Foi encontrado um erro na busca");
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Vector find_by_nome(String nome) throws SQLException{
        Connection conecta= ConnectionFactory.getInstance().getConnection();
        Vector lista = new Vector();
        try {
            SQL = conecta.prepareStatement("SELECT * FROM chefias WHERE n_serie = '"+nome+"'");
            result_set = SQL.executeQuery();
            while (result_set.next()) {
                    Vector listas = new Vector();
                    listas.add(result_set.getString("id"));
                    listas.add(result_set.getString("matricula"));
                    listas.add(result_set.getString("nome"));
                    listas.add(result_set.getString("setor"));				
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

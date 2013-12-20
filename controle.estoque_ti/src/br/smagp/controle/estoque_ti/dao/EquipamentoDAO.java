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
            SQL = conecta.prepareStatement("INSERT INTO equipamentos"+"(n_serie, tipo, marca, patrimonio)"+"VALUES (?, ?, ?, ?);");

            SQL.setString(1, this.equipamento.getNumero_Serie_Equipamento());
            SQL.setString(2, this.equipamento.getTipo_Equipamento());
            SQL.setString(3, this.equipamento.getMarca_Equipamento());
            SQL.setString(4, this.equipamento.getPatrimonio());

            int updated = SQL.executeUpdate();
            System.out.println("Padrao de retorno: "+updated+"\nTabela atualizada com um novo equipamento.");
            SQL.close();
            JOptionPane.showMessageDialog(null, "Equipamento registrado!", "Sucesso" ,JOptionPane.INFORMATION_MESSAGE);

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
            String sql = "select id, n_serie, tipo, marcca, patrimonio from equipamentos where n_serie=? order by id";
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
                    this.equipamento.setNumero_Serie_Equipamento(_n_serie_);
                    this.equipamento.setTipo_Equipamento(_tipo_);
                    this.equipamento.setMarca_Equipamento(_marca_);
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
            String queryString = "UPDATE equipamentos SET n_serie=?, tipo=?, marca=? patrimonio=? WHERE id=?";
            SQL = conecta.prepareStatement(queryString);
    SQL.setString(1, this.equipamento.getNumero_Serie_Equipamento());
    SQL.setString(2, this.equipamento.getTipo_Equipamento());
    SQL.setString(3, this.equipamento.getMarca_Equipamento());
    SQL.setString(4, this.equipamento.getPatrimonio());
    SQL.setInt(5, 	 this.equipamento.getId());
    System.out.println("Tabela Orgaos atualizada com sucesso por: "+this.equipamento);
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
                    SQL = conecta.prepareStatement("SELECT * FROM equipamentos t ORDER BY t.n_serie;");
                    result_set = SQL.executeQuery();
                    while (result_set.next()) {
                            Vector listas = new Vector();
                            listas.add(result_set.getString("id"));
                            listas.add(result_set.getString("n_serie"));
                            listas.add(result_set.getString("tipo"));
                            listas.add(result_set.getString("marca"));
                            listas.add(result_set.getString("patrimonio"));				
                            lista.add(listas);
                    }
                    return lista;
            } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Foi encontrado um erro na busca");
                    e.printStackTrace();
            }
            return lista;
    }

    public Vector findByNumeroDeSerie(String n_serie) throws SQLException{
            Connection conecta= ConnectionFactory.getInstance().getConnection();
            Vector lista = new Vector();
            try {
                    SQL = conecta.prepareStatement("SELECT * FROM equipamentos WHERE n_serie = '"+n_serie+"'");
                    result_set = SQL.executeQuery();
                    while (result_set.next()) {
                            Vector listas = new Vector();
                            listas.add(result_set.getString("id"));
                            listas.add(result_set.getString("n_serie"));
                            listas.add(result_set.getString("tipo"));
                            listas.add(result_set.getString("marca"));
                            listas.add(result_set.getString("patrimonio"));				
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

    /**
     * @param args
     */
    public static void main(String[] args) {

            Equipamento equipamento= new Equipamento();
            equipamento.setNumero_Serie_Equipamento("{CCaABdDb#001}");
            equipamento.setTipo_Equipamento("HP - 4015");
            equipamento.setMarca_Equipamento("HP");
            equipamento.setPatrimonio("2013XXDdzw");

            System.out.println("Numero de Serie: "+equipamento.getNumero_Serie_Equipamento()+"\n"
                                                +"Tipo: "+equipamento.getTipo_Equipamento()+"\n"
                                                +"Marca: "+equipamento.getMarca_Equipamento()
            );


            EquipamentoDAO dao = new DAOFactory().getEquipamento(); //Fazer isto na hora de instanciar na interface
            try {
                    dao.insert(equipamento);
                    System.out.println(dao.findByNumeroDeSerie(equipamento.getNumero_Serie_Equipamento()));
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.smagp.controle.estoque_ti.dao;
import br.smagp.controle.estoque_ti.db.ConnectionFactory;
import br.smagp.controle.estoque_ti.interfaces.CRUD;
import br.smagp.controle.estoque_ti.model.Controle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
/**
 *
 * @author AllexOnRails
 */
public class ControleDAO implements CRUD{
	
    private static Statement statement;
    private static ResultSet result_set;
    private PreparedStatement SQL;
    private Controle controle;

    
    @Override
    public int create(Object object) throws SQLException{
        Connection conecta= ConnectionFactory.getInstance().getConnection();
        this.controle = (Controle) object;
        SQL = conecta.prepareStatement("INSERT INTO controle"+"(cod_equipamento, cod_tecnico, cod_orgao, setor_orgao, cod_chefia)"+"VALUES (?, ?, ?, ?, ?);");

        SQL.setInt(1, this.controle.getEquipamento());
        SQL.setInt(2, this.controle.getTecnico());
        SQL.setInt(3, this.controle.getOrgao());
        SQL.setString(4, this.controle.getSetorOrgao());
        SQL.setInt(5, this.controle.getChefia());

        int updated = SQL.executeUpdate();
        SQL.close();
        return updated;
    }

    @Override
    public int update(Object object) throws SQLException{
        Connection conecta= ConnectionFactory.getInstance().getConnection();
        this.controle = (Controle) object;
        SQL = conecta.prepareStatement("UPDATE chefias SET nome=?, matricula=?, cod_orgao=?, setor=? WHERE id=?");
        SQL.setInt(1, this.controle.getEquipamento());
        SQL.setInt(2, this.controle.getTecnico());
        SQL.setInt(3, this.controle.getOrgao());
        SQL.setInt(4, this.controle.getChefia());
        SQL.setString(5, this.controle.getSetorOrgao());
        int updated = SQL.executeUpdate();
        SQL.close();
        return updated;
    }
    
//    public Vector selecionar() throws SQLException{
//        Connection conecta= ConnectionFactory.getInstance().getConnection();
//        Vector lista = new Vector();
//        try {
//            SQL = conecta.prepareStatement("SELECT e.n_serie, e.tipo, e.patrimonio, t.nome, t.setor ,o.nome_orgao, x.chefia, x.setor "
//                                            + "FROM controle c, equipamento e, tecnico t, orgao o, chefia x "
//                                            + "WHERE c.cod_equipamento = e.id AND c.cod_tecnico = t.id "
//                                            + "AND c.cod_orgao = o.id AND c.cod_chefia = x.id;"
//            );
//            result_set = SQL.executeQuery();
//            while (result_set.next()) {
//                    Vector listas = new Vector();
//                    listas.add(result_set.getString("e.n_serie"));
//                    listas.add(result_set.getString("e.tipo"));
//                    listas.add(result_set.getString("e.patrimonio"));
//                    listas.add(result_set.getString("t.nome"));
//                    listas.add(result_set.getString("o.nome_orgao"));
//                    listas.add(result_set.getString("x.chefia"));
//                    listas.add(result_set.getString("x.setor"));
//                    lista.add(listas);
//            }
//            return lista;
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Foi encontrado um erro na busca");
//            e.printStackTrace();
//        }
//        return lista;
//    }

    @Override
    public ArrayList select(){
        ArrayList dados = new ArrayList();
        ConnectionFactory con= ConnectionFactory.getInstance();
        try {
            con.conexao();
            /**
             * Select c.nome, (o.nome_orgao) as orgao FROM chefias c, orgaos o Where c.matricula='120' AND c.cod_orgao= o.id;
             */
            con.executaSQL("SELECT e.n_serie, e.tipo, e.patrimonio, t.nome, t.setor ,o.nome_orgao, x.chefia, x.setor "
                                            + "FROM controle c, equipamento e, tecnico t, orgao o, chefia x "
                                            + "WHERE c.cod_equipamento = e.id AND c.cod_tecnico = t.id "
                                            + "AND c.cod_orgao = o.id AND c.cod_chefia = x.id;");
            con.result_set.first();
            do {                
                dados.add(new Object[]{
                    con.result_set.getInt("c.id"), 
                    con.result_set.getString("c.nome"),
                    con.result_set.getString("c.matricula"),
                    con.result_set.getString("orgao"),
                    con.result_set.getString("c.setor"),
                });
            } while (con.result_set.next());
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher a Tabela.\nNenhuma chefia encontrado na base de dados.", "Erro 404 - Not Found", JOptionPane.ERROR_MESSAGE);
        }
        return dados; 
    }
    
    
    @Override
    public void delete(String cod_object) throws SQLException{
        Connection conecta= ConnectionFactory.getInstance().getConnection();
        try {
            SQL = conecta.prepareStatement("DELETE FROM controle WHERE id='" + cod_object+"';");
            SQL.executeUpdate();
            SQL.close();            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Foi encontrado um erro na remoção"+JOptionPane.ERROR_MESSAGE);	
            e.printStackTrace();
        }
    }
}

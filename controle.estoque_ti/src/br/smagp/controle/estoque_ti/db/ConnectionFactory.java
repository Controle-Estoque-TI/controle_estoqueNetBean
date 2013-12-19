package br.smagp.controle.estoque_ti.db;

/**
 * Classe que implementa a Conexão com a base de dados
 */

/* 
 * Bibliotecas necessárias para fazer a conexão com 
 * a base de dados;
 * 
 *  DriveManagger => gerência o drive de conexão
 *  seja ele mysql, postgresql, sql-server
 *  
 *  SQLException Trata exceções de Sintaxe SQL
 *  
 *  JOptionPane - Abre um painel grafico
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

import br.smagp.controle.estoque_ti.interfaces.Conexao;

/**
 *
 * @author AllexOnRails
 */
public class ConnectionFactory implements Conexao{
    /**
     * Parametros para criar uma conexão
     * com a base de dados
     **/
	
    private static ConnectionFactory instance= new ConnectionFactory();
    private static Connection conection;

    private static Statement statement;
    private static ResultSet result_set;
    private PreparedStatement SQL;

    protected String database;
    protected String user;
    protected String password;
    private static boolean status;
    
    
    
    //VERIFICA UMA INSTANCIA
    public static ConnectionFactory getInstance() {
        return instance;
    }
	
    //VERIFICA UMA CONEXAO
    @Override
    public Connection getConnection() {
       System.out.println("Conexao status: aberta com sucesso ao Usuário: suporte \n");
       return conection;
    }
    
    /**
    * CONEXAO
    * 
    * Bloco que estabelece a conexao 
    * com o driver e o Banco de Dados 
    */

    @Override
    public void conexao() {
        try {
            this.status= true;
            if(this.status){
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    this.conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+this.database, this.user,this.password);
            }	
        } catch (InstantiationException e) {
                e.printStackTrace();
        } catch (IllegalAccessException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Não é possível carregar o driver de conexão.", "Mysql error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
                e.printStackTrace();
        } 
    }
    
    /**
    * 
    * database => banco de dados
    * user 	=> usuário
    * password => senha de acesso ao banco
    * 
    */

   public ConnectionFactory() { 
       this.database= "controle_estoque"; 
       this.user= "suporte"; 
       this.password= "controle";
       try {
           this.conexao();
       } catch (Exception e) {
       }
   }

   /**
    * Teste de conexao
    * @param args
    */
   public static void main(String[] args) {
        // TODO Auto-generated method stub
        Connection dt= new ConnectionFactory().getInstance().getConnection();

        try {
            dt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   }
}
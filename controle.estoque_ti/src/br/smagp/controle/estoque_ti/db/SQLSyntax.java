/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.smagp.controle.estoque_ti.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author AllexOnRails
 */
public abstract class SQLSyntax {
    
	
    public int insert(Object object) throws SQLException{
            Connection conecta= ConnectionFactory.getInstance().getConnection();
            // TODO Auto-generated method stub
            return 1;
    }

    public void update(Object object) throws SQLException{
            Connection conecta= ConnectionFactory.getInstance().getConnection();
            // TODO Auto-generated method stub
    }

    public void delete(int cod_object) throws SQLException{
            Connection conecta= ConnectionFactory.getInstance().getConnection();
            // TODO Auto-generated method stub
    }

    public Vector find_by_nome(String nome) throws SQLException{
            // TODO Auto-generated method stub
            return null;	
    }

    public Vector select() throws SQLException {
            // TODO Auto-generated method stub
            return null;
    }
}
package br.smagp.controle.estoque_ti.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * INTERFACE RESPONSAVÉL POR ASSINAR
 * COMO O CRUD É IMPLEMENTADO NO SISTEMA
 * CONTROLE ESTOQUE DE TI DA PMCG
 * @author AllexOnRails
 */
public interface CRUD {
    public int create(Object Object) throws SQLException; // Create metodo
    public ArrayList select() throws SQLException;        // Retrieve metodo
    public int update(Object object) throws SQLException; // update metodo
    public void delete(String str) throws SQLException; // delete metodo
}

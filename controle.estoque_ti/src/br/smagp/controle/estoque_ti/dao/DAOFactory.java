/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.smagp.controle.estoque_ti.dao;

/**
 *
 * @author AllexOnRails
 */
public class DAOFactory {
    public static TecnicoDAO getTecnico(){
		return new TecnicoDAO();	
	}
	
	public static EquipamentoDAO getEquipamento(){
		return new EquipamentoDAO();	
	}
	
	public static OrgaoDAO getOrgao(){
		return new OrgaoDAO();	
	}
	
	public static ChefiaDAO getChefia(){
		return new ChefiaDAO();	
	}
	
	public static ControleDAO getControleEstoque(){
		return new ControleDAO();	
	}
	
	public LogDAO getLogDAO(){
		return new LogDAO();
	}
}

/**
 * ESTA CLASSE É RESPONSAVEL POR COLETAR 
 * TODOS OS OBJECT DATA ACCESS DE CADA UM
 * DOS MODELOS DESCRITOS NO PACOTE MODEL
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

    public TipoEquipamentoDAO getTipoEquipamento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

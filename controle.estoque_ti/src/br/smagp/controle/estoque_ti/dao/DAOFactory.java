/**
 * CLASSE FACTORY RESPONSAVEL POR INSTANCIAR 
 * CADA UM DOS OS OBJECT DATA ACCESS DE CADA
 * UM DOS MODELOS DESCRITOS NO PACKAGE MODEL
 */

package br.smagp.controle.estoque_ti.dao;

/**
 *
 * @author AllexOnRails
 */
public class DAOFactory {
    public static TecnicoDAO getTecnico(){ //INSTANCIA UM NOVO TÉCNICO_DAO
        return new TecnicoDAO();	
    }
	
    public static EquipamentoDAO getEquipamento(){ //INSTANCIA UM NOVO EQUIPAMENTO_DAO
        return new EquipamentoDAO();	
    }

    public static OrgaoDAO getOrgao(){//INSTANCIA UM NOVO ORGAO_DAO
        return new OrgaoDAO();	
    }

    public static ChefiaDAO getChefia(){//INSTANCIA UMA NOVA CHEFIA_DAO
        return new ChefiaDAO();	
    }

    public static ControleDAO getControleEstoque(){//INSTANCIA UM NOVO CONTROLE_DAO
        return new ControleDAO();	
    }

    public TipoEquipamentoDAO getTipoEquipamento() {//INSTANCIA UM NOVO TIPO_EQUIPAMENTO_DAO 
        return new TipoEquipamentoDAO();
    }
}

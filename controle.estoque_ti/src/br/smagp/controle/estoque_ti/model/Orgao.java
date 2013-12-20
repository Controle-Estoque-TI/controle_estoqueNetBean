/**
 * CLASSE RESPONSAVEL POR DEFINIR 
 * OS ORGÃOS MUNICIPAIS DA PMCG
 */

package br.smagp.controle.estoque_ti.model;

/**
 *
 * @author AllexOnRails
 */
public class Orgao {

    /**
     * PARAMETROS PARA CADASTRAR UM ORGÃO NO SISTEMA
     */

    private int id;
    private String nome_orgao;

    public Orgao(){

    }

    public Orgao(String orgao) {
        this.nome_orgao = orgao;
    }

    public int getId() {
            return this.id;
    }

    public void setId(int id) {
            this.id = id;
    }

    public String getNomeOrgao() {
            return this.nome_orgao;
    }

    public void setNomeOrgao(String nome) {
            this.nome_orgao = nome;
    }
}
/**
 * CLASSE RESPONSAVEL POR REGISTRAR AS CHEFIAS DOS SETORES COM SEUS RESPECTIVOS
 * ORGAOS
 */
package br.smagp.controle.estoque_ti.model;

/**
 *
 * @author AllexOnRails
 */
public class Chefia extends Funcionario {
    private int id_orgao;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSetor() {
        return this.setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getOrgao() {
        return this.id_orgao;
    }

    public void setOrgao(int id) {
        this.id_orgao = id;
    }
}

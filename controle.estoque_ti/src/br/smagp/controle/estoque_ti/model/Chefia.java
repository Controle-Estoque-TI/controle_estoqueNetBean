/**
 * CLASSE RESPONSAVEL POR REGISTRAR 
 * AS CHEFIAS DOS SETORES COM SEUS 
 * RESPECTIVOS ORGAOS
 */
package br.smagp.controle.estoque_ti.model;

/**
 *
 * @author AllexOnRails
 */
public class Chefia extends Funcionario{
	
    private Orgao orgao;

    public String getNome()
    {
            return this.nome;
    }

    public void setNome(String nome)
    {
            this.nome = nome;
    }

    public String getMatricula()
    {
            return this.matricula;
    }

    public void setMatricula(String matricula)
    {
            this.matricula = matricula;
    }

    public String getSetor()
    {
            return this.setor;
    }

    public void setSetor(String setor)
    {
            this.setor = setor;
    }

    public Orgao getOrgao()
    {
            return this.orgao;
    }

    public void setOrgao(Orgao orgao)
    {
            this.orgao = orgao;
    }
}

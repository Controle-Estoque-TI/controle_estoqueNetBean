/**
 * CLASSE ABSTRATA PARA DESCREVER OS FUNCIONARIOS
 * RESPOSNSAVEIS PELO SISTEMA E PELO ESTOQUE 
 */

package br.smagp.controle.estoque_ti.model;

/**
 * @author AllexOnRails
 *
 */
public abstract class Funcionario extends CryptographyGeneric
{
	/**
	 * PARAMETROS PARA DESCREVER O FUNCIONÁRIO
	 */
	
	protected int _ID_;
	protected String nome;
	protected String matricula;
	protected String setor;
	
	/**
	 * 
	 * Getters & Setters
	 * 
	 */
	
	public int getID()
	{
		return this._ID_;
	}
	
	public void setID(int _ID_)
	{
		this._ID_ = _ID_;
	}
	
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
}
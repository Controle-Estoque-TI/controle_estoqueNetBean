/**
 * CLASSE PARA DESCREVER OS TECNICOS
 * RESPOSNSAVEIS PELO SISTEMA E PELO ESTOQUE
 * COMPOSTA PELA ABSTRAÇÃO DE FUNCIONARIO E 
 * PELO MODULO DE CRYPTOGRAFIA GENERICA. 
 */

package br.smagp.controle.estoque_ti.model;

import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author AllexOnRails
 */
public class Tecnico extends Funcionario {
    /**
    *  PARAMETROS DE FUNCIONARIO ESTAO SENDO 
    *  HERDADOS DA CLASSE ABSTRATA FUNCIONARIO
    *  A INTERFACE AUTENTICAVEL É RESPONSAVEL POR 
    *  ESBOÇAR O METODO AUTENTICA COM PARAMETRO SENHA 
    *  SENDO PASSADO POR REFERÊNCIA. O UNICO PARAMETRO 
    *  DENTRO DA CLASSE FUNCIONARIO É A SENHA PROPRIAMENTE DITA 
    */
	
    private static String password;
    private static String celular;
    
    /**
    * 
    * Getters & Setters
    * 
    **/
	
    public int getID()
    {
        return this.id;
    }

    public void setID(int _ID_)
    {
        this.id = _ID_;
    }

    public String getCelular()
    {
        return this.celular;
    }

    public void setCelular(String celular)
    {
        this.celular = celular;
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

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
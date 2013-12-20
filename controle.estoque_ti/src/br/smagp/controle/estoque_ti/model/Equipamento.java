/**
 * CLASSE PARA DESCREVER OS EQUIPAMENTOS QUE
 * ENTRAM NO ESTOQUE 
 */

package br.smagp.controle.estoque_ti.model;

import java.io.Serializable;

/**
 * @author AllexOnRails
 *
 */
public class Equipamento implements Serializable
{

    /**
     * PARAMETROS PARA DESCREVER O EQUIPAMENTO 
     */


    private int id;

    private String n_serie_equipamento;
    private String equipamento;
    private String tipo_equipamento;
    private String marca_equipamento;
    private String patrimonio;



    public int getId()
    {
            return this.id;
    }

    public void setId(int _id_)
    {
            this.id = _id_;
    }

    public String getNumero_Serie_Equipamento()
    {
            return this.n_serie_equipamento;
    }

    public void setNumero_Serie_Equipamento(String serie)
    {
            this.n_serie_equipamento = serie;
    }
    
    public String getEquipamento()
    {
            return this.equipamento;
    }

    public void setEquipamento(String equipamento)
    {
            this.equipamento = equipamento;
    }

    public String getTipo_Equipamento()
    {
            return this.tipo_equipamento;
    }

    public void setTipo_Equipamento(String tipo)
    {
            this.tipo_equipamento = tipo;
    }

    public String getMarca_Equipamento()
    {
            return this.marca_equipamento;
    }

    public void setMarca_Equipamento(String marca)
    {
            this.marca_equipamento = marca;
    }

    public String getPatrimonio()
    {
            return this.patrimonio;
    }

    public void setPatrimonio(String patrimonio)
    {
            this.patrimonio = patrimonio;
    }
}


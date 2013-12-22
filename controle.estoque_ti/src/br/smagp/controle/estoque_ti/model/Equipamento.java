/**
 * CLASSE PARA DESCREVER OS EQUIPAMENTOS QUE
 * ENTRAM NO ESTOQUE 
 */

package br.smagp.controle.estoque_ti.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
    
    /**
     * CONSTANTES QUE IRÃO AJUDAR A MONITORAR AS VARIAVEIS ACIMA
     */
    public static final String PROP_ID = "id";
    public static final String PROP_N_SERIE_EQUIPAMENTO = "n_serie_equipamento";
    public static final String PROP_EQUIPAMENTO = "equipamento";
    public static final String PROP_TIPO_EQUIPAMENTO = "tipo_equipamento";
    public static final String PROP_MARCA_EQUIPAMENTO = "marca_equipamento";
    public static final String PROP_PATRIMONIO = "patrimonio";

    

    /**
     * RETORNA O VALOR DE id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * SETA O VALOR DE id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange(PROP_ID, oldId, id); // ESTA PROPRIEDADE IRÁ MONITORAR A ALTERAÇÃO DE VALORES NA VARIAVÉL ID
        //O MESMO PROCEDIMENTO ACIMA SE APLICA AOS MÉTODOS ABAIXO
    }

    /**
     * RETORNA O VALOR DO NUMERO DE SÉRIE DO EQUIPPAMENTO
     *
     * @return the value of n_serie_equipamento
     */
    public String getN_serie_equipamento() {
        return n_serie_equipamento;
    }

    /**
     * SETA O VALOR DO NUMERO DE SERIE DO EQUIPAMENTO
     *
     * @param n_serie_equipamento new value of n_serie_equipamento
     */
    public void setN_serie_equipamento(String n_serie_equipamento) {
        String oldN_serie_equipamento = this.n_serie_equipamento;
        this.n_serie_equipamento = n_serie_equipamento;
        propertyChangeSupport.firePropertyChange(PROP_N_SERIE_EQUIPAMENTO, oldN_serie_equipamento, n_serie_equipamento);
    }


    /**
     * RETORNA O NOME DO EQUIPAMENTO
     *
     * @return the value of equipamento
     */
    public String getEquipamento() {
        return equipamento;
    }

    /**
     * SETA O EQUIPAMENTO
     *
     * @param equipamento new value of equipamento
     */
    public void setEquipamento(String equipamento) {
        String oldEquipamento = this.equipamento;
        this.equipamento = equipamento;
        propertyChangeSupport.firePropertyChange(PROP_EQUIPAMENTO, oldEquipamento, equipamento);
    }

    /**
     * RETORNA O TIPO DO EQUIPAMENTO
     *
     * @return the value of tipo_equipamento
     */
    public String getTipo_equipamento() {
        return tipo_equipamento;
    }

    /**
     * SETA O TIPO DO EQUIPAMENTO
     *
     * @param tipo_equipamento new value of tipo_equipamento
     */
    public void setTipo_equipamento(String tipo_equipamento) {
        String oldTipo_equipamento = this.tipo_equipamento;
        this.tipo_equipamento = tipo_equipamento;
        propertyChangeSupport.firePropertyChange(PROP_TIPO_EQUIPAMENTO, oldTipo_equipamento, tipo_equipamento);
    }

    /**
     * RETORNA A MARCA DO EQUIPAMENTO
     *
     * @return the value of marca_equipamento
     */
    public String getMarca_equipamento() {
        return marca_equipamento;
    }

    /**
     * SETA A MARCA DO EQUIPAMENTO
     *
     * @param marca_equipamento new value of marca_equipamento
     */
    public void setMarca_equipamento(String marca_equipamento) {
        String oldMarca_equipamento = this.marca_equipamento;
        this.marca_equipamento = marca_equipamento;
        propertyChangeSupport.firePropertyChange(PROP_MARCA_EQUIPAMENTO, oldMarca_equipamento, marca_equipamento);
    }

    /**
     * Get the value of patrimonio
     *
     * @return the value of patrimonio
     */
    public String getPatrimonio() {
        return patrimonio;
    }

    /**
     * Set the value of patrimonio
     *
     * @param patrimonio new value of patrimonio
     */
    public void setPatrimonio(String patrimonio) {
        String oldPatrimonio = this.patrimonio;
        this.patrimonio = patrimonio;
        propertyChangeSupport.firePropertyChange(PROP_PATRIMONIO, oldPatrimonio, patrimonio);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}


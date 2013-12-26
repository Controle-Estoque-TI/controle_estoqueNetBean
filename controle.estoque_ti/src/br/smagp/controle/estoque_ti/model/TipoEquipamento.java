/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.smagp.controle.estoque_ti.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 *
 * @author AllexOnRails
 */
public class TipoEquipamento {
    /**
     * PARAMETROS PARA DESCREVER O EQUIPAMENTO 
     */

    private int id;
    
    private String tipo_equipamento;
    
    public static final String PROP_ID = "id";
    public static final String PROP_TIPO_EQUIPAMENTO = "tipo_equipamento";

    /**
     * Get the value of tipo_equipamento
     *
     * @return the value of tipo_equipamento
     */
    public String getTipo_equipamento() {
        return tipo_equipamento;
    }

    /**
     * Set the value of tipo_equipamento
     *
     * @param tipo_equipamento new value of tipo_equipamento
     */
    public void setTipo_equipamento(String tipo_equipamento) {
        String oldTipo_equipamento = this.tipo_equipamento;
        this.tipo_equipamento = tipo_equipamento;
        propertyChangeSupport.firePropertyChange(PROP_TIPO_EQUIPAMENTO, oldTipo_equipamento, tipo_equipamento);
    }

    

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange(PROP_ID, oldId, id);
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
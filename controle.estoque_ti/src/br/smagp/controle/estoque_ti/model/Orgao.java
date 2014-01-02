/**
 * CLASSE RESPONSAVEL POR DEFINIR 
 * OS ORGÃOS MUNICIPAIS DA PMCG
 */

package br.smagp.controle.estoque_ti.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

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

    public static final String PROP_NOME_ORGAO = "nome_orgao";
    public static final String PROP_ID = "id";
    
    /**
     * Get the value of nome_orgao
     *
     * @return the value of nome_orgao
     */
    public String getNome_orgao() {
        return nome_orgao;
    }

    /**
     * Set the value of nome_orgao
     *
     * @param nome_orgao new value of nome_orgao
     */
    public void setNome_orgao(String nome_orgao) {
        String oldNome_orgao = this.nome_orgao;
        this.nome_orgao = nome_orgao;
        propertyChangeSupport.firePropertyChange(PROP_NOME_ORGAO, oldNome_orgao, nome_orgao);
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
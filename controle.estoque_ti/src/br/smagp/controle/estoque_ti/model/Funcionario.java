/**
 * CLASSE ABSTRATA PARA DESCREVER OS FUNCIONARIOS RESPOSNSAVEIS PELO SISTEMA E
 * PELO ESTOQUE
 */
package br.smagp.controle.estoque_ti.model;

import br.smagp.controle.estoque_ti.cryptonita.CryptographyGeneric;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author AllexOnRails
 *
 */
public abstract class Funcionario extends CryptographyGeneric {

    /**
     * PARAMETROS PARA DESCREVER O FUNCIONÁRIO
     */

    protected int id;

    protected String nome;

    protected String matricula;
    
    protected String setor;

    public static final String PROP_NOME = "nome";
    public static final String PROP_SETOR = "setor";
    public static final String PROP_MATRICULA = "matricula";

    /**
     * Get the value of setor
     *
     * @return the value of setor
     */
    public String getSetor() {
        return setor;
    }

    /**
     * Set the value of setor
     *
     * @param setor new value of setor
     */
    public void setSetor(String setor) {
        String oldSetor = this.setor;
        this.setor = setor;
        propertyChangeSupport.firePropertyChange(PROP_SETOR, oldSetor, setor);
    }

    /**
     * Get the value of matricula
     *
     * @return the value of matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Set the value of matricula
     *
     * @param matricula new value of matricula
     */
    public void setMatricula(String matricula) {
        String oldMatricula = this.matricula;
        this.matricula = matricula;
        propertyChangeSupport.firePropertyChange(PROP_MATRICULA, oldMatricula, matricula);
    }

    

    /**
     * Get the value of nome
     *
     * @return the value of nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Set the value of nome
     *
     * @param nome new value of nome
     */
    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, nome);
    }

    public static final String PROP_ID = "id";

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

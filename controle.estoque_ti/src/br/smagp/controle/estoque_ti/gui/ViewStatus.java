/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.smagp.controle.estoque_ti.gui;

import br.smagp.controle.estoque_ti.interfaces.JFrameStatus;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author AllexOnRails
 */
public class ViewStatus implements JFrameStatus{
    public boolean STATUS;
    
    public boolean getSTATUS(){ return this.STATUS; }
    
    public void setSTATUS(boolean status){
        this.STATUS = status;
    }
    
    @Override
    public boolean verificaStatus() {
        if(this.STATUS == true){
            JOptionPane.showMessageDialog(null, "Já se encontra um processo em execução.", "ERRO AO INSTANCIAR UMA NOVA JANELA" ,JOptionPane.ERROR_MESSAGE);
        }
        else{
            this.STATUS = false;
        }
        return this.STATUS;
    }
}
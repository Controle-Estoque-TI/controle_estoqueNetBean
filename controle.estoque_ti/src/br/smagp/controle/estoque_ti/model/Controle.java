/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.smagp.controle.estoque_ti.model;

import java.util.Date;
import java.io.Serializable;
import java.text.StringCharacterIterator;
import java.util.*;
import java.io.*;

/**
 *
 * @author AllexOnRails
 */
public class Controle {
	
    private Orgao orgao;
    private Chefia chefia;
    private Tecnico tecnico;
    private Equipamento equipamento;

    private String setor;
    private Date date;

    public Controle() {}

    public Controle(Tecnico tecnico, Orgao orgao, Equipamento equipamento , String setor, Chefia chefia) {
        this.tecnico = tecnico;
        this.orgao   = orgao;
        this.equipamento = equipamento;
        this.setor = setor;
        this.chefia = chefia;
    }

    public void verifica_numero_serie(String serie){
        if (this.equipamento.getNumero_Serie_Equipamento() == serie){
            System.out.println("O número de série informado Válido");
        }
        else{
            System.out.println("O número de série informado é inválido!");
        }
    }

    /**
     * 
     * Getters & Setters
     * 
     */

    public int getTecnico(){
        return this.tecnico.getID();
    }

    public int getOrgao(){
        return this.orgao.getId();
    }

    public int getEquipamento(){
        return this.equipamento.getId();
    }

    public int getChefia(){
        return this.chefia.getID();
    }

    public String getSetorOrgao(){
        return this.setor;
    }

    public void setSetorOrgao(String setor_orgao){
        this.setor = setor_orgao;
    }
}

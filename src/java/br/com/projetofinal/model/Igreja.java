/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofinal.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author maxim
 */
@Entity
public class Igreja implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idIgreja;
    private String nome;
    private String descricao;    
    public Igreja(){
        idIgreja=-1;
    }
    public long getIdIgreja() {
        return idIgreja;
    }

    public void setIdIgreja(long idIgreja) {
        this.idIgreja = idIgreja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

     
    @Override
    public String toString(){
        return nome;
    }
}

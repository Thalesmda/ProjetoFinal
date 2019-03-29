/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofinal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author maxim
 */
@Entity
public class Evento implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEvento;
    private String nome;
    private String descricao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    @OneToMany (fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "evento")
    private List<Pessoa> inscricoes;

    public Evento(){
        idEvento=-1;
    }
    public long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(long idEvento) {
        this.idEvento = idEvento;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }


    
    @Override
    public String toString(){
        return getNome();
        
    }

    public List<Pessoa> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Pessoa> inscricoes) {
        this.inscricoes = inscricoes;
    }
}

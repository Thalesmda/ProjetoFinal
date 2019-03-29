/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofinal.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author maxim
 */
@Entity
public class Inscricao implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idInscricao;
    
    @OneToOne
    private Evento evento;

    private Pessoa pessoa;
    
    public Inscricao(){
        idInscricao=-1;
    } 

    public long getIdInscricao() {
        return idInscricao;
    }

    public void setIdInscricao(long idInscricao) {
        this.idInscricao = idInscricao;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}

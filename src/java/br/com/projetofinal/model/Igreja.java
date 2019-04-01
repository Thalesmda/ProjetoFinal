/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofinal.model;

import java.io.Serializable;
import java.util.ArrayList;
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
   
    @OneToMany(mappedBy="igreja", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Pessoa> membros;
    
    public Igreja(){
        idIgreja=-1;
        membros= new ArrayList();
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

    public List<Pessoa> getMembros() {
        return membros;
    }

    public void setMembros(List<Pessoa> membros) {
        this.membros = membros;
    }

    public void adicionarMembro(Pessoa membro){
        membros.add(membro);
    }
    
    public void removerMembro(Pessoa membro){
        membros.remove(membro);
    }
}

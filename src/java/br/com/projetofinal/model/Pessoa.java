/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetofinal.model;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;
import javax.persistence.*;

/**
 *
 * @author maxim
 */
@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPessoa;

    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String genero;

    private boolean admin;

    @Temporal(value = TemporalType.DATE)
    private Date dataNascimento;

    @OneToOne
    private Igreja igreja;

    @Transient
    private boolean sessaoAtiva;

    @Transient
    private final String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ@!#$%&*";
    
    public Pessoa() {
        idPessoa = -1;
        admin = false;
        genero = "Masculino";
        senha = "";
    }

    public long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Igreja getIgreja() {
        return igreja;
    }

    public void setIgreja(Igreja igreja) {
        this.igreja = igreja;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = converterStringParaMD5(senha);
    }

    @Override
    public String toString() {
        return nome;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String gerarSenha() {
        String senha = "";
        for (int i = 0; i < 8; i++) {
            Random r = new Random();
            if (r.nextFloat() > 0.5f) {
                r = new Random();
                int index = (int) (letras.length() * r.nextFloat());
                char a = letras.charAt(index);
                r = new Random();
                String ch = String.valueOf(a);
                if (r.nextFloat() > 0.5f) {
                    ch = ch.toLowerCase();
                }
                senha = senha + ch;
            } else {
                int numero = (int) (100 * r.nextFloat());
                senha = senha + numero;
            }
        }
        return senha;

    }

    private String converterStringParaMD5(String valor) {
        MessageDigest mDigest;
        try {
            mDigest = MessageDigest.getInstance("MD5");
            byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();
            for (byte b : valorMD5) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public boolean isSessaoAtiva() {
        return sessaoAtiva;
    }

    public void setSessaoAtiva(boolean sessaoAtiva) {
        this.sessaoAtiva = sessaoAtiva;
    }
}

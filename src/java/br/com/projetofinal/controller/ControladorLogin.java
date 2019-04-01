/*
 * Copyright (C) 2019 Pablo Rangel <pablorangel at gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.projetofinal.controller;

import br.com.projetofinal.dao.LoginDAO;
import br.com.projetofinal.model.Pessoa;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * @brief Classe ControladorLogin controla os logins dos usuários.
 * @author Pablo Rangel <pablorangel at gmail.com>
 * @date 03/03/2019
 */
@ManagedBean
@SessionScoped
@Named(value = "controladorLogin")
public class ControladorLogin extends Controlador {

    private Pessoa login;
    private String perfil;
  

    public ControladorLogin() {
        login = new Pessoa();
    }

    public Pessoa getLogin() {
        return login;
    }

    public void setLogin(Pessoa login) {
        this.login = login;
    }

    public void efetuarLogin() {
        LoginDAO dao = new LoginDAO(login);
        if (dao.efetuarLogin()) {
            setAttribute("usuario", login);
            login.setSessaoAtiva(true);
            setMensagem("Usuário logado com sucesso.");
            login.setSenha("");
            if (login.isAdmin()){
                perfil = "/restricted/area_trabalho_admin?faces-redirect=true";
                
            }else{
                perfil = "/restricted/area_trabalho_usuario?faces-redirect=true";
            }
        } 
        else {
            login.setEmail("");
            login.setSenha("");
            login.setSessaoAtiva(false);
            perfil="";
            setAttribute("usuario", null);
            setMensagem("Erro ao efetuar login. Verifique seu nome de usuário e senha.");
            FacesContext.getCurrentInstance().validationFailed();
        }

    }
    
    public void efetuarLogout(){
        login.setEmail("");
        login.setSenha("");
        setAttribute("usuario", null);
        login.setSessaoAtiva(false);
        setMensagem("");
    }
    
    private ExternalContext currentExternalContext(){
         if (FacesContext.getCurrentInstance() == null){
             throw new RuntimeException("O FacesContext não pode ser chamado fora de uma requisição HTTP");
         }else{
             return FacesContext.getCurrentInstance().getExternalContext();
         }
    }

    public Object getAttribute(String nome) {
        return currentExternalContext().getSessionMap().get(nome);
    }

    public void setAttribute(String nome, Object valor) {
        currentExternalContext().getSessionMap().put(nome, valor);
    }
    
    public void encerrarSessao(){   
         currentExternalContext().invalidateSession();
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

}

/*
 * Copyright (C) 2018 Pablo Rangel <pablorangel@gmail.com>
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

import br.com.projetofinal.model.Pessoa;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @brief  Classe ControladorGerenciarLogin controlador do Caso de Uso "Gerenciar Usuário".
 * @author Pablo Rangel <pablorangel at gmail.com>
 * @date   03/03/2019
 */
@ManagedBean
@SessionScoped
@Named(value = "controladorGerenciarPessoa")
public class ControladorGerenciarPessoa extends ControladorGerenciar<Pessoa>{
   private String generoMasculino = "Masculino";
   private String generoFeminino = "Feminino";
   
   public ControladorGerenciarPessoa(){
       super(new Pessoa());
   }

    public String getGeneroMasculino() {
        return generoMasculino;
    }

    public String getGeneroFeminino() {
        return generoFeminino;
    }
   
    public void gerarSenha(){
        getModelo().gerarSenha();
        setMensagem("Senha gerada com sucesso: " + getModelo().getSenha());
    }

}

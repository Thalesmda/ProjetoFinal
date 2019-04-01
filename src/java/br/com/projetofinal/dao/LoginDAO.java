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

package br.com.projetofinal.dao;

import br.com.projetofinal.model.Pessoa;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @brief  Classe LoginDAO contém as consultas personalizadas para a classe de modelo Login.
 * @author Pablo Rangel <pablorangel at gmail.com>
 * @date   03/03/2019
 */
public class LoginDAO extends DAO<Pessoa>{
    
    public LoginDAO(Pessoa login){
        super(login);
    }
    
    public boolean efetuarLogin(){
        String sql = "Select PESSOA.idPessoa, PESSOA.nome, PESSOA.email, PESSOA.senha, PESSOA.genero, PESSOA.cpf, PESSOA.admin from PROJETOFINAL.PESSOA where PESSOA.email = '" + this.getObjetoModelo().getEmail() + "'";
        List lista = executarConsultaPersonalizada(sql);
        Iterator<HashMap> iterator = lista.iterator();
        while (iterator.hasNext()){
            HashMap dados = iterator.next();
            
            if ((dados.get("SENHA")).equals(this.getObjetoModelo().getSenha())){
                getObjetoModelo().setNome((String)dados.get("NOME"));
                getObjetoModelo().setEmail((String)dados.get("EMAIL"));
                getObjetoModelo().setGenero((String)dados.get("GENERO"));
                getObjetoModelo().setAdmin((boolean)dados.get("ADMIN"));
                return true;
            }
        }
        return false;
    }
}

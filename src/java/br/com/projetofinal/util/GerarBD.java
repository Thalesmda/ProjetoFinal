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
package br.com.projetofinal.util;

import br.com.projetofinal.dao.DAO;
import br.com.projetofinal.model.Pessoa;

/**
 * @brief  Classe utilitária para testes com o banco de dados e inclusão de registros essenciais.
 * @author Pablo Rangel <pablorangel at gmail.com>
 * @date   03/03/2019
 */
public class GerarBD {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setNome("Pablo");
        p.setCpf("11111");
        DAO<Pessoa> dao = new DAO(p);
        dao.inserir();
    }
}

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

import java.io.Serializable;

/**
 * @brief  Classe Controlador controlador genérico
 * @author Pablo Rangel <pablorangel at gmail.com>
 * @date   03/03/2019
 */
public abstract class Controlador implements Serializable{
    private String mensagem;

    /**
     * Log rudimentar do backend.
     * 
     * @return mensagem relativa ao resultado da operação efetuada no backend. 
     */
    public String getMensagem() {
        String msg = mensagem;
        setMensagem("");
        return msg;
    }

    /**
     * Log rudimentar do backend.
     * 
     * @param mensagem mensagem a ser gravada no log do backend relativo 
     * ao resultado da operação.
     */
    public void setMensagem(String mensagem) {
        System.out.println(mensagem);
        this.mensagem = mensagem;
    }
}

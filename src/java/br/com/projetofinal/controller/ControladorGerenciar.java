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


import br.com.projetofinal.dao.DAO;
import br.com.projetofinal.util.CalendarioFormatado;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @brief  Classe ControladorGerenciarPessoaJuridica controlador CRUD básico.
 * @author Pablo Rangel <pablorangel at gmail.com>
 * @date   03/03/2019
 * @param <T> tipo genérico para uma classe de Modelo.
 */
public abstract class ControladorGerenciar <T> extends Controlador{

    private T modelo;
   
    /**
     * Creates a new instance of Controller
     * @param modelo parametro genérico informado pelos construtores das classes filhas.
     */
    public ControladorGerenciar(T modelo) {
        this.modelo = modelo;
    }
    
    protected void inserir (){
        DAO <T> acesso = new DAO(modelo);
        acesso.inserir();
    }
    
    protected void alterar (){
        DAO <T> acesso = new DAO(modelo);
        acesso.alterar();
    }
    
    public void excluir (){
        DAO <T> acesso = new DAO(modelo);
        acesso.excluir();
    }
    
    public void buscar (int id){
        DAO <T> acesso = new DAO(modelo);
        acesso.buscar(id);
    }
    
    public List listar (){
        DAO <T> acesso = new DAO(modelo);
        return acesso.getList();
    }
    

    public T getModelo() {
        return modelo;
    }

    public void setModelo(T modelo){
        if (modelo == null){
            try {
                modelo = (T)this.modelo.getClass().newInstance();
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ControladorGerenciar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ControladorGerenciar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.modelo = modelo;
    }
    
public void salvar(int id){
        if (id == -1){
            inserir();
        }
        else{
            alterar();
        }
        setMensagem("Dados salvos com sucesso em " + CalendarioFormatado.getHoraAtual());
    }
    
}

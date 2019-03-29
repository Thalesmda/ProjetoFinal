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
package br.com.projetofinal.dao;

import br.com.projetofinal.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 * @brief  Classe DAO implementa um DAO (Data Access Object - Genérico) para conexão ao Banco de Dados.
 * @author Pablo Rangel <pablorangel at gmail.com>
 * @param <T> tipo genérico para as classes de modelo a serem persistidas.
 * @date   03/03/2019
 */
public class DAO<T> {

    private T objetoModelo;

    public DAO(T objetoModelo) {
        this.objetoModelo = objetoModelo;
    }

    public T getObjetoModelo() {
        return objetoModelo;
    }

    public void setObjetoModelo(T objetoModelo) {
        this.objetoModelo = objetoModelo;
    }

    public void inserir() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.getTransaction().begin();
            s.save(getObjetoModelo());
        } catch (HibernateException ex) {
            System.err.println("Erro ao incluir registro: " + ex);
            s.getTransaction().rollback();
        } finally {
            s.getTransaction().commit();
            s.flush();
            s.close();
        }
    }

    public void alterar() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.getTransaction().begin();
            s.update(getObjetoModelo());
        } catch (HibernateException ex) {
            System.err.println("Erro ao incluir alterar: " + ex);
            s.getTransaction().rollback();
        } finally {
            s.getTransaction().commit();
            s.flush();
            s.close();
        }
    }

    public void excluir() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.getTransaction().begin();
            s.delete(getObjetoModelo());
        } catch (HibernateException ex) {
            System.err.println("Erro ao excluir registro: " + ex);
            s.getTransaction().rollback();
        } finally {
            s.getTransaction().commit();
            s.flush();
            s.close();
        }
    }

    public List<T> getList() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<T> list = null;
        try {
            s.getTransaction().begin();
            Criteria criteria = s.createCriteria(getObjetoModelo().getClass());
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            list = criteria.list();

        } catch (HibernateException ex) {
            System.err.println("Erro ao buscar registros (lista): " + ex);
            s.getTransaction().rollback();
        } finally {
            s.getTransaction().commit();
            s.flush();
            s.close();
        }

        return list;
    }

    public void buscar(long id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        try {
            s.getTransaction().begin();
            s.load(getObjetoModelo(), id);
        } catch (HibernateException ex) {
            System.err.println("Erro ao buscar registro: " + ex);
            s.getTransaction().rollback();
        } finally {
            s.getTransaction().commit();
            s.flush();
            s.close();
        }
    }

    public List executarConsultaPersonalizada(String sql) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List data = null;
        try {
            s.getTransaction().begin();
            SQLQuery query = s.createSQLQuery(sql);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            data = query.list();
        } catch (HibernateException ex) {
            System.err.println("Erro ao buscar registros: " + ex);
            s.getTransaction().rollback();
        } finally {
            s.getTransaction().commit();
            s.flush();
            s.close();
        }
        return data;
    }
}


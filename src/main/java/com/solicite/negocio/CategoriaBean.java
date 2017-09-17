/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.negocio;

import com.solicite.entidade.Categoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class CategoriaBean implements ICategoria{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Categoria> consultar() {
        return em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.negocio;

import com.solicite.entidade.Estado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class EstadoBean implements IEstado{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Estado> consultar() {
        return em.createQuery("SELECT e FROM Estado e", Estado.class).getResultList();
    }
    
}

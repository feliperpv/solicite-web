/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.negocio;

import com.solicite.entidade.Prefeitura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario 
 */
@Stateless
public class PrefeituraBean implements IPrefeitura{
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Prefeitura> consultar() {
        return em.createQuery("SELECT p FROM Prefeitura p", Prefeitura.class).getResultList();
    }

    @Override
    public List<Prefeitura> consultarByEstado(Long idEstado) {
        return em.createQuery("SELECT p FROM Prefeitura p WHERE p.estado.idEstado = " + idEstado, Prefeitura.class).getResultList();
    }
    
    

   
}

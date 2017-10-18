/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.negocio;

import com.solicite.entidade.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class UsuarioBean implements IUsuario{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public Usuario consultar() {
        return em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario = 1", Usuario.class).getSingleResult();
    }
}

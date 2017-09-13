/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.negocio;

import com.solicite.entidade.Usuario;
import javax.ejb.Stateless;

/**
 *
 * @author Usuario
 */
@Stateless
public class UsuarioBean implements IUsuario{

    @Override
    public boolean criar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}

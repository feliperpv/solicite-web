/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.modelo;

import com.solicite.entidade.Usuario;
import com.solicite.negocio.IUsuario;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import lombok.Data;

/**
 *
 * @author Usuario
 */
@ManagedBean
@ViewScoped
@Data
public class UsuarioMB {
    
    private Usuario usuario;
    
    private IUsuario usuarioBean;
    
    public UsuarioMB(){
        super();
        usuario = new Usuario();
    }
    
}


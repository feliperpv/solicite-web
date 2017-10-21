/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.modelo;

import com.solicite.entidade.Usuario;
import com.solicite.negocio.IUsuario;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import lombok.Data;

/**
 *
 * @author Usuario
 */
@ManagedBean
@SessionScoped
@Data
public class UsuarioMB {
        
    @EJB
    private IUsuario usuarioBean;
    
    public Usuario consultar(){
        return usuarioBean.consultar();
    }
    
    public int diminutirPontos(int pontos){
        return  usuarioBean.diminuirPontos(pontos);
    }
    
}


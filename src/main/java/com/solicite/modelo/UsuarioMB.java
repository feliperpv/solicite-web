/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.modelo;

import com.solicite.entidade.Usuario;
import com.solicite.negocio.IUsuario;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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

    public void trocarPontos(int pontos){
        int pontosAtuais = usuarioBean.consultar().getPontos();
        FacesContext context = FacesContext.getCurrentInstance();
        
        if((pontosAtuais - pontos) >= 0){
            context.addMessage(null, new FacesMessage("Sucesso", "Produto adquirido!") );
            diminutirPontos(pontos);
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Pontos insuficientes", "Faça Solicitações!") );
        }
    }
}


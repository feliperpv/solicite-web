/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.modelo;

import com.solicite.entidade.Login;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import lombok.Data;

/**
 *
 * @author Usuario
 */
@ManagedBean
@Data
public class LoginMB {
       
    private Login lgn;
    
    public LoginMB(){
        super();
        lgn = new Login();
    }
    
    public String validar(){
        
        if(lgn.getLogin().equals("usuario") &&
                lgn.getSenha().equals("usuario123")){
            
            return "usuario";
        } else if(lgn.getLogin().equals("prefeitura") &&
                lgn.getSenha().equals("prefeitura123")){
            
            return "prefeitura";
        } else {            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO!", "Usuário ou senha inválidos"));
            return "";
        }
    }
}
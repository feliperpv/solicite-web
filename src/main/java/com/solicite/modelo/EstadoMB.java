/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.modelo;

import com.solicite.entidade.Estado;
import com.solicite.negocio.IEstado;
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
public class EstadoMB {
    
    private Estado prefeitura;
    
    private IEstado prefeituraBean;
    
    public EstadoMB(){
        super();
        prefeitura = new Estado();
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.modelo;

import com.solicite.entidade.Estado;
import com.solicite.negocio.IEstado;
import java.util.List;
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
    
    private String nome;
    
    private IEstado estadoBean;
    
    public List<Estado> consultar(){
        return estadoBean.consultar();
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.modelo;

import com.solicite.entidade.Prefeitura;
import com.solicite.negocio.IEstado;
import com.solicite.negocio.IPrefeitura;
import java.util.List;
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
public class PrefeituraMB {
    
    private Prefeitura prefeitura;
    
    @EJB
    private IPrefeitura prefeituraBean;
    private List<Prefeitura> prefeituras;
    
    @EJB
    private IEstado estadoBean;
    private Long idEstado;
    
    public PrefeituraMB(){
        super();
        prefeitura = new Prefeitura();
    }
    
    public List<Prefeitura> consultar(){
        return prefeituraBean.consultar();
    }
    
    public List<Prefeitura> consultarByEstado(){
        
        if (idEstado != null && idEstado != 0) {
            prefeituras = this.prefeituraBean.consultarByEstado(idEstado);
        } 
        
        return prefeituras;
    }
}


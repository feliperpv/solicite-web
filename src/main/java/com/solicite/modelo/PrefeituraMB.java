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
       
    @EJB
    private IPrefeitura prefeituraBean;
    
    @EJB
    private IEstado estadoBean;
    private Long idEstado;
    
    public List<Prefeitura> consultar(){
        return prefeituraBean.consultar();
    }
    
    public List<Prefeitura> consultarByEstado(Long idEstado){
        return prefeituraBean.consultarByEstado(idEstado);
    }
}


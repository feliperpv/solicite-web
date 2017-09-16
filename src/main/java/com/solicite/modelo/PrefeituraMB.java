/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.modelo;

import com.solicite.entidade.Prefeitura;
import com.solicite.negocio.IPrefeitura;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Usuario
 */
@ManagedBean
@ViewScoped
public class PrefeituraMB {
    
    private Prefeitura prefeitura;
    
    @EJB
    private IPrefeitura prefeituraBean;
    
    public PrefeituraMB(){
        super();
        prefeitura = new Prefeitura();
    }
    
}


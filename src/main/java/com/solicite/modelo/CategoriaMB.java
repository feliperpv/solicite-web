/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.modelo;

import com.solicite.entidade.Categoria;
import com.solicite.negocio.ICategoria;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import lombok.Data;

@ManagedBean
@SessionScoped
@Data
public class CategoriaMB {
    
    private Categoria categoria;
    
    @EJB
    private ICategoria categoriaBean;
    
    public CategoriaMB(){
        super();
        categoria = new Categoria();
    }
       
}

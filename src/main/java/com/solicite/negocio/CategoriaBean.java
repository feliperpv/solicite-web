/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.negocio;

import com.solicite.entidade.Categoria;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Usuario
 */
@Stateless
public class CategoriaBean implements ICategoria{

    @Override
    public List<Categoria> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

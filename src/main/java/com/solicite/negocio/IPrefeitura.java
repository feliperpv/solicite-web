/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.negocio;

import com.solicite.entidade.Prefeitura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface IPrefeitura {
    
    List<Prefeitura> consultar();
    List<Prefeitura> consultarByEstado(Long idEstado);
    
}

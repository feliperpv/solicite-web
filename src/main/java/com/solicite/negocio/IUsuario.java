/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.negocio;

import javax.ejb.Local;
import com.solicite.entidade.Usuario;
import java.util.List;

/**
 *
 * @author Usuario
 */
@Local
public interface IUsuario {
    
    public Usuario consultar();
    public int diminuirPontos(int pontos);
    public int aumentarPontos(int pontos);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.negocio;

import com.solicite.entidade.Solicitacao;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Usuario
 */
@Local
public interface ISolicitacao {
    
    boolean persistir(Solicitacao solicitacao);
    public void criar(String endereço, String descrição, Long idCategoria, Long idPrefeitura, Long idUsuario);
    List<Solicitacao> consultar();
    
    //boolean alterar (Long id, String novaDescricao);
    //boolean deletar (Long id);
    //List<Usuario> consultar();
}

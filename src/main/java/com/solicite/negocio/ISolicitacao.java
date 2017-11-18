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
    
    public void criar(String endereco, String descricao, String observacao, Long idCategoria, Long idPrefeitura, Long idUsuario);
    public List<Solicitacao> consultarByPrefeitura();
    public List<Solicitacao> consultarByUsuario();
    public List<Solicitacao> consultarAceitasByPrefeitura();
    public List<Solicitacao> consultarAceitasByUsuario();
    public int setFlagAceitar(Long idSolicitacao);
    public List<Solicitacao> consultarRecusadasByPrefeitura();
    public List<Solicitacao> consultarRecusadasByUsuario();
    public int setFlagRecusar(Long idSolicitacao);
}

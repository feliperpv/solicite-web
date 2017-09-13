/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.negocio;

import com.solicite.entidade.Solicitacao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Usuario
 */
@Stateless
public class SolicitacaoBean implements ISolicitacao{
    
    @PersistenceContext
    private EntityManager em;
    
    private ICategoria categoriaBean;
    
    private IPrefeitura prefeituraBean;
    
    private IUsuario usuarioBean;
            
    @Override
    public boolean persistir(Solicitacao solicitacao) {
        
        em.persist(solicitacao);
        return true;
        
    }

    @Override
    public void criar(String endereço, String descrição, Long idCategoria, Long idPrefeitura, Long idUsuario) {
        Solicitacao solicitacao = new Solicitacao();
        
        solicitacao.setEndereçoSolicitacao(endereço);
        solicitacao.setDescriçãoSolicitacao(descrição);
        
             
        throw new UnsupportedOperationException("Not supported yet.");
       
        }

    @Override
    public List<Solicitacao> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

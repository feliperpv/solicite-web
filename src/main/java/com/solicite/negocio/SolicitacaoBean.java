/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.negocio;

import com.solicite.entidade.Solicitacao;
import com.solicite.entidade.Categoria;
import com.solicite.entidade.Prefeitura;
import java.util.List;
import java.util.Optional;
import javax.ejb.EJB;
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
    
    @EJB
    private ICategoria categoriaBean;
    
    @EJB
    private IPrefeitura prefeituraBean;

    @Override
    public void criar(String endereco, String descricao, String observacao, Long idCategoria, Long idPrefeitura) {
        Prefeitura prefeitura = null;
        for (Prefeitura p: prefeituraBean.consultar()){
            if (p.getIdPrefeitura() == idPrefeitura)
                prefeitura = p;
        }
        
        Categoria categoria = null;
        for (Categoria c: categoriaBean.consultar()){
            if (c.getIdCategoria() == idCategoria)
                categoria = c;
        }
        
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setEnderecoSolicitacao(endereco);
        solicitacao.setDescricaoSolicitacao(descricao);
        solicitacao.setObservacaoSolicitacao(observacao);
        solicitacao.setPrefeitura(prefeitura);
        solicitacao.setCategoria(categoria);
                             
        em.persist(solicitacao);
    }

    @Override
    public List<Solicitacao> consultar() {
         return em.createQuery("SELECT s FROM Solicitacao s", Solicitacao.class).getResultList();
    }
}
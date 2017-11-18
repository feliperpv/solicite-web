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
import org.eclipse.persistence.jpa.jpql.parser.IdentificationVariableBNF;

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
        for (Prefeitura p: prefeituraBean.consultarPrefeituras()){
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
         return em.createQuery("SELECT s FROM Solicitacao s WHERE s.flagAtivo IS NULL AND s.prefeitura.idPrefeitura = 1", Solicitacao.class).getResultList();
    }
    
    @Override
    public int setFlagAceitar(Long idSolicitacao){
        return em.createQuery("UPDATE Solicitacao s SET s.flagAtivo = 1 WHERE s.idSolicitacao = " + idSolicitacao, Solicitacao.class).executeUpdate();
    }
    
    @Override
    public List<Solicitacao> consultarAceitas(){
        return em.createQuery("SELECT s FROM Solicitacao s WHERE s.flagAtivo = 1 AND s.prefeitura.idPrefeitura = 1", Solicitacao.class).getResultList();
    }
    
    @Override
    public List<Solicitacao> consultarRecusadas(){
        return em.createQuery("SELECT s FROM Solicitacao s WHERE s.flagAtivo = 0 AND s.prefeitura.idPrefeitura = 1", Solicitacao.class).getResultList();
    }
    
    @Override
    public int setFlagRecusar(Long idSolicitacao){
        return em.createQuery("UPDATE Solicitacao s SET s.flagAtivo = 0 WHERE s.idSolicitacao = " + idSolicitacao, Solicitacao.class).executeUpdate();
    }
}

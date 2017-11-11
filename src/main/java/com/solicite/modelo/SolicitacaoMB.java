/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.modelo;

import com.solicite.entidade.Categoria;
import com.solicite.entidade.Estado;
import com.solicite.entidade.Solicitacao;
import com.solicite.entidade.Prefeitura;
import com.solicite.negocio.ICategoria;
import com.solicite.negocio.IEstado;
import com.solicite.negocio.IPrefeitura;
import com.solicite.negocio.ISolicitacao;
import com.solicite.negocio.IUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import lombok.Data;

/**
 *
 * @author Usuario
 */
@ManagedBean
@SessionScoped
@Data
public class SolicitacaoMB {
    
    private Solicitacao solicitacao;
    
    @EJB
    private ISolicitacao solicitacaoBean;
    private String endereco;
    private String descricao;
    private String observacao;
    
    @EJB
    private IPrefeitura prefeituraBean;
    private Long idPrefeitura;
    private List<Prefeitura> prefeituras;
    
    @EJB
    private ICategoria categoriaBean;
    private Long idCategoria;
    
    @EJB
    private IEstado estadoBean;
    private Long idEstado;
    
    @EJB
    private IUsuario usuarioBean;
    
    public String criar(){
        
        try{
            solicitacaoBean.criar(
                    this.getEndereco(), 
                    this.getDescricao(),
                    this.getObservacao(),
                    this.getIdPrefeitura(),
                    this.getIdCategoria());
            return "criado";
        } catch (Exception e) {
            System.out.println(e);
            return "erro";
        }
    }
    
    public List<Solicitacao> consultarSolicitacoes(){
        return solicitacaoBean.consultar();
    }
    
    public List<Categoria> consultarCategorias() {
        return categoriaBean.consultar();
    }
    
    public List<Estado> consultarEstados(){
        return estadoBean.consultar();
    }

    public void onMudaEstado() {

        if (idEstado != null && idEstado != 0) {
            prefeituras = this.prefeituraBean.consultarByEstado(idEstado);
        } else {
            prefeituras = new ArrayList<>();
        }
    }
    
    public void mensagemSucesso() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Sucesso! Solicitação criada com sucesso!") );
    }
   
    public int setFlagAtivo(Long idSolicitacao){
        return solicitacaoBean.setFlagAceitar(idSolicitacao);
    }
    
    public List<Solicitacao> consultarSolicitacoesAceitas(){
        return solicitacaoBean.consultarAceitas();
    }

    public List<Solicitacao> consultarSolicitacoesRecusadas(){
        return solicitacaoBean.consultarRecusadas();
    }
        
    public int setFlagRecusar(Long idSolicitacao){
        return solicitacaoBean.setFlagRecusar(idSolicitacao);
    }
    
    public int aumentarPontuacao(int pontos){
        return usuarioBean.aumentarPontos(pontos);
    }
    
    public void aceitarSolicitacao(Long idSolicitacao, int pontos){
        this.aumentarPontuacao(pontos);
        this.setFlagAtivo(idSolicitacao);
    }
    
}


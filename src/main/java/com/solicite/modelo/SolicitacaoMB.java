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
    private Long idUsuario;
    
    public String criar(){
          
        try{
            solicitacaoBean.criar(
                    this.getEndereco(), 
                    this.getDescricao(),
                    this.getObservacao(),
                    this.getIdCategoria(),
                    this.getIdPrefeitura(),
                    this.getIdUsuario());
            
            mensagemSucesso();
            return "criado";
        } catch (Exception e) {
            System.out.println(e);
            return "erro";
        }
    }

    public List<Solicitacao> consultarSolicitacoesByPrefeitura(){
        return solicitacaoBean.consultarByPrefeitura();
    }
    
    public List<Solicitacao> consultarSolicitacoesByUsuario(){
        return solicitacaoBean.consultarByUsuario();
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
         
        context.addMessage(null, new FacesMessage("Solicitação criada com sucesso!") );
    }
   
    public int setFlagAtivo(Long idSolicitacao){
        return solicitacaoBean.setFlagAceitar(idSolicitacao);
    }
    
    public List<Solicitacao> consultarSolicitacoesAceitasByPrefeitura(){
        return solicitacaoBean.consultarAceitasByPrefeitura();
    }
    
    public List<Solicitacao> consultarSolicitacoesAceitasByUsuario(){
        return solicitacaoBean.consultarAceitasByUsuario();
    }

    public List<Solicitacao> consultarSolicitacoesRecusadasByPrefeitura(){
        return solicitacaoBean.consultarRecusadasByPrefeitura();
    }
    
    public List<Solicitacao> consultarSolicitacoesRecusadasByUsuario(){
        return solicitacaoBean.consultarRecusadasByUsuario();
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


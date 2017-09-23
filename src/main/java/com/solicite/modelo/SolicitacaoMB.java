/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.modelo;

import com.solicite.entidade.Categoria;
import com.solicite.entidade.Solicitacao;
import com.solicite.negocio.ICategoria;
import com.solicite.negocio.IPrefeitura;
import com.solicite.negocio.ISolicitacao;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
    
    @EJB
    private ICategoria categoriaBean;
    private Long idCategoria;
            
    public SolicitacaoMB(){
        super();
        solicitacao = new Solicitacao();
    }
    
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
    
    public List<Categoria> consultarCategorias() {
        return categoriaBean.consultar();
    }
}


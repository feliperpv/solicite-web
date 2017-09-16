/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.modelo;

import com.solicite.entidade.Solicitacao;
import com.solicite.negocio.ISolicitacao;
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
    
    private ISolicitacao solicitacaoBean;
    
    public SolicitacaoMB(){
        super();
        solicitacao = new Solicitacao();
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author Usuario
 */
@Entity
@Data
public class Prefeitura implements Serializable{
    
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idPrefeitura;
    
    private String nomePrefeitura;
    
    @ManyToOne (fetch = FetchType.EAGER)
    private Estado estado;
    
    public Prefeitura(){
        super();
    }
}

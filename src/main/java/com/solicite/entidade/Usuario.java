/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author Usuario
 */
@Entity
@Data
public class Usuario implements Serializable{
    
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    private String nomeUsuario;
    
    private String cpf;
    
    private int pontos;
    
    public Usuario(){
        super();
    }
    
}

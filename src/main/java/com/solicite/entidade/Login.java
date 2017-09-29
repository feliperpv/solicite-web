/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solicite.entidade;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Usuario
 */
@Data
public class Login implements Serializable {
    
    private String login;
    
    private String senha;
    
    public Login(){
        super();
    }
    
}

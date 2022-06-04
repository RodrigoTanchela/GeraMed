/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.model;

/**
 *
 * @author Pichau
 */
public class Medico extends Pessoa{
    
    private String crm;

    public Medico(String crm, String nome, String cep, String email) {
        super(nome, cep, email);
        this.crm = crm;
    }

    public String getCrm() {
        return crm;
    }
    
    
    
}

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
public class Paciente extends Pessoa{
    
    private String cpf;

    public Paciente(String cpf, String nome, String cep, String email) {
        super(nome, cep, email);
        this.cpf = cpf;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    
    
}

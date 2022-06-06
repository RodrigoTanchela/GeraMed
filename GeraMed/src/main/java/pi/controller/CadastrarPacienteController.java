/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.controller;

import java.awt.Color;
import pi.view.TelaCadastraPaciente;

/**
 *
 * @author Pichau
 */
public class CadastrarPacienteController {
    private TelaCadastraPaciente telaPaciente;
    private Color cor;
    
    public CadastrarPacienteController(){
        this.telaPaciente = new TelaCadastraPaciente();
        this.cor = new Color(151,202,178);
        
    }
    
     public void exibirTela(){
        telaPaciente.setTela();
        telaPaciente.exibirTela();
    }
}

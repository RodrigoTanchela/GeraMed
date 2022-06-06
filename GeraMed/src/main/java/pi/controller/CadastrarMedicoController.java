/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.controller;

import java.awt.Color;
import pi.view.TelaCadastraMedico;

/**
 *
 * @author Pichau
 */
public class CadastrarMedicoController {
    private TelaCadastraMedico telaMedico;
    private Color cor;
    
    public CadastrarMedicoController(){
        this.telaMedico = new TelaCadastraMedico();    
    }
    
    
     public void exibirTela(){
        /*telaMedico.getContentPane().setBackground(cor);
        telaMedico.getContentPane().setLocation(1,311);
        telaMedico.setLocationRelativeTo(null);*/
        telaMedico.setTela();
        telaMedico.exibirTela();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pi.dao.MedicoDAO;
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
        adicionarAcoes();
    }
    
    
     public void exibirTela(){
        /*telaMedico.getContentPane().setBackground(cor);
        telaMedico.getContentPane().setLocation(1,311);
        telaMedico.setLocationRelativeTo(null);*/
        telaMedico.setTela();
        telaMedico.exibirTela();
    }

    private void adicionarAcoes() {
                telaMedico.adicionarAcaoBtnSalvarMedico(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        salvarMedico();
                        System.out.println(MedicoDAO.getTodosMedico());
                    }

                    private void salvarMedico() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
        });
    }
    

}

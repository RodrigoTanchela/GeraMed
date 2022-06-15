/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.model;

import java.sql.Date;

/**
 *
 * @author Pichau
 */
public class Bula {
    private int id;
    private int numeroDoRegistro;
    private String categoriaRegulatoria;
    private Date periodoDePublicacao;
    private Date dataFinal;
    private Paciente paciente;
    private Medicamento medicamento; 

    public Bula(int numeroDoRegistro, String categoriaRegulatoria, Date periodoDePublicacao, Date dataFinal, Paciente paciente, Medicamento medicamento) {
        this.numeroDoRegistro = numeroDoRegistro;
        this.categoriaRegulatoria = categoriaRegulatoria;
        this.periodoDePublicacao = periodoDePublicacao;
        this.dataFinal = dataFinal;
        this.paciente = paciente;
        this.medicamento = medicamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
    public int getNumeroDoRegistro() {
        return numeroDoRegistro;
    }

    public String getCategoriaRegulatoria() {
        return categoriaRegulatoria;
    }

    public Date getPeriodoDePublicacao() {
        return periodoDePublicacao;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    @Override
    public String toString() {
        return "Bula{" + "numeroDoRegistro=" + numeroDoRegistro + ", categoriaRegulatoria=" + categoriaRegulatoria + ", periodoDePublicacao=" + periodoDePublicacao + ", dataFinal=" + dataFinal + ", paciente=" + paciente + ", medicamento=" + medicamento + '}';
    }
    
    
    
}

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
    

    public Bula(int numeroDoRegistro, String categoriaRegulatoria, Date periodoDePublicacao, Date dataFinal) {
        this.numeroDoRegistro = numeroDoRegistro;
        this.categoriaRegulatoria = categoriaRegulatoria;
        this.periodoDePublicacao = periodoDePublicacao;
        this.dataFinal = dataFinal;
        
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

    @Override
    public String toString() {
        return "Bula{" + "id=" + id + ", numeroDoRegistro=" + numeroDoRegistro + ", categoriaRegulatoria=" + categoriaRegulatoria + ", periodoDePublicacao=" + periodoDePublicacao + ", dataFinal=" + dataFinal + '}';
    }

    
    
    
    
}

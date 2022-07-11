/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.model;

/**
 *
 * @author Igor
 */
public class Medicamento {
    
    private String nome;
    private String numeroDeRegistro;
    private String dosagem;
    private String uso;
    private String conteudo;
    private String identificacao;

    public Medicamento(String nome, String numeroDeRegistro, String dosagem, String uso, String conteudo, String identificacao) {
        this.nome = nome;
        this.numeroDeRegistro = numeroDeRegistro;
        this.dosagem = dosagem;
        this.uso = uso;
        this.conteudo = conteudo;
        this.identificacao = identificacao;
    }

    public String getNome() {
        return nome;
    }

    public String getNumeroDeRegistro() {
        return numeroDeRegistro;
    }

    public String getDosagem() {
        return dosagem;
    }

    public String getUso() {
        return uso;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    @Override
    public String toString() {
        return "Medicamento{" + "nome=" + nome + ", numeroDeRegistro=" + numeroDeRegistro + ", dosagem=" + dosagem + ", uso=" + uso + ", conteudo=" + conteudo + ", identificacao=" + identificacao + '}';
    }
    
}

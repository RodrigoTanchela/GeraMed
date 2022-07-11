/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pi.model.Medicamento;

/**
 *
 * @author Pichau
 */
public class MedicamentoDAO {
    
    private static void createTable() {
        Connection connection = ConnectDB.getConnection();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS MEDICAMENTO"
                + "   (nome            VARCHAR(100) PRIMARY KEY AUTOINCREMENT,"
                + "   numeroDeRegistro            VARCHAR(50),"
                + "   dosagem          VARCHAR(50),"
                + "   uso              VARCHAR(20),"
                + "   conteudo         VARCHAR(20),"
                + "   identificacao    VARCHAR(50))";

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public static boolean salvarMedicamento(Medicamento medicamento){
        createTable();
        Connection connection = ConnectDB.getConnection();
        String sql = "INSERT INTO MEDICAMENTO (nome,numeroDeRegistro,dosagem,uso,conteudo,identificacao) VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, medicamento.getNome());
            pstmt.setString(2, medicamento.getNumeroDeRegistro());
            pstmt.setString(3, medicamento.getDosagem());
            pstmt.setString(4, medicamento.getUso());
            pstmt.setString(5, medicamento.getConteudo());
            pstmt.setString(6, medicamento.getIdentificacao());
            pstmt.execute();

            System.out.println("Medicamento cadastrado!");
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } 
    }
    
    public static boolean atualizarMedicamento(Medicamento medicamento){
        createTable();
        Connection connection = ConnectDB.getConnection();
        String sql = "UPDATE MEDICAMENTO SET ";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, medicamento.getNome());            
            pstmt.execute();

            System.out.println("Medicamento atualizado!");
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } 
    }
    
    
    public static List<Medicamento> getTodosMedicamento(){
        createTable();
        List<Medicamento> medicamentos = new ArrayList<>();
        Connection connection = ConnectDB.getConnection();
        String sql = "SELECT * FROM MEDICAMENTO";
        Statement stmt;

        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) { 
                String nome = resultado.getString("nome");
                String numeroDeRegistro = resultado.getString("numeroDeRegistro");
                String dosagem = resultado.getString("dosagem");
                String uso = resultado.getString("uso");
                String conteudo = resultado.getString("conteudo");
                String identificacao = resultado.getString("identificacao");
                
                Medicamento m = new Medicamento(nome, numeroDeRegistro, dosagem, uso, conteudo, identificacao);
                medicamentos.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
        return medicamentos;
    }
    
    public static boolean excluirMedicamento(String numeroDeRegistro){
        createTable();
        Connection connection = ConnectDB.getConnection();
        String sql = "DELETE FROM MEDICAMENTO WHERE numeroDeRegistro = ?";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, numeroDeRegistro);
            pstmt.execute();
            System.out.println("Medicamento deletado!");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}



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
import pi.model.Paciente;

/**
 *
 * @author Pichau
 */
public class PacienteDAO {
    
    private static void createTable() {
        Connection connection = ConnectDB.getConnection();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS PACIENTE"
                + "   (id            INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "   CPF            VARCHAR(20),"
                + "   nome           VARCHAR(100)"
                + "   CEP            VARCHAR(20),"
                + "   email            VARCHAR(100))";

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarPaciente(Paciente paciente){
        createTable();
        Connection connection = ConnectDB.getConnection();
        String sql = "INSERT INTO PACIENTE (CPF,nome,CEP,email) VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, paciente.getCpf());
            pstmt.setString(2, paciente.getNome());
            pstmt.setString(3, paciente.getCep());
            pstmt.setString(4, paciente.getEmail());
            pstmt.execute();

            System.out.println("Paciente cadastrado!");

            final ResultSet resultado = pstmt.getGeneratedKeys();
            if (resultado.next()) {
                int id = resultado.getInt(1);
                paciente.setId(id);
            }
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } 
    }
    
    public static boolean atualizarPaciente(Paciente paciente){
        createTable();
        Connection connection = ConnectDB.getConnection();
        String sql = "UPDATE PACIENTE SET email=? WHERE CPF=?";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, paciente.getEmail());            
            pstmt.setString(2, paciente.getCpf());
            pstmt.execute();

            System.out.println("Paciente atualizado!");
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } 
    }
    
    public static List<Paciente> getTodosPaciente(){
        createTable();
        List<Paciente> pacientes = new ArrayList<>();
        Connection connection = ConnectDB.getConnection();
        String sql = "SELECT * FROM PACIENTE";
        Statement stmt;

        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String cpf = resultado.getString("CPF");
                String nome = resultado.getString("nome");
                String cep = resultado.getString("CEP");
                String email = resultado.getString("email");
                
                Paciente p = new Paciente(nome, cpf, cep, email);
                p.setId(id);
                pacientes.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
        return pacientes;
    }
    
    public static boolean excluirPaciente(String CPF){
        createTable();
        Connection connection = ConnectDB.getConnection();
        String sql = "DELETE FROM PACIENTE WHERE CPF = ?";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, CPF);
            pstmt.execute();
            System.out.println("Paciente deletado!");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}

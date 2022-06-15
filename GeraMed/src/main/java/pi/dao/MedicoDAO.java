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
import pi.model.Medico;

/**
 *
 * @author Pichau
 */
public class MedicoDAO {
    
    private static void createTable() {
        Connection connection = ConnectDB.getConnection();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS MEDICO"
                + "   (id            INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "   CRM            VARCHAR(20),"
                + "   nome           VARCHAR(100),"
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
    
    public static boolean salvarMedico(Medico medico){
        createTable();
        Connection connection = ConnectDB.getConnection();
        String sql = "INSERT INTO MEDICO (CRM,nome,CEP,email) VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, medico.getCrm());
            pstmt.setString(2, medico.getNome());
            pstmt.setString(3, medico.getCep());
            pstmt.setString(4, medico.getEmail());
            pstmt.execute();

            System.out.println("Medico cadastrado!");

            final ResultSet resultado = pstmt.getGeneratedKeys();
            if (resultado.next()) {
                int id = resultado.getInt(1);
                medico.setId(id);
            }
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } 
    }
    
    public static boolean atualizarMedico(Medico medico){
        createTable();
        Connection connection = ConnectDB.getConnection();
        String sql = "UPDATE MEDICO SET email=? WHERE CPF=?";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, medico.getEmail());            
            pstmt.setString(2, medico.getCrm());
            pstmt.execute();

            System.out.println("Medico atualizado!");
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } 
    }
    
    public static List<Medico> getTodosMedico(){
        createTable();
        List<Medico> medicos = new ArrayList<>();
        Connection connection = ConnectDB.getConnection();
        String sql = "SELECT * FROM MEDICO";
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
                
                Medico med = new Medico(nome, cpf, cep, email);
                med.setId(id);
                medicos.add(med);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
        return medicos;
    }
    
    public static boolean excluirMedico(String CRM){
        createTable();
        Connection connection = ConnectDB.getConnection();
        String sql = "DELETE FROM MEDICO WHERE CRM = ?";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, CRM);
            pstmt.execute();
            System.out.println("Medico deletado!");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}

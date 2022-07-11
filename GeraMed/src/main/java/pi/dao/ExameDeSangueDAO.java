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
import pi.model.ExameDeSangue;

/**
 *
 * @author Pichau
 */
public class ExameDeSangueDAO {
    
    private static void createTable() {
        Connection connection = ConnectDB.getConnection();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS EXAMEDESANGUE"
                + "   (id            INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "   eritrocitos            VARCHAR(50),"
                + "   hemoglobina          VARCHAR(50),"
                + "   hematocrito              VARCHAR(50),"
                + "   VCM              DOUBLE,"
                + "   HCM              DOUBLE,"
                + "   CHCM             DOUBLE,"
                + "   leucocitos         VARCHAR(50),"
                + "   neutrofilos      INTEGER,"
                + "   plaquetas    VARCHAR(50))";

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarExame(ExameDeSangue exame){
        createTable();
        Connection connection = ConnectDB.getConnection();
        String sql = "INSERT INTO EXAMEDESANGUE (eritrocitos, hemoglobina, hematocrito, VCM, HCM, CHCM, leucocitos, neutrofilos, plaquetas) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, exame.getEritrocitos());
            pstmt.setString(2, exame.getHemoglobina());
            pstmt.setString(3, exame.getHematocrito());
            pstmt.setDouble(4, exame.getVCM());
            pstmt.setDouble(5, exame.getHCM());
            pstmt.setDouble(6, exame.getCHCM());
            pstmt.setString(7, exame.getLeucocitos());
            pstmt.setInt(8, exame.getNeutrofilos());
            pstmt.setString(3, exame.getPlaquetas());
            pstmt.execute();

            System.out.println("Exame de sangue cadastrado!");
            
            final ResultSet resultado = pstmt.getGeneratedKeys();
            if (resultado.next()) {
                int id = resultado.getInt(1);
                exame.setId(id);
            }
            
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } 
    }
    
    public static boolean atualizarExame(ExameDeSangue exame){
        createTable();
        Connection connection = ConnectDB.getConnection();
        String sql = "UPDATE EXAMEDESANGUE SET ";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, exame.getId());            
            pstmt.execute();

            System.out.println("Exame de sangue atualizado!");
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } 
    }
    
    public static List<ExameDeSangue> getTodosExames(){
        createTable();
        List<ExameDeSangue> exames = new ArrayList<>();
        Connection connection = ConnectDB.getConnection();
        String sql = "SELECT * FROM EXAMEDESANGUE";
        Statement stmt;

        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) { 
                int id = resultado.getInt("id");
                String eritrocitos = resultado.getString("eritrocitos");
                String hemoglobina = resultado.getString("hemoglobina");
                String hematocrito = resultado.getString("hematocrito");
                double VCM = resultado.getDouble("VCM");
                double HCM = resultado.getDouble("HCM");
                double CHCM = resultado.getDouble("CHCM");
                String leucocitos = resultado.getString("leucocitos");
                int neutrofilos = resultado.getInt("neutrofilos");
                String plaquetas = resultado.getString("plaquetas");
                
                ExameDeSangue e = new ExameDeSangue(eritrocitos, hemoglobina, hematocrito, VCM, HCM, CHCM, leucocitos, neutrofilos, plaquetas);
                e.setId(id);
                exames.add(e);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
        return exames;
    }
    
    public static boolean excluirExame(int id){
        createTable();
        Connection connection = ConnectDB.getConnection();
        String sql = "DELETE FROM EXAMEDESANGUE WHERE id = ?";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.execute();
            System.out.println("Exame deletado!");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
}

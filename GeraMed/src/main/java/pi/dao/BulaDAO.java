/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pi.model.Bula;
import pi.model.Paciente;

/**
 *
 * @author Pichau
 */
public class BulaDAO {
    
    
    private static void createTable() {
        Connection connection = ConnectDB.getConnection();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS BULA"
                + "   (id            INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "   numeroDoRegistro             INTEGER,"
                + "   categoriaRegulatoria         VARCHAR(100),"
                + "   periodoDePublicacao          DATE,"
                + "   dataFinal                    Date,"
                + "   paciente                     INTEGER,"
                + "   medicamento                  INTEGER)";

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarBula(Bula bula){
        createTable();
        Connection connection = ConnectDB.getConnection();
        String sql = "INSERT INTO BULA (numeroDoRegistro,CategoriaRegulatoria,PeriodoDePublicacao,dataFinal,paciente,medicamento) VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, bula.getNumeroDoRegistro());
            pstmt.setString(2, bula.getCategoriaRegulatoria());
            pstmt.setDate(3, bula.getPeriodoDePublicacao());
            pstmt.setDate(4, bula.getDataFinal());
            pstmt.setInt(5, bula.getPaciente().getId());
            pstmt.setDate(6, bula.getMedicamento().getId());
            pstmt.execute();

            System.out.println("Bula cadastrada!");

            final ResultSet resultado = pstmt.getGeneratedKeys();
            if (resultado.next()) {
                int id = resultado.getInt(1);
                bula.setId(id);
            }
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } 
    }
    
 public static List<Bula> getTodasBulas(){
        createTable();
        List<Bula> bulas = new ArrayList<>();
        Connection connection = ConnectDB.getConnection();
        String sql = "SELECT * FROM BULA";
        Statement stmt;

        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                int numeroDoRegistro = resultado.getInt("numeroDoRegistro");
                String categoriaRegulatoria = resultado.getString("categoriaRegulatoria");
                Date periodoDePublicacao = resultado.getDate("periodoDePublicacao");
                int Paciente = resultado.getInt("paciente");
                int medicamento = resultado.getInt("medicamento");
                
                Bula bula = new bula(int numeroDoRegistro, String categoriaRegulatoria, Date periodoDePublicacao, Date dataFinal, Paciente paciente, Medicamento medicamento);
                bula.setId(id);
                bulas.add(bula);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
        return bulas;
    }
 
 public static boolean excluirBula(String numeroDoRegistro){
        createTable();
        Connection connection = ConnectDB.getConnection();
        String sql = "DELETE FROM BULA WHERE numeroDoRegistro = ?";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, numeroDoRegistro);
            pstmt.execute();
            System.out.println("Bula deletada!");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
}

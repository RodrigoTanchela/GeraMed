/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pichau
 */
public class ConnectDB {
    
    
    private static Connection connection = null;
    
    private static String url = "jdbc:mysql://localhost:5432/Trabalho";
    private static String nome = "postgres";
    private static String senha = "postgres";
    
    
    public static Connection conectar() {
        try {
            connection = DriverManager.getConnection(url, nome, senha);
            System.out.println("Conectado ao database");    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    
    
    public static void descontecar(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static Connection getConnection(){
        if(connection == null)
            conectar();
        return connection;
    }
}

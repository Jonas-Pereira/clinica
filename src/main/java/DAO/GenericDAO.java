/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Jonas Pereira
 */
public class GenericDAO {
    
    public static void main(String[] args) {
    System.out.println("Funcionando!");
    }   
    // método para obter a conexão com o banco de dados
    public Connection getConnection() {
        
        try {
            Connection cn;
            cn = DriverManager.getConnection("jdbc:mysql://localhost/consultorio_medico", "root", " ");
            //"jdbc:mysql://localhost/consultorio_medico", "root", "root"
           
            return cn;
       
        } catch (SQLException ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        //cn.close();
        
        
    } // fim getConnection
    
    // Query normal
    public Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    } // fim getStatement
    
    // Query pré-compilada
    public PreparedStatement getprePreparedStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    } // fim getprePreparedStatement
    
    public ResultSet executeQuery(String query,Object... params) throws SQLException {
        PreparedStatement ps = getprePreparedStatement(query);
        
        for (int i=0; i <params.length; i++) {
            ps.setObject(1+i, params[i]);
        }
        return ps.executeQuery();    
    }
    // método que executa INSERT, DELETE e UPDATES no BD
    public int executeComand(String query,Object... params) throws SQLException {
        int result;
        try (PreparedStatement ps = getprePreparedStatement(query)) {
            for (int i=0; i <params.length; i++) {
                ps.setObject(1+i, params[i]);
            }   result = ps.executeUpdate();
        }
        return result;
    } // fim do executeComand
      
}

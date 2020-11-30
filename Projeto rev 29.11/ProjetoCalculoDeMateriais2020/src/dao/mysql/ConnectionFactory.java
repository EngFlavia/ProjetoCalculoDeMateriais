/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ngarcia
 */
public class ConnectionFactory {

    private static String url = "jdbc:mysql://localhost:3306/projeto?zeroDateTimeBehavior=converttonull&useTimezone=true&serverTimezone=UTC";
    
    private static String usuario = "root";
    private static String senha = "usbw";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

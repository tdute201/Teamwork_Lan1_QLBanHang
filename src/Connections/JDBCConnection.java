/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author thien
 */
public class JDBCConnection {
    public static Connection getJDBCConnection() {
        final String url = "net.sourceforge.jtds.jdbc.Driver";
        final String dbUrl = "jdbc:jtds:sqlserver://DESKTOP-7J9JTIA:1433/teamwork1_qlbh;instance=SQLEXPRESS";
        
        try {
            Class.forName(url);
            return DriverManager.getConnection(dbUrl);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

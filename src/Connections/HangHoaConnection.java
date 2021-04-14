/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thien
 */
public class HangHoaConnection {
        static JDBCConnection con= new JDBCConnection();

    public static void delete(String idSP){
        Connection cn = con.getJDBCConnection();
        String sql = "delete from tblSanPham where idSP = ?";
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, idSP);
            int rs = pstm.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

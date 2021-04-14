/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

import Model.HangHoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public static HangHoa getHangHoa(String idSP){
        
        Connection cn =  con.getJDBCConnection();
        String sql ="select * from tblSanPham where idSP = ?";
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, idSP);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                HangHoa hh = new HangHoa();//tao doi tuong moi cua class user
                hh.setMaHang(rs.getString("idSP"));
                hh.setTenMatHang(rs.getString("tenSP"));
                hh.setNamSanXuat(rs.getString("namSX"));
                hh.setDonGian(rs.getString("donGia"));
                hh.setSoLuong(rs.getString("soLuong"));
                return hh;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;//tra ve list
    }
    public static void update(HangHoa sv){
        Connection cn = con.getJDBCConnection();
        String sql="update tblSanPham set tenSP = ?, namSX = ?, donGia = ?, soLuong =? where idSP = ?";
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, sv.getTenMatHang());
            pstm.setString(2, sv.getNamSanXuat());
            pstm.setString(3, sv.getDonGian());
            pstm.setString(4, sv.getSoLuong());
            pstm.setString(5, sv.getMaHang());

            int rs = pstm.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

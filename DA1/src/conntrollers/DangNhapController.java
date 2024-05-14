/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conntrollers;

import DAO.DBConnect;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DangNhapController {

    public boolean checkDangNhap(String username, String pass) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnect.getConnection();
            String sql = "select tenTaiKhoan, matKhau from TAIKHOAN where tenTaiKhoan=?,matKhau=? ";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DangNhapController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DangNhapController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}

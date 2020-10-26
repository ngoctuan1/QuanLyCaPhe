/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tt
 */
public class ChiTietHDDAO {
    MySQLConnect connect;
    
    ChiTietHDDAO() throws Exception
    {
        connect = new MySQLConnect("localhost", "root", "", "shopdb");
    }
    
    ArrayList docDSCTHD() throws Exception
    {
        ArrayList dscthd = new ArrayList<ChiTietHDDTO>();
        try
        {
            String qry = "SELECT * FROM TBLCHITIETHD";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next())
            {
                ChiTietHDDTO cthd = new ChiTietHDDTO();
                cthd.setMaHD(rs.getString(1));
                cthd.setMaSP(rs.getString(2));
                cthd.setSoLuong(rs.getInt(3));
                cthd.setDonGia(rs.getFloat(4));
                dscthd.add(cthd);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin ChiTietHD");
        }
        
        return dscthd;
    }
    
    ArrayList docCTHD(String maHD) throws Exception
    {
        ArrayList arr = new ArrayList<ChiTietHDDTO>();
        try
        {
            String qry = "SELECT * FROM TBLCHITIETHD WHERE MaHD = '" + maHD + "'";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next())
            {
                ChiTietHDDTO cthd = new ChiTietHDDTO();
                cthd.setMaHD(rs.getString(1));
                cthd.setMaSP(rs.getString(2));
                cthd.setSoLuong(rs.getInt(3));
                cthd.setDonGia(rs.getFloat(4));
                arr.add(cthd);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin ChiTietHD");
        }
        
        return arr;
    }
    
    void them(ChiTietHDDTO cthd) throws Exception
    {
        try
        {
            String qry = "INSERT INTO TBLCHITIETHD(MaHD, MaSP, SoLuong, DonGia) VALUES(";
            qry += "'" + cthd.getMaHD()+ "', ";
            qry += "'" + cthd.getMaSP()+ "', ";
            qry += "'" + cthd.getSoLuong()+ "', ";
            qry += "'" + cthd.getDonGia()+ "')";
      
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi thêm thông tin ChiTietHD");
        }
    }
    
    void xoa(String maHD,String maSP) throws Exception
    {
        try
        {
            String qry = "DELETE FROM TBLCHITIETHD WHERE MaHD = '" + maHD + "'";
                   qry += " AND MaSP = '"+ maSP +"'";
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin ChiTietHD");
        }
    }
    
    void sua(ChiTietHDDTO cthd, ChiTietHDDTO old) throws Exception
    {
        try
        {
            String qry = "UPDATE TBLCHITIETHD ";
            qry += "SET MaHD = '" + cthd.getMaHD()+ "', ";
            qry += "MaSP = '" + cthd.getMaSP()+ "', ";
            qry += "SoLuong = '" + cthd.getSoLuong()+ "', ";
            qry += "DonGia = '" + cthd.getDonGia()+ "'";
            qry += " WHERE ";
            qry += "MaHD = '" + old.getMaHD() + "'";
            qry += " AND MaSP = '" + old.getMaSP() + "'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin ChiTietHD");
        }
    }
}


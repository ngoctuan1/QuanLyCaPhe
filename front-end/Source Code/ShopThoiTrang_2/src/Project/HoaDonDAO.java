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
public class HoaDonDAO {
    MySQLConnect connect;
    
    HoaDonDAO() throws Exception
    {
        connect = new MySQLConnect("localhost", "root", "", "shopdb");
    }
    
    ArrayList docDSHD() throws Exception
    {
        ArrayList dshd = new ArrayList<HoaDonDTO>();
        try
        {
            String qry = "SELECT * FROM TBLHOADON";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next())
            {
                HoaDonDTO hd = new HoaDonDTO();
                hd.setMaHD(rs.getString(1));
                hd.setMaKH(rs.getString(2));
                hd.setMaNV(rs.getString(3));
                hd.setNgayHD(rs.getString(4));
                hd.setTongTien(rs.getFloat(5));
                hd.setMaKM((rs.getString(6) == null) ? "" : rs.getString(6));
                hd.setThanhTien(rs.getFloat(7));
                dshd.add(hd);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin HoaDon");
        }
        
        return dshd;
    }
    
    void them(HoaDonDTO hd) throws Exception
    {
        try
        {
            String qry = "INSERT INTO TBLHOADON(MaHD, MaKH, MaNV, NgayHD, TongTien, MaKM, ThanhTien) VALUES(";
            qry += "'" + hd.getMaHD() + "', ";
            qry += "'" + hd.getMaKH() + "', ";
            qry += "'" + hd.getMaNV() + "', ";
            qry += "'" + hd.getNgayHD() + "', ";
            qry += "'" + hd.getTongTien() + "', ";
            qry += hd.getMaKM().equals("") ? "NULL, " : ("'" + hd.getMaKM() + "', ");
            qry += "'" + hd.getThanhTien() + "')";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi thêm thông tin HoaDon");
        }
    }
    
    void xoa(String maHD) throws Exception
    {
        try
        {
            String qry = "DELETE FROM TBLHOADON WHERE MaHD = '" + maHD + "'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin HoaDon");
        }
    }
    
    void sua(HoaDonDTO hd, HoaDonDTO old) throws Exception
    {
        try
        {
            String qry = "UPDATE TBLHOADON ";
            qry += "SET MaHD = '" + hd.getMaHD() + "', ";
            qry += "MaKH = '" + hd.getMaKH() + "', ";
            qry += "MaNV = '" + hd.getMaNV() + "', ";
            qry += "NgayHD = '" + hd.getNgayHD() + "', ";
            qry += "TongTien = '" + hd.getTongTien() + "', ";
            qry += "MaKM = " + (hd.getMaKM().equals("") ? "NULL" : ("'" + hd.getMaKM() + "'")) + ", ";
            qry += "ThanhTien = '" + hd.getThanhTien() + "'";
            qry += " WHERE ";
            qry += "MaHD = '" + old.getMaHD() + "'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin HoaDon");
        }
    }
    
     String layMaxID() throws Exception
    {
        String ID = "HD100";
        try
        {
            String qry = "SELECT MAX(MaHD) FROM TBLHOADON";
            ResultSet rs = connect.executeQuery(qry);
            if(rs.next())
            {
                ID = rs.getString(1);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi lấy Max ID");
        }
        
        return ID;
    }
}

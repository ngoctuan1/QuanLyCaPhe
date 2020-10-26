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
public class KhuyenMaiDAO {
    MySQLConnect connect;
    
    KhuyenMaiDAO() throws Exception
    {
        connect = new MySQLConnect("localhost", "root", "", "shopdb");
    }
    
    ArrayList docDSKM() throws Exception
    {
        ArrayList dskm = new ArrayList<KhuyenMaiDTO>();
        try
        {
            String qry = "SELECT * FROM TBLKHUYENMAI";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next())
            {
                KhuyenMaiDTO km = new KhuyenMaiDTO();
                km.setMaKM(rs.getString(1));
                km.setTenKM(rs.getString(2));
                km.setGiaDHToiThieu(rs.getFloat(3));
                km.setNgayBatDau(rs.getString(4));
                km.setNgayKetThuc(rs.getString(5));
                km.setPhanTramKhuyenMai(rs.getFloat(6));
                dskm.add(km);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin KhuyenMai");
        }
        
        return dskm;
    }
    
    void them(KhuyenMaiDTO km) throws Exception
    {
        try
        {
            String qry = "INSERT INTO TBLKHUYENMAI(MaKM, TenKM, GiaDHToiThieu, NgayBatDau, NgayKetThuc, PhanTramKM) VALUES(";
            qry += "'" + km.getMaKM() + "', ";
            qry += "'" + km.getTenKM() + "', ";
            qry += "'" + km.getGiaDHToiThieu() + "', ";
            qry += "'" + km.getNgayBatDau() + "', ";
            qry += "'" + km.getNgayKetThuc() + "', ";
            qry += "'" + km.getPhanTramKhuyenMai() + "')";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi thêm thông tin KhuyenMai");
        }
    }
    
    void xoa(String maKM) throws Exception
    {
        try
        {
            String qry = "DELETE FROM TBLKHUYENMAI WHERE MaKM = '" + maKM + "'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin KhuyenMai");
        }
    }
    
    void sua(KhuyenMaiDTO km, KhuyenMaiDTO old) throws Exception
    {
        try
        {
            String qry = "UPDATE TBLKHUYENMAI ";
            qry += "SET MaKM = '" + km.getMaKM() + "', ";
            qry += "TenKM = '" + km.getTenKM() + "', ";
            qry += "GiaDHToiThieu = '" + km.getGiaDHToiThieu() + "', ";
            qry += "NgayBatDau = '" + km.getNgayBatDau() + "', ";
            qry += "NgayKetThuc = '" + km.getNgayKetThuc() + "', ";
            qry += "PhanTramKM = '" + km.getPhanTramKhuyenMai() + "'";
            qry += " WHERE ";
            qry += "MaKM = '" + old.getMaKM() + "'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin KhuyenMai");
        }
    }
    
    String layMaxID() throws Exception
    {
        String ID = "KM100";
        try
        {
            String qry = "SELECT MAX(MaKM) FROM TBLKHUYENMAI";
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

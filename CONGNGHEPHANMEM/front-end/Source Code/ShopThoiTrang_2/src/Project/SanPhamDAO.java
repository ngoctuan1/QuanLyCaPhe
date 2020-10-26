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
public class SanPhamDAO {
    MySQLConnect connect;
    
    SanPhamDAO() throws Exception
    {
        connect = new MySQLConnect("localhost", "root", "", "shopdb");
    }
    
    ArrayList docDSSP() throws Exception
    {
        ArrayList dssp = new ArrayList<SanPhamDTO>();
        try
        {
            String qry = "SELECT * FROM TBLSANPHAM";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next())
            {
                SanPhamDTO sp = new SanPhamDTO();
                sp.setMaSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                sp.setSoLuong(rs.getInt(3));
                sp.setDonGia(rs.getFloat(4));
                sp.setMaLoaiSP(rs.getString(5));
                sp.setMaNSX(rs.getString(6));
                dssp.add(sp);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin SanPham");
        }
        
        return dssp;
    }
    
    void them(SanPhamDTO sp) throws Exception
    {
        try
        {
            String qry = "INSERT INTO TBLSANPHAM(MaSP, TenSP, SoLuong, DonGia, MaLSP, MaNSX) VALUES(";
            qry += "'" + sp.getMaSP()+ "', ";
            qry += "'" + sp.getTenSP()+ "', ";
            qry += "'" + sp.getSoLuong()+ "', ";
            qry += "'" + sp.getDonGia()+ "', ";
            qry += "'" + sp.getMaLoaiSP()+ "',";
            qry += "'" + sp.getMaNSX()+ "')";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi thêm thông tin SanPham");
        }
    }
    
    void xoa(String maSP) throws Exception
    {
        try
        {
            String qry = "DELETE FROM TBLSANPHAM WHERE MaSP = '" + maSP + "'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin SanPham");
        }
    }
    
    void sua(SanPhamDTO sp, SanPhamDTO old) throws Exception
    {
        try
        {
            String qry = "UPDATE TBLSANPHAM ";
            qry += "SET MaSP = '" + sp.getMaSP()+ "', ";
            qry += "TenSP = '" + sp.getTenSP()+ "', ";
            qry += "SoLuong = '" + sp.getSoLuong()+ "', ";
            qry += "DonGia = '" + sp.getDonGia()+ "', ";
            qry += "MaLSP = '" + sp.getMaLoaiSP()+ "',";
            qry += "MaNSX = '" + sp.getMaNSX()+ "'";
            qry += " WHERE ";
            qry += "MaSP = '" + old.getMaSP() + "'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin SanPham");
        }
    }
    
    String layMaxID() throws Exception
    {
        String ID = "SP100";
        try
        {
            String qry = "SELECT MAX(MaSP) FROM TBLSANPHAM";
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

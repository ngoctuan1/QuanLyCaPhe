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
public class TaiKhoanDAO {
    MySQLConnect connect;
    
    TaiKhoanDAO() throws Exception
    {
        connect = new MySQLConnect("localhost", "root", "", "shopdb");
    }
    
    ArrayList docDSTK() throws Exception
    {
        ArrayList dstk = new ArrayList<TaiKhoanDTO>();
        try
        {
            String qry = "SELECT * FROM TBLTAIKHOAN";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next())
            {
                TaiKhoanDTO tk = new TaiKhoanDTO();
                tk.setMaNV(rs.getString(1));
                tk.setTenDangNhap(rs.getString(2));
                tk.setMatKhau(rs.getString(3));
                tk.setQuyen(rs.getString(4));
                dstk.add(tk);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin TaiKhoan");
        }
        
        return dstk;
    }
    
    void them(TaiKhoanDTO tk) throws Exception
    {
        try
        {
            String qry = "INSERT INTO TBLTAIKHOAN(MaNV, TenDangNhap, MatKhau, Quyen) VALUES(";
            qry += "'" + tk.getMaNV() + "', ";
            qry += "'" + tk.getTenDangNhap() + "', ";
            qry += "'" + tk.getMatKhau() + "', ";
            qry += "'" + tk.getQuyen() + "')";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi thêm thông tin TaiKhoan");
        }
    }
    
    void xoa(String maTK) throws Exception
    {
        try
        {
            String qry = "DELETE FROM TBLTAIKHOAN WHERE MaKM = '" + maTK + "'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin TaiKhoan");
        }
    }
    
    void sua(TaiKhoanDTO tk, TaiKhoanDTO old) throws Exception
    {
        try
        {
            String qry = "UPDATE TBLTAIKHOAN ";
            qry += "SET MaNV = '" + tk.getMaNV() + "', ";
            qry += "TenDangNhap = '" + tk.getTenDangNhap() + "', ";
            qry += "MatKhau = '" + tk.getMatKhau() + "', ";
            qry += "Quyen = '" + tk.getQuyen() + "'";
            qry += " WHERE ";
            qry += "MaNV = '" + old.getMaNV() + "'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin TaiKhoan");
        }
    }
    
    String layMaxID() throws Exception
    {
        String ID = "TK100";
        try
        {
            String qry = "SELECT MAX(MaLSP) FROM TBLTAIKHOAN";
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
    
    boolean dangNhapThanhCong(String tenDangNhap, String matKhau) throws Exception
    {
        try
        {
            String qry = "SELECT * FROM TBLTAIKHOAN WHERE ";
            qry += "binary TenDangNhap = '" + tenDangNhap + "' AND ";
            qry += "binary MatKhau = '" + matKhau + "'";
            
            ResultSet rs = connect.executeQuery(qry);
            if(rs.next())
                return true;
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin TaiKhoan");
        }
        return false;
    }
    
    String getQuyen(String tenDangNhap, String matKhau) throws Exception
    {
        try
        {
            String qry = "SELECT * FROM TBLTAIKHOAN WHERE ";
            qry += "binary TenDangNhap = '" + tenDangNhap + "' AND ";
            qry += "binary MatKhau = '" + matKhau + "'";
            
            ResultSet rs = connect.executeQuery(qry);
            if(rs.next())
                return rs.getString(4);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin TaiKhoan");
        }
        return null;
    }
}

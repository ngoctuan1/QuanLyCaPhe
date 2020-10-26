/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author kossp
 */
public class NhanVienDAO {
    MySQLConnect connect;
    public static String names;
    NhanVienDAO() throws Exception
    {
        connect = new MySQLConnect("localhost", "root", "", "shopdb");
    }    
        
        
    ArrayList docComboBoxMaNV() throws Exception{
        ArrayList comboBoxMaNV= new ArrayList<NhanVienDTO>();
        try{
            String qry="SELECT * FROM TBLNHANVIEN";
            ResultSet rs= connect.executeQuery(qry);
            while(rs.next()){
                NhanVienDTO nv= new NhanVienDTO();
                nv.setMaNV(rs.getString(1));     
                comboBoxMaNV.add(nv);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "lỗi đọc thông tin đọc combobox nhân viên");
        }
        return comboBoxMaNV;
    }    
    
    ArrayList docDSNV() throws Exception
    {
        ArrayList dsnv = new ArrayList<NhanVienDTO>();
        try
        {
            String qry = "SELECT * FROM TBLNHANVIEN";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next())
            {
                NhanVienDTO nv = new NhanVienDTO();
                nv.setMaNV(rs.getString(1));
                nv.setHo(rs.getString(2));
                nv.setTen(rs.getString(3));
                if(rs.getBoolean(4) == true)  
                    nv.setGioiTinh("Nam") ;
                else 
                    nv.setGioiTinh("Nữ");
                nv.setNgaySinh(rs.getString(5));
                nv.setDiaChi(rs.getString(6));
                nv.setLuong(rs.getFloat(7));
                dsnv.add(nv);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin NhanVien");
        }
        
        return dsnv;
    }
 
    void them(NhanVienDTO nv) throws Exception
    {
        try
        {
            String qry = "INSERT INTO TBLNHANVIEN(MaNV, Ho, Ten, GioiTinh, NgaySinh, DiaChi, Luong) VALUES(";
            qry += "'" + nv.getMaNV()+ "', ";
            qry += "'" + nv.getHo()+ "', ";
            qry += "'" + nv.getTen()+ "', ";
            qry += ((nv.getGioiTinh().equals("Nam")) ? "true" : "false") + ", ";
            qry += "'" + nv.getNgaySinh()+ "', ";
            qry += "'" + nv.getDiaChi()+ "', ";
            qry += "'" + nv.getLuong()+ "')";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi thêm thông tin NhanVien");
        }
    }   
    
    void xoa(String maNV) throws Exception
    {
        try
        {
            String qry = "DELETE FROM TBLNHANVIEN WHERE MaNV = '" + maNV + "'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin NhanVien");
        }
    }
    
    void sua(NhanVienDTO nv, NhanVienDTO old) throws Exception
    {
        try
        {
            String qry = "UPDATE TBLNHANVIEN ";
            qry += "SET MaNV = '" + nv.getMaNV()+ "', ";
            qry += "Ho = '" + nv.getHo()+ "', ";
            qry += "Ten = '" + nv.getTen()+ "', ";
            qry += "GioiTinh = " + ((nv.getGioiTinh().equals("Nam")) ? "true" : "false") + ", ";
            qry += "NgaySinh = '" + nv.getNgaySinh()+ "', ";
            qry += "DiaChi = '" + nv.getDiaChi()+ "', ";
            qry += "Luong = '" + nv.getLuong()+ "'";
            qry += " WHERE ";
            qry += "MaNV = '" + old.getMaNV()+ "'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin NhanVien");
        }
    }     
    
        String layMaxID() throws Exception
    {
        String ID = "NV100";
        try
        {
            String qry = "SELECT MAX(MaNV) FROM TBLNHANVIEN";
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

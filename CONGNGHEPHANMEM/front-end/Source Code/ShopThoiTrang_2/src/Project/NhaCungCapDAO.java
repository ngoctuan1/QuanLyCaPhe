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
 * @author kossp
 */
public class NhaCungCapDAO {
    MySQLConnect connect;
    
    NhaCungCapDAO() throws Exception
    {
        connect = new MySQLConnect("localhost", "root", "", "shopdb");
    }    
    
    ArrayList docComboBoxMaNCC() throws Exception{
        ArrayList comboBoxMaNCC= new ArrayList<NhaCungCapDTO>();
        try{
            String qry="SELECT * FROM TBLNHACUNGCAP";
            ResultSet rs= connect.executeQuery(qry);
            while(rs.next()){
                NhaCungCapDTO ncc= new NhaCungCapDTO();
                ncc.setMaNCC(rs.getString(1));     
                comboBoxMaNCC.add(ncc);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "lỗi đọc thông tin doc combobox nah cung cap");
        }
        return comboBoxMaNCC;
    }
        
    ArrayList docDSNCC() throws Exception
    {
        ArrayList dsncc = new ArrayList<NhaCungCapDTO>();
        try
        {
            String qry = "SELECT * FROM TBLNHACUNGCAP";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next())
            {
                NhaCungCapDTO ncc = new NhaCungCapDTO();
                ncc.setMaNCC(rs.getString(1));
                ncc.setTenNCC(rs.getString(2));
                ncc.setSoDT(rs.getString(3));
                ncc.setDiaChi(rs.getString(4));
                dsncc.add(ncc);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin NhaCungCap");
        }
        
        return dsncc;
    }

    void them(NhaCungCapDTO ncc) throws Exception
    {
        try
        {
            String qry = "INSERT INTO TBLNHACUNGCAP(MaNCC, TenNCC, SoDT, DiaChi) VALUES(";
            qry += "'" + ncc.getMaNCC()+ "', ";
            qry += "'" + ncc.getTenNCC()+ "', ";
            qry += "'" + ncc.getSoDT()+ "', ";
            qry += "'" + ncc.getDiaChi()+ "')";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi thêm thông tin NhaCungCap");
        }
    }    
    
    void xoa(String maNCC) throws Exception
    {
        try
        {
            String qry = "DELETE FROM TBLNHACUNGCAP WHERE MaNCC = '" + maNCC + "'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin NhaCungCap");
        }
    }    

    void sua(NhaCungCapDTO ncc, NhaCungCapDTO old) throws Exception
    {
        try
        {
            String qry = "UPDATE TBLNHACUNGCAP ";
            qry += "SET MaNCC = '" + ncc.getMaNCC()+ "', ";
            qry += "TenNCC = '" + ncc.getTenNCC()+ "', ";
            qry += "SoDT = '" + ncc.getSoDT()+ "', ";
            qry += "DiaChi = '" + ncc.getDiaChi()+ "'";
            qry += " WHERE ";
            qry += "MaNCC = '" + old.getMaNCC()+ "'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin NhaCungCap");
        }
    }

    String layMaxID() throws Exception
    {
        String ID = "NCC100";
        try
        {
            String qry = "SELECT MAX(MaNCC) FROM TBLNHACUNGCAP";
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

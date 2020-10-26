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
public class LoaiSPDAO {
    MySQLConnect connect;
    
    LoaiSPDAO() throws Exception
    {
        connect = new MySQLConnect("localhost", "root", "", "shopdb");
    }
    
    ArrayList docDSLSP() throws Exception
    {
        ArrayList dslsp = new ArrayList<LoaiSPDTO>();
        try
        {
            String qry = "SELECT * FROM TBLLOAISP";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next())
            {
                LoaiSPDTO lsp = new LoaiSPDTO();
                lsp.setMaLSP(rs.getString(1));
                lsp.setTenLSP(rs.getString(2));
                lsp.setLoaiTienTe(rs.getString(3));
                
                dslsp.add(lsp);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin LoaiSP");
        }
        
        return dslsp;
    }
    
    void them(LoaiSPDTO lsp) throws Exception
    {
        try
        {
            String qry = "INSERT INTO TBLLOAISP(MaLSP, TenLSP, LoaiTienTe) VALUES(";
            qry += "'" + lsp.getMaLSP() + "', ";
            qry += "'" + lsp.getTenLSP() + "', ";
            qry += "'" + lsp.getLoaiTienTe() + "')";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi thêm thông tin LoaiSP");
        }
    }
    
    void xoa(String maLSP) throws Exception
    {
        try
        {
            String qry = "DELETE FROM TBLLOAISP WHERE MaLSP = '" + maLSP + "'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin LoaiSP");
        }
    }
    
    void sua(LoaiSPDTO lsp, LoaiSPDTO old) throws Exception
    {
        try
        {
            String qry = "UPDATE TBLLOAISP ";
            qry += "SET MaLSP = '" + lsp.getMaLSP() + "', ";
            qry += "TenLSP = '" + lsp.getTenLSP() + "', ";
            qry += "LoaiTienTe = '" + lsp.getLoaiTienTe()+ "'";  
            qry += " WHERE ";
            qry += "MaLSP = '" + old.getMaLSP() + "'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin LoaiSP");
        }
    }
    
    String layMaxID() throws Exception
    {
        String ID = "LSP100";
        try
        {
            String qry = "SELECT MAX(MaLSP) FROM TBLLOAISP";
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

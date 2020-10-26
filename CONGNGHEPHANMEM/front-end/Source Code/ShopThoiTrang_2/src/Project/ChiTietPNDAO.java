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
public class ChiTietPNDAO {
    MySQLConnect connect;
    
    ChiTietPNDAO() throws Exception
    {
        connect = new MySQLConnect("localhost", "root", "", "shopdb");
    }    
    
    ArrayList docDSCTPN() throws Exception
    {
        ArrayList dsctpn = new ArrayList<ChiTietPNDTO>();
        try
        {
            String qry = "SELECT * FROM TBLCHITIETPN";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next())
            {
                ChiTietPNDTO ctpn = new ChiTietPNDTO();
                ctpn.setMaPN(rs.getString(1));
                ctpn.setMaSP(rs.getString(2));
                ctpn.setSoLuong(rs.getInt(3));
                ctpn.setDonGia(rs.getFloat(4));
                dsctpn.add(ctpn);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin ChiTietPN");
        }
        
        return dsctpn;
    }    
    
    ArrayList docCTPN(String maPN) throws Exception
    {
        ArrayList arr = new ArrayList<ChiTietPNDTO>();
        try
        {
            String qry = "SELECT * FROM TBLCHITIETPN WHERE MaPN = '" + maPN + "'";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next())
            {
                ChiTietPNDTO ctpn = new ChiTietPNDTO();
                ctpn.setMaPN(rs.getString(1));
                ctpn.setMaSP(rs.getString(2));
                ctpn.setSoLuong(rs.getInt(3));
                ctpn.setDonGia(rs.getFloat(4));
                arr.add(ctpn);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin ChiTietPN");
        }
        
        return arr;
    }
    
    void them(ChiTietPNDTO ctpn) throws Exception
    {
        try
        {
            String qry = "INSERT INTO TBLCHITIETPN(MaPN, MaSP, SoLuong, DonGia) VALUES(";
            qry += "'" + ctpn.getMaPN()+ "', ";
            qry += "'" + ctpn.getMaSP()+ "', ";
            qry += "'" + ctpn.getSoLuong()+ "', ";
            qry += "'" + ctpn.getDonGia()+ "')";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi thêm thông tin ChiTietPN");
        }
    }  
    
    void xoa(String maPN , String maSP) throws Exception
    {
        try
        {
            String qry = "DELETE FROM TBLCHITIETPN WHERE MaPN = '" + maPN + "'";
                   qry += " AND MaSP = '"+ maSP +"'";
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin ChiTietPN");
        }
    }
    
    void sua(ChiTietPNDTO ctpn, ChiTietPNDTO old) throws Exception
    {
        try
        {
            String qry = "UPDATE TBLCHITIETPN ";
            qry += "SET MaPN = '" + ctpn.getMaPN()+ "', ";
            qry += "MaSP = '" + ctpn.getMaSP()+ "', ";
            qry += "SoLuong = '" + ctpn.getSoLuong()+ "', ";
            qry += "DonGia = '" + ctpn.getDonGia()+ "'";
            qry += " WHERE ";
            qry += "MaPN = '" + old.getMaPN()+ "'";
            qry += " AND MASP = '" + old.getMaSP()+ "'";
            connect.executeUpdate(qry);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin ChiTietPN");
        }
    }      
}

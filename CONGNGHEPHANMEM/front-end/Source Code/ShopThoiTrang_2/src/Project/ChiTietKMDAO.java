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
 * @author LLOST
 */
public class ChiTietKMDAO {
    MySQLConnect connect;

    public ChiTietKMDAO() throws Exception{
        connect = new MySQLConnect("localhost", "root", "", "shopdb");
    }
    
    ArrayList docDSCTKM() throws Exception{
        ArrayList dsctkm= new ArrayList<ChiTietKMDTO>();
        try{
            String qry = "SELECT * FROM TBLCHITIETKM";
            ResultSet rs= connect.executeQuery(qry);
            while(rs.next()){
                ChiTietKMDTO ctkm=new ChiTietKMDTO();
                ctkm.setMaKM(rs.getString(1));
                ctkm.setMaSP(rs.getString(2));
                ctkm.setSoLuongToiThieu(rs.getInt(3));
                ctkm.setPhanTramKM(rs.getFloat(4));
                dsctkm.add(ctkm);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin ChiTietKM");
        }
        return dsctkm;
    }
    
    ArrayList docDSCTKM(String maKM) throws Exception
    {
        ArrayList dsctkm = new ArrayList<ChiTietKMDTO>();
        try
        {
            String qry = "SELECT * FROM TBLCHITIETKM WHERE MaKM = '"+maKM+"'";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next())
            {
                ChiTietKMDTO ctkm = new ChiTietKMDTO();
                ctkm.setMaKM(rs.getString(1));
                ctkm.setMaSP(rs.getString(2));
                ctkm.setSoLuongToiThieu(rs.getInt(3));
                ctkm.setPhanTramKM(rs.getFloat(4));
                dsctkm.add(ctkm);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin ChiTietKM");
        }
        
        return dsctkm;
    }
    
    void them(ChiTietKMDTO ctkm) throws Exception{
        try{
            String qry = "INSERT INTO TBLCHITIETKM(MaKM, MASP, SoLuongToiThieu, PhanTramKM) VALUES(";
            qry += "'"+ctkm.getMaKM()+"',";
            qry += "'"+ctkm.getMaSP()+"',";
            qry += "'"+ctkm.getSoLuongToiThieu()+"',";
            qry += "'"+ctkm.getPhanTramKM()+"')";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Lỗi thêm thông tin ChiTietKM");
        }
    }
    
    void xoa(String maKM, String maSP) throws Exception{
        try{
            String qry = "DELLETE FROM TBLCHITIETKM WHERE MaKM = '"+maKM+"'";
                   qry += " AND MaSP = '"+maSP+"'";
               
                   connect.executeUpdate(qry);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin ChiTietKM");
        }
    }
    
    void sua(ChiTietKMDTO ctkm, ChiTietKMDTO old) throws Exception{
        try{
            String qry ="UPDATE TBLCHITIETKM";
            qry += " SET MaKM = '"+ctkm.getMaKM()+"',";
            qry += " MaSP = '"+ctkm.getMaSP()+"',";
            qry += " SoLuongToiThieu = '"+ctkm.getSoLuongToiThieu()+"',";
            qry += " PhanTramKM = '"+ctkm.getPhanTramKM()+"' ";
            qry += " WHERE ";
            qry += " MaKM = '"+old.getMaKM()+"'";
            qry += " AND MaSP = '"+old.getMaSP()+"'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin ChiTietKM");
        }
    }

}

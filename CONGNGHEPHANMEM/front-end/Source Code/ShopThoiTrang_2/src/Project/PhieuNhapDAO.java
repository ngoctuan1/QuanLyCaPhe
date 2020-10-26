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
public class PhieuNhapDAO {
    MySQLConnect connect;

    public PhieuNhapDAO() throws Exception{
        connect = new MySQLConnect("localhost", "root", "", "shopdb");
    }
    
    ArrayList docDSPN() throws Exception{
        ArrayList dsPH= new ArrayList<PhieuNhapDTO>();
        try{
            String qry="SELECT * FROM TBLPHIEUNHAP";
            ResultSet rs= connect.executeQuery(qry);
            while(rs.next()){
                PhieuNhapDTO pn= new PhieuNhapDTO();
                pn.setMaPN(rs.getString(1));
                pn.setMaNV(rs.getString(2));
                pn.setMaNCC(rs.getString(3));
                pn.setNgayNhap(rs.getString(4));
                pn.setTongTien(rs.getFloat(5));
                
                dsPH.add(pn);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "lỗi đọc thông tin PhieuNhap");
        }
        return dsPH;
    }
    
        
    void them(PhieuNhapDTO pn) throws Exception{
        try{
            String qry = "INSERT INTO TBLPHIEUNHAP(MaPN,MaNV,MaNCC,NgayNhap,TongTien) VALUES (";
            qry += "'"+pn.getMaPN()+"',";
            qry += "'"+pn.getMaNV()+"',";
            qry += "'"+pn.getMaNCC()+"',";
            qry += "'"+pn.getNgayNhap()+"',";
            qry += "'"+pn.getTongTien()+"')";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "lỗi thêm thông tin PhieuNhap");
        }
    }
    
    void xoa(String maPN) throws Exception{
        try{
            String qry= "DELETE FROM TBLPHIEUNHAP WHERE MaPN = '"+maPN+"'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "lỗi xóa thông tin PhieuNhap");
        }
    }
    
    void sua(PhieuNhapDTO pn,PhieuNhapDTO old) throws Exception{
        try{
            String qry= "UPDATE TBLPHIEUNHAP";
            qry += " SET MaPN= '"+pn.getMaPN()+"',";
            qry += " MaNV= '"+pn.getMaNV()+"',";
            qry += " MaNCC= '"+pn.getMaNCC()+"',";
            qry += " NgayNhap= '"+pn.getNgayNhap()+"',";
            qry += " TongTien= '"+pn.getTongTien()+"' ";
            qry += " WHERE ";
            qry += " MaPN= '"+old.getMaPN()+"'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "lỗi sửa thông tin PhiepNhap");
        }
    }
    
        String layMaxID() throws Exception{
        String ID="PN100";
        try{
            String qry= "SELECT MAX(MaPN) FROM TBLPhieuNhap";
            ResultSet rs=connect.executeQuery(qry);
            if(rs.next()){
                ID= rs.getString(1);
            }
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Lỗi lấy Max ID");
        }
        return ID;
    }
}

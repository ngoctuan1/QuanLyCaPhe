package Project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Project.MySQLConnect;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author LLOST
 */
public class KhachHangDAO {
    MySQLConnect connect;

    public KhachHangDAO() throws Exception{
        connect = new MySQLConnect("localhost", "root", "", "shopdb");
    }
    
    ArrayList docDSKH() throws Exception{
        ArrayList dsKH=new ArrayList<KhachHangDTO>();
        try{
            String qry = "SELECT * FROM TBLKHACHHANG";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next()){
                KhachHangDTO kh=new KhachHangDTO();
                kh.setMaKH(rs.getString(1));
                kh.setHo(rs.getString(2));
                kh.setTen(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                kh.setSoDT(rs.getString(5));
                dsKH.add(kh);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "lỗi đọc thông tin KhachHang");
        }
        return dsKH;
    }
    
    void them(KhachHangDTO kh) throws Exception{
        try{
            String qry= "INSERT INTO TBLKHACHHANG(MaKH,Ho,Ten,DiaChi,SoDT) VALUES(";
            qry +="'"+kh.getMaKH()+"',";
            qry +="'"+kh.getHo()+"',";
            qry +="'"+kh.getTen()+"',";
            qry +="'"+kh.getDiaChi()+"',";
            qry +="'"+kh.getSoDT()+"')";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "lỗi thêm thông tin KhachHang");
        }
    }
    
    void xoa(String maKH) throws Exception{
        try{
            String qry = "DELETE FROM TBLKHACHHANG WHERE MAKH='"+maKH+"'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "lỗi xóa thông tin KhachHang");
        }
    }
    
    void sua(KhachHangDTO kh,KhachHangDTO old) throws Exception{
        try{
            String qry= "UPDATE TBLKHACHHANG";
            qry += " SET MaKH = '"+kh.getMaKH()+"',";
            qry += " Ho = '"+kh.getHo()+"',";
            qry += " Ten = '"+kh.getTen()+"',";
            qry += " DiaChi = '"+kh.getDiaChi()+"',";
            qry += " SoDT = '"+kh.getSoDT()+"' ";
            qry += " WHERE";
            qry += " MaKH = '"+old.getMaKH()+"'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "lỗi sửa thông tin KhachHang");
        }
    }
    
        String layMaxID() throws Exception{
        String ID= "KH100";
        try{
            String qry="SELECT MAX(MaKH) FROM TBLKhachHang";
            ResultSet rs= connect.executeQuery(qry);
            if(rs.next()){
                ID=rs.getString(1);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Lỗi lấy Max ID");
        }
        return ID;
    }
}

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
public class NhaSanXuatDAO {
    MySQLConnect connect;

    public NhaSanXuatDAO() throws Exception{
        connect = new MySQLConnect("localhost", "root", "", "shopdb");
    }
    
    ArrayList docDSNSX() throws Exception{
        ArrayList dsNSX= new ArrayList<NhaSanXuatDTO>();
        try{
            String qry = "SELECT * FROM TBLNHASANXUAT";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next()){
                NhaSanXuatDTO nsx=new NhaSanXuatDTO();
                nsx.setMaNSX(rs.getString(1));
                nsx.setTenNSX(rs.getString(2));
                nsx.setQuocGia(rs.getString(3));
                dsNSX.add(nsx);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "lỗi đọc thông tin NhaSanXuat");
        }
        return dsNSX;
    }
    
    void them(NhaSanXuatDTO nsx) throws Exception{
        try{
            String qry="INSERT INTO TBLNHASANXUAT(MaNSX,TenNSX,QuocGia) VALUES(";
            qry +="'"+nsx.getMaNSX()+"',";
            qry +="'"+nsx.getTenNSX()+"',";
            qry +="'"+nsx.getQuocGia()+"')";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "lỗi thêm thông tin NhaSanXuat");
        }
    }
    
    void xoa(String maNSX) throws Exception{
        try{
            String qry = "DELETE FROM TBLNHASANXUAT WHERE MaNSX = '"+maNSX+"'";
            
            connect.executeUpdate(qry);
        }
    
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "lỗi xóa thông tin NhaSanXuat");
        }
    }
    
    
    void sua(NhaSanXuatDTO nsx, NhaSanXuatDTO old) throws Exception{
        try{
            String qry = "UPDATE TBLNHASANXUAT";
            qry +=  " SET MaNSX = '"+nsx.getMaNSX()+"',";
            qry +=  " TenNSX = '"+nsx.getTenNSX()+"',";
            qry +=  " QuocGia = '"+nsx.getQuocGia()+"' ";
            qry +=  " WHERE";
            qry +=  " MaNSX = '"+old.maNSX+"'";
            
            connect.executeUpdate(qry);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "lỗi sửa thông tin NhaSanXuat");
        }
    }
    
    String layMaxID() throws Exception{
        String ID= "NSX100";
        try{
            String qry="SELECT MAX(MaNSX) FROM TBLNhaSanXuat";
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

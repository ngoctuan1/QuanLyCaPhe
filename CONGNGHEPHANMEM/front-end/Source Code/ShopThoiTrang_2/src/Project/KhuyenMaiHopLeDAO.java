/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tt
 */
public class KhuyenMaiHopLeDAO {
    MySQLConnect connect;
    
    KhuyenMaiHopLeDAO() throws Exception
    {
        connect = new MySQLConnect("localhost", "root", "", "shopdb");
    }
    
    ArrayList docDSKMHL() throws Exception
    {
        ArrayList dskmhl = new ArrayList<KhuyenMaiHopLeDTO>();
        try
        {
            String qry = "SELECT DISTINCT hd.MaHD, km.MaKM, km.TenKM " +
                         "FROM TBLHOADON hd, TBLKHUYENMAI km, TBLCHITIETHD cthd, TBLCHITIETKM ctkm " +
                         "WHERE hd.MaHD = cthd.MaHD AND km.MaKM = ctkm.MaKM AND "
                            + "(hd.NgayHD BETWEEN km.NgayBatDau AND km.NgayKetThuc) AND "
                            + "((cthd.MaSP = ctkm.MaSP AND cthd.SoLuong >= ctkm.SoLuongToiThieu) "
                            + "OR hd.TongTien >= km.GiaDHToiThieu)";
            ResultSet rs = connect.executeQuery(qry);
            while(rs.next())
            {
                KhuyenMaiHopLeDTO kmhl = new KhuyenMaiHopLeDTO();
                kmhl.setMaHD(rs.getString(1));
                kmhl.setMaKM(rs.getString(2));
                kmhl.setTenKM(rs.getString(3));
                
                dskmhl.add(kmhl);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin KhuyenMaiHopLe");
        }
        
        return dskmhl;
    }
    
}

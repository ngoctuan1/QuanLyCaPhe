/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.util.ArrayList;

/**
 *
 * @author tt
 */
public class ChiTietHDBUS {
    private static ArrayList<ChiTietHDDTO> dscthd;
    
    ChiTietHDBUS(){}

    public static ArrayList<ChiTietHDDTO> getDscthd() {
        return dscthd;
    }

    public static void setDscthd(ArrayList<ChiTietHDDTO> dscthd) {
        ChiTietHDBUS.dscthd = dscthd;
    }
    
    boolean kiemTraTrung(String maHD, String maSP)
    {
        for(ChiTietHDDTO cthd : dscthd)
        {
            if (cthd.getMaHD().equals(maHD) && cthd.getMaSP().equals(maSP) )
                return true;
        }
        return false;
    }
    
    boolean kiemTraTrung(String maHD, String maHDCu, String maSP, String maSPCu)
    {
        for(ChiTietHDDTO cthd : dscthd)
        {
            if( cthd.getMaHD().equals(maHD) && cthd.getMaSP().equals(maSP))
            {
                if( maHD.equals(maHDCu) && maSP.equals(maSPCu))
                    return false;
                else
                    return true;
            }
        }
        return false;
    }
    
    public int timIndex(String maHD, String maSP)
    {
        int i;
        for(i = 0; i < dscthd.size(); ++i)
        {
            if(maHD.equals(dscthd.get(i).getMaHD()) && maSP.equals(dscthd.get(i).getMaSP()))
                break;
        }
        return i;
    }
    
    public ChiTietHDDTO timCTHD(String maHD, String maSP)
    {
        for(ChiTietHDDTO item : dscthd)
        {
            if(item.getMaHD().equals(maHD) && item.getMaSP().equals(maSP))
                return item;
        }
        
        return null;
    }
    
    public float tinhTongTien(String maHD)
    {
        float tongTien = 0;
        
        for(ChiTietHDDTO item : dscthd)
        {
            if(item.getMaHD().equals(maHD))
                tongTien += item.getDonGia() * item.getSoLuong();
        }
        
        return tongTien;
    }
    
    public float tinhTongTien(String maHD, String maKM) throws Exception
    {
        float tongTien = 0;
        
        ArrayList<ChiTietKMDTO> dsspGiamGia = new ArrayList<>();
        ChiTietKMBUS ctkmBus = new ChiTietKMBUS();
        if(ChiTietKMBUS.getDsctkm() == null)
            ctkmBus.docDSCTKM();
        
        for(ChiTietKMDTO item : ChiTietKMBUS.getDsctkm())
        {
            if(item.getMaKM().equals(maKM))
                dsspGiamGia.add(item);
        }
        
        docDSCTHD();
        for(ChiTietHDDTO item : dscthd)
        {
            if(item.getMaHD().equals(maHD))
            {
                boolean flag = false;
                for(ChiTietKMDTO i : dsspGiamGia)
                {
                    if(item.getMaSP().equals(i.getMaSP()))
                    {
                        if(item.getSoLuong() >= i.getSoLuongToiThieu())
                            tongTien += item.getDonGia() * item.getSoLuong() * ((100 - i.getPhanTramKM()) / 100);
                        else
                            tongTien += item.getDonGia() * item.getSoLuong();
                        flag = true;
                        break;
                    }
                }
                if(flag == false)
                    tongTien += item.getDonGia() * item.getSoLuong();
            }
        }
        
        return tongTien;
    }
    
    void docDSCTHD() throws Exception
    {
        ChiTietHDDAO data = new ChiTietHDDAO();
        dscthd = new ArrayList<ChiTietHDDTO>();
        dscthd = data.docDSCTHD();
    }
    
    void docCTHD(String maHD) throws Exception
    {
        ChiTietHDDAO data = new ChiTietHDDAO();
        dscthd = new ArrayList<ChiTietHDDTO>();
        dscthd = data.docCTHD(maHD);
    }
    
    void them(ChiTietHDDTO cthd) throws Exception
    {
        ChiTietHDDAO data = new ChiTietHDDAO();
        data.them(cthd);
        
        dscthd.add(cthd);
    }
    
    void xoa(String maHD,String maSP) throws Exception
    {
        ChiTietHDDAO data = new ChiTietHDDAO();
        data.xoa(maHD,maSP);
        
        for(ChiTietHDDTO cthd : dscthd)
        {
            if(cthd.getMaHD().equals(maHD) && cthd.getMaSP().equals(maSP))
            {
                dscthd.remove(cthd);
                break;
            }
        }
    }
    
    void sua(ChiTietHDDTO cthd, ChiTietHDDTO old) throws Exception
    {
        ChiTietHDDAO data = new ChiTietHDDAO();
        data.sua(cthd, old);
        
        for(int i = 0; i < dscthd.size(); ++i)
        {
            if(dscthd.get(i).getMaHD().equals(old.getMaHD()) && dscthd.get(i).getMaSP().equals(old.getMaSP()))
            {
                dscthd.set(i,cthd);
                break;
            }
        }
    }
    
    ArrayList timKiem(String mucTimKiem, String duLieu)
    {
        ArrayList<ChiTietHDDTO> tempArr = new ArrayList<ChiTietHDDTO>();
        
        switch(mucTimKiem)
        {
            case "Mã HĐ":
                for(ChiTietHDDTO cthd : dscthd)
                {
                    if(cthd.getMaHD().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(cthd);
                }
                break;
                
            case "Mã SP":
                for(ChiTietHDDTO cthd : dscthd)
                {
                    if(cthd.getMaSP().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(cthd);
                }
                break;
                
            case "Số lượng":
                for(ChiTietHDDTO cthd : dscthd)
                {
                    if( Integer.toString(cthd.getSoLuong()).indexOf(duLieu) >= 0)
                        tempArr.add(cthd);
                }
                break;
                
            case "Đơn giá":
                for(ChiTietHDDTO cthd : dscthd)
                {
                    if( Float.toString(cthd.getDonGia()).indexOf(duLieu) >= 0)
                        tempArr.add(cthd);
                }
                break;
          
            default:
                break;
        }
        
        return tempArr;
    }
}
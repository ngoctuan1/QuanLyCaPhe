/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.util.ArrayList;

/**
 *
 * @author kossp
 */
public class ChiTietPNBUS {
private static ArrayList<ChiTietPNDTO> dsctpn;
    
    ChiTietPNBUS(){}

    public static ArrayList<ChiTietPNDTO> getDsctpn() {
        return dsctpn;
    }

    public static void setDsctpn(ArrayList<ChiTietPNDTO> dsctpn) {
        ChiTietPNBUS.dsctpn = dsctpn;
    }
    
    boolean kiemTraTrung(String maPN, String maSP)
    {
        for(ChiTietPNDTO ctpn : dsctpn)
        {
            if(ctpn.getMaPN().equals(maPN) && ctpn.getMaSP().equals(maSP))
                return true;
        }
        return false;
    }
 
    void docDSCTPN() throws Exception
    {
        ChiTietPNDAO data = new ChiTietPNDAO();
        dsctpn = new ArrayList<ChiTietPNDTO>();
        dsctpn = data.docDSCTPN();
    }
        
    void docCTPN(String maPN) throws Exception
    {
        ChiTietPNDAO data = new ChiTietPNDAO();
        dsctpn = new ArrayList<ChiTietPNDTO>();
        dsctpn = data.docCTPN(maPN);
    }
    
    boolean kiemTraTrung(String maPN, String maPNCu , String maSP, String maSPCu)
    {
        for(ChiTietPNDTO ctpn : dsctpn)
        {
            if(ctpn.getMaPN().equals(maPN) && ctpn.getMaSP().equals(maSP))
            {
                if(maPN.equals(maPNCu) && maSP.equals(maSPCu))
                    return false;
                else
                    return true;
            }
        }
        return false;
    }
    
    public int timIndex(String maPN ,String maSP)
    {
        int i;
        for(i = 0; i < dsctpn.size(); ++i)
        {
            if(maPN.equals(dsctpn.get(i).getMaPN()) && maSP.equals(dsctpn.get(i).getMaSP()))
                break;
        }
        return i;
    }   
    
    public ChiTietPNDTO timCTPN(String maPN, String maSP)
    {
        for(ChiTietPNDTO item : dsctpn)
        {
            if(item.getMaPN().equals(maPN) && item.getMaSP().equals(maSP))
                return item;
        }
        
        return null;
    }
    
    public float tinhTongTien(String maPN)
    {
        float tongTien = 0;
        
        for(ChiTietPNDTO item : dsctpn)
        {
            if(item.getMaPN().equals(maPN))
                tongTien += item.getDonGia() * item.getSoLuong();
        }
        
        return tongTien;
    }
    
    void them(ChiTietPNDTO ctpn) throws Exception
    {
        ChiTietPNDAO data = new ChiTietPNDAO();
        data.them(ctpn);
        
        dsctpn.add(ctpn);
    }
    
    void xoa(String maPN, String maSP) throws Exception
    {
        ChiTietPNDAO data = new ChiTietPNDAO();
        data.xoa(maPN,maSP);
        
        for(ChiTietPNDTO ctpn : dsctpn)
        {
            if(ctpn.getMaPN().equals(maPN) && ctpn.getMaSP().equals(maSP))
            {
                dsctpn.remove(ctpn);
                break;
            }
        }
    }
    
    void sua(ChiTietPNDTO ctpn, ChiTietPNDTO old) throws Exception
    {
        ChiTietPNDAO data = new ChiTietPNDAO();
        data.sua(ctpn, old);
        
        for(int i = 0; i < dsctpn.size(); ++i)
        {
            if(dsctpn.get(i).getMaPN().equals(old.getMaPN()) && dsctpn.get(i).getMaSP().equals(old.getMaSP()))
            {
                dsctpn.set(i,ctpn);
                break;
            }
        }
    }
    
    ArrayList timKiem(String mucTimKiem, String duLieu)
    {
        ArrayList<ChiTietPNDTO> tempArr = new ArrayList<ChiTietPNDTO>();
        
        switch(mucTimKiem)
        {
            case "Mã PN":
                for(ChiTietPNDTO ctpn : dsctpn)
                {
                    if(ctpn.getMaPN().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(ctpn);
                }
                break;
                
            case "Mã SP":
                for(ChiTietPNDTO ctpn : dsctpn)
                {
                    if(ctpn.getMaSP().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(ctpn);
                }
                break;
                
            case "Số lượng":
                for(ChiTietPNDTO ctpn : dsctpn)
                {
                    if(Integer.toString(ctpn.getSoLuong()).indexOf(duLieu) >= 0)
                        tempArr.add(ctpn);
                }
                break;
                
            case "Đơn giá":
                for(ChiTietPNDTO ctpn : dsctpn)
                {
                    if(Float.toString(ctpn.getDonGia()).indexOf(duLieu) >= 0)
                        tempArr.add(ctpn);
                }
                break;
            default:
                break;
        }
        
        return tempArr;
    }          
}

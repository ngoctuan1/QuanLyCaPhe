
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
public class HoaDonBUS {
    public static ArrayList<HoaDonDTO> dshd;
    
    HoaDonBUS(){}

    public static ArrayList<HoaDonDTO> getDshd() {
        return dshd;
    }

    public static void setDshd(ArrayList<HoaDonDTO> dshd) {
        HoaDonBUS.dshd = dshd;
    }
    
    String[] docComboBoxMaHD() throws Exception{
        docDSHD();
        String[] array = new String[dshd.size()];
        for(int i = 0; i < dshd.size(); i++)
            array[i] = dshd.get(i).getMaHD();
        if(array.length > 0)
            return array;
        return null;
    }
        
    public static int getDshdSize() throws Exception {
        if(dshd == null)
        {
            HoaDonDAO data = new HoaDonDAO();
            dshd = new ArrayList<HoaDonDTO>();
            dshd = data.docDSHD();
        } 
        int size = dshd.size();
        return size;
    }
    
    boolean kiemTraTrung(String maHD)
    {
        for(HoaDonDTO hd : dshd)
        {
            if(hd.getMaHD().equals(maHD))
                return true;
        }
        return false;
    }
    
    boolean kiemTraTrung(String maHD, String maHDCu)
    {
        for(HoaDonDTO hd : dshd)
        {
            if(hd.getMaHD().equals(maHD))
            {
                if(maHD.equals(maHDCu))
                    return false;
                else
                    return true;
            }
        }
        return false;
    }
    
    public int timIndex(String maHD)
    {
        int i;
        for(i = 0; i < dshd.size(); ++i)
        {
            if(maHD.equals(dshd.get(i).getMaHD()))
                break;
        }
        return i;
    }
    
    public HoaDonDTO timHD(String maHD)
    {
        for(HoaDonDTO item : dshd)
        {
            if(item.getMaHD().equals(maHD))
                return item;
        }
        
        return null;
    }
    
    public float tinhThanhTien(String maHD, Float tongTien)
    {
        return tongTien;
    }
    
    public float tinhThanhTien(String maHD, Float tongTien, String maKM)
    {
        float thanhTien = tongTien;
        
        KhuyenMaiBUS kmBus = new KhuyenMaiBUS();
        KhuyenMaiDTO km = kmBus.timKM(maKM);
        if(tongTien >= km.getGiaDHToiThieu())
            thanhTien *= ((100 - km.getPhanTramKhuyenMai()) / 100);
        
        return thanhTien;
    }
    
    void docDSHD() throws Exception
    {
        if(dshd == null)
        {
            HoaDonDAO data = new HoaDonDAO();
            dshd = new ArrayList<HoaDonDTO>();
            dshd = data.docDSHD();
        }
    }
    
    void them(HoaDonDTO hd) throws Exception
    {
        HoaDonDAO data = new HoaDonDAO();
        data.them(hd);
        
        dshd.add(hd);
    }
    
    void xoa(String maHD) throws Exception
    {
        HoaDonDAO data = new HoaDonDAO();
        data.xoa(maHD);
        
        for(HoaDonDTO hd : dshd)
        {
            if(hd.getMaHD().equals(maHD))
            {
                dshd.remove(hd);
                break;
            }
        }
    }
    
    void sua(HoaDonDTO hd, HoaDonDTO old) throws Exception
    {
        HoaDonDAO data = new HoaDonDAO();
        data.sua(hd, old);
        
        for(int i = 0; i < dshd.size(); ++i)
        {
            if(dshd.get(i).getMaHD().equals(old.getMaHD()))
            {
                dshd.set(i,hd);
                break;
            }
        }
    }
    
    String taoIdTuDong() throws Exception
    {
        HoaDonDAO data = new HoaDonDAO();
        String ID = data.layMaxID();
        String txt = ID.substring(0,2);
        int num = Integer.parseInt(ID.substring(2));
        ++num;
        
        String snum = Integer.toString(num);
        ID = txt + snum;
        
        return ID;
    }
    
    ArrayList timKiem(String mucTimKiem, String duLieu)
    {
        ArrayList<HoaDonDTO> tempArr = new ArrayList<HoaDonDTO>();
        
        switch(mucTimKiem)
        {
            case "Mã HĐ":
                for(HoaDonDTO hd : dshd)
                {
                    if(hd.getMaHD().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(hd);
                }
                break;
                
            case "Mã KH":
                for(HoaDonDTO hd : dshd)
                {
                    if(hd.getMaKH().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(hd);
                }
                break;
                
            case "Mã NV":
                for(HoaDonDTO hd : dshd)
                {
                    if(hd.getMaNV().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(hd);
                }
                break;
                
            case "Ngày HĐ":
                for(HoaDonDTO hd : dshd)
                {
                    if(hd.getNgayHD().indexOf(duLieu) >= 0)
                        tempArr.add(hd);
                }
                break;
                
            case "Tổng tiền":
                for(HoaDonDTO hd : dshd)
                {
                    if(Float.toString(hd.getTongTien()).indexOf(duLieu) >= 0)
                        tempArr.add(hd);
                }
                break;
                
            case "Mã KM":
                for(HoaDonDTO hd : dshd)
                {
                    if(hd.getMaKM().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(hd);
                }
                break;
                
            case "Thành tiền":
                for(HoaDonDTO hd : dshd)
                {
                    if(Float.toString(hd.getThanhTien()).indexOf(duLieu) >= 0)
                        tempArr.add(hd);
                }
                break;
                
            default:
                break;
        }
        
        return tempArr;
    }
}

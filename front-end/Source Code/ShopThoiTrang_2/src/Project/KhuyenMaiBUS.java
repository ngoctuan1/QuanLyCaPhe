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
public class KhuyenMaiBUS {
    private static ArrayList<KhuyenMaiDTO> dskm;
    
    KhuyenMaiBUS(){}

    public static ArrayList<KhuyenMaiDTO> getDskm() {
        return dskm;
    }

    public static void setDskm(ArrayList<KhuyenMaiDTO> dskm) {
        KhuyenMaiBUS.dskm = dskm;
    }
    
    String[] docComboBoxMaKM() throws Exception{
        docDSKM();
        String[] array = new String[dskm.size()];
        for(int i = 0; i < dskm.size(); i++)
            array[i] = dskm.get(i).getMaKM();
        if(array.length > 0)
            return array;
        return null;
    }
    
    public static int getDskmSize() throws Exception
    {
    
        if(dskm == null)
        {
            KhuyenMaiDAO data = new KhuyenMaiDAO();
            dskm = new ArrayList<KhuyenMaiDTO>();
            dskm = data.docDSKM();
        }
        int size = dskm.size();
        return size;
    }
    
    boolean kiemTraTrung(String maKM)
    {
        for(KhuyenMaiDTO km : dskm)
        {
            if(km.getMaKM().equals(maKM))
                return true;
        }
        return false;
    }
    
    boolean kiemTraTrung(String maKM, String maKMCu)
    {
        for(KhuyenMaiDTO km : dskm)
        {
            if(km.getMaKM().equals(maKM))
            {
                if(maKM.equals(maKMCu))
                    return false;
                else
                    return true;
            }
        }
        return false;
    }
    
    public int timIndex(String maKM)
    {
        int i;
        for(i = 0; i < dskm.size(); ++i)
        {
            if(maKM.equals(dskm.get(i).getMaKM()))
                break;
        }
        return i;
    }
    
    public KhuyenMaiDTO timKM(String maKM)
    {
        for(KhuyenMaiDTO item : dskm)
        {
            if(item.getMaKM().equals(maKM))
                return item;
        }
        
        return null;
    }
    
    void docDSKM() throws Exception
    {
        if(dskm == null)
        {
            KhuyenMaiDAO data = new KhuyenMaiDAO();
            dskm = new ArrayList<KhuyenMaiDTO>();
            dskm = data.docDSKM();
        }
    }
    
    void them(KhuyenMaiDTO km) throws Exception
    {
        KhuyenMaiDAO data = new KhuyenMaiDAO();
        data.them(km);
        
        dskm.add(km);
    }
    
    void xoa(String maKM) throws Exception
    {
        KhuyenMaiDAO data = new KhuyenMaiDAO();
        data.xoa(maKM);
        
        for(KhuyenMaiDTO km : dskm)
        {
            if(km.getMaKM().equals(maKM))
            {
                dskm.remove(km);
                break;
            }
        }
    }
    
    void sua(KhuyenMaiDTO km, KhuyenMaiDTO old) throws Exception
    {
        KhuyenMaiDAO data = new KhuyenMaiDAO();
        data.sua(km, old);
        
        for(int i = 0; i < dskm.size(); ++i)
        {
            if(dskm.get(i).getMaKM().equals(old.getMaKM()))
            {
                dskm.set(i,km);
                break;
            }
        }
    }
    
    String taoIdTuDong() throws Exception
    {
        KhuyenMaiDAO data = new KhuyenMaiDAO();
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
        ArrayList<KhuyenMaiDTO> tempArr = new ArrayList<KhuyenMaiDTO>();
        
        switch(mucTimKiem)
        {
            case "Mã KM":
                for(KhuyenMaiDTO km : dskm)
                {
                    if(km.getMaKM().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(km);
                }
                break;
                
            case "Tên KM":
                for(KhuyenMaiDTO km : dskm)
                {
                    if(km.getTenKM().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(km);
                }
                break;
                
            case "Giá ĐH tối thiểu":
                for(KhuyenMaiDTO km : dskm)
                {
                    if(Float.toString(km.getGiaDHToiThieu()).indexOf(duLieu) >= 0)
                        tempArr.add(km);
                }
                break;
                
            case "Ngày bắt đầu":
                for(KhuyenMaiDTO km : dskm)
                {
                    if(km.getNgayBatDau().indexOf(duLieu) >= 0)
                        tempArr.add(km);
                }
                break;
                
            case "Ngày kết thúc":
                for(KhuyenMaiDTO km : dskm)
                {
                    if(km.getNgayKetThuc().indexOf(duLieu) >= 0)
                        tempArr.add(km);
                }
                break;
                
            case "Phần trăm KM":
                for(KhuyenMaiDTO km : dskm)
                {
                    if(Float.toString(km.getPhanTramKhuyenMai()).indexOf(duLieu) >= 0)
                        tempArr.add(km);
                }
                break;
                
            default:
                break;
        }
        
        return tempArr;
    }
}

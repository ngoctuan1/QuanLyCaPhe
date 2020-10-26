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
public class NhanVienBUS {
private static ArrayList<NhanVienDTO> dsnv;
    
    NhanVienBUS(){}
    
        
    public static ArrayList<NhanVienDTO> getDsnv() {
        return dsnv;
    }

    public static void setDsnv(ArrayList<NhanVienDTO> dsnv) {
        NhanVienBUS.dsnv = dsnv;
    }
    
    public static int getDsnvSize() throws Exception
    {
        if(dsnv == null)
        {
            NhanVienDAO data = new NhanVienDAO();
            dsnv = new ArrayList<NhanVienDTO>();
            dsnv = data.docDSNV();
        }
        int size = dsnv.size();
        return size;
    }
    
    boolean kiemTraTrung(String maNV)
    {
        for(NhanVienDTO nv : dsnv)
        {
            if(nv.getMaNV().equals(maNV))
                return true;
        }
        return false;
    }
    
    boolean kiemTraTrung(String maNV, String maNVCu)
    {
        for(NhanVienDTO nv : dsnv)
        {
            if(nv.getMaNV().equals(maNV))
            {
                if(maNV.equals(maNVCu))
                    return false;
                else
                    return true;
            }
        }
        return false;
    }
    
    public int timIndex(String maNV)
    {
        int i;
        for(i = 0; i < dsnv.size(); ++i)
        {
            if(maNV.equals(dsnv.get(i).getMaNV()))
                break;
        }
        return i;
    }
    
    void docDSNV() throws Exception
    {
        if(dsnv == null)
        {
            NhanVienDAO data = new NhanVienDAO();
            dsnv = new ArrayList<NhanVienDTO>();
            dsnv = data.docDSNV();
        }
    }
    
    
    
    void them(NhanVienDTO nv) throws Exception
    {
        NhanVienDAO data = new NhanVienDAO();
        data.them(nv);
        
        dsnv.add(nv);
    }
    
    void xoa(String maNV) throws Exception
    {
        NhanVienDAO data = new NhanVienDAO();
        data.xoa(maNV);
        
        for(NhanVienDTO nv : dsnv)
        {
            if(nv.getMaNV().equals(maNV))
            {
                dsnv.remove(nv);
                break;
            }
        }
    }
    
    void sua(NhanVienDTO nv, NhanVienDTO old) throws Exception
    {
        NhanVienDAO data = new NhanVienDAO();
        data.sua(nv, old);
        
        for(int i = 0; i < dsnv.size(); ++i)
        {
            if(dsnv.get(i).getMaNV().equals(old.getMaNV()))
            {
                dsnv.set(i,nv);
                break;
            }
        }
    }
    
    String[] docComboBoxMaNV() throws Exception{
        docDSNV();
        String [] array = new String[dsnv.size()];
        for (int i = 0; i< dsnv.size(); i++)
          array[i] = dsnv.get(i).getMaNV();
        if(array.length > 0)
            return array;
        return null;
    }
    
    String taoIdTuDong() throws Exception
    {
        NhanVienDAO data = new NhanVienDAO();
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
        ArrayList<NhanVienDTO> tempArr = new ArrayList<NhanVienDTO>();
        
        switch(mucTimKiem)
        {
            case "Mã NV":
                for(NhanVienDTO nv : dsnv)
                {
                    if(nv.getMaNV().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(nv);
                }
                break;
                
            case "Họ":
                for(NhanVienDTO nv : dsnv)
                {
                    if(nv.getHo().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(nv);
                }
                break;
                
            case "Tên":
                for(NhanVienDTO nv : dsnv)
                {
                    if(nv.getTen().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(nv);
                }
                break;
                
            case "Giới tính":
                for(NhanVienDTO nv : dsnv)
                {
                    if(nv.getGioiTinh().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(nv);
                }
                break;
            case "Ngày sinh":
                for(NhanVienDTO nv : dsnv)
                {
                    if(nv.getNgaySinh().indexOf(duLieu) >= 0)
                        tempArr.add(nv);
                }
                break;
            case "Địa chỉ":
                for(NhanVienDTO nv : dsnv)
                {
                    if(nv.getDiaChi().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(nv);
                }
                break;
            case "Lương":
                for(NhanVienDTO nv : dsnv)
                {
                    if(Float.toString(nv.getLuong()).indexOf(duLieu) >= 0)
                        tempArr.add(nv);
                }
                break;    
            default:
                break;
        }
        
        return tempArr;
    }    
}

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

public class TaiKhoanBUS {
    private static ArrayList<TaiKhoanDTO> dstk;
    TaiKhoanBUS(){}

    public static ArrayList<TaiKhoanDTO> getDstk() {
        return dstk;
    }
    
    public static void setDstk(ArrayList<TaiKhoanDTO> dstk) {
        TaiKhoanBUS.dstk = dstk;
    }
    
    public static int getDstkSize() throws Exception
    {
         if(dstk == null)
        {
            TaiKhoanDAO data = new TaiKhoanDAO();
            dstk = new ArrayList<TaiKhoanDTO>();
            dstk = data.docDSTK();
        }
        int size = dstk.size();
        return size;
    }
    
    boolean kiemTraTrung(String maNV)
    {
        for(TaiKhoanDTO tk : dstk)
        {
            if(tk.getMaNV().equals(maNV))
                return true;
        }
        return false;
    }
    
    boolean kiemTraTrung(String maNV, String maNVCu)
    {
        for(TaiKhoanDTO tk : dstk)
        {
            if(tk.getMaNV().equals(maNV))
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
        for(i = 0; i < dstk.size(); ++i)
        {
            if(maNV.equals(dstk.get(i).getMaNV()))
                break;
        }
        return i;
    }
    
    void docDSTK() throws Exception
    {
        if(dstk == null)
        {
            TaiKhoanDAO data = new TaiKhoanDAO();
            dstk = new ArrayList<TaiKhoanDTO>();
            dstk = data.docDSTK();
        }
    }
    
    void them(TaiKhoanDTO tk) throws Exception
    {
        TaiKhoanDAO data = new TaiKhoanDAO();
        data.them(tk);
        
        dstk.add(tk);
    }
    
    void xoa(String maNV) throws Exception
    {
        TaiKhoanDAO data = new TaiKhoanDAO();
        data.xoa(maNV);
        
        for(TaiKhoanDTO tk : dstk)
        {
            if(tk.getMaNV().equals(maNV))
            {
                dstk.remove(tk);
                break;
            }
        }
    }
    
    void sua(TaiKhoanDTO tk, TaiKhoanDTO old) throws Exception
    {
        TaiKhoanDAO data = new TaiKhoanDAO();
        data.sua(tk, old);
        
        for(int i = 0; i < dstk.size(); ++i)
        {
            if(dstk.get(i).getMaNV().equals(old.getMaNV()))
            {
                dstk.set(i,tk);
                break;
            }
        }
    }
    
    String taoIdTuDong() throws Exception
    {
        TaiKhoanDAO data = new TaiKhoanDAO();
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
        ArrayList<TaiKhoanDTO> tempArr = new ArrayList<TaiKhoanDTO>();
        
        switch(mucTimKiem)
        {
            case "Mã NV":
                for(TaiKhoanDTO tk : dstk)
                {
                    if(tk.getMaNV().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(tk);
                }
                break;
                
            case "Tên đăng nhập":
                for(TaiKhoanDTO tk : dstk)
                {
                    if(tk.getTenDangNhap().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(tk);
                }
                break;
                
            case "Mật khẩu":
                for(TaiKhoanDTO tk : dstk)
                {
                    if(tk.getMatKhau().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(tk);
                }
                break;
                
            case "Quyền":
                for(TaiKhoanDTO tk : dstk)
                {
                    if(tk.getQuyen().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(tk);
                }
                break;
                
            default:
                break;
        }
        
        return tempArr;
    }
}

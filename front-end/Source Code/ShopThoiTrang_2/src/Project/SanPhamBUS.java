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
public class SanPhamBUS {
    private static ArrayList<SanPhamDTO> dssp;
    
    SanPhamBUS(){}

    public static ArrayList<SanPhamDTO> getDssp() {
        return dssp;
    }

    public static void setDssp(ArrayList<SanPhamDTO> dssp) {
        SanPhamBUS.dssp = dssp;
    }
    
    public static int getDsspSize() throws Exception
    {
         if(dssp == null)
        {
            SanPhamDAO data = new SanPhamDAO();
            dssp = new ArrayList<SanPhamDTO>();
            dssp = data.docDSSP();
        }
        int size = dssp.size();
        return size;
    }
    
    boolean kiemTraTrung(String maSP)
    {
        for(SanPhamDTO sp : dssp)
        {
            if(sp.getMaSP().equals(maSP))
                return true;
        }
        return false;
    }
    
    boolean kiemTraTrung(String maSP, String maSPCu)
    {
        for(SanPhamDTO sp : dssp)
        {
            if(sp.getMaSP().equals(maSP))
            {
                if(maSP.equals(maSPCu))
                    return false;
                else
                    return true;
            }
        }
        return false;
    }
    
    public int timIndex(String maSP)
    {
        int i;
        for(i = 0; i < dssp.size(); ++i)
        {
            if(maSP.equals(dssp.get(i).getMaSP()))
                break;
        }
        return i;
    }
    
    public SanPhamDTO timSP(String maSP)
    {
        for(SanPhamDTO item : dssp)
        {
            if(item.getMaSP().equals(maSP))
                return item;
        }
        
        return null;
    }
    
    public boolean laySP(String maSP, int soLuong) throws Exception
    {
        SanPhamDTO old = timSP(maSP);
        SanPhamDTO sp = old;
        if(soLuong <= old.getSoLuong())
        {
            sp.setSoLuong(old.getSoLuong() - soLuong);
            sua(sp, old);
            return true;
        }
        return false;
    }
    
    public void nhapSP(String maSP, int soLuong) throws Exception
    {
        SanPhamDTO old = timSP(maSP);
        SanPhamDTO sp = old;
        sp.setSoLuong(soLuong + sp.getSoLuong());
        sua(sp, old);
    }
    
    void docDSSP() throws Exception
    {
        if(dssp == null)
        {
            SanPhamDAO data = new SanPhamDAO();
            dssp = new ArrayList<SanPhamDTO>();
            dssp = data.docDSSP();
        }
    }
    
    void them(SanPhamDTO sp) throws Exception
    {
        SanPhamDAO data = new SanPhamDAO();
        data.them(sp);
        
        dssp.add(sp);
    }
    
    void xoa(String maSP) throws Exception
    {
        SanPhamDAO data = new SanPhamDAO();
        data.xoa(maSP);
        
        for(SanPhamDTO sp : dssp)
        {
            if(sp.getMaSP().equals(maSP))
            {
                dssp.remove(sp);
                break;
            }
        }
    }
    
    void sua(SanPhamDTO sp, SanPhamDTO old) throws Exception
    {
        SanPhamDAO data = new SanPhamDAO();
        data.sua(sp, old);
        
        for(int i = 0; i < dssp.size(); ++i)
        {
            if(dssp.get(i).getMaSP().equals(old.getMaSP()))
            {
                dssp.set(i,sp);
                break;
            }
        }
    }
    
    String[] docComboBoxMaSP() throws Exception{
        docDSSP();
        String[] array = new String[dssp.size()];
        for(int i = 0; i < dssp.size(); i++)
            array[i] = dssp.get(i).getMaSP();
        if(array.length > 0)
            return array;
        return null;
    }
    
    String taoIdTuDong() throws Exception
    {
        SanPhamDAO data = new SanPhamDAO();
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
        ArrayList<SanPhamDTO> tempArr = new ArrayList<SanPhamDTO>();
        
        switch(mucTimKiem)
        {
            case "Mã SP":
                for(SanPhamDTO sp : dssp)
                {
                    if(sp.getMaSP().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(sp);
                }
                break;
                
            case "Tên SP":
                for(SanPhamDTO sp : dssp)
                {
                    if(sp.getTenSP().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(sp);
                }
                break;
                
            case "Số lượng":
                for(SanPhamDTO sp : dssp)
                {
                    if( Integer.toString(sp.getSoLuong()).indexOf(duLieu) >= 0)
                        tempArr.add(sp);
                }
                break;
                
            case "Đơn giá":
                for(SanPhamDTO sp : dssp)
                {
                    if( Float.toString(sp.getDonGia()).indexOf(duLieu) >= 0)
                        tempArr.add(sp);
                }
                break;
                
            case "Mã LSP":
                for(SanPhamDTO sp : dssp)
                {
                    if(sp.getMaLoaiSP().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(sp);
                }
                break;     
                
            case "Mã NSX":
                for(SanPhamDTO sp : dssp)
                {
                    if(sp.getMaNSX().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(sp);
                }
                break;
                
            default:
                break;
        }
        
        return tempArr;
    }
}
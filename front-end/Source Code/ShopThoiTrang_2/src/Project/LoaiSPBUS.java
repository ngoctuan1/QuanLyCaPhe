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
public class LoaiSPBUS {
    private static ArrayList<LoaiSPDTO> dslsp;
    
    LoaiSPBUS(){}

    public static ArrayList<LoaiSPDTO> getDslsp() {
        return dslsp;
    }

    public static void setDstk(ArrayList<LoaiSPDTO> dslsp) {
        LoaiSPBUS.dslsp = dslsp;
    }
    
    boolean kiemTraTrung(String maLSP)
    {
        for(LoaiSPDTO lsp : dslsp)
        {
            if(lsp.getMaLSP().equals(maLSP))
                return true;
        }
        return false;
    }
    
    boolean kiemTraTrung(String maLSP, String maLSPCu)
    {
        for(LoaiSPDTO lsp : dslsp)
        {
            if(lsp.getMaLSP().equals(maLSP))
            {
                if(maLSP.equals(maLSPCu))
                    return false;
                else
                    return true;
            }
        }
        return false;
    }
    
    public int timIndex(String maLSP)
    {
        int i;
        for(i = 0; i < dslsp.size(); ++i)
        {
            if(maLSP.equals(dslsp.get(i).getMaLSP()))
                break;
        }
        return i;
    }
    
    public static int getDslspSize() throws Exception
    {
         if(dslsp == null)
        {
            LoaiSPDAO data = new LoaiSPDAO();
            dslsp = new ArrayList<LoaiSPDTO>();
            dslsp = data.docDSLSP();
        }
        int size = dslsp.size();
        return size;
    }
    
    void docDSLSP() throws Exception
    {
        if(dslsp == null)
        {
            LoaiSPDAO data = new LoaiSPDAO();
            dslsp = new ArrayList<LoaiSPDTO>();
            dslsp = data.docDSLSP();
        }
    }
    
    String[] docComboBoxMaLSP() throws Exception{
        docDSLSP();
        String[] array = new String[dslsp.size()];
        for(int i = 0; i<dslsp.size(); i++)
            array[i] = dslsp.get(i).getMaLSP();
        if(array.length > 0)
            return array;
        return null;
    }
     
    void them(LoaiSPDTO lsp) throws Exception
    {
        LoaiSPDAO data = new LoaiSPDAO();
        data.them(lsp);
        
        dslsp.add(lsp);
    }
    
    void xoa(String maLSP) throws Exception
    {
        LoaiSPDAO data = new LoaiSPDAO();
        data.xoa(maLSP);
        
        for(LoaiSPDTO lsp : dslsp)
        {
            if(lsp.getMaLSP().equals(maLSP))
            {
                dslsp.remove(lsp);
                break;
            }
        }
    }
    
    void sua(LoaiSPDTO lsp, LoaiSPDTO old) throws Exception
    {
        LoaiSPDAO data = new LoaiSPDAO();
        data.sua(lsp, old);
        
        for(int i = 0; i < dslsp.size(); ++i)
        {
            if(dslsp.get(i).getMaLSP().equals(old.getMaLSP()))
            {
                dslsp.set(i,lsp);
                break;
            }
        }
    }
    
    String taoIdTuDong() throws Exception
    {
        LoaiSPDAO data = new LoaiSPDAO();
        String ID = data.layMaxID();
        String txt = ID.substring(0,3);
        int num = Integer.parseInt(ID.substring(3));
        ++num;
        
        String snum = Integer.toString(num);
        ID = txt + snum;
        
        return ID;
    }
    
    ArrayList timKiem(String mucTimKiem, String duLieu)
    {
        ArrayList<LoaiSPDTO> tempArr = new ArrayList<LoaiSPDTO>();
        
        switch(mucTimKiem)
        {
            case "Mã LSP":
                for(LoaiSPDTO lsp : dslsp)
                {
                    if(lsp.getMaLSP().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(lsp);
                }
                break;
                
            case "Tên LSP":
                for(LoaiSPDTO lsp : dslsp)
                {
                    if(lsp.getTenLSP().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(lsp);
                }
                break;
                
            case "Loại tiền tệ":
                for(LoaiSPDTO lsp : dslsp)
                {
                    if(lsp.getLoaiTienTe().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(lsp);
                }
                break;
                
            default:
                break;
        }
        
        return tempArr;
    }
}
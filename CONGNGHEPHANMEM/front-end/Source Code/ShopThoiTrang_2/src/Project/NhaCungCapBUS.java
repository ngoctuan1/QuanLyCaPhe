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
public class NhaCungCapBUS {
private static ArrayList<NhaCungCapDTO> dsncc;
    
    NhaCungCapBUS(){}

    public static ArrayList<NhaCungCapDTO> getDsncc() {
        return dsncc;
    }

    public static void setDsncc(ArrayList<NhaCungCapDTO> dsncc) {
        NhaCungCapBUS.dsncc = dsncc;
    }
    
    public static int getDsnccSize() throws Exception
    {
        if(dsncc == null)
        {
            NhaCungCapDAO data = new NhaCungCapDAO();
            dsncc = new ArrayList<NhaCungCapDTO>();
            dsncc = data.docDSNCC();
        }
        int size = dsncc.size();
        return size;
    }
    
    boolean kiemTraTrung(String maNCC)
    {
        for(NhaCungCapDTO ncc : dsncc)
        {
            if(ncc.getMaNCC().equals(maNCC))
                return true;
        }
        return false;
    }
    
    boolean kiemTraTrung(String maNCC, String maNCCCu)
    {
        for(NhaCungCapDTO ncc : dsncc)
        {
            if(ncc.getMaNCC().equals(maNCC))
            {
                if(maNCC.equals(maNCCCu))
                    return false;
                else
                    return true;
            }
        }
        return false;
    }
    
    public int timIndex(String maNCC)
    {
        int i;
        for(i = 0; i < dsncc.size(); ++i)
        {
            if(maNCC.equals(dsncc.get(i).getMaNCC()))
                break;
        }
        return i;
    }
    
    void docDSNCC() throws Exception
    {
        if(dsncc == null)
        {
            NhaCungCapDAO data = new NhaCungCapDAO();
            dsncc = new ArrayList<NhaCungCapDTO>();
            dsncc = data.docDSNCC();
        }
    }
    
      String[] docComboBoxMaNCC() throws Exception{
        docDSNCC();
        String [] array = new String[dsncc.size()];
        for (int i = 0; i< dsncc.size(); i++)
          array[i] = dsncc.get(i).getMaNCC();
        if(array.length > 0)
            return array;
        return null;
    }
      
    void them(NhaCungCapDTO ncc) throws Exception
    {
        NhaCungCapDAO data = new NhaCungCapDAO();
        data.them(ncc);
        
        dsncc.add(ncc);
    }
    
    void xoa(String maNCC) throws Exception
    {
        NhaCungCapDAO data = new NhaCungCapDAO();
        data.xoa(maNCC);
        
        for(NhaCungCapDTO ncc : dsncc)
        {
            if(ncc.getMaNCC().equals(maNCC))
            {
                dsncc.remove(ncc);
                break;
            }
        }
    }
    
    void sua(NhaCungCapDTO ncc, NhaCungCapDTO old) throws Exception
    {
        NhaCungCapDAO data = new NhaCungCapDAO();
        data.sua(ncc, old);
        
        for(int i = 0; i < dsncc.size(); ++i)
        {
            if(dsncc.get(i).getMaNCC().equals(old.getMaNCC()))
            {
                dsncc.set(i,ncc);
                break;
            }
        }
    }
    
        String taoIdTuDong() throws Exception
    {
        NhaCungCapDAO data = new NhaCungCapDAO();
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
        ArrayList<NhaCungCapDTO> tempArr = new ArrayList<NhaCungCapDTO>();
        
        switch(mucTimKiem)
        {
            case "Mã NCC":
                for(NhaCungCapDTO ncc : dsncc)
                {
                    if(ncc.getMaNCC().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(ncc);
                }
                break;
                
            case "Tên NCC":
                for(NhaCungCapDTO ncc : dsncc)
                {
                    if(ncc.getTenNCC().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(ncc);
                }
                break;
                
            case "Số ĐT":
                for(NhaCungCapDTO ncc : dsncc)
                {
                    if(ncc.getSoDT().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(ncc);
                }
                break;
                
            case "Địa chỉ":
                for(NhaCungCapDTO ncc : dsncc)
                {
                    if(ncc.getDiaChi().toLowerCase().indexOf(duLieu.toLowerCase()) >= 0)
                        tempArr.add(ncc);
                }
                break;
            default:
                break;
        }
        
        return tempArr;
    }        
}

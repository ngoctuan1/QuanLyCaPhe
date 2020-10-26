/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;
import com.sun.source.doctree.ThrowsTree;
import java.util.ArrayList;
/**
 *
 * @author LLOST
 */
public class PhieuNhapBUS {
    private static ArrayList<PhieuNhapDTO> dspn;
    
    public PhieuNhapBUS() {
    }

    public static ArrayList<PhieuNhapDTO> getDspn() {
        return dspn;
    }
    
    public static void setDspn(ArrayList<PhieuNhapDTO> dspn) {
        PhieuNhapBUS.dspn = dspn;
    }
    
    String[] docComboBoxMaPN() throws Exception{
        docDSPN();
        String[] array = new String[dspn.size()];
        for(int i = 0; i < dspn.size(); i++)
            array[i] = dspn.get(i).getMaPN();
        if(array.length > 0)
            return array;
        return null;
    }
        
    public static int getDspnSize() throws Exception
    {
      if(dspn == null){
            PhieuNhapDAO data= new PhieuNhapDAO();
            dspn= new ArrayList<PhieuNhapDTO>();
            dspn= data.docDSPN();
        }
      int size = dspn.size();
      return size;  
    }
    
    boolean kiemTraTrung(String maPN){
        for(PhieuNhapDTO pn: dspn){
            if(pn.getMaPN().equals(pn))
                return true;
        }
        return false;
    }
    
    boolean kiemTraTrung(String maPN, String maPNCu){
        for(PhieuNhapDTO pn: dspn){
            if(pn.getMaPN().equals(maPN)){
                if(maPN.equals(maPNCu))
                    return false;
                else
                    return true;
            }
        }
        return false;
    }
    
    public int timIndex(String maPN){
        int i;
        for(i=0; i<dspn.size(); i++){
            if(maPN.equals(dspn.get(i).getMaPN()))
                break;
        }
        return i;
    }
    
    public PhieuNhapDTO timPN(String maPN)
    {
        for(PhieuNhapDTO item : dspn)
        {
            if(item.getMaPN().equals(maPN))
                return item;
        }
        
        return null;
    }
    
    void docDSPN() throws Exception{
        if(dspn == null){
            PhieuNhapDAO data= new PhieuNhapDAO();
            dspn= new ArrayList<PhieuNhapDTO>();
            dspn= data.docDSPN();
        }
    }
            
    void them(PhieuNhapDTO pn) throws Exception{
        PhieuNhapDAO data= new PhieuNhapDAO();
        data.them(pn);
        dspn.add(pn);
    }
    
    void xoa(String maPN) throws Exception{
        PhieuNhapDAO data= new PhieuNhapDAO();
        data.xoa(maPN);
        
        for(PhieuNhapDTO pn: dspn){
            if(pn.getMaPN().equals(maPN)){
                dspn.remove(pn);
                break;
            }
        }
    }
    
    void sua(PhieuNhapDTO pn, PhieuNhapDTO old) throws Exception{
        PhieuNhapDAO data= new PhieuNhapDAO();
        data.sua(pn, old);
        
        for(int i=0; i<dspn.size(); i++){
            if(dspn.get(i).getMaPN().equals(old.getMaPN())){
                dspn.set(i, pn);
                break;
            }
        }
    }
    
    String taoIdTuDong() throws Exception{
        PhieuNhapDAO data= new PhieuNhapDAO();
        String ID= data.layMaxID();
        String txt= ID.substring(0,2);
        int num= Integer.parseInt(ID.substring(2));
        num++;
        
        String snum=Integer.toString(num);
        ID=txt+snum;
        return ID;
    }
    
    ArrayList timKiem(String mucTimKiem, String duLieu)
    {
        ArrayList<PhieuNhapDTO> tempArr= new ArrayList<PhieuNhapDTO>();
        switch(mucTimKiem){
            case "Mã PN":
                for(PhieuNhapDTO pn: dspn){
                    if(pn.getMaPN().toLowerCase().indexOf(duLieu.toLowerCase())>=0)
                        tempArr.add(pn);
                }break;
            case "Mã NV":
                for(PhieuNhapDTO pn: dspn){
                    if(pn.getMaNV().toLowerCase().indexOf(duLieu.toLowerCase())>=0)
                        tempArr.add(pn);
                }break;
            case "Mã NCC":
                for(PhieuNhapDTO pn: dspn){
                    if(pn.getMaNCC().toLowerCase().indexOf(duLieu.toLowerCase())>=0)
                        tempArr.add(pn);
                }break;
            case "Ngày Nhập":
                for(PhieuNhapDTO pn: dspn){
                    if(pn.getNgayNhap().indexOf(duLieu)>=0)
                        tempArr.add(pn);
                }break;
            case "Tổng Tiền":
                for(PhieuNhapDTO pn: dspn){
                    if(Float.toString(pn.getTongTien()).indexOf(duLieu)>=0)
                        tempArr.add(pn);
                }break;
            default:
                break;
        }
        return tempArr;
    }

}

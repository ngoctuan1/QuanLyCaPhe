/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;
import java.util.ArrayList;
/**
 *
 * @author LLOST
 */
public class KhachHangBUS {
    private static ArrayList<KhachHangDTO> dskh;

    public KhachHangBUS() {
    }

    public static ArrayList<KhachHangDTO> getDskh() {
        return dskh;
    }

    public static void setDskh(ArrayList<KhachHangDTO> dskh) {
        KhachHangBUS.dskh = dskh;
    }
    
    public static int getDskhSize() throws Exception
    {
         
        if(dskh == null){
            KhachHangDAO data=new KhachHangDAO();
            dskh = new ArrayList<KhachHangDTO>();
            dskh = data.docDSKH();
        }
        int size = dskh.size();
        return size;
    }
    String[] docComboBoxMaKH() throws Exception{
        docDSKH();
        String [] array = new String[dskh.size()];
        for (int i = 0; i< dskh.size(); i++)
          array[i] = dskh.get(i).getMaKH();
        if(array.length > 0)
            return array;
        return null;
    }
        
    boolean kiemTraTrung(String maKH){
        for(KhachHangDTO kh: dskh){
            if(kh.getMaKH().equals(maKH))
                return true;
        }
        return false;
    }
    
    boolean kiemTraTrung(String maKH, String maKHCu){
        for(KhachHangDTO kh: dskh){
            if(kh.getMaKH().equals(maKH)){
                if(maKH.equals(maKHCu))
                    return false;
                else
                    return true;
            }
        }
        return false;
    }
    
    public int timIndex(String maKH){
        int i;
        for(i=0; i < dskh.size(); i++){
            if(maKH.equals(dskh.get(i).getMaKH()))
                break;
        }
        return i;
    }
    
    void docDSKH() throws Exception{
        if(dskh == null){
            KhachHangDAO data=new KhachHangDAO();
            dskh = new ArrayList<KhachHangDTO>();
            dskh = data.docDSKH();
        }
    }
    
    void them(KhachHangDTO kh) throws Exception{
        KhachHangDAO data= new KhachHangDAO();
        data.them(kh);
        dskh.add(kh);
    }
    
    void xoa(String maKH) throws Exception{
        KhachHangDAO data= new KhachHangDAO();
        data.xoa(maKH);
        
        for(KhachHangDTO kh: dskh){
            if(kh.getMaKH().equals(maKH)){
                dskh.remove(kh);
                break;
            }
        }
    }
    
    void sua(KhachHangDTO kh, KhachHangDTO old) throws Exception{
        KhachHangDAO data= new KhachHangDAO();
        data.sua(kh, old);
        
        for(int i=0;i<dskh.size();i++){
            if(dskh.get(i).getMaKH().equals(old.getMaKH())){
                dskh.set(i, kh);
                break;
            }
        }
    }
    
    String taoIdTuDong() throws Exception
    {
        KhachHangDAO data = new KhachHangDAO();
        String ID = data.layMaxID();
        String txt = ID.substring(0,2);
        int num = Integer.parseInt(ID.substring(2));
        ++num;
        
        String snum = Integer.toString(num);
        ID = txt + snum;
        
        return ID;
    } 
    
    ArrayList timKiem(String mucTimKiem, String duLieu){
        ArrayList<KhachHangDTO> tempArr = new ArrayList<KhachHangDTO>();
        
        switch(mucTimKiem){
            case "Mã KH":
                for(KhachHangDTO kh: dskh){
                    if(kh.getMaKH().toLowerCase().indexOf(duLieu.toLowerCase())>=0)
                        tempArr.add(kh);
                }break;
            case "Họ":
                for(KhachHangDTO kh: dskh){
                    if(kh.getHo().toLowerCase().indexOf(duLieu.toLowerCase())>=0)
                        tempArr.add(kh);
                }break;
            case "Tên":
                for(KhachHangDTO kh:dskh){
                    if(kh.getTen().toLowerCase().indexOf(duLieu.toLowerCase())>=0)
                        tempArr.add(kh);
                }break;
            case "Địa Chỉ":
                for(KhachHangDTO kh: dskh){
                    if(kh.getDiaChi().toLowerCase().indexOf(duLieu.toLowerCase())>=0)
                        tempArr.add(kh);
                    }break;
            case  "Số ĐT":
                for(KhachHangDTO kh: dskh){
                    if(kh.getSoDT().indexOf(duLieu)>=0)
                        tempArr.add(kh);
                }break;
            default:
                break;
        }
        return tempArr;
    }
}

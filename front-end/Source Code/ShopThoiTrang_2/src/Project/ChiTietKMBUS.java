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
public class ChiTietKMBUS {
    private static ArrayList<ChiTietKMDTO> dsctkm;

    public ChiTietKMBUS() {
    }

    public static ArrayList<ChiTietKMDTO> getDsctkm() {
        return dsctkm;
    }

    public static void setDsctkm(ArrayList<ChiTietKMDTO> dsctkm) {
        ChiTietKMBUS.dsctkm = dsctkm;
    }
    
    boolean kiemTraTrung(String maKM, String maSP){
        for(ChiTietKMDTO ctkm: dsctkm){
            if(ctkm.getMaKM().equals(maKM) && ctkm.getMaSP().equals(maSP))
                return true;
        }
        return false;
    }
    
    boolean kiemTraTrung(String maKM, String maKMCu, String maSP, String maSPCu){
        for(ChiTietKMDTO ctkm: dsctkm){
            if(ctkm.getMaKM().equals(maKM) && ctkm.getMaSP().equals(maSP)){
                if(maKM.equals(maKMCu) && maSP.equals(maSPCu))
                    return false;
                else
                    return true;
            }
        }
        return false;
    }
    
    public int timIndex(String maKM, String maSP){
        int i = 0;
        for(i = 0; i < dsctkm.size(); i++){
            if(maKM.equals(dsctkm.get(i).getMaKM()) && maSP.equals(dsctkm.get(i).getMaSP()))
                break;
        }
        return i;
    }
    
    void docDSCTKM() throws Exception{
        ChiTietKMDAO data= new ChiTietKMDAO();
        dsctkm= new ArrayList<ChiTietKMDTO>();
        dsctkm= data.docDSCTKM();
    }
    
    void docDSCTKM(String maKM) throws Exception{
        ChiTietKMDAO data = new ChiTietKMDAO();
        dsctkm = new ArrayList<ChiTietKMDTO>();
        dsctkm = data.docDSCTKM(maKM);

    }
    
    void them(ChiTietKMDTO ctkm) throws Exception{
        ChiTietKMDAO data= new ChiTietKMDAO();
        data.them(ctkm);
        dsctkm.add(ctkm);
    }
    
    void xoa(String maKM, String maSP) throws Exception{
        ChiTietKMDAO data= new ChiTietKMDAO();
        data.xoa(maKM, maSP);
        
        for(ChiTietKMDTO ctkm : dsctkm){
            if(ctkm.getMaKM().equals(maKM) && ctkm.getMaSP().equals(maSP)){
                dsctkm.remove(ctkm);
                break;
            }
        }
    }
    
    void sua(ChiTietKMDTO ctkm, ChiTietKMDTO old) throws Exception{
        ChiTietKMDAO data= new ChiTietKMDAO();
        data.sua(ctkm, old);
        
        for(int i=0; i<dsctkm.size(); i++){
            if(dsctkm.get(i).getMaKM().equals(old.getMaKM()) && dsctkm.get(i).getMaSP().equals(old.getMaSP())){
                dsctkm.set(i,ctkm);
                break;
            }
        }
    }
    
    ArrayList timKiem(String mucTimKiem, String duLieu){
        ArrayList<ChiTietKMDTO> tempArr= new ArrayList<ChiTietKMDTO>();
        
        switch(mucTimKiem){
            case "Mã KM":
                for(ChiTietKMDTO ctkm: dsctkm){
                    if(ctkm.getMaKM().toLowerCase().indexOf(duLieu.toLowerCase())>=0)
                        tempArr.add(ctkm);
                }break;
            case "Mã SP":
                for(ChiTietKMDTO ctkm: dsctkm){
                    if(ctkm.getMaSP().toLowerCase().indexOf(duLieu.toLowerCase())>=0)
                        tempArr.add(ctkm);
                }break;
            case "Số Lượng Tối Thiểu":
                for(ChiTietKMDTO ctkm: dsctkm){
                    if(Integer.toString(ctkm.getSoLuongToiThieu()).indexOf(duLieu)>=0)
                        tempArr.add(ctkm);
                }break;
            case "Phần Trăm KM":
                for(ChiTietKMDTO ctkm: dsctkm){
                    if(Float.toString(ctkm.getPhanTramKM()).indexOf(duLieu)>=0)
                        tempArr.add(ctkm);
                }break;
            default:
                break;
        }
        return tempArr;
    }
}

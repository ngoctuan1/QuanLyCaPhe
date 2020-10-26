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
public class NhaSanXuatBUS {
    private static ArrayList<NhaSanXuatDTO> dsnsx;

    public NhaSanXuatBUS() {
    }
    
    public static ArrayList<NhaSanXuatDTO> getDsnsx(){
        return dsnsx;
    }
    
    public static void setDsnsx(ArrayList<NhaSanXuatDTO> dsnsx){
        NhaSanXuatBUS.dsnsx=dsnsx;
    }
    
    public static int getDsnsxSize() throws Exception
    {
        if(dsnsx == null){
            NhaSanXuatDAO data = new NhaSanXuatDAO();
            dsnsx = new ArrayList<NhaSanXuatDTO>();
            dsnsx = data.docDSNSX();
        }
        int size = dsnsx.size();
        return size;
    }
    
    boolean kiemTraTrung(String maNSX){
        for(NhaSanXuatDTO nsx : dsnsx){
            if(nsx.getMaNSX().equals(maNSX))
                return true;
        }
        return false;
    }
    
    boolean kiemTraTrung(String maNSX, String maNSXCu){
        for(NhaSanXuatDTO nsx : dsnsx){
            if(nsx.getMaNSX().equals(maNSX)){
                if(maNSX.equals(maNSXCu))
                    return false;
                else 
                    return true;             
            }
        }
        return false;
    }
    
    public int timIndex(String maNSX){
        int i;
        for(i = 0; i < dsnsx.size(); i++){
            if(maNSX.equals(dsnsx.get(i).getMaNSX()))
                break;
        }
        return i;
    }
    
    void docDSNSX() throws Exception{
        if(dsnsx == null){
            NhaSanXuatDAO data = new NhaSanXuatDAO();
            dsnsx = new ArrayList<NhaSanXuatDTO>();
            dsnsx = data.docDSNSX();
        }
    }
    
    String[] docComboBoxMaNSX() throws Exception{
        docDSNSX();
        String[] array = new String[dsnsx.size()];
        for(int i = 0; i < dsnsx.size(); i++)
            array[i] = dsnsx.get(i).getMaNSX();
        if(array.length > 0)
            return array;
        return null;
    }
    
    void them(NhaSanXuatDTO nsx) throws Exception{
        NhaSanXuatDAO data= new NhaSanXuatDAO();
        data.them(nsx);
        dsnsx.add(nsx);
    }
    
    void xoa(String maNSX) throws Exception{
        NhaSanXuatDAO data= new NhaSanXuatDAO();
        data.xoa(maNSX);
        
        for(NhaSanXuatDTO nsx : dsnsx){
            if(nsx.getMaNSX().equals(maNSX)){
                dsnsx.remove(nsx);
                break;
            }
        }
    }
    
    void sua(NhaSanXuatDTO nsx, NhaSanXuatDTO old) throws Exception{
        NhaSanXuatDAO data= new NhaSanXuatDAO();
        data.sua(nsx, old);
        
        for(int i=0;i<dsnsx.size();i++)
        {
            if(dsnsx.get(i).getMaNSX().equals(old.getMaNSX()))
            {
                dsnsx.set(i, nsx);
                break;
            }
        }
    }
    
    String taoIdTuDong() throws Exception{
        NhaSanXuatDAO data= new NhaSanXuatDAO();
        String ID = data.layMaxID();
        String txt = ID.substring(0,3);
        int num= Integer.parseInt(ID.substring(3));
        num++;
        
        String snum= Integer.toString(num);
        ID= txt+snum;
        return ID;
    }
    
    ArrayList timKiem(String mucTimKiem, String duLieu){
        ArrayList<NhaSanXuatDTO> tempArr = new ArrayList<NhaSanXuatDTO>();
        
        switch(mucTimKiem){
            case "Mã NSX":
                for(NhaSanXuatDTO nsx: dsnsx){
                    if(nsx.getMaNSX().toLowerCase().indexOf(duLieu.toLowerCase())>=0)
                        tempArr.add(nsx);
                }
                break;
            case "Tên NSX":
                for(NhaSanXuatDTO nsx: dsnsx){
                    if(nsx.getTenNSX().toLowerCase().indexOf(duLieu.toLowerCase())>=0)
                        tempArr.add(nsx);
                }
                break;
            case "Quốc Gia":
                for(NhaSanXuatDTO nsx: dsnsx){
                    if(nsx.getQuocGia().toLowerCase().indexOf(duLieu.toLowerCase())>=0)
                        tempArr.add(nsx);
                }
                break;
            default:
                break;
        }
        return tempArr;
    }
}

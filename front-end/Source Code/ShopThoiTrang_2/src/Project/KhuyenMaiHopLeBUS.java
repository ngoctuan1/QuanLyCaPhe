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
public class KhuyenMaiHopLeBUS {
    private static ArrayList<KhuyenMaiHopLeDTO> dskmhl;
    
    KhuyenMaiHopLeBUS(){}

    public static ArrayList<KhuyenMaiHopLeDTO> getDskmhl() {
        return dskmhl;
    }

    public static void setDstk(ArrayList<KhuyenMaiHopLeDTO> dskmhl) {
        KhuyenMaiHopLeBUS.dskmhl = dskmhl;
    }
    
    void docDSKMHL() throws Exception
    {
        KhuyenMaiHopLeDAO data = new KhuyenMaiHopLeDAO();
        dskmhl = new ArrayList<KhuyenMaiHopLeDTO>();
        dskmhl = data.docDSKMHL();
    }
    
    ArrayList<KhuyenMaiHopLeDTO> timDSKMHL(String maHD) throws Exception
    {
        docDSKMHL();
        ArrayList<KhuyenMaiHopLeDTO> arr = new ArrayList<>();
        for(KhuyenMaiHopLeDTO item : dskmhl)
        {
            if(item.getMaHD().equals(maHD))
                arr.add(item);
        }
        
        return arr;
    }
}

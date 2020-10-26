/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

/**
 *
 * @author tt
 */
public class KhuyenMaiHopLeDTO {
    String maHD;
    String maKM;
    String tenKM;
    
    KhuyenMaiHopLeDTO(){}
    
    KhuyenMaiHopLeDTO(String maHD, String maKM, String tenKM)
    {
        this.maHD = maHD;
        this.maKM = maKM;
        this.tenKM = tenKM;
    }
    
    KhuyenMaiHopLeDTO(KhuyenMaiHopLeDTO kmhl)
    {
        this.maHD = kmhl.getMaHD();
        this.maKM = kmhl.getMaKM();
        this.tenKM = kmhl.getTenKM();
    }
    
    public KhuyenMaiHopLeDTO Clone()
    {
        KhuyenMaiHopLeDTO other = new KhuyenMaiHopLeDTO(this.maHD, this.maKM, this.tenKM);
        return other;
    }
    
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }
}

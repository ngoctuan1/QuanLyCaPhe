/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

/**
 *
 * @author loith
 */
public class LoaiSPDTO {
    String maLSP;
    String tenLSP;
    String loaiTienTe;
    
    LoaiSPDTO(){}
    
    LoaiSPDTO(String maLSP, String tenLSP, String loaiTienTe)
    {
        this.maLSP = maLSP;
        this.tenLSP = tenLSP;
        this.loaiTienTe = loaiTienTe;
    }
    
    LoaiSPDTO(LoaiSPDTO lSp)
    {
        this.maLSP = lSp.getMaLSP();
        this.tenLSP = lSp.getTenLSP();
        this.loaiTienTe = lSp.getLoaiTienTe();
    }
    
    public LoaiSPDTO Clone()
    {
        LoaiSPDTO other = new LoaiSPDTO(this.maLSP, this.tenLSP, this.loaiTienTe);
        return other;
    }
    
    public String getMaLSP() {
        return maLSP;
    }

    public void setMaLSP(String maLSP) {
        this.maLSP = maLSP;
    }

    public String getTenLSP() {
        return tenLSP;
    }

    public void setTenLSP(String tenLSP) {
        this.tenLSP = tenLSP;
    }

    public String getLoaiTienTe() {
        return loaiTienTe;
    }

    public void setLoaiTienTe(String loaiTienTe) {
        this.loaiTienTe = loaiTienTe;
    }
    
}

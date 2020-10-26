/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;
/**
 *
 * @author LLOST
 */
public class PhieuNhapDTO {

    String maPN;
    String maNV;
    String maNCC;
    String ngayNhap;
    float tongTien;
    
    public PhieuNhapDTO(){}

    public PhieuNhapDTO(String maPN, String maNV, String maNCC, String ngayNhap, float tongTien) {
        this.maPN = maPN;
        this.maNV = maNV;
        this.maNCC = maNCC;
        this.ngayNhap = ngayNhap;
        this.tongTien = tongTien;
    }
    
    public PhieuNhapDTO(PhieuNhapDTO pn){
        this.maPN=pn.getMaPN();
        this.maNV=pn.getMaNV();
        this.maNCC=pn.getMaNCC();
        this.ngayNhap=pn.getNgayNhap();
        this.tongTien=pn.getTongTien();
    }
    
    public PhieuNhapDTO Clone(){
        PhieuNhapDTO other=new PhieuNhapDTO(this.maPN, this.maNV, this.maNCC, this.ngayNhap, this.tongTien);
        return other;
    }
    
    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }
    

}

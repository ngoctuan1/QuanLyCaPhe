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
public class SanPhamDTO {
    String maSP;
    String tenSP;
    int soLuong;
    float donGia;
    String maLoaiSP;
    String maNSX;
    
    public SanPhamDTO() {}
    
    public SanPhamDTO(String maSP, String tenSP, int soLuong, float donGia, String maLoaiSP, String maNSX) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.maLoaiSP = maLoaiSP;
        this.maNSX = maNSX;
    }
    
    public SanPhamDTO(SanPhamDTO sp)
    {
        this.maSP = sp.getMaSP();
        this.tenSP = sp.getTenSP();
        this.soLuong = sp.getSoLuong();
        this.donGia = sp.getDonGia();
        this.maLoaiSP = sp.getMaLoaiSP();
        this.maNSX = sp.getMaNSX();
    }
    
     public SanPhamDTO Clone()
    {
        SanPhamDTO other = new SanPhamDTO(this.maSP, this.tenSP, this.soLuong, this.donGia, this.maLoaiSP, this.maNSX);
        return other;
    }
     
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public String getMaLoaiSP() {
        return maLoaiSP;
    }

    public void setMaLoaiSP(String maLoaiSP) {
        this.maLoaiSP = maLoaiSP;
    }

    public String getMaNSX() {
        return maNSX;
    }

    public void setMaNSX(String maNSX) {
        this.maNSX = maNSX;
    }
    
    
    
}

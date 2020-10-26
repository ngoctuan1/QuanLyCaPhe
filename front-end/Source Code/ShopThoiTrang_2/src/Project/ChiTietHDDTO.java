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
public class ChiTietHDDTO {
    String maHD;
    String maSP;
    int soLuong;
    float donGia;
    ChiTietHDDTO(){}

    public ChiTietHDDTO(String maHD, String maSP, int soLuong, float donGia) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    
    public ChiTietHDDTO(ChiTietHDDTO chiTietHD)
    {
        this.maHD = chiTietHD.getMaHD();
        this.maSP = chiTietHD.getMaSP() ;
        this.soLuong = chiTietHD.getSoLuong() ;
        this.donGia = chiTietHD.getDonGia() ;
    }
    
    public ChiTietHDDTO Clone()
    {
        ChiTietHDDTO other = new ChiTietHDDTO(this.maHD, this.maSP, this.soLuong, this.donGia);
        return other;
    }
    
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
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
    
    
    
}

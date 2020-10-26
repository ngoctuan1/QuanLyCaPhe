/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;
/**
 *
 * @author kossp
 */
public class ChiTietPNDTO {
    String maPN;
    String maSP;
    int soLuong;
    Float donGia;
    
    public ChiTietPNDTO() {}

    public ChiTietPNDTO(String maPN, String maSP, int soLuong, Float donGia) 
    {
        this.maPN = maPN;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    
    public ChiTietPNDTO(ChiTietPNDTO ctpn)
    {
        this.maPN = ctpn.getMaPN();
        this.maSP = ctpn.getMaSP();
        this.soLuong = ctpn.getSoLuong();
        this.donGia = ctpn.getDonGia();        
    }
    
    public ChiTietPNDTO Clone()
    {
        ChiTietPNDTO other = new ChiTietPNDTO(this.maPN, this.maSP, this.soLuong, this.donGia);
        return other;
    }
    public String getMaPN() {
        return maPN;
    }

    public void setMaPN(String maPN) {
        this.maPN = maPN;
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

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }
    
    
    
}

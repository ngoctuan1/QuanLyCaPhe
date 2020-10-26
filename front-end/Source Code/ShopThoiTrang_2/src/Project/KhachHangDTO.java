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
public class KhachHangDTO {
    String maKH;
    String ho;
    String ten;
    String diaChi;
    String soDT;
    
    public KhachHangDTO(){}

    public KhachHangDTO(String maKH, String ho, String ten, String diaChi, String soDT) {
        this.maKH = maKH;
        this.ho = ho;
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }
    
    public KhachHangDTO(KhachHangDTO kh){
        this.maKH=kh.getMaKH();
        this.ho=kh.getHo();
        this.ten=kh.getTen();
        this.diaChi=kh.getDiaChi();
        this.soDT=kh.getSoDT();
    }
    
    public KhachHangDTO Clone(){
        KhachHangDTO other=new KhachHangDTO(this.maKH, this.ho, this.ten,this.diaChi, this.soDT);
        return other;
    }
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
    
}

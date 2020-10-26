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
public class HoaDonDTO {
    String maHD;
    String maKH;
    String maNV;
    String ngayHD;
    Float tongTien;
    String maKM;
    Float thanhTien;

    public HoaDonDTO() {}
    
    public HoaDonDTO(String maHD, String maKH, String maNV, String ngayHD, Float tongTien, String maKM, Float thanhTien) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayHD = ngayHD;
        this.tongTien = tongTien;
        this.maKM = maKM;
        this.thanhTien = thanhTien;
    }

    public HoaDonDTO(HoaDonDTO hd) {
        this.maHD = hd.getMaHD();
        this.maKH = hd.getMaKH();
        this.maNV = hd.getMaNV();
        this.ngayHD = hd.getNgayHD();
        this.tongTien = hd.getTongTien();
        this.maKM = hd.getMaKM();
        this.thanhTien = hd.getThanhTien();
    }
    
    public HoaDonDTO Clone()
    {
        HoaDonDTO other = new HoaDonDTO(this.maHD, this.maKH, this.maNV, this.ngayHD, this.tongTien, this.maKM, this.thanhTien);
        return other;
    }
    
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayHD() {
        return ngayHD;
    }

    public void setNgayHD(String ngayHD) {
        this.ngayHD = ngayHD;
    }

    public Float getTongTien() {
        return tongTien;
    }

    public void setTongTien(Float tongTien) {
        this.tongTien = tongTien;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public Float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Float thanhTien) {
        this.thanhTien = thanhTien;
    }
}

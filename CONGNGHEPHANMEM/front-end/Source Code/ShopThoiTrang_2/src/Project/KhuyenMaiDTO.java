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
public class KhuyenMaiDTO {
    String maKM;
    String tenKM;
    Float giaDHToiThieu;
    String ngayBatDau;
    String ngayKetThuc;
    Float phanTramKhuyenMai;
    
    
    public KhuyenMaiDTO(){}

    public KhuyenMaiDTO(String maKM, String tenKM, Float giaDHToiThieu, String ngayBatDau, String ngayKetThuc, Float phanTramKhuyenMai) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.giaDHToiThieu = giaDHToiThieu;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.phanTramKhuyenMai = phanTramKhuyenMai;
    }
    
    public KhuyenMaiDTO(KhuyenMaiDTO km)
    {
        this.maKM = km.getMaKM();
        this.tenKM = km.getTenKM();
        this.giaDHToiThieu = km.getGiaDHToiThieu();
        this.ngayBatDau = km.getNgayBatDau();
        this.ngayKetThuc = km.getNgayKetThuc();
        this.phanTramKhuyenMai = km.getPhanTramKhuyenMai();
    }
    
    public KhuyenMaiDTO Clone()
    {
        KhuyenMaiDTO other = new KhuyenMaiDTO(this.maKM, this.tenKM, this.giaDHToiThieu, this.ngayBatDau, this.ngayKetThuc, this.phanTramKhuyenMai);
        return other;
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

    public Float getGiaDHToiThieu() {
        return giaDHToiThieu;
    }

    public void setGiaDHToiThieu(Float giaDHToiThieu) {
        this.giaDHToiThieu = giaDHToiThieu;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Float getPhanTramKhuyenMai() {
        return phanTramKhuyenMai;
    }

    public void setPhanTramKhuyenMai(Float phanTramKhuyenMai) {
        this.phanTramKhuyenMai = phanTramKhuyenMai;
    }
}

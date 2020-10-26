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
public class NhanVienDTO {
    String maNV;
    String ho;
    String ten;
    String gioiTinh;
    String ngaySinh;
    String diaChi;
    Float luong;
    
    public NhanVienDTO() {}

    public NhanVienDTO(String maNV, String ho, String ten, String gioiTinh, String ngaySinh, String diaChi, Float luong) 
    {
        this.maNV = maNV;
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.luong = luong;
    }

    public NhanVienDTO (NhanVienDTO nv)
    {
        this.maNV = nv.getMaNV();
        this.ho = nv.getHo();
        this.ten = nv.getTen();
        this.gioiTinh = nv.getGioiTinh();
        this.ngaySinh = nv.getNgaySinh();
        this.diaChi = nv.getDiaChi();
        this.luong = nv.getLuong();        
    }
    public NhanVienDTO Clone ()
    {
        NhanVienDTO other = new NhanVienDTO (this.maNV, this.ho, this.ten, this.gioiTinh, this.ngaySinh, this.diaChi, this.luong);
        return other;
    }
    
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
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

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Float getLuong() {
        return luong;
    }

    public void setLuong(Float luong) {
        this.luong = luong;
    }
    
    
    
}

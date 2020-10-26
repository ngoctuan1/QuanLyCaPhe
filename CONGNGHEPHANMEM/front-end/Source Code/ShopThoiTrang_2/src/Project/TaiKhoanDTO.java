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
public class TaiKhoanDTO {
    String maNV;
    String tenDangNhap;
    String matKhau;
    String quyen;

    public TaiKhoanDTO(){}

    public TaiKhoanDTO(String maNV, String tenDangNhap, String matKhau, String quyen) {
        this.maNV = maNV;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.quyen = quyen;
    }
    
    public TaiKhoanDTO(TaiKhoanDTO tk) {
        this.maNV = tk.getMaNV();
        this.tenDangNhap = tk.getTenDangNhap();
        this.matKhau = tk.getMatKhau();
        this.quyen = tk.getQuyen();
    }
    
    public TaiKhoanDTO Clone()
    {
        TaiKhoanDTO other = new TaiKhoanDTO(this.maNV, this.tenDangNhap, this.matKhau, this.quyen);
        return other;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }
}

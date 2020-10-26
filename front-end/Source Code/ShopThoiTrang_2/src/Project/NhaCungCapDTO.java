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
public class NhaCungCapDTO {
    String maNCC ;
    String tenNCC;
    String soDT;
    String diaChi;
    
    public NhaCungCapDTO() {}

    public NhaCungCapDTO(String maNCC, String tenNCC, String soDT, String diaChi) 
    {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.soDT = soDT;
        this.diaChi = diaChi;
    }
    
    public NhaCungCapDTO(NhaCungCapDTO ncc)
    {
        this.maNCC = ncc.getMaNCC();
        this.tenNCC = ncc.getTenNCC();
        this.soDT = ncc.getSoDT();
        this.diaChi = ncc.getDiaChi();
    }
    
    public NhaCungCapDTO Clone()
    {
        NhaCungCapDTO other = new NhaCungCapDTO(this.maNCC, this.tenNCC, this.soDT, this.diaChi);
        return other;
    }
    
    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    
    
}

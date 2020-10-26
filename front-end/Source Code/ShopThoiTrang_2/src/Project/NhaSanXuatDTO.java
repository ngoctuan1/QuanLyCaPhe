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
public class NhaSanXuatDTO {
    
    String maNSX;
    String tenNSX;
    String quocGia;
    
    public NhaSanXuatDTO(){}

    public NhaSanXuatDTO(String maNSX, String tenNSX, String quocGia) {
        this.maNSX = maNSX;
        this.tenNSX = tenNSX;
        this.quocGia = quocGia;
    }

    public NhaSanXuatDTO(NhaSanXuatDTO nsx){
        this.maNSX=nsx.getMaNSX();
        this.tenNSX=nsx.getTenNSX();
        this.quocGia=nsx.getQuocGia();
    }
    
    public NhaSanXuatDTO Clone(){
        NhaSanXuatDTO other=new NhaSanXuatDTO(this.maNSX,this.tenNSX,this.quocGia);
        return other;
    }
    
    public String getMaNSX() {
        return maNSX;
    }

    public void setMaNSX(String maNSX) {
        this.maNSX = maNSX;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenSX) {
        this.tenNSX = tenSX;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }
    

}

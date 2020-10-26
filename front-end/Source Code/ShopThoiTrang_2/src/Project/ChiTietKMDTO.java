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
public class ChiTietKMDTO {
    String maKM;
    String maSP;
    int soLuongToiThieu;
    Float phanTramKM;

    public ChiTietKMDTO() {
    }

    public ChiTietKMDTO(String maKM, String maSP, int soLuongToiThieu, Float phanTram) {
        this.maKM = maKM;
        this.maSP = maSP;
        this.soLuongToiThieu = soLuongToiThieu;
        this.phanTramKM = phanTram;
    }
    
    public ChiTietKMDTO(ChiTietKMDTO ctkm){
        this.maKM=ctkm.getMaKM();
        this.maSP=ctkm.getMaSP();
        this.soLuongToiThieu=ctkm.getSoLuongToiThieu();
        this.phanTramKM=ctkm.getPhanTramKM();
    }
    
    public ChiTietKMDTO clone(){
        ChiTietKMDTO other=new ChiTietKMDTO(this.maKM, this.maSP, this.soLuongToiThieu, this.phanTramKM);
        return other;
    }
    
    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuongToiThieu() {
        return soLuongToiThieu;
    }

    public void setSoLuongToiThieu(int soLuongToiThieu) {
        this.soLuongToiThieu = soLuongToiThieu;
    }

    public Float getPhanTramKM() {
        return phanTramKM;
    }

    public void setPhanTramKM(Float phanTram) {
        this.phanTramKM = phanTram;
    }
    
    
}

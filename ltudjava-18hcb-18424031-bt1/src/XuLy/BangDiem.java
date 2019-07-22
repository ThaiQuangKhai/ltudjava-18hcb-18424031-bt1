/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy;

/**
 *
 * @author DELL
 */
public class BangDiem{
    private String mssv;
    private String hoten;
    private float diem_gk;
    private float diem_ck;
    private float diem_khac;
    private float diem_tong;
    
    public BangDiem(String mssv, String hoten, float diem_gk, float diem_ck, float diem_khac, float diem_tong){
        this.mssv=mssv;
        this.hoten=hoten;
        this.diem_gk=diem_gk;
        this.diem_ck=diem_ck;
        this.diem_khac=diem_khac;
        this.diem_tong=diem_tong;
    }

    /**
     * @return the mssv
     */
    public String getMssv() {
        return mssv;
    }

    /**
     * @param mssv the mssv to set
     */
    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    /**
     * @return the hoten
     */
    public String getHoten() {
        return hoten;
    }

    /**
     * @param hoten the hoten to set
     */
    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    /**
     * @return the diem_gk
     */
    public float getDiem_gk() {
        return diem_gk;
    }

    /**
     * @param diem_gk the diem_gk to set
     */
    public void setDiem_gk(float diem_gk) {
        this.diem_gk = diem_gk;
    }

    /**
     * @return the diem_ck
     */
    public float getDiem_ck() {
        return diem_ck;
    }

    /**
     * @param diem_ck the diem_ck to set
     */
    public void setDiem_ck(float diem_ck) {
        this.diem_ck = diem_ck;
    }

    /**
     * @return the diem_khac
     */
    public float getDiem_khac() {
        return diem_khac;
    }

    /**
     * @param diem_khac the diem_khac to set
     */
    public void setDiem_khac(float diem_khac) {
        this.diem_khac = diem_khac;
    }

    /**
     * @return the diem_tong
     */
    public float getDiem_tong() {
        return diem_tong;
    }

    /**
     * @param diem_tong the diem_tong to set
     */
    public void setDiem_tong(float diem_tong) {
        this.diem_tong = diem_tong;
    }
}

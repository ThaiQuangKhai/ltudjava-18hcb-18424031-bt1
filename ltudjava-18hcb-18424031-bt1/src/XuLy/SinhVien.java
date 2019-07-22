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
public class SinhVien {
    private String mssv;
    private String hoten;
    private String gt;
    private String cmnd;
    
    public SinhVien(String mssv, String hoten, String gt, String cmnd){
        this.mssv=mssv;
        this.hoten=hoten;
        this.gt=gt;
        this.cmnd=cmnd;
    }
    public String getmssv() {
        return mssv;
    }

    public void setmssv(String mssv) {
        this.mssv = mssv;
    }
    
    public String gethoten() {
        return hoten;
    }

    public void sethoten(String hoten) {
        this.hoten = hoten;
    }
    
    public String getgt() {
        return gt;
    }

    public void setgt(String gt) {
        this.gt = gt;
    }
    
    public String getcmnd() {
        return cmnd;
    }

    public void setcmnd(String cmnd) {
        this.cmnd = cmnd;
    }
}

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
public class TKB {
    private String mamon;
    private String tenmon;
    private String phonghoc;
    
    public TKB(String mamon, String tenmon, String phonghoc){
        this.mamon=mamon;
        this.tenmon=tenmon;
        this.phonghoc=phonghoc;
    }

    /**
     * @return the mamon
     */
    public String getMamon() {
        return mamon;
    }

    /**
     * @param mamon the mamon to set
     */
    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    /**
     * @return the tenmon
     */
    public String getTenmon() {
        return tenmon;
    }

    /**
     * @param tenmon the tenmon to set
     */
    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    /**
     * @return the phonghoc
     */
    public String getPhonghoc() {
        return phonghoc;
    }

    /**
     * @param phonghoc the phonghoc to set
     */
    public void setPhonghoc(String phonghoc) {
        this.phonghoc = phonghoc;
    }
}

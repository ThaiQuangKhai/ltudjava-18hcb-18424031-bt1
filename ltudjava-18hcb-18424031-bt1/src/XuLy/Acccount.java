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
public class Acccount {
    private String user;
    private String passwourd;
    public Acccount(String user, String passwourd){
        this.user=user;
        this.passwourd=passwourd;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the passwourd
     */
    public String getPasswourd() {
        return passwourd;
    }

    /**
     * @param passwourd the passwourd to set
     */
    public void setPasswourd(String passwourd) {
        this.passwourd = passwourd;
    }
}

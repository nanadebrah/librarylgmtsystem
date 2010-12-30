/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI.*;

/**
 *
 * @author CuongNQ
 */
public class Main {

    //Defined login frame
    loginFrm login;
    //Defined splash screen
    splashScreen ss;

    public Main() {
        //Create new instance of login frame
        login = new loginFrm();
        //Create new instance of splash screen
        ss = new splashScreen();
        //Do splashscreen
        ss.loadProcess();
        //When splash screen closed display login frame
        ss.addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosed(java.awt.event.WindowEvent evt) {
                if (!login.isVisible()) {
                    login.setVisible(true);
                }
            }
        });
    }

    public static void main(String[] args) {
        //Start system
        new Main();
    }
}

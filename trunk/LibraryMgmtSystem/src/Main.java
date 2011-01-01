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
    LoginFrm login;
    //Defined splash screen
    SplashScreen ss;

    public Main() {
        //Create new instance of login frame
        login = new LoginFrm();
        //Create new instance of splash screen
        ss = new SplashScreen();
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

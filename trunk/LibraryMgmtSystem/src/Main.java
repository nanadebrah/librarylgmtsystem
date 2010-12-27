/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import GUI.Images.loginFrm;
import Util.*;

/**
 *
 * @author CuongNQ
 */
public class Main {

    public static void main(String[] args) {
        splashScreen ss=new splashScreen();
        ss.loadProcess();
        ss.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                new loginFrm().setVisible(true);
            }
        });
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;

/**
 * Store path to imageicon
 * @author CuongNQ
 */
public class LibImages {

    //Defined instance of LibBook
    private static LibImages instance = new LibImages();

    /*
     * Static method get instance of Libook
     */
    public static LibImages getInstance() {
        return instance;
    }
    /**
     * Other image
     */
    public static final String SPLASH =
            "images" + File.separator + "other" + File.separator + "Splash.png";
    public static final String ABOUT =
            "images" + File.separator + "other" + File.separator + "About.png";

    /**
     * Label image
     */
    public static final String LABEL_EMAIL = "images" + File.separator
            + "labelImages" + File.separator + "Email.png";
    public static final String LABEL_SETTING = "images" + File.separator
            + "labelImages" + File.separator + "Setting.png";
    public static final String LABEL_LOGIN = "images" + File.separator
            + "labelImages" + File.separator + "Login.png";
    public static final String LABEL_INFOSUB = "images" + File.separator
            + "labelImages" + File.separator + "InfoSub.png";
    public static final String LABEL_INFOEMP = "images" + File.separator
            + "labelImages" + File.separator + "InfoEmp.png";
    public static final String LABEL_INFOBOOK = "images" + File.separator
            + "labelImages" + File.separator + "InfoBook.png";
    public static final String LABEL_EDITSUB = "images" + File.separator
            + "labelImages" + File.separator + "EditSub.png";
    public static final String LABEL_EDITEMP = "images" + File.separator
            + "labelImages" + File.separator + "EditEmp.png";
    public static final String LABEL_EDITBOOK = "images" + File.separator
            + "labelImages" + File.separator + "EditBook.png";
    public static final String LABEL_CONNECTFAILED = "images" + File.separator
            + "labelImages" + File.separator + "ConnectFailed.png";
    public static final String LABEL_CONNECT = "images" + File.separator
            + "labelImages" + File.separator + "Connect.png";
    public static final String LABEL_ADDSUB = "images" + File.separator
            + "labelImages" + File.separator + "AddSub.png";
    public static final String LABEL_ADDEMP = "images" + File.separator
            + "labelImages" + File.separator + "AddEmp.png";
    public static final String LABEL_ADDBOOK = "images" + File.separator
            + "labelImages" + File.separator + "AddBook.png";
    public static final String LABEL_FEERATE = "images" + File.separator
            + "labelImages" + File.separator + "FeeRate.png";
    public static final String LABEL_INFOBOR = "images" + File.separator
            + "labelImages" + File.separator + "InfoBorrow.png";

    /**
     * Menu image
     */
    public static final String MENU_ADD = "images" + File.separator
            + "menuImages" + File.separator + "Add.png";
    public static final String MENU_DELETE = "images" + File.separator
            + "menuImages" + File.separator + "Delete.png";
    public static final String MENU_EDIT = "images" + File.separator
            + "menuImages" + File.separator + "Edit.png";
    public static final String MENU_LOGOUT = "images" + File.separator
            + "menuImages" + File.separator + "Logout.png";
    public static final String MENU_QUIT = "images" + File.separator
            + "menuImages" + File.separator + "Quit.png";
    public static final String MENU_SETTING = "images" + File.separator
            + "menuImages" + File.separator + "Setting.png";
    public static final String MENU_VIEW = "images" + File.separator
            + "menuImages" + File.separator + "View.png";
    public static final String MENU_ABOUT = "images" + File.separator
            + "menuImages" + File.separator + "About.png";
    public static final String MENU_HELP = "images" + File.separator
            + "menuImages" + File.separator + "Help.png";

    /**
     * navigation bar
     */
    public static final String TASKBAR_FIRST = "images" + File.separator
            + "taskbarImages" + File.separator + "First.png";
    public static final String TASKBAR_LAST = "images" + File.separator
            + "taskbarImages" + File.separator + "Last.png";
    public static final String TASKBAR_NEXT = "images" + File.separator
            + "taskbarImages" + File.separator + "Next.png";
    public static final String TASKBAR_BACK = "images" + File.separator
            + "taskbarImages" + File.separator + "Back.png";
    /**
     * Taskbar image
     */
    public static final String TASKBAR_ADD = "images" + File.separator
            + "taskbarImages" + File.separator + "Add.png";
    public static final String TASKBAR_ANALYTIC = "images" + File.separator
            + "taskbarImages" + File.separator + "Analytic.png";
    public static final String TASKBAR_BOOK = "images" + File.separator
            + "taskbarImages" + File.separator + "Book.png";
    public static final String TASKBAR_BORROW = "images" + File.separator
            + "taskbarImages" + File.separator + "Borrow.png";
    public static final String TASKBAR_CHECKIN = "images" + File.separator
            + "taskbarImages" + File.separator + "CheckIn.png";
    public static final String TASKBAR_CHECKOUT = "images" + File.separator
            + "taskbarImages" + File.separator + "CheckOut.png";
    public static final String TASKBAR_DETELE = "images" + File.separator
            + "taskbarImages" + File.separator + "Delete.png";
    public static final String TASKBAR_EDIT = "images" + File.separator
            + "taskbarImages" + File.separator + "Edit.png";
    public static final String TASKBAR_EMPLOYEE = "images" + File.separator
            + "taskbarImages" + File.separator + "Employee.png";
    public static final String TASKBAR_FEE = "images" + File.separator
            + "taskbarImages" + File.separator + "Fee.png";
    public static final String TASKBAR_REVENUE = "images" + File.separator
            + "taskbarImages" + File.separator + "Revenue.png";
    public static final String TASKBAR_SEARCH = "images" + File.separator
            + "taskbarImages" + File.separator + "Search.png";
    public static final String TASKBAR_SENDALERT = "images" + File.separator
            + "taskbarImages" + File.separator + "SendAlert.png";
    public static final String TASKBAR_SUB = "images" + File.separator
            + "taskbarImages" + File.separator + "Sub.png";
    public static final String TASKBAR_TOPBOOK = "images" + File.separator
            + "taskbarImages" + File.separator + "TopBook.png";
    public static final String TASKBAR_TOPBORROWER = "images" + File.separator
            + "taskbarImages" + File.separator + "TopBorrower.png";
    public static final String TASKBAR_VIEW = "images" + File.separator
            + "taskbarImages" + File.separator + "View.png";
}

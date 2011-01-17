/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;

/**
 * Store path to imageicon
 * 
 * @author CuongNQ
 */
public class LibImages {

	// Defined instance of LibImages
	private static LibImages instance = new LibImages();

	/*
	 * Static method get instance of LibImages
	 */
	public static LibImages getInstance() {
		return instance;
	}

	/**
	 * Other image
	 */
	public static final String SPLASH = "/view/images/other/Splash.png";
	public static final String ABOUT = "/view/images/other/About.png";

	/**
	 * Label image 
	 */
	public static final String LABEL_EMAIL = "/view/images/labelImages/Email.png";
	public static final String LABEL_SETTING = "/view/images/labelImages/Setting.png";
	public static final String LABEL_LOGIN = "/view/images/labelImages/Login.png";
	public static final String LABEL_INFOSUB = "/view/images/labelImages/InfoSub.png";
	public static final String LABEL_INFOEMP = "/view/images/labelImages/InfoEmp.png";
	public static final String LABEL_INFOBOOK = "/view/images/labelImages/InfoBook.png";
	public static final String LABEL_EDITSUB = "/view/images/labelImages/EditSub.png";
	public static final String LABEL_EDITEMP = "/view/images/labelImages/EditEmp.png";
	public static final String LABEL_EDITBOOK = "/view/images/labelImages/EditBook.png";
	public static final String LABEL_CONNECTFAILED = "/view/images/labelImages/ConnectFailed.png";
	public static final String LABEL_CONNECT = "/view/images/labelImages/Connect.png";
	public static final String LABEL_ADDSUB = "/view/images/labelImages/AddSub.png";
	public static final String LABEL_ADDEMP = "/view/images/labelImages/AddEmp.png";
	public static final String LABEL_ADDBOOK = "/view/images/labelImages/AddBook.png";
	public static final String LABEL_FEERATE = "/view/images/labelImages/FeeRate.png";
	public static final String LABEL_INFOBOR = "/view/images/labelImages/InfoBorrow.png";

	/**
	 * Menu image
	 */
	public static final String MENU_ADD = "/view/images/menuImages/Add.png";
	public static final String MENU_DELETE = "/view/images/menuImages/Delete.png";
	public static final String MENU_EDIT = "/view/images/menuImages/Edit.png";
	public static final String MENU_LOGOUT = "/view/images/menuImages/Logout.png";
	public static final String MENU_QUIT = "/view/images/menuImages/Quit.png";
	public static final String MENU_SETTING = "/view/images/menuImages/Setting.png";
	public static final String MENU_VIEW = "/view/images/menuImages/View.png";
	public static final String MENU_ABOUT = "/view/images/menuImages/About.png";
	public static final String MENU_HELP = "/view/images/menuImages/Help.png";

	/**
	 * navigation bar
	 */
	public static final String TASKBAR_FIRST = "/view/images/taskbarImages/First.png";
	public static final String TASKBAR_LAST = "/view/images/taskbarImages/Last.png";
	public static final String TASKBAR_NEXT = "/view/images/taskbarImages/Next.png";
	public static final String TASKBAR_BACK = "/view/images/taskbarImages/Back.png";
	/**
	 * Taskbar image
	 */
	public static final String TASKBAR_ADD = "/view/images/taskbarImages/Add.png";
	public static final String TASKBAR_ANALYTIC = "/view/images/taskbarImages/Analytic.png";
	public static final String TASKBAR_BOOK = "/view/images/taskbarImages/Book.png";
	public static final String TASKBAR_BORROW = "/view/images/taskbarImages/Borrow.png";
	public static final String TASKBAR_CHECKIN = "/view/images/taskbarImages/CheckIn.png";
	public static final String TASKBAR_CHECKOUT = "/view/images/taskbarImages/CheckOut.png";
	public static final String TASKBAR_DETELE = "/view/images/taskbarImages/Delete.png";
	public static final String TASKBAR_EDIT = "/view/images/taskbarImages/Edit.png";
	public static final String TASKBAR_EMPLOYEE = "/view/images/taskbarImages/Employee.png";
	public static final String TASKBAR_FEE = "/view/images/taskbarImages/Fee.png";
	public static final String TASKBAR_REVENUE = "/view/images/taskbarImages/Revenue.png";
	public static final String TASKBAR_SEARCH = "/view/images/taskbarImages/Search.png";
	public static final String TASKBAR_SENDALERT = "/view/images/taskbarImages/SendAlert.png";
	public static final String TASKBAR_SUB = "/view/images/taskbarImages/Sub.png";
	public static final String TASKBAR_TOPBOOK = "/view/images/taskbarImages/TopBook.png";
	public static final String TASKBAR_TOPBORROWER = "/view/images/taskbarImages/TopBorrower.png";
	public static final String TASKBAR_VIEW = "/view/images/taskbarImages/View.png";
}

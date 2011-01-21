/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Store path to image icon
 * 
 * @author CuongNQ
 */
public class LibImages {

	// Defined instance of LibImages
	private static LibImages instance = new LibImages();

	/**
	 * Other image
	 */
	public static final String SPLASH = Messages.getString("LibImages.0"); //$NON-NLS-1$

	public static final String ABOUT = Messages.getString("LibImages.1"); //$NON-NLS-1$
	/**
	 * Label image
	 */
	public static final String LABEL_EMAIL = Messages.getString("LibImages.2"); //$NON-NLS-1$

	public static final String LABEL_SETTING = Messages
			.getString("LibImages.3"); //$NON-NLS-1$
	public static final String LABEL_LOGIN = Messages.getString("LibImages.4"); //$NON-NLS-1$
	public static final String LABEL_INFOSUB = Messages
			.getString("LibImages.5"); //$NON-NLS-1$
	public static final String LABEL_INFOEMP = Messages
			.getString("LibImages.6"); //$NON-NLS-1$
	public static final String LABEL_INFOBOOK = Messages
			.getString("LibImages.7"); //$NON-NLS-1$
	public static final String LABEL_EDITSUB = Messages
			.getString("LibImages.8"); //$NON-NLS-1$
	public static final String LABEL_EDITEMP = Messages
			.getString("LibImages.9"); //$NON-NLS-1$
	public static final String LABEL_EDITBOOK = Messages
			.getString("LibImages.10"); //$NON-NLS-1$
	public static final String LABEL_CONNECTFAILED = Messages
			.getString("LibImages.11"); //$NON-NLS-1$
	public static final String LABEL_CONNECT = Messages
			.getString("LibImages.12"); //$NON-NLS-1$
	public static final String LABEL_ADDSUB = Messages
			.getString("LibImages.13"); //$NON-NLS-1$
	public static final String LABEL_ADDEMP = Messages
			.getString("LibImages.14"); //$NON-NLS-1$
	public static final String LABEL_ADDBOOK = Messages
			.getString("LibImages.15"); //$NON-NLS-1$
	public static final String LABEL_FEERATE = Messages
			.getString("LibImages.16"); //$NON-NLS-1$
	public static final String LABEL_INFOBOR = Messages
			.getString("LibImages.17"); //$NON-NLS-1$
	/**
	 * Menu image
	 */
	public static final String MENU_LOGOUT = Messages.getString("LibImages.21"); //$NON-NLS-1$
	public static final String MENU_QUIT = Messages.getString("LibImages.22"); //$NON-NLS-1$
	public static final String MENU_SETTING = Messages
			.getString("LibImages.23"); //$NON-NLS-1$
	public static final String MENU_PRO_SETTING = Messages
			.getString("LibImages.48"); //$NON-NLS-1$
	public static final String MENU_ABOUT = Messages.getString("LibImages.25"); //$NON-NLS-1$
	public static final String MENU_HELP = Messages.getString("LibImages.26"); //$NON-NLS-1$
	/**
	 * navigation bar
	 */
	public static final String TASKBAR_FIRST = Messages
			.getString("LibImages.27"); //$NON-NLS-1$

	public static final String TASKBAR_LAST = Messages
			.getString("LibImages.28"); //$NON-NLS-1$
	public static final String TASKBAR_NEXT = Messages
			.getString("LibImages.29"); //$NON-NLS-1$
	public static final String TASKBAR_BACK = Messages
			.getString("LibImages.30"); //$NON-NLS-1$
	/**
	 * Taskbar image
	 */
	public static final String TASKBAR_ADD = Messages.getString("LibImages.31"); //$NON-NLS-1$
	public static final String TASKBAR_ANALYTIC = Messages
			.getString("LibImages.32"); //$NON-NLS-1$
	public static final String TASKBAR_BOOK = Messages
			.getString("LibImages.33"); //$NON-NLS-1$
	public static final String TASKBAR_BORROW = Messages
			.getString("LibImages.34"); //$NON-NLS-1$
	public static final String TASKBAR_CHECKIN = Messages
			.getString("LibImages.35"); //$NON-NLS-1$
	public static final String TASKBAR_CHECKOUT = Messages
			.getString("LibImages.36"); //$NON-NLS-1$
	public static final String TASKBAR_DELETE = Messages
			.getString("LibImages.37"); //$NON-NLS-1$
	public static final String TASKBAR_EDIT = Messages
			.getString("LibImages.38"); //$NON-NLS-1$
	public static final String TASKBAR_EMPLOYEE = Messages
			.getString("LibImages.39"); //$NON-NLS-1$
	public static final String TASKBAR_FEE = Messages.getString("LibImages.40"); //$NON-NLS-1$
	public static final String TASKBAR_REVENUE = Messages
			.getString("LibImages.41"); //$NON-NLS-1$
	public static final String TASKBAR_SEARCH = Messages
			.getString("LibImages.42"); //$NON-NLS-1$
	public static final String TASKBAR_SENDALERT = Messages
			.getString("LibImages.43"); //$NON-NLS-1$
	public static final String TASKBAR_SUB = Messages.getString("LibImages.44"); //$NON-NLS-1$
	public static final String TASKBAR_TOPBOOK = Messages
			.getString("LibImages.45"); //$NON-NLS-1$
	public static final String TASKBAR_TOPBORROWER = Messages
			.getString("LibImages.46"); //$NON-NLS-1$
	public static final String TASKBAR_VIEW = Messages
			.getString("LibImages.47"); //$NON-NLS-1$

	/*
	 * Static method get instance of LibImages
	 */
	public static LibImages getInstance() {
		return instance;
	}
}

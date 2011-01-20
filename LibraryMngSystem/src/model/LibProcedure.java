/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * 
 * @author CuongNQ
 */
public class LibProcedure {

	// Defined instance of LibProcedure
	private static LibProcedure instance = new LibProcedure();

	/**
	 * Login procedure
	 */
	public static final String LOGIN = Messages.getString("LibProcedure.0"); //$NON-NLS-1$

	/**
	 * Fee procedure
	 */
	public static final String GET_FEE = Messages.getString("LibProcedure.1"); //$NON-NLS-1$
	public static final String EDIT_FEE = Messages.getString("LibProcedure.2"); //$NON-NLS-1$
	/**
	 * Book procedure
	 */
	public static final String ADD_BOOK = Messages.getString("LibProcedure.3"); //$NON-NLS-1$
	public static final String EDIT_BOOK = Messages.getString("LibProcedure.4"); //$NON-NLS-1$
	public static final String GET_BOOK_INFO = Messages
			.getString("LibProcedure.5"); //$NON-NLS-1$
	public static final String GET_BOOK_BOR_INFO = Messages
			.getString("LibProcedure.6"); //$NON-NLS-1$
	public static final String SEARCH_BOOK = Messages
			.getString("LibProcedure.7"); //$NON-NLS-1$
	public static final String GET_NEWEST_BOOKID = Messages
			.getString("LibProcedure.8"); //$NON-NLS-1$
	public static final String DETELE_BOOK = Messages
			.getString("LibProcedure.9"); //$NON-NLS-1$
	/**
	 * Employee procedure
	 */
	public static final String GET_EMP_INFO = Messages
			.getString("LibProcedure.10"); //$NON-NLS-1$
	public static final String GET_EMP_BOR_INFO = Messages
			.getString("LibProcedure.11"); //$NON-NLS-1$
	public static final String ADD_LIB = Messages.getString("LibProcedure.12"); //$NON-NLS-1$
	public static final String ADD_EMP = Messages.getString("LibProcedure.13"); //$NON-NLS-1$
	public static final String EDIT_LIB = Messages.getString("LibProcedure.14"); //$NON-NLS-1$
	public static final String EDIT_EMP = Messages.getString("LibProcedure.15"); //$NON-NLS-1$
	public static final String GET_EMP_BY_NAME = Messages
			.getString("LibProcedure.16"); //$NON-NLS-1$
	public static final String GET_EMP_BY_ID = Messages
			.getString("LibProcedure.17"); //$NON-NLS-1$
	public static final String DETELE_EMP = Messages
			.getString("LibProcedure.18"); //$NON-NLS-1$
	/**
	 * Subject procedure
	 */
	public static final String ADD_SUB = Messages.getString("LibProcedure.19"); //$NON-NLS-1$
	public static final String GET_SUBID = Messages
			.getString("LibProcedure.20"); //$NON-NLS-1$
	public static final String GET_ALL_SUBNAME = Messages
			.getString("LibProcedure.21"); //$NON-NLS-1$
	public static final String GET_SUB_BY_NAME = Messages
			.getString("LibProcedure.22"); //$NON-NLS-1$
	public static final String GET_SUB_BY_ID = Messages
			.getString("LibProcedure.23"); //$NON-NLS-1$
	public static final String GET_SUB = Messages.getString("LibProcedure.24"); //$NON-NLS-1$
	public static final String EDIT_SUB = Messages.getString("LibProcedure.25"); //$NON-NLS-1$
	public static final String DETELE_SUB = Messages
			.getString("LibProcedure.26"); //$NON-NLS-1$
	/**
	 * Check out
	 */
	public static final String PREPARE_CHECKOUT = Messages
			.getString("LibProcedure.27"); //$NON-NLS-1$
	public static final String CHECK_OUT = Messages
			.getString("LibProcedure.28"); //$NON-NLS-1$
	/**
	 * Borrow Manage
	 */
	public static final String GET_BOR_BY_CALLNO = Messages
			.getString("LibProcedure.29"); //$NON-NLS-1$
	public static final String GET_BOR_BY_EMPID = Messages
			.getString("LibProcedure.30"); //$NON-NLS-1$
	public static final String GET_FULL_BOR_INFO = Messages
			.getString("LibProcedure.31"); //$NON-NLS-1$
	public static final String DETELE_BORROW = Messages
			.getString("LibProcedure.32"); //$NON-NLS-1$
	/**
	 * Searching to check-in
	 */
	public static final String SEARCH_CHECKOUT_BY_BORID = Messages
			.getString("LibProcedure.33"); //$NON-NLS-1$
	public static final String SEARCH_CHECKOUT_BY_BOOK_INFO = Messages
			.getString("LibProcedure.34"); //$NON-NLS-1$
	public static final String SERCH_CHECKOUT_BY_EMPID = Messages
			.getString("LibProcedure.35"); //$NON-NLS-1$
	public static final String SEARCH_CHECKOUT_BY_EMPNAME = Messages
			.getString("LibProcedure.36"); //$NON-NLS-1$
	/**
	 * Check-in
	 */
	public static final String CHECK_IN = Messages.getString("LibProcedure.37"); //$NON-NLS-1$
	/**
	 * Analytic procedure
	 */
	public static final String TOP_BOOK = Messages.getString("LibProcedure.38"); //$NON-NLS-1$
	public static final String TOP_BORROWER = Messages
			.getString("LibProcedure.39"); //$NON-NLS-1$
	public static final String GET_CHECKING_OUT = Messages
			.getString("LibProcedure.40"); //$NON-NLS-1$

	/**
	 * Static method get instance of LibProcedure
	 */
	public static LibProcedure getInstance() {
		return instance;
	}
}

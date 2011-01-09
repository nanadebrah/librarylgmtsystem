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

    //Defined instance of LibBook
    private static LibProcedure instance = new LibProcedure();

    /*
     * Static method get instance of Libook
     */
    public static LibProcedure getInstance() {
        return instance;
    }
    /**
     * Login procedure
     */
    public static final String LOGIN = "{call sp_Login(?,?)}";
    /**
     * Fee procedure
     */
    public static final String GET_FEE = "{call sp_GetFee}";
    public static final String EDIT_FEE = "{call sp_EditFee(?,?)}";
    /**
     * Book procedure
     */
    public static final String ADD_BOOK = "{call sp_AddBook(?,?,?,?,?,?,?,?)}";
    public static final String EDIT_BOOK = "{call sp_EditBook(?,?,?,?,?,?,?,?,?)}";
    public static final String GET_BOOK_INFO = "{call sp_GetBookInfo(?)}";
    public static final String GET_BOOK_BOR_INFO = "{call sp_GetBookBorInfo(?)}";
    public static final String SEARCH_BOOK = "{call sp_SearchBook(?,?,?,?,?,?,?)}";
    public static final String GET_NEWEST_BOOKID = "{call sp_GetNewestBookID}";
    public static final String DETELE_BOOK = "{call sp_DelBook(?)}";
    /**
     * Employee procedure
     */
    public static final String GET_EMP_INFO = "{call sp_GetEmpInfo(?)}";
    public static final String GET_EMP_BOR_INFO = "{call sp_GetEmpBorowInfo(?)}";
    public static final String ADD_LIB = "{call sp_AddLib(?,?,?,?,?,?,?,?)}";
    public static final String ADD_EMP = "{call sp_AddEmp(?,?,?,?,?,?,?)}";
    public static final String EDIT_LIB = "{call sp_EditLib(?,?,?,?,?,?,?,?,?,?)}";
    public static final String EDIT_EMP = "{call sp_EditEmp(?,?,?,?,?,?,?,?)}";
    public static final String GET_EMP_BY_NAME =
            "{call sp_GetAnEmpWithName(?,?,?,?)}";
    public static final String GET_EMP_BY_ID =
            "{call sp_GetAnEmpWithEmpID(?,?,?,?)}";
    public static final String DETELE_EMP = "{call sp_DelEmp(?)}";
    /**
     * Subject procedure
     */
    public static final String ADD_SUB = "{call sp_AddSub(?,?)}";
    public static final String GET_SUBID = "{call sp_GetSubID(?)}";
    public static final String GET_ALL_SUBNAME = "{call sp_GetAllSubName}";
    public static final String GET_SUB_BY_NAME = "{call sp_GetSubByName(?,?,?,?)}";
    public static final String GET_SUB_BY_ID = "{call sp_GetSubByID(?,?,?,?)}";
    public static final String GET_SUB = "{call sp_GetSub(?)}";
    public static final String EDIT_SUB = "{call sp_EditSub(?,?,?)}";
    public static final String DETELE_SUB = "{call sp_DelSub(?)}";
    /**
     * Borrow procedure
     */
    //Check out
    public static final String PREPARE_CHECKOUT = "{call sp_PrepareCheckOut(?)}";
    public static final String CHECK_OUT = "{call sp_CheckOut(?,?,?)}";
    //-------------------------------------------------------
    //Borrow Manage
    public static final String GET_BOR_BY_CALLNO = "{call sp_GetBorrowByCalNo(?,?,?,?)}";
    public static final String GET_BOR_BY_EMPID = "{call sp_GetBorrowByEmpID(?,?,?,?)}";
    public static final String GET_FULL_BOR_INFO = "{call sp_GetFullBorrowInfo(?,?,?)}";
    public static final String DETELE_BORROW = "{call sp_DelBorrow(?,?)}";
    //-------------------------------------------------------
    //Searching to check=in
    public static final String SEARCH_CHECKOUT_BY_BORID =
            "{call sp_SearhCheckOutByBorID(?)}";
    public static final String SEARCH_CHECKOUT_BY_BOOK_INFO =
            "{call sp_SearhCheckOutByBookInfo(?,?,?,?,?,?,?)}";
    public static final String SERCH_CHECKOUT_BY_EMPID =
            "{call sp_SearhCheckOutByEmpID(?,?,?,?)}";
    public static final String SEARCH_CHECKOUT_BY_EMPNAME =
            "{call sp_SearhCheckOutByEmpName(?,?,?,?)}";
    //-------------------------------------------------------
    //Check-in
    public static final String CHECK_IN = "{call sp_CheckIn(?,?,?,?)}";
    //-------------------------------------------------------
    /**
     * Analytic procedure
     */
    public static final String TOP_BOOK = "{call sp_GetTopBook(?,?,?)}";
    public static final String TOP_BORROWER = "{call sp_GetTopBorrower(?,?,?)}";
}

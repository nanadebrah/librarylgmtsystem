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
    public static final String SEARCH_BOOK = "{call sp_GetAllBook(?,?,?,?,?,?,?)}";
    public static final String GET_NEWEST_BOOK = "{call sp_GetNewestBook}";
    public static final String DETELE_BOOK = "{call sp_DelBook(?)}";
    /**
     * Employee procedure
     */
    public static final String GET_EMP_INFO = "{call sp_GetEmpInfo(?)}";
    public static final String GET_EMP_BOR_INFO = "{call sp_GetEmpBorowInfo(?)}";
    public static final String ADD_LIB = "{call sp_InsLib(?,?,?,?,?,?,?,?)}";
    public static final String ADD_EMP = "{call sp_InsEmp(?,?,?,?,?,?,?)}";
    public static final String EDIT_LIB = "{call sp_EditLib(?,?,?,?,?,?,?,?,?)}";
    public static final String EDIT_EMP = "{call sp_EditEmp(?,?,?,?,?,?,?,?)}";
    public static final String GET_ALL_EMP = "{call sp_GetAllEmp(?,?,?)}";
    public static final String GET_EMP_BY_NAME =
            "{call sp_GetAnEmpWithName(?,?,?,?)}";
    public static final String GET_EMP_BY_ID =
            "{call sp_GetAnEmpWithEmpID(?,?,?,?)}";
    public static final String GET_NEWEST_EMP = "{call sp_GetNewestEmp}";
    public static final String DETELE_EMP = "{call sp_DelEmp(?)}";
    /**
     * Subject procedure
     */
    public static final String ADD_SUB = "{call sp_AddSub(?,?)}";    
    public static final String GET_SUBNAME = "{call sp_GetSubName(?)}";
    public static final String GET_ALL_SUBNAME = "{call sp_GetAllSubName}";
    public static final String GET_SUB_BY_NAME = "{call sp_GetSubByName(?,?,?,?)}";
    public static final String GET_SUB_WITH_ID = "{call sp_GetSubWithID(?,?,?,?)}";
    public static final String GET_SUB_BY_ID = "{call sp_GetSubByID(?)}";
    public static final String EDIT_SUB = "{call sp_EditSub(?,?,?)}";
    public static final String GET_NEWEST_SUB = "{call sp_GetNewestSub}";
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
    public static final String GET_ALL_BORROW = "{call sp_GetAllBorrow}";
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
}

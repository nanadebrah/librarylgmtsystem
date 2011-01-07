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
    public static final String GET_BOOK = "{call sp_GetABook(?)}";
    public static final String SEARCH_BOOK = "{call sp_GetAllBook(?,?,?,?)}";
    public static final String GET_NEWEST_BOOK = "{call sp_GetNewestBook}";
    /**
     * Employee procedure
     */
    public static final String GET_EMP = "{call sp_GetEmp(?)}";
    public static final String ADD_LIB = "{call sp_InsLib(?,?,?,?,?,?,?,?)}";
    public static final String ADD_EMP = "{call sp_InsEmp(?,?,?,?,?,?,?)}";
    public static final String GET_ALL_EMP = "{call sp_GetAllEmp}";
    public static final String EDIT_LIB = "{call sp_EditLib(?,?,?,?,?,?,?,?,?)}";
    public static final String EDIT_EMP = "{call sp_EditEmp(?,?,?,?,?,?,?,?)}";
    public static final String GET_EMP_BY_NAME = "{call sp_GetAnEmpWithName(?)}";
    public static final String GET_EMP_BY_ID = "{call sp_GetAnEmpWithEmpID(?)}";
    public static final String GET_EMP_BY_BOTH = "{call sp_GetAnEmpAll(?,?)}";
    public static final String GET_NEWEST_EMP = "{call sp_GetNewestEmp}";
    /**
     * Subject procedure
     */
    public static final String ADD_SUB = "{call sp_AddSub(?,?)}";
    public static final String GET_SUBID = "{call sp_GetSubID(?)}";
    public static final String GET_SUBNAME = "{call sp_GetSubName(?)}";
    public static final String GET_ALL_SUBNAME = "{call sp_GetAllSubName}";
    public static final String GET_ALL_SUB = "{call sp_GetAllSub}";
    public static final String GET_SUB_BY_NAME = "{call sp_GetSubByName(?)}";
    public static final String GET_SUB = "{call sp_GetSubByID(?)}";
    public static final String GET_SUB_BY_BOTH = "{call sp_GetSubByAll(?,?)}";
    public static final String EDIT_SUB = "{call sp_EditSub(?,?,?)}";
    public static final String GET_NEWEST_SUB = "{call sp_GetNewestSub}";
    /**
     * Borrow procedure
     */
    public static final String ADD_BORROW = "{call sp_AddBorrow(?)}";
    public static final String ADD_BORDETAIL = "{call sp_AddBorDetail(?,?,?,?,?)}";
    public static final String GET_NEWEST_BORROWID = "{call sp_GetNewestBorrowID}";
    public static final String GET_BORROW_BY_BORID = "{call sp_GetBorrowByBorID(?)}";
    public static final String GET_BOR_BY_CALLNO = "{call sp_GetBorrowByCalNo(?)}";
    public static final String GET_BOR_BY_EMPID = "{call sp_GetBorrowByEmpID(?)}";
    public static final String GET_BOR_BY_BOTH = "{call sp_GetBorrowByBoth(?,?)}";
    public static final String GET_ALL_BORROW = "{call sp_GetAllBorrow}";

    public static final String SEARCH_ALL_CHECKOUT =
            "{call sp_SearhAllCheckOut}";
    public static final String SEARCH_CHECKOUT_BY_BORID =
            "{call sp_SearhCheckOutByBorID(?)}";
    public static final String SEARCH_CHECKOUT_BY_BOOK_INFO =
            "{call sp_SearhCheckOutByBookInfo(?,?,?,?)}";
    public static final String SERCH_CHECKOUT_BY_EMPID =
            "{call sp_SearhCheckOutByEmpID(?)}";
    public static final String SEARCH_CHECKOUT_BY_EMPNAME =
            "{call sp_SearhCheckOutByEmpName(?)}";
    public static final String SEARCH_CHECKOUT_BY_ALL_EMPINFO =
            "{call sp_SearhCheckOutByAllEmpInfo(?,?)}";
}

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
    public static final String GETFEE = "{call sp_GetFee}";
    /**
     * Book procedure
     */
    public static final String ADDBOOK = "{call sp_AddBook(?,?,?,?,?,?,?,?)}";
    public static final String EDITBOOK = "{call sp_EditBook(?,?,?,?,?,?,?,?,?)}";
    public static final String GETBOOK = "{call sp_GetABook(?)}";
    public static final String SEARCHBOOK = "{call sp_GetAllBook(?,?,?,?)}";
    public static final String GETNEWESTBOOK = "{call sp_GetNewestBook}";
    /**
     * Employee procedure
     */
    public static final String GETEMP = "{call sp_GetEmp(?)}";
    public static final String ADDLIB = "{call sp_InsLib(?,?,?,?,?,?,?,?)}";
    public static final String ADDEMP = "{call sp_InsEmp(?,?,?,?,?,?,?)}";
    public static final String GETALLEMP = "{call sp_GetAllEmp}";
    public static final String EDITLIB = "{call sp_EditLib(?,?,?,?,?,?,?,?,?)}";
    public static final String EDITEMP = "{call sp_EditEmp(?,?,?,?,?,?,?,?)}";
    public static final String GETEMPBYNAME = "{call sp_GetAnEmpWithName(?)}";
    public static final String GETEMPBYID = "{call sp_GetAnEmpWithEmpID(?)}";
    public static final String GETEMPBYBOTH = "{call sp_GetAnEmpAll(?,?)}";
    public static final String GETNEWESTEMP = "{call sp_GetNewestEmp}";
    /**
     * Subject procedure
     */
    public static final String ADDSUB = "{call sp_AddSub(?,?)}";
    public static final String GETSUBID = "{call sp_GetSubID(?)}";
    public static final String GETSUBNAME = "{call sp_GetSubName(?)}";
    public static final String GETALLSUBNAME = "{call sp_GetAllSubName}";
    public static final String GETALLSUB = "{call sp_GetAllSub}";
    public static final String GETSUBBYNAME = "{call sp_GetSubByName(?)}";
    public static final String GETSUB = "{call sp_GetSubByID(?)}";
    public static final String GETSUBBYBOTH = "{call sp_GetSubByAll(?,?)}";
    public static final String EDITSUB = "{call sp_EditSub(?,?,?)}";
    public static final String GETNEWESTSUB = "{call sp_GetNewestSub}";
    /**
     * Borrow procedure
     */
    public static final String ADDBORROW = "{call sp_AddBorrow(?)}";
    public static final String ADDBORDETAIL = "{call sp_AddBorDetail(?,?,?,?,?)}";
    public static final String GETNEWESTBORROWID = "{call sp_GetNewestBorrowID}";
    public static final String GETBORROWBYBORID = "{call sp_GetBorrowByBorID(?)}";
    public static final String GETBORBYCALLNO = "{call sp_GetBorrowByCalNo(?)}";
    public static final String GETBORBYEMPID = "{call sp_GetBorrowByEmpID(?)}";
    public static final String GETBORBYBOTH = "{call sp_GetBorrowByBoth(?,?)}";
    public static final String GETALLBORROW = "{call sp_GetAllBorrow}";
}

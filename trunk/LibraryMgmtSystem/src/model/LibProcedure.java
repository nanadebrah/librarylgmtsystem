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
     * Book procedure
     */
    public static final String AddBook = "{call sp_AddBook(?,?,?,?,?,?,?,?)}";
    public static final String EditBook = "{call sp_EditBook(?,?,?,?,?,?,?,?,?)}";
    public static final String GetABook = "{call sp_GetABook(?)}";
    public static final String SearchBook = "{call sp_GetAllBook(?,?,?,?)}";
    public static final String GetNewestBook = "{call sp_GetNewestBook}";
    /**
     * Employee procedure
     */
    public static final String GetAEmp = "{call sp_GetEmp(?)}";
    public static final String AddLib = "{call sp_InsLib(?,?,?,?,?,?,?,?)}";
    public static final String AddEmp = "{call sp_InsEmp(?,?,?,?,?,?,?)}";
    public static final String GetAllEmp = "{call sp_GetAllEmp}";
    public static final String EditLib = "{call sp_EditLib(?,?,?,?,?,?,?,?,?)}";
    public static final String EditEmp = "{call sp_EditEmp(?,?,?,?,?,?,?,?)}";
    public static final String GetEmpByName = "{call sp_GetAnEmpWithName(?)}";
    public static final String GetEmpByID = "{call sp_GetAnEmpWithEmpID(?)}";
    public static final String GetEmpByBoth = "{call sp_GetAnEmpAll(?,?)}";
    /**
     * Subject procedure
     */
    public static final String AddSub = "{call sp_AddSub(?,?)}";
    public static final String GetSubID = "{call sp_GetSubID(?)}";
    public static final String GetSubName = "{call sp_GetSubName(?)}";
    public static final String GetAllSubName = "{call sp_GetAllSubName}";
    public static final String GetAllSub = "{call sp_GetAllSub}";
    public static final String GetSubByName = "{call sp_GetSubByName(?)}";
    public static final String GetASub = "{call sp_GetSubByID(?)}";
    public static final String GetSubByBoth = "{call sp_GetSubByAll(?,?)}";
    public static final String EditSub = "{call sp_EditSub(?,?,?)}";
}

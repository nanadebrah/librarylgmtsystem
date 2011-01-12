/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author CuongNQ
 */
public class LibUtil {

    //Defined instance of LibBook
    private static LibUtil instance = new LibUtil();
    //Defined
    private Pattern pt;
    private Matcher ma;
    //This setting no of row display on a page
    public static int noRow = 20;

    /*
     * Static method get instance of Libook
     */
    public static LibUtil getInstance() {
        return instance;
    }

    /**
     * 
     * @param date
     * @return
     */
    public String convertDate(String date) {
        //Get year
        pt = Pattern.compile("^\\d{4}");
        ma = pt.matcher(date);
        ma.find();
        String y = ma.group();
        //Get day
        pt = Pattern.compile("\\d{2}$");
        ma = pt.matcher(date);
        ma.find();
        String d = ma.group();
        //get moth
        pt = Pattern.compile("-\\d{2}-");
        ma = pt.matcher(date);
        ma.find();
        String m = ma.group().substring(1).substring(0, 2);

        return m + "/" + d + "/" + y;
    }

    /**
     * 
     * @param totalRow
     * @return
     */
    public int getPage(int totalRow) {
        return (int) Math.ceil((float) totalRow / noRow);
    }
}

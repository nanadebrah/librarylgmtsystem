/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Book;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author CuongNQ
 */
public class LibBook {

    //Defined instance of LibBook
    private static LibBook instance = new LibBook();

    /*
     * Static method get instance of Libook
     */
    public static LibBook getInstance() {
        return instance;
    }

    /**
     *
     * @param bok is Book added from dialog
     * @return Callnumber generated
     */
    public String generateCallNo(Book bok) {
        //Defined
        String callNumber = null;
        String title, author, sequence;
        Pattern pt;
        Matcher ma;
        //First 2 alphabets of title
        pt = Pattern.compile("^\\w{2}");
        ma = pt.matcher(bok.getTitle());
        ma.find();
        title = ma.group().toUpperCase();
        //First 2 alphabets of author
        ma = pt.matcher(bok.getAuthName());
        ma.find();
        author = ma.group().toUpperCase();
        //sequence number of book
        pt = Pattern.compile("\\w{3}?");
        ma = pt.matcher(AccessBook.getInstance().getNewestBook());
        ma.find();
        Integer intSe = new Integer(ma.group());
        //increment sequence number of book
        intSe++;
        //set zero in head
        if (intSe < 10) {
            sequence = "00" + intSe.toString();
        } else if (intSe < 100) {
            sequence = "0" + intSe.toString();
        } else {
            sequence = intSe.toString();
        }
        //set complete call number and return it
        callNumber = title + "-" + author + "-" + sequence;
        return callNumber;
    }

    public String generateISBN(Book bok){
        return "";
    }
}

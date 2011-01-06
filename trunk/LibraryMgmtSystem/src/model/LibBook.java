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
    //Defined
    private String callNumber = null;
    private String title, author, sequence;
    private Pattern pt;
    private Matcher ma;

    /*
     * Static method get instance of Libook
     */
    public static LibBook getInstance() {
        return instance;
    }

    /**
     *
     * @param book is Book added from dialog
     * @return Callnumber generated
     */
    public String generateCallNo(Book book) {
        Integer intSe = 0;
        //First 2 alphabets of title
        pt = Pattern.compile("^\\w{2}");
        ma = pt.matcher(book.getTitle());
        ma.find();
        title = ma.group().toUpperCase();
        //First 2 alphabets of author
        ma = pt.matcher(book.getAuthName());
        ma.find();
        author = ma.group().toUpperCase();
        //sequence number of book
        intSe = AccessBook.getInstance().getNewestBook();
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

    public String fixCallNo(Book book) {
        //First 2 alphabets of title
        pt = Pattern.compile("^\\w{2}");
        ma = pt.matcher(book.getTitle());
        ma.find();
        title = ma.group().toUpperCase();
        //First 2 alphabets of author
        ma = pt.matcher(book.getAuthName());
        ma.find();
        author = ma.group().toUpperCase();
        //sequence number of book
        pt = Pattern.compile("\\w{3}?");
        ma = pt.matcher(book.getCallNumber());
        ma.find();
        sequence = ma.group();
        return title + "-" + author + "-" + sequence;
    }
}

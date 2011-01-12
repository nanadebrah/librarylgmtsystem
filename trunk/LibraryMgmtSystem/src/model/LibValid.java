/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author CuongNQ
 */
public class LibValid {

    private static LibValid instance = new LibValid();
    private String ISBNRegex = "\\d{3}-\\d{4}";
    private String PasswordRegex = "[a-zA-Z0-9]{4,12}";
    private String NameRegex = "^[a-zA-Z][a-zA-Z.'_0-9-]{1,99}";
    private String AddressRegex = "[a-zA-Z_0-9-.' ]{2,100}";
    private String EmailRegex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9_-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private String TitleRegex = "[a-zA-Z_0-9-.' ]{2,100}";
    private String AuthRegex = "[a-zA-Z_0-9-.' ]{2,30}";
    private String SubRegex = "[a-zA-Z_0-9-.' ]{2,30}";
    private String DepartRegex = "[a-zA-Z_0-9-.' ]{2,50}";
    private String PublishRegex = "[a-zA-Z_0-9-.' ]{2,150}";
    private String PhoneNumberRegex = "\\d{5,20}";

    /**
     *
     * @return
     */
    public static LibValid getInstance() {
        return instance;
    }

    /**
     * 
     * @param ISBN
     * @return
     */
    public boolean ISBN(String ISBN) {
        return ISBN.matches(ISBNRegex);
    }

    /**
     * 
     * @param Name
     * @return
     */
    public boolean Name(String Name) {
        return Name.matches(NameRegex);
    }

    /**
     * 
     * @param Address
     * @return
     */
    public boolean Address(String Address) {
        return Address.matches(AddressRegex);
    }

    /**
     * 
     * @param Pass
     * @return
     */
    public boolean Password(String Pass) {
        return Pass.matches(PasswordRegex);
    }

    /**
     *
     * @param Title
     * @return
     */
    public boolean Title(String Title) {
        return Title.matches(TitleRegex);
    }

    /**
     * 
     * @param Phone
     * @return
     */
    public boolean Phone(String Phone) {
        return Phone.matches(PhoneNumberRegex);
    }

    /**
     * 
     * @param Email
     * @return
     */
    public boolean Email(String Email) {
        return Email.matches(EmailRegex);
    }

    /**
     * 
     * @param Depart
     * @return
     */
    public boolean Depart(String Depart) {
        return Depart.matches(DepartRegex);
    }

    /**
     *
     * @param Auth
     * @return
     */
    public boolean Auth(String Auth) {
        return Auth.matches(AuthRegex);
    }

    /**
     *
     * @param Auth
     * @return
     */
    public boolean Publish(String Publish) {
        return Publish.matches(PublishRegex);
    }

    /**
     * 
     * @param Sub
     * @return
     */
    public boolean Sub(String Sub) {
        return Sub.matches(SubRegex);
    }
}

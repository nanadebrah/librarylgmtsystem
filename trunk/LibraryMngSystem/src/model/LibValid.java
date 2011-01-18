/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Valid all field
 * @author CuongNQ
 */
public class LibValid {

    private static LibValid instance = new LibValid();
    private String ISBNRegex = "\\d{3}-\\d{4}";
    private String EmpIDRegex = "\\d{0,10}";
    private String SubIDRegex = "\\d{0,10}";
    private String BorIDRegex = "\\d{0,10}";
    private String PasswordRegex = "[a-zA-Z0-9]{4,12}";
    private String NameRegex = "^[a-zA-Z][a-zA-Z.'_0-9- ]{1,99}";
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
     * Create instane of LibValid
     * @return instance
     */
    public static LibValid getInstance() {
        return instance;
    }

    /**
     * Valid ISBN
     * @param ISBN
     * @return true,false
     */
    public boolean ISBN(String ISBN) {
        return ISBN.matches(ISBNRegex);
    }

    /**
     * Valid Name
     * @param Name
     * @return true,false
     */
    public boolean Name(String Name) {
        return Name.matches(NameRegex);
    }

    /**
     * Valid Address
     * @param Address
     * @return true,false
     */
    public boolean Address(String Address) {
        return Address.matches(AddressRegex);
    }

    /**
     * Valid Password
     * @param Pass
     * @return true,false
     */
    public boolean Password(String Pass) {
        return Pass.matches(PasswordRegex);
    }

    /**
     * Valid Title
     * @param Title
     * @return true,false
     */
    public boolean Title(String Title) {
        return Title.matches(TitleRegex);
    }

    /**
     * Valid Phone
     * @param Phone
     * @return true,false
     */
    public boolean Phone(String Phone) {
        return Phone.matches(PhoneNumberRegex);
    }

    /**
     * Valid Email
     * @param Email
     * @return true,false
     */
    public boolean Email(String Email) {
        return Email.matches(EmailRegex);
    }

    /**
     * Valid Department
     * @param Depart
     * @return true,false
     */
    public boolean Depart(String Depart) {
        return Depart.matches(DepartRegex);
    }

    /**
     * Valid AuthorName
     * @param Auth
     * @return true,false
     */
    public boolean Auth(String Auth) {
        return Auth.matches(AuthRegex);
    }

    /**
     * Valid Puslisher
     * @param Publish
     * @return true,flase
     */
    public boolean Publish(String Publish) {
        return Publish.matches(PublishRegex);
    }

    /**
     *  Valid Subject
     * @param Sub
     * @return true,false
     */
    public boolean Sub(String Sub) {
        return Sub.matches(SubRegex);
    }

    /**
     * Valid Employee ID
     * @param EmpID
     * @return
     */
    public boolean EmpID(String EmpID) {
        return EmpID.matches(EmpIDRegex);
    }

    /**
     * Valid Subject ID
     * @param SubID
     * @return
     */
    public boolean SubID(String SubID) {
        return SubID.matches(SubIDRegex);
    }

    /**
     * Valid Borrow ID
     * @param BorID
     * @return
     */
    public boolean BorID(String BorID) {
        return BorID.matches(BorIDRegex);
    }
}

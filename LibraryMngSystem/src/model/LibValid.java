/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Valid all field
 * 
 * @author CuongNQ
 */
public class LibValid {
	// Defined instance of LibValid
	private static LibValid instance = new LibValid();

	/**
	 * Create instance of LibValid
	 * 
	 * @return instance
	 */
	public static LibValid getInstance() {
		return instance;
	}

	private String ISBNRegex = Messages.getString("ISBN"); //$NON-NLS-1$
	private String EmpIDRegex = Messages.getString("ID"); //$NON-NLS-1$
	private String SubIDRegex = Messages.getString("ID"); //$NON-NLS-1$
	private String BorIDRegex = Messages.getString("ID"); //$NON-NLS-1$
	private String PasswordRegex = Messages.getString("Password"); //$NON-NLS-1$
	private String NameRegex = Messages.getString("Name"); //$NON-NLS-1$
	private String AddressRegex = Messages.getString("Address"); //$NON-NLS-1$
	private String EmailRegex = Messages.getString("Email"); //$NON-NLS-1$
	private String TitleRegex = Messages.getString("Title"); //$NON-NLS-1$
	private String AuthRegex = Messages.getString("Author"); //$NON-NLS-1$
	private String SubRegex = Messages.getString("Subject"); //$NON-NLS-1$
	private String DepartRegex = Messages.getString("Depart"); //$NON-NLS-1$
	private String PublishRegex = Messages.getString("Publisher"); //$NON-NLS-1$
	private String PhoneNumberRegex = Messages.getString("Phone"); //$NON-NLS-1$

	/**
	 * Valid Address
	 * 
	 * @param Address
	 * @return true,false
	 */
	public boolean Address(String Address) {
		return Address.matches(AddressRegex);
	}

	/**
	 * Valid AuthorName
	 * 
	 * @param Auth
	 * @return true,false
	 */
	public boolean Auth(String Auth) {
		return Auth.matches(AuthRegex);
	}

	/**
	 * Valid Borrow ID
	 * 
	 * @param BorID
	 * @return
	 */
	public boolean BorID(String BorID) {
		return BorID.matches(BorIDRegex);
	}

	/**
	 * Valid Department
	 * 
	 * @param Depart
	 * @return true,false
	 */
	public boolean Depart(String Depart) {
		return Depart.matches(DepartRegex);
	}

	/**
	 * Valid Email
	 * 
	 * @param Email
	 * @return true,false
	 */
	public boolean Email(String Email) {
		return Email.matches(EmailRegex);
	}

	/**
	 * Valid Employee ID
	 * 
	 * @param EmpID
	 * @return
	 */
	public boolean EmpID(String EmpID) {
		return EmpID.matches(EmpIDRegex);
	}

	/**
	 * Valid ISBN
	 * 
	 * @param ISBN
	 * @return true,false
	 */
	public boolean ISBN(String ISBN) {
		return ISBN.matches(ISBNRegex);
	}

	/**
	 * Valid Name
	 * 
	 * @param Name
	 * @return true,false
	 */
	public boolean Name(String Name) {
		return Name.matches(NameRegex);
	}

	/**
	 * Valid Password
	 * 
	 * @param Pass
	 * @return true,false
	 */
	public boolean Password(String Pass) {
		return Pass.matches(PasswordRegex);
	}

	/**
	 * Valid Phone
	 * 
	 * @param Phone
	 * @return true,false
	 */
	public boolean Phone(String Phone) {
		return Phone.matches(PhoneNumberRegex);
	}

	/**
	 * Valid Publisher
	 * 
	 * @param Publish
	 * @return true,false
	 */
	public boolean Publish(String Publish) {
		return Publish.matches(PublishRegex);
	}

	/**
	 * Valid Subject
	 * 
	 * @param Sub
	 * @return true,false
	 */
	public boolean Sub(String Sub) {
		return Sub.matches(SubRegex);
	}

	/**
	 * Valid Subject ID
	 * 
	 * @param SubID
	 * @return
	 */
	public boolean SubID(String SubID) {
		return SubID.matches(SubIDRegex);
	}

	/**
	 * Valid Title
	 * 
	 * @param Title
	 * @return true,false
	 */
	public boolean Title(String Title) {
		return Title.matches(TitleRegex);
	}
}

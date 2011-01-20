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

	private String ISBNRegex = Messages.getString("LibValid.0"); //$NON-NLS-1$
	private String EmpIDRegex = Messages.getString("LibValid.1"); //$NON-NLS-1$
	private String SubIDRegex = Messages.getString("LibValid.2"); //$NON-NLS-1$
	private String BorIDRegex = Messages.getString("LibValid.3"); //$NON-NLS-1$
	private String PasswordRegex = Messages.getString("LibValid.4"); //$NON-NLS-1$
	private String NameRegex = Messages.getString("LibValid.5"); //$NON-NLS-1$
	private String AddressRegex = Messages.getString("LibValid.6"); //$NON-NLS-1$
	private String EmailRegex = Messages.getString("LibValid.7") //$NON-NLS-1$
			+ Messages.getString("LibValid.8"); //$NON-NLS-1$
	private String TitleRegex = Messages.getString("LibValid.9"); //$NON-NLS-1$
	private String AuthRegex = Messages.getString("LibValid.10"); //$NON-NLS-1$
	private String SubRegex = Messages.getString("LibValid.11"); //$NON-NLS-1$
	private String DepartRegex = Messages.getString("LibValid.12"); //$NON-NLS-1$
	private String PublishRegex = Messages.getString("LibValid.13"); //$NON-NLS-1$

	private String PhoneNumberRegex = Messages.getString("LibValid.14"); //$NON-NLS-1$

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

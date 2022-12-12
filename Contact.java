package main;

public class Contact {
	private String m_id;
	private String m_firstName;
	private String m_lastName;
	private String m_phoneNumber;
	private String m_address;
	
	public Contact(String id, String firstName, String lastName, String phoneNumber, String address) {	
		setID(id);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setAddress(address);
	}
	
	public String getID() { return m_id; }
	private void setID(String newID) { 
		if (newID == null || newID.length() > 10) {
			throw new IllegalArgumentException("'ID' must be 10 characters or less");
		}
		m_id = newID; 		
	}
	
	public String getFirstName() { return m_firstName; }
	public void setFirstName(String newFirstName) { 
		if (newFirstName == null || newFirstName.length() > 10) {
			throw new IllegalArgumentException("'First Name' ID must be 10 characters or less");
		}
		m_firstName = newFirstName; 
	}
	
	public String getLastName() { return m_lastName; }
	public void setLastName(String newLastName) { 
		if (newLastName == null || newLastName.length() > 10) {
			throw new IllegalArgumentException("'Last Name' must be 10 characters or less");
		}
		m_lastName = newLastName;
	}
	
	public String getPhoneNumber() { return m_phoneNumber; }
	public void setPhoneNumber(String newPhoneNumber) { 
		if (newPhoneNumber == null || newPhoneNumber.length() != 10) {
			throw new IllegalArgumentException("'Phone Number' must be exactly 10 characters (ex: '3334445555'");
		}
		m_phoneNumber = newPhoneNumber; 
	}
	
	public String getAddress() { return m_address; }
	public void setAddress(String newAddress) { 
		if (newAddress == null || newAddress.length() > 30) {
			throw new IllegalArgumentException("'Address' must be 30 characters or less");
		}
		m_address = newAddress; 
	}
}

package test;


import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.Contact;

class ContactTest {
	private static Contact testContact;
	private static String contactID;
	private static String firstName;
	private static String lastName;
	private static String phoneNumber;
	private static String address;
	
	@BeforeAll
	static void createTestContact() {
		contactID = "12345";
		firstName = "Nicolas";
		lastName = "Blaisdell";
		phoneNumber = "1234567890";
		address = "123 Main Street";	
		
		testContact = new Contact(contactID, firstName, lastName, phoneNumber, address);
	}

	@Test
	void testContactConstructor() {		
		assertTrue(testContact.getID() == contactID);
		assertTrue(testContact.getFirstName() == firstName);
		assertTrue(testContact.getLastName() == lastName);
		assertTrue(testContact.getPhoneNumber() == phoneNumber);
		assertTrue(testContact.getAddress() == address);
	}
	
	@Test
	void testID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123451234512345", null, null, null, null);			
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, null, null, null, null);	
		});		
	}
	
	@Test
	void testFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setFirstName("NicolasNicolasNicolas");			
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setFirstName(null);			
		});
	}
	
	@Test
	void testLastName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setLastName("BlaisdellBlaisdellBlaisdell");			
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setLastName(null);			
		});
	}
	
	@Test
	void testPhoneNumber() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setPhoneNumber("123451234512345");			
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setPhoneNumber(null);			
		});
	}
	
	@Test
	void testAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setAddress("123 Main Street 123 Main Street 123 Main Street 123 Main Street");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testContact.setAddress(null);
		});
	}
}

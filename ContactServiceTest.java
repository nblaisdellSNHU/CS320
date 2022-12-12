package test;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import main.Contact;
import main.ContactService;

class ContactServiceTest {
	private static Contact testContact;
	private static String contactID;
	private static String firstName;
	private static String lastName;
	private static String phoneNumber;
	private static String address;
	
	private static ContactService testContactService;
	
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
	void testContactServiceConstructor() {
		testContactService = new ContactService();
		
		assertTrue(testContactService.getContactsCount() == 0);
	}
	
	@Test
	void testAddContact() throws Exception {
		testContactService = new ContactService();
		
		assertTrue(testContactService.getContactsCount() == 0);		
		testContactService.addContact(testContact);
		assertTrue(testContactService.getContactsCount() == 1);			
	}

	@Test
	void testAddExistingContact() throws Exception {
		testContactService = new ContactService();
		
		Assertions.assertThrows(Exception.class, () -> {
			testContactService.addContact(testContact);
			testContactService.addContact(testContact);
		});
	}
	
	@Test
	void testDeleteContact() throws Exception {
		testContactService = new ContactService();

		testContactService.addContact(testContact);
		assertTrue(testContactService.getContactsCount() == 1);
		
		testContactService.deleteContact(testContact.getID());
		assertTrue(testContactService.getContactsCount() == 0);	
	}
	
	@Test
	void testDeleteNonExistingContact() throws Exception {
		testContactService = new ContactService();

		// Add a real Contact and get the current count (should be 1)
		testContactService.addContact(testContact);
		int currContactCount = testContactService.getContactsCount();
		
		// Attempt to delete a non-existing contact
		// and assert that the contacts count did not change
		testContactService.deleteContact(testContact.getID() + "999");
		assertTrue(testContactService.getContactsCount() == currContactCount);
	}
	
	@Test
	void testUpdateContact() throws Exception {
		testContactService = new ContactService();

		testContactService.addContact(testContact);
		
		testContact.setFirstName("New First");
		testContact.setLastName("New Last");
		testContact.setPhoneNumber("3334445555");
		testContact.setAddress("New Address");
		testContactService.updateContact(testContact);		
	}
	
	@Test
	void testUpdateNonExistingContact() throws Exception {
		testContactService = new ContactService();
		testContactService.addContact(testContact);
		
		Assertions.assertThrows(Exception.class, () -> {
			testContactService.updateContact(new Contact("456", "", "", "3334445555", ""));
		});		
	}
}

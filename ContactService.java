package main;

import java.util.HashMap;
import java.util.Set;

public class ContactService {
	HashMap<String, Contact> m_contacts;
	
	public ContactService() {
		m_contacts = new HashMap<String, Contact>();
	}
	
	public void addContact(Contact contact) throws Exception {
		Set<String> keys = m_contacts.keySet();
		String contactID = contact.getID();
		
		if (keys.contains(contactID)) {
			throw new Exception("Contact with ID (" + contactID + ") already exists.");
		}
		
		m_contacts.put(contactID, contact);
	}
	
	public void deleteContact(String contactID) {
		m_contacts.remove(contactID);
	}
	
	public void updateContact(Contact newContact) throws Exception {
		String newContactID = newContact.getID();		
		System.out.println("newContactID " + newContactID);
		System.out.println("ContainsKey: " + !m_contacts.containsKey(newContactID));
		
		if (!m_contacts.containsKey(newContactID)) {
			throw new Exception("No Contact with ID (" + newContactID + ") found.");
		}		
		
		Contact toUpdate = m_contacts.get(newContactID);
		toUpdate.setFirstName(newContact.getFirstName());
		toUpdate.setLastName(newContact.getLastName());
		toUpdate.setPhoneNumber(newContact.getPhoneNumber());
		toUpdate.setAddress(newContact.getAddress());			
	}
	
	public int getContactsCount() {
		return m_contacts.size();
	}
}

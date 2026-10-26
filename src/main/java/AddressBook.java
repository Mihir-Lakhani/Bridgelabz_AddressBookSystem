import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private final String name;
    private final List<ContactPerson> contacts = new ArrayList<>();

    public AddressBook(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<ContactPerson> getContacts() {
        return contacts;
    }

    public void addContact(ContactPerson contact) {
        contacts.add(contact);
    }

    public ContactPerson findContact(String firstName, String lastName) {
        for (ContactPerson contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)
                    && contact.getLastName().equalsIgnoreCase(lastName)) {
                return contact;
            }
        }
        return null;
    }

    public boolean editContact(String firstName, String lastName, ContactPerson updatedContact) {
        ContactPerson contact = findContact(firstName, lastName);
        if (contact == null) {
            return false;
        }
        contact.updateFrom(updatedContact);
        return true;
    }

    public boolean deleteContact(String firstName, String lastName) {
        ContactPerson contact = findContact(firstName, lastName);
        if (contact == null) {
            return false;
        }
        contacts.remove(contact);
        return true;
    }
}

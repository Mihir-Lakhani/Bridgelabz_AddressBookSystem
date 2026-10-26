import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public boolean addContact(ContactPerson contact) {
        boolean alreadyExists = contacts.stream().anyMatch(existing -> existing.equals(contact));
        if (alreadyExists) {
            return false;
        }
        contacts.add(contact);
        return true;
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

    public List<ContactPerson> getContactsSortedByName() {
        return contacts.stream()
                .sorted(Comparator.comparing(ContactPerson::getFirstName, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(ContactPerson::getLastName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }
}

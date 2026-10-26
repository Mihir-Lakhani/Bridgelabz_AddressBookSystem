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
}

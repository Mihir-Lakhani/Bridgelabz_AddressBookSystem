import java.util.HashMap;
import java.util.Map;

public class AddressBookSystem {
    private final Map<String, AddressBook> addressBooks = new HashMap<>();

    public boolean addAddressBook(String name) {
        if (addressBooks.containsKey(name)) {
            return false;
        }
        addressBooks.put(name, new AddressBook(name));
        return true;
    }

    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }

    public Map<String, AddressBook> getAddressBooks() {
        return addressBooks;
    }
}

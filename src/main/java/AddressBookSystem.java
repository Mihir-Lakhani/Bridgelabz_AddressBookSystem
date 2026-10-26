import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBookSystem {
    private final Map<String, AddressBook> addressBooks = new HashMap<>();
    private Map<String, List<ContactPerson>> contactsByCity = new HashMap<>();
    private Map<String, List<ContactPerson>> contactsByState = new HashMap<>();

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

    public List<ContactPerson> searchByCity(String city) {
        return addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContacts().stream())
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<ContactPerson> searchByState(String state) {
        return addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContacts().stream())
                .filter(contact -> contact.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }

    public List<ContactPerson> getContactsInCity(String city) {
        updateCityAndStateDictionaries();
        return contactsByCity.entrySet().stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(city))
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());
    }

    public List<ContactPerson> getContactsInState(String state) {
        updateCityAndStateDictionaries();
        return contactsByState.entrySet().stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(state))
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());
    }

    private void updateCityAndStateDictionaries() {
        List<ContactPerson> allContacts = addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContacts().stream())
                .collect(Collectors.toList());
        contactsByCity = allContacts.stream()
                .collect(Collectors.groupingBy(ContactPerson::getCity));
        contactsByState = allContacts.stream()
                .collect(Collectors.groupingBy(ContactPerson::getState));
    }
}

import java.util.Locale;
import java.util.Objects;

public class ContactPerson {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public ContactPerson(String firstName, String lastName, String address,
                         String city, String state, String zip,
                         String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZip() { return zip; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }

    public void updateFrom(ContactPerson contact) {
        firstName = contact.firstName;
        lastName = contact.lastName;
        address = contact.address;
        city = contact.city;
        state = contact.state;
        zip = contact.zip;
        phoneNumber = contact.phoneNumber;
        email = contact.email;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof ContactPerson)) return false;
        ContactPerson contact = (ContactPerson) other;
        return firstName.equalsIgnoreCase(contact.firstName)
                && lastName.equalsIgnoreCase(contact.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(Locale.ROOT), lastName.toLowerCase(Locale.ROOT));
    }
}

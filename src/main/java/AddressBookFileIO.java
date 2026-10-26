import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AddressBookFileIO {

    public static void writeContacts(List<ContactPerson> contacts, Path file) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            for (ContactPerson contact : contacts) {
                writer.write(contact.getFirstName() + "|" + contact.getLastName() + "|"
                        + contact.getAddress() + "|" + contact.getCity() + "|"
                        + contact.getState() + "|" + contact.getZip() + "|"
                        + contact.getPhoneNumber() + "|" + contact.getEmail());
                writer.newLine();
            }
        }
    }

    public static List<ContactPerson> readContacts(Path file) throws IOException {
        List<ContactPerson> contacts = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|", -1);
                if (fields.length == 8) {
                    contacts.add(new ContactPerson(fields[0], fields[1], fields[2], fields[3],
                            fields[4], fields[5], fields[6], fields[7]));
                }
            }
        }
        return contacts;
    }
}

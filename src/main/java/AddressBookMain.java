import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Address Book Program");

        AddressBookSystem system = new AddressBookSystem();
        system.addAddressBook("My Address Book");
        AddressBook addressBook = system.getAddressBook("My Address Book");
        while (true) {
            System.out.println("Current Address Book: " + addressBook.getName());
            System.out.println("1. Add contact");
            System.out.println("2. Edit contact");
            System.out.println("3. Delete contact");
            System.out.println("4. View all contacts");
            System.out.println("5. Add an Address Book");
            System.out.println("6. Select an Address Book");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                if (addressBook.addContact(readContact(scanner))) {
                    System.out.println("Contact added to " + addressBook.getName());
                } else {
                    System.out.println("A contact with that name already exists in this Address Book.");
                }
            } else if (choice.equals("2")) {
                System.out.print("First name of contact to edit: ");
                String firstName = scanner.nextLine();
                System.out.print("Last name of contact to edit: ");
                String lastName = scanner.nextLine();
                System.out.println("Enter the updated contact details:");
                ContactPerson updatedContact = readContact(scanner);
                if (addressBook.editContact(firstName, lastName, updatedContact)) {
                    System.out.println("Contact updated.");
                } else {
                    System.out.println("Contact not found.");
                }
            } else if (choice.equals("0")) {
                break;
            } else if (choice.equals("3")) {
                System.out.print("First name of contact to delete: ");
                String firstName = scanner.nextLine();
                System.out.print("Last name of contact to delete: ");
                String lastName = scanner.nextLine();
                if (addressBook.deleteContact(firstName, lastName)) {
                    System.out.println("Contact deleted.");
                } else {
                    System.out.println("Contact not found.");
                }
            } else if (choice.equals("4")) {
                for (ContactPerson contact : addressBook.getContacts()) {
                    System.out.println(contact.getFirstName() + " " + contact.getLastName()
                            + " | " + contact.getAddress() + " | " + contact.getCity()
                            + " | " + contact.getState() + " | " + contact.getZip()
                            + " | " + contact.getPhoneNumber() + " | " + contact.getEmail());
                }
            } else if (choice.equals("5")) {
                System.out.print("New Address Book name: ");
                String name = scanner.nextLine();
                if (system.addAddressBook(name)) {
                    System.out.println("Address Book added.");
                } else {
                    System.out.println("An Address Book with that name already exists.");
                }
            } else if (choice.equals("6")) {
                System.out.println("Address Books: " + system.getAddressBooks().keySet());
                System.out.print("Name to select: ");
                String name = scanner.nextLine();
                AddressBook selectedBook = system.getAddressBook(name);
                if (selectedBook == null) {
                    System.out.println("Address Book not found.");
                } else {
                    addressBook = selectedBook;
                }
            } else {
                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    private static ContactPerson readContact(Scanner scanner) {
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("State: ");
        String state = scanner.nextLine();
        System.out.print("ZIP: ");
        String zip = scanner.nextLine();
        System.out.print("Phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        return new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber, email);
    }
}

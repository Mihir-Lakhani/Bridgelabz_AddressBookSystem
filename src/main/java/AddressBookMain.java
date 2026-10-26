import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Address Book Program");

        AddressBook addressBook = new AddressBook("My Address Book");
        System.out.println("Enter contact details:");
        ContactPerson contact = readContact(scanner);
        addressBook.addContact(contact);
        System.out.println("Contact added to " + addressBook.getName());

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

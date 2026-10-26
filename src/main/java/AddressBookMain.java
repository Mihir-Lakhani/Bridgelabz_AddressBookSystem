import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Address Book Program");

        AddressBook addressBook = new AddressBook("My Address Book");
        while (true) {
            System.out.println("1. Add contact");
            System.out.println("2. Edit contact");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                addressBook.addContact(readContact(scanner));
                System.out.println("Contact added to " + addressBook.getName());
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

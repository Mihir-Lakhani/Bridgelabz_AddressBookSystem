# Address Book System

## Problem statement

Build a small console program that helps a person keep contact details organized. A contact has a first name, last name, address, city, state, ZIP code, phone number, and email address.

The program should let the user add, edit, and delete contacts. It should support more than one named address book, prevent the same person's name from being added twice to one book, and make it possible to search, view, count, and sort contacts by the details requested in the use cases. The program should also save a book's contacts to a file and read them back later.

## What this program can do

- Add, edit, delete, and display contacts.
- Create and switch between named address books.
- Check for duplicate first and last names within the selected book.
- Search across address books by city or state.
- View and count contacts by city or state.
- Sort contacts by name, city, state, or ZIP code.
- Save the selected address book's contacts to a text file and load them back.

## Run the program

Open the project in IntelliJ IDEA and run `AddressBookMain`. The program starts with a menu; enter the number for the action you want. When adding or editing a contact, enter each requested field on its own line.

The project uses plain Java source files and does not require a database or external library. The code uses Java 8 stream operations for searching, grouping, counting, and sorting.

## Saving and loading contacts

Choose **17. Save contacts to file** to write the currently selected address book to `addressbook.txt` in the program's working directory. Choose **18. Read contacts from file** to replace the selected book's in-memory contacts with the contacts in that file.

Each saved contact is written as one line with its fields separated by `|` characters. Keep `|` out of contact fields so the program can read the saved line back correctly.

## Project files

- `ContactPerson.java` stores one person's contact details.
- `AddressBook.java` manages contacts in one address book.
- `AddressBookSystem.java` manages named address books and searches across them.
- `AddressBookFileIO.java` reads and writes contact data.
- `AddressBookMain.java` runs the console menu.

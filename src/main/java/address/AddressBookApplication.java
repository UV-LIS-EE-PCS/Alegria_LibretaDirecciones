package address;

import address.data.AddressBook;

/**
 * The AddressBookApplication class is the entry point for the address book application.
 * It creates an AddressBook instance and a Menu instance to interact with the user.
 */
public class AddressBookApplication {
    
    /**
     * The main method that starts the address book application.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Menu menu = new Menu(addressBook);
        menu.menu();
    }
}
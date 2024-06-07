package address;

import java.util.List;
import java.util.Scanner;
import address.data.AddressBook;
import address.data.AddressEntry;

/**
 * The Menu class provides a user interface for interacting with the AddressBook.
 * It allows users to load entries from a file, add, remove, search, and display all entries.
 */
public class Menu {

    private AddressBook addressBook;

    /**
     * Constructs a Menu instance with the specified AddressBook.
     *
     * @param addressBook the AddressBook to interact with
     */
    public Menu(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Displays the menu and processes user input to perform various actions on the AddressBook.
     */
    public void menu() {

        Scanner in = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("------------------------------------");
            System.out.println("Choose a menu option:");
            System.out.println("a) Load from file");
            System.out.println("b) Add");
            System.out.println("c) Remove");
            System.out.println("d) Search");
            System.out.println("e) Show all");
            System.out.println("f) Exit");
            System.out.println("-------------------------------------");

            String choice = in.nextLine();

            switch (choice) {
                case "a":
                    openTXT(in);
                    break;
                case "b":
                    addNewRegister(in);
                    break;
                case "c":
                    removeRegister(in);
                    break;
                case "d":
                    searchRegister(in);
                    break;
                case "e":
                    showAllRegisters();
                    break;
                case "f":
                    exit = true;
                    break;
                default:
                    System.out.println("Choose an option between a and f");
            }
        }
    }

    /**
     * Prompts the user to add a new address entry to the AddressBook.
     *
     * @param in the Scanner to read user input
     */
    public void addNewRegister(Scanner in) {
        System.out.print("First name:");
        String firstName = in.nextLine();
        System.out.print("Last name:");
        String lastName = in.nextLine();
        System.out.print("Street:");
        String street = in.nextLine();
        System.out.print("City:");
        String city = in.nextLine();
        System.out.print("State:");
        String state = in.nextLine();
        System.out.print("ZIP:");
        int ZIP = in.nextInt();
        in.nextLine(); // Consume newline
        System.out.print("Email Address:");
        String emailAddress = in.nextLine();
        System.out.print("Phone number:");
        String phoneNumber = in.nextLine();

        AddressEntry newRegister = new AddressEntry(firstName, lastName, street, city, state, ZIP, emailAddress, phoneNumber);
        addressBook.addNewRegister(newRegister);
    }

    /**
     * Prompts the user to remove an address entry from the AddressBook by last name.
     *
     * @param in the Scanner to read user input
     */
    public void removeRegister(Scanner in) {
        if (addressBook.getAllRegisters().isEmpty()) {
            System.out.println("The list is empty. No registers to remove.");
            return;
        }

        System.out.println("Enter the last name of the register to remove:");
        String lastName = in.nextLine();

        List<AddressEntry> searchResult = addressBook.searchRegister(lastName);

        if (searchResult.isEmpty()) {
            System.out.println("Register not found");
        } else {
            for (int i = 0; i < searchResult.size(); i++) {
                AddressEntry entryToRemove = searchResult.get(i);
                System.out.println("You have selected:");
                System.out.println(entryToRemove);
                System.out.println("Enter 'y' to confirm removal or 'n' to cancel:");
                String confirmation = in.nextLine();
                if (confirmation.equalsIgnoreCase("y")) {
                    addressBook.removeRegister(entryToRemove);
                    System.out.println("Register successfully removed.");
                } else {
                    System.out.println("Removal canceled.");
                }
            }
        }
    }

    /**
     * Prompts the user to search for address entries by last name.
     *
     * @param in the Scanner to read user input
     */
    public void searchRegister(Scanner in) {
        System.out.println("Search by last name");
        String lastName = in.nextLine();

        List<AddressEntry> searchResult = addressBook.searchRegister(lastName);

        if (searchResult.isEmpty()) {
            System.out.println("Register not found");
        } else {
            for (AddressEntry register : searchResult) {
                System.out.println(register);
            }
        }
    }

    /**
     * Displays all address entries in the AddressBook.
     */
    public void showAllRegisters() {
        List<AddressEntry> allRegisters = addressBook.getAllRegisters();
        if (allRegisters.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            for (AddressEntry register : allRegisters) {
                System.out.println(register);
            }
        }
    }

    /**
     * Prompts the user to enter a filename and loads address entries from the specified file.
     *
     * @param in the Scanner to read user input
     */
    public void openTXT(Scanner in) {
        System.out.println("Enter the filename:");
        String fileName = in.nextLine();
        addressBook.openTXT(fileName);
    }
}
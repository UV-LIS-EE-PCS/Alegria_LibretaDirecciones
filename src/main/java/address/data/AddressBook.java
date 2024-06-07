package address.data;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The AddressBook class manages a list of address entries.
 * It allows adding, removing, searching, and retrieving all entries.
 * It can also read entries from a text file.
 */
public class AddressBook {

    private List<AddressEntry> listOfRegisters;

    /**
     * Constructs a new AddressBook with an empty list of address entries.
     */
    public AddressBook() {
        this.listOfRegisters = new ArrayList<>();
    }

    /**
     * Adds a new address entry to the address book.
     *
     * @param input the address entry to add
     */
    public void addNewRegister(AddressEntry input) { 
        listOfRegisters.add(input); 
    } 
    
    /**
     * Removes an address entry from the address book.
     *
     * @param input the address entry to remove
     */
    public void removeRegister(AddressEntry input) { 
        listOfRegisters.remove(input);
    }

    /**
     * Searches for address entries by last name.
     *
     * @param lastName the last name to search for
     * @return a list of address entries with the specified last name
     */
    public List<AddressEntry> searchRegister(String lastName) {
        List<AddressEntry> result = new ArrayList<>(); 

        for (AddressEntry entry : listOfRegisters) { 
            if (entry.getLastName().equals(lastName)) { 
                result.add(entry);
            } 
        }
        return result; 
    } 
    
    /**
     * Gets a list of all address entries in the address book.
     *
     * @return a list of all address entries
     */
    public List<AddressEntry> getAllRegisters() { 
        return new ArrayList<>(listOfRegisters); 
    }

    /**
     * Reads address entries from a text file and adds them to the address book.
     * The file should have one entry per line, with fields separated by commas.
     *
     * @param fileName the name of the file to read from
     */
    public void openTXT(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into parts separated by commas
                String[] data = line.split(",");
                // Check if the line has the correct number of fields
                if (data.length == 8) {
                    AddressEntry entry = new AddressEntry(
                        data[0].trim(),  // First name
                        data[1].trim(),  // Last name
                        data[2].trim(),  // Street
                        data[3].trim(),  // City
                        data[4].trim(),  // State
                        Integer.parseInt(data[5].trim()),  // ZIP
                        data[6].trim(),  // Email address
                        data[7].trim()   // Phone number
                    );
                    addNewRegister(entry);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
import address.Menu;
import address.data.AddressBook;
import address.data.AddressEntry;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class MenuTest {

    private AddressBook addressBook;
    private Menu menu;

    @Before
    public void setUp() {
        addressBook = new AddressBook();
        menu = new Menu(addressBook);
    }

    @Test
    public void testAddNewRegister() {
        Scanner scanner = new Scanner("John\nDoe\n123 Maple Street\nSpringfield\nIL\n62704\njohn.doe@example.com\n555-1234\n");
        menu.addNewRegister(scanner);

        List<AddressEntry> entries = addressBook.getAllRegisters();
        assertEquals(1, entries.size());
        assertEquals("John", entries.get(0).getFirstName());
    }

    @Test
    public void testRemoveRegister() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Maple Street", "Springfield", "IL", 62704, "john.doe@example.com", "555-1234");
        addressBook.addNewRegister(entry);
        Scanner scanner = new Scanner("Doe\ny\n");
        menu.removeRegister(scanner);

        List<AddressEntry> entries = addressBook.getAllRegisters();
        assertTrue(entries.isEmpty());
    }

    @Test
    public void testSearchRegister() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Maple Street", "Springfield", "IL", 62704, "john.doe@example.com", "555-1234");
        addressBook.addNewRegister(entry);
        Scanner scanner = new Scanner("Doe\n");
        menu.searchRegister(scanner);

        List<AddressEntry> results = addressBook.searchRegister("Doe");
        assertEquals(1, results.size());
    }

    @Test
    public void testShowAllRegisters() {
        AddressEntry entry1 = new AddressEntry("John", "Doe", "123 Maple Street", "Springfield", "IL", 62704, "john.doe@example.com", "555-1234");
        AddressEntry entry2 = new AddressEntry("Jane", "Doe", "456 Oak Avenue", "Lincoln", "NE", 68508, "jane.doe@example.com", "555-5678");
        addressBook.addNewRegister(entry1);
        addressBook.addNewRegister(entry2);

        menu.showAllRegisters();

        List<AddressEntry> entries = addressBook.getAllRegisters();
        assertEquals(2, entries.size());
    }
}
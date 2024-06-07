import address.data.AddressBook;
import address.data.AddressEntry;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class AddressBookTest {
    
    private AddressBook addressBook;

    @Before
    public void setUp() {
        addressBook = new AddressBook();
    }

    @Test
    public void testAddNewRegister() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Maple Street", "Springfield", "IL", 62704, "john.doe@example.com", "555-1234");
        addressBook.addNewRegister(entry);
        List<AddressEntry> entries = addressBook.getAllRegisters();
        assertEquals(1, entries.size());
        assertEquals(entry, entries.get(0));
    }

    @Test
    public void testRemoveRegister() {
        AddressEntry entry = new AddressEntry("John", "Doe", "123 Maple Street", "Springfield", "IL", 62704, "john.doe@example.com", "555-1234");
        addressBook.addNewRegister(entry);
        addressBook.removeRegister(entry);
        List<AddressEntry> entries = addressBook.getAllRegisters();
        assertTrue(entries.isEmpty());
    }

    @Test
    public void testSearchRegister() {
        AddressEntry entry1 = new AddressEntry("John", "Doe", "123 Maple Street", "Springfield", "IL", 62704, "john.doe@example.com", "555-1234");
        AddressEntry entry2 = new AddressEntry("Jane", "Doe", "456 Oak Avenue", "Lincoln", "NE", 68508, "jane.doe@example.com", "555-5678");
        addressBook.addNewRegister(entry1);
        addressBook.addNewRegister(entry2);
        List<AddressEntry> results = addressBook.searchRegister("Doe");
        assertEquals(2, results.size());
        assertTrue(results.contains(entry1));
        assertTrue(results.contains(entry2));
    }

    @Test
    public void testGetAllRegisters() {
        AddressEntry entry1 = new AddressEntry("John", "Doe", "123 Maple Street", "Springfield", "IL", 62704, "john.doe@example.com", "555-1234");
        AddressEntry entry2 = new AddressEntry("Jane", "Doe", "456 Oak Avenue", "Lincoln", "NE", 68508, "jane.doe@example.com", "555-5678");
        addressBook.addNewRegister(entry1);
        addressBook.addNewRegister(entry2);
        List<AddressEntry> entries = addressBook.getAllRegisters();
        assertEquals(2, entries.size());
        assertTrue(entries.contains(entry1));
        assertTrue(entries.contains(entry2));
    }
}
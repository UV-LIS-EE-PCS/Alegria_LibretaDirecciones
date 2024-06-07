import address.data.AddressEntry;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddressEntryTest {
    
    private AddressEntry entry;

    @Before
    public void setUp() {
        entry = new AddressEntry("John", "Doe", "123 Maple Street", "Springfield", "IL", 62704, "john.doe@example.com", "555-1234");
    }

    @Test
    public void testGetters() {
        assertEquals("John", entry.getFirstName());
        assertEquals("Doe", entry.getLastName());
        assertEquals("123 Maple Street", entry.getStreet());
        assertEquals("Springfield", entry.getCity());
        assertEquals("IL", entry.getState());
        assertEquals(62704, entry.getZIP());
        assertEquals("john.doe@example.com", entry.getEmailAddress());
        assertEquals("555-1234", entry.getPhoneNumber());
    }

    @Test
    public void testSetters() {
        entry.setFirstName("Jane");
        entry.setLastName("Smith");
        entry.setStreet("456 Oak Avenue");
        entry.setCity("Lincoln");
        entry.setState("NE");
        entry.setZIP(68508);
        entry.setEmailAddress("jane.smith@example.com");
        entry.setPhoneNumber("555-5678");

        assertEquals("Jane", entry.getFirstName());
        assertEquals("Smith", entry.getLastName());
        assertEquals("456 Oak Avenue", entry.getStreet());
        assertEquals("Lincoln", entry.getCity());
        assertEquals("NE", entry.getState());
        assertEquals(68508, entry.getZIP());
        assertEquals("jane.smith@example.com", entry.getEmailAddress());
        assertEquals("555-5678", entry.getPhoneNumber());
    }

    @Test
    public void testToString() {
        String expected = "John Doe\n123 Maple Street\nSpringfield, IL. 62704\njohn.doe@example.com\n555-1234\n";
        assertEquals(expected, entry.toString());
    }
}
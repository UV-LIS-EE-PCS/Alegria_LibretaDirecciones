package address.data;

/**
 * The AddressEntry class represents an entry in an address book.
 * It contains information about a person's address and contact details.
 */
public class AddressEntry {

    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private int ZIP;
    private String emailAddress;
    private String phoneNumber;

    /**
     * Constructs a new AddressEntry with the specified details.
     *
     * @param firstName the first name of the person
     * @param lastName the last name of the person
     * @param street the street address of the person
     * @param city the city of the person
     * @param state the state of the person
     * @param ZIP the ZIP code of the person
     * @param emailAddress the email address of the person
     * @param phoneNumber the phone number of the person
     */
    public AddressEntry (String firstName, String lastName, String street, String city, String state, int ZIP, String emailAddress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.ZIP = ZIP;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the first name of the person.
     *
     * @return the first name of the person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the person.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the person.
     *
     * @return the last name of the person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the person.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the street address of the person.
     *
     * @return the street address of the person
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street address of the person.
     *
     * @param street the street address to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets the city of the person.
     *
     * @return the city of the person
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the person.
     *
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state of the person.
     *
     * @return the state of the person
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state of the person.
     *
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the ZIP code of the person.
     *
     * @return the ZIP code of the person
     */
    public int getZIP() {
        return ZIP;
    }

    /**
     * Sets the ZIP code of the person.
     *
     * @param ZIP the ZIP code to set
     */
    public void setZIP(int ZIP) {
        this.ZIP = ZIP;
    }

    /**
     * Gets the email address of the person.
     *
     * @return the email address of the person
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the email address of the person.
     *
     * @param emailAddress the email address to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets the phone number of the person.
     *
     * @return the phone number of the person
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the person.
     *
     * @param phoneNumber the phone number to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns a string representation of the AddressEntry.
     *
     * @return a string representation of the AddressEntry
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + "\n"
                + street + "\n"
                + city + ", " + state + ". " + ZIP + "\n"
                + emailAddress + "\n"
                + phoneNumber + "\n";
    }
}
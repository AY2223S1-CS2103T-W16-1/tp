package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class NumberOfGuestsTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new NumberOfGuests(null));
    }

    @Test
    public void constructor_invalidNumberOfGuests_throwsIllegalArgumentException() {
        String invalidNumberOfGuests = "-1";
        assertThrows(IllegalArgumentException.class, () -> new NumberOfGuests(invalidNumberOfGuests));
    }

    @Test
    public void isValidNumberOfGuests() {
        // null number of guests
        assertThrows(NullPointerException.class, () -> NumberOfGuests.isValidNumberOfGuests(null));

        // invalid number of guests
        assertFalse(NumberOfGuests.isValidNumberOfGuests("")); // empty string
        assertFalse(NumberOfGuests.isValidNumberOfGuests(" ")); // spaces only
        assertFalse(NumberOfGuests.isValidNumberOfGuests("-1")); // negative number
        assertFalse(NumberOfGuests.isValidNumberOfGuests("5")); // outside 1 to 4 range

        // valid number of guests
        assertTrue(NumberOfGuests.isValidNumberOfGuests("1")); // range of 1 to 4
        assertTrue(NumberOfGuests.isValidNumberOfGuests("2"));
        assertTrue(NumberOfGuests.isValidNumberOfGuests("3"));
        assertTrue(NumberOfGuests.isValidNumberOfGuests("4"));
    }
}


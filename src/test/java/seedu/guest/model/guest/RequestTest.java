package seedu.guest.model.guest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.guest.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class RequestTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Request(null));
    }

    @Test
    public void constructor_invalidPhone_throwsIllegalArgumentException() {
        String invalidRequest = " ";
        assertThrows(IllegalArgumentException.class, () -> new Phone(invalidRequest));
    }

    @Test
    public void testing() {
        String input = "hi";
        Request r = new Request(input);
        assertTrue(Request.isValidRequests(input));
    }

    @Test
    public void isValidRequests() {
        // null requests
        assertThrows(NullPointerException.class, () -> Request.isValidRequests(null));

        // invalid requests
        assertFalse(Request.isValidRequests("")); // empty string

        // valid requests
        assertTrue(Request.isValidRequests("I want to sleep")); // Is english sentence
    }

    @Test
    public void hashcode() {
        Request tempReq = new Request("Good morning my neighbours");

        // same values -> return true
        assertEquals(tempReq.hashCode(), new Request("Good morning my neighbours").hashCode());

        // different values -> return false
        assertNotEquals(tempReq.hashCode(), new Request("Xue Hua Piao Piao").hashCode());
    }

}

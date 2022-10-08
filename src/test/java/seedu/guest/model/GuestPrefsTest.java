package seedu.guest.model;

import static seedu.guest.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class GuestPrefsTest {

    @Test
    public void setGuiSettings_nullGuiSettings_throwsNullPointerException() {
        GuestPrefs userPref = new GuestPrefs();
        assertThrows(NullPointerException.class, () -> userPref.setGuiSettings(null));
    }

    @Test
    public void setAddressBookFilePath_nullPath_throwsNullPointerException() {
        GuestPrefs userPrefs = new GuestPrefs();
        assertThrows(NullPointerException.class, () -> userPrefs.setGuestBookFilePath(null));
    }
}

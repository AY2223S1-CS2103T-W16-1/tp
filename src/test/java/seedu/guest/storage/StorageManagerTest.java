package seedu.guest.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static seedu.guest.testutil.TypicalGuests.getTypicalGuestBook;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.guest.commons.core.GuiSettings;
import seedu.guest.model.GuestBook;
import seedu.guest.model.ReadOnlyGuestBook;
import seedu.guest.model.GuestPrefs;

public class StorageManagerTest {

    @TempDir
    public Path testFolder;

    private StorageManager hotelStorageManager;

    @BeforeEach
    public void setUp() {
        JsonGuestBookStorage GuestBookStorage = new JsonGuestBookStorage(getTempFilePath("ab"));
        JsonGuestPrefsStorage userPrefsStorage = new JsonGuestPrefsStorage(getTempFilePath("prefs"));
        hotelStorageManager = new StorageManager(GuestBookStorage, userPrefsStorage);
    }

    private Path getTempFilePath(String fileName) {
        return testFolder.resolve(fileName);
    }

    @Test
    public void prefsReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonUserPrefsStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonUserPrefsStorageTest} class.
         */
        GuestPrefs original = new GuestPrefs();
        original.setGuiSettings(new GuiSettings(300, 600, 4, 6));
        hotelStorageManager.saveGuestPrefs(original);
        GuestPrefs retrieved = hotelStorageManager.readGuestPrefs().get();
        assertEquals(original, retrieved);
    }

    @Test
    public void addressBookReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonAddressBookStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonAddressBookStorageTest} class.
         */
        GuestBook original = getTypicalGuestBook();
        hotelStorageManager.saveGuestBook(original);
        ReadOnlyGuestBook retrieved = hotelStorageManager.readGuestBook().get();
        assertEquals(original, new GuestBook(retrieved));
    }

    @Test
    public void getAddressBookFilePath() {
        assertNotNull(hotelStorageManager.getGuestBookFilePath());
    }

}

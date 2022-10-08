package seedu.guest.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static seedu.guest.testutil.Assert.assertThrows;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.guest.commons.core.GuiSettings;
import seedu.guest.commons.exceptions.DataConversionException;
import seedu.guest.model.GuestPrefs;

public class JsonGuestPrefsStorageTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonUserPrefsStorageTest");

    @TempDir
    public Path testFolder;

    @Test
    public void readUserPrefs_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> readGuestPrefs(null));
    }

    private Optional<GuestPrefs> readGuestPrefs(String userPrefsFileInTestDataFolder) throws DataConversionException {
        Path prefsFilePath = addToTestDataPathIfNotNull(userPrefsFileInTestDataFolder);
        return new JsonGuestPrefsStorage(prefsFilePath).readGuestPrefs(prefsFilePath);
    }

    @Test
    public void readUserPrefs_missingFile_emptyResult() throws DataConversionException {
        assertFalse(readGuestPrefs("NonExistentFile.json").isPresent());
    }

    @Test
    public void readUserPrefs_notJsonFormat_exceptionThrown() {
        assertThrows(DataConversionException.class, () -> readGuestPrefs("NotJsonFormatUserPrefs.json"));
    }

    private Path addToTestDataPathIfNotNull(String userPrefsFileInTestDataFolder) {
        return userPrefsFileInTestDataFolder != null
                ? TEST_DATA_FOLDER.resolve(userPrefsFileInTestDataFolder)
                : null;
    }

    @Test
    public void readUserPrefs_fileInOrder_successfullyRead() throws DataConversionException {
        GuestPrefs expected = getTypicalGuestPrefs();
        GuestPrefs actual = readGuestPrefs("TypicalUserPref.json").get();
        assertEquals(expected, actual);
    }

    @Test
    public void readUserPrefs_valuesMissingFromFile_defaultValuesUsed() throws DataConversionException {
        GuestPrefs actual = readGuestPrefs("EmptyUserPrefs.json").get();
        assertEquals(new GuestPrefs(), actual);
    }

    @Test
    public void readUserPrefs_extraValuesInFile_extraValuesIgnored() throws DataConversionException {
        GuestPrefs expected = getTypicalGuestPrefs();
        GuestPrefs actual = readGuestPrefs("ExtraValuesUserPref.json").get();

        assertEquals(expected, actual);
    }

    private GuestPrefs getTypicalGuestPrefs() {
        GuestPrefs guestPrefs = new GuestPrefs();
        guestPrefs.setGuiSettings(new GuiSettings(1000, 500, 300, 100));
        guestPrefs.setGuestBookFilePath(Paths.get("data/guestbook.json"));
        return guestPrefs;
    }

    @Test
    public void savePrefs_nullPrefs_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveGuestPrefs(null, "SomeFile.json"));
    }

    @Test
    public void saveUserPrefs_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveGuestPrefs(new GuestPrefs(), null));
    }

    /**
     * Saves {@code userPrefs} at the specified {@code prefsFileInTestDataFolder} filepath.
     */
    private void saveGuestPrefs(GuestPrefs guestPrefs, String prefsFileInTestDataFolder) {
        try {
            new JsonGuestPrefsStorage(addToTestDataPathIfNotNull(prefsFileInTestDataFolder))
                    .saveGuestPrefs(guestPrefs);
        } catch (IOException ioe) {
            throw new AssertionError("There should not be an error writing to the file", ioe);
        }
    }

    @Test
    public void saveUserPrefs_allInOrder_success() throws DataConversionException, IOException {

        GuestPrefs original = new GuestPrefs();
        original.setGuiSettings(new GuiSettings(1200, 200, 0, 2));

        Path pefsFilePath = testFolder.resolve("TempPrefs.json");
        JsonGuestPrefsStorage jsonGuestPrefsStorage = new JsonGuestPrefsStorage(pefsFilePath);

        //Try writing when the file doesn't exist
        jsonGuestPrefsStorage.saveGuestPrefs(original);
        GuestPrefs readBack = jsonGuestPrefsStorage.readGuestPrefs().get();
        assertEquals(original, readBack);

        //Try saving when the file exists
        original.setGuiSettings(new GuiSettings(5, 5, 5, 5));
        jsonGuestPrefsStorage.saveGuestPrefs(original);
        readBack = jsonGuestPrefsStorage.readGuestPrefs().get();
        assertEquals(original, readBack);
    }

}
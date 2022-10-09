package seedu.guest.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.guest.commons.core.LogsCenter;
import seedu.guest.commons.exceptions.DataConversionException;
import seedu.guest.model.ReadOnlyGuestBook;
import seedu.guest.model.ReadOnlyGuestPrefs;
import seedu.guest.model.UserPrefs;

/**
 * Manages storage of GuestBook data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private GuestBookStorage guestBookStorage;
    private UserPrefsStorage userPrefsStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code GuestBookStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(GuestBookStorage guestBookStorage, UserPrefsStorage userPrefsStorage) {
        this.guestBookStorage = guestBookStorage;
        this.userPrefsStorage = userPrefsStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getGuestPrefsFilePath() {
        return userPrefsStorage.getGuestPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readGuestPrefs() throws DataConversionException, IOException {
        return userPrefsStorage.readGuestPrefs();
    }

    @Override
    public void saveGuestPrefs(ReadOnlyGuestPrefs userPrefs) throws IOException {
        userPrefsStorage.saveGuestPrefs(userPrefs);
    }


    // ================ GuestBook methods ==============================

    @Override
    public Path getGuestBookFilePath() {
        return guestBookStorage.getGuestBookFilePath();
    }

    @Override
    public Optional<ReadOnlyGuestBook> readGuestBook() throws DataConversionException, IOException {
        return readGuestBook(guestBookStorage.getGuestBookFilePath());
    }

    @Override
    public Optional<ReadOnlyGuestBook> readGuestBook(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return guestBookStorage.readGuestBook(filePath);
    }

    @Override
    public void saveGuestBook(ReadOnlyGuestBook guestBook) throws IOException {
        saveGuestBook(guestBook, guestBookStorage.getGuestBookFilePath());
    }

    @Override
    public void saveGuestBook(ReadOnlyGuestBook guestBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        guestBookStorage.saveGuestBook(guestBook, filePath);
    }

}

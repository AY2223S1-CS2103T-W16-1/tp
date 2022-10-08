package seedu.guest.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.guest.commons.exceptions.DataConversionException;
import seedu.guest.model.GuestPrefs;
import seedu.guest.model.ReadOnlyGuestPrefs;

/**
 * Represents a storage for {@link GuestPrefs}.
 */
public interface GuestPrefsStorage {

    /**
     * Returns the file path of the UserPrefs data file.
     */
    Path getGuestPrefsFilePath();

    /**
     * Returns UserPrefs data from storage.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<GuestPrefs> readGuestPrefs() throws DataConversionException, IOException;

    /**
     * Saves the given {@link ReadOnlyGuestPrefs} to the storage.
     * @param userPrefs cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveGuestPrefs(ReadOnlyGuestPrefs userPrefs) throws IOException;

}

package seedu.guest.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.guest.commons.exceptions.DataConversionException;
import seedu.guest.model.UserPrefs;
import seedu.guest.model.ReadOnlyGuestBook;
import seedu.guest.model.ReadOnlyGuestPrefs;

/**
 * API of the Storage component
 */
public interface Storage extends GuestBookStorage, GuestPrefsStorage {

    @Override
    Optional<UserPrefs> readGuestPrefs() throws DataConversionException, IOException;

    @Override
    void saveGuestPrefs(ReadOnlyGuestPrefs userPrefs) throws IOException;

    @Override
    Path getGuestBookFilePath();

    @Override
    Optional<ReadOnlyGuestBook> readGuestBook() throws DataConversionException, IOException;

    @Override
    void saveGuestBook(ReadOnlyGuestBook addressBook) throws IOException;

}

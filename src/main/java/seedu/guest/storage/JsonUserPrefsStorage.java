package seedu.guest.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.guest.commons.exceptions.DataConversionException;
import seedu.guest.commons.util.JsonUtil;
import seedu.guest.model.ReadOnlyGuestPrefs;
import seedu.guest.model.UserPrefs;

/**
 * A class to access UserPrefs stored in the hard disk as a json file
 */
public class JsonUserPrefsStorage implements UserPrefsStorage {

    private Path filePath;

    public JsonUserPrefsStorage(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public Path getGuestPrefsFilePath() {
        return filePath;
    }

    @Override
    public Optional<UserPrefs> readGuestPrefs() throws DataConversionException {
        return readGuestPrefs(filePath);
    }

    /**
     * Similar to {@link #readGuestPrefs(Path filePath)}
     * @param prefsFilePath location of the data. Cannot be null.
     * @throws DataConversionException if the file format is not as expected.
     */
    public Optional<UserPrefs> readGuestPrefs(Path prefsFilePath) throws DataConversionException {
        return JsonUtil.readJsonFile(prefsFilePath, UserPrefs.class);
    }

    @Override
    public void saveGuestPrefs(ReadOnlyGuestPrefs guestPrefs) throws IOException {
        JsonUtil.saveJsonFile(guestPrefs, filePath);
    }

}

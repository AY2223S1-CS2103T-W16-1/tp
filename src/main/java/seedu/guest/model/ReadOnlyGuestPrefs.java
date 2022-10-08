package seedu.guest.model;

import java.nio.file.Path;

import seedu.guest.commons.core.GuiSettings;

/**
 * Unmodifiable view of user prefs.
 */
public interface ReadOnlyGuestPrefs {

    GuiSettings getGuiSettings();

    Path getGuestBookFilePath();

}

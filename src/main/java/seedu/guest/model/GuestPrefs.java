package seedu.guest.model;

import static java.util.Objects.requireNonNull;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import seedu.guest.commons.core.GuiSettings;

/**
 * Represents User's preferences.
 */
public class GuestPrefs implements ReadOnlyGuestPrefs {

    private GuiSettings guiSettings = new GuiSettings();
    private Path guestBookFilePath = Paths.get("data" , "guestbook.json");

    /**
     * Creates a {@code UserPrefs} with default values.
     */
    public GuestPrefs() {}

    /**
     * Creates a {@code UserPrefs} with the prefs in {@code userPrefs}.
     */
    public GuestPrefs(ReadOnlyGuestPrefs userPrefs) {
        this();
        resetData(userPrefs);
    }

    /**
     * Resets the existing data of this {@code UserPrefs} with {@code newUserPrefs}.
     */
    public void resetData(ReadOnlyGuestPrefs newUserPrefs) {
        requireNonNull(newUserPrefs);
        setGuiSettings(newUserPrefs.getGuiSettings());
        setGuestBookFilePath(newUserPrefs.getGuestBookFilePath());
    }

    public GuiSettings getGuiSettings() {
        return guiSettings;
    }

    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        this.guiSettings = guiSettings;
    }

    public Path getGuestBookFilePath() {
        return guestBookFilePath;
    }

    public void setGuestBookFilePath(Path guestBookFilePath) {
        requireNonNull(guestBookFilePath);
        this.guestBookFilePath = guestBookFilePath;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof GuestPrefs)) { //this handles null as well.
            return false;
        }

        GuestPrefs o = (GuestPrefs) other;

        return guiSettings.equals(o.guiSettings)
                && guestBookFilePath.equals(o.guestBookFilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guiSettings, guestBookFilePath);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gui Settings : " + guiSettings);
        sb.append("\nLocal data file location : " + guestBookFilePath);
        return sb.toString();
    }
}
package seedu.guest.model.guest;

import static java.util.Objects.requireNonNull;
import static seedu.guest.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 * Represents the dates that a Guest is staying at the hotel for.
 * Guarantees: immutable; is valid as declared in {@link #isValidDateRange(String)}
 */
public class DateRange {
    public static final String MESSAGE_CONSTRAINTS =
            "DateRanges should contain only numbers, hyphens, backslashes, and spaces. They must follow the format"
                    + "\"dd/MM/yy - dd/MM/yy\" and the second date must be later than the first date.";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/uu")
            .withResolverStyle(ResolverStyle.STRICT);
    public final String value;

    /**
     * Constructs a {@code CheckInDate}.
     *
     * @param dateRange A valid date range.
     */
    public DateRange(String dateRange) {
        requireNonNull(dateRange);
        checkArgument(isValidDateRange(dateRange), MESSAGE_CONSTRAINTS);
        value = dateRange;
    }

    /**
     * Returns true if a given string is a valid date range.
     */
    public static boolean isValidDateRange(String test) {
        try {
            String[] dates = test.split(" - ", 2);
            LocalDate checkInDate = LocalDate.parse(dates[0], DATE_TIME_FORMATTER);
            LocalDate checkOutDate = LocalDate.parse(dates[1], DATE_TIME_FORMATTER);
            return checkOutDate.isAfter(checkInDate);
        } catch (DateTimeParseException | ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DateRange // instanceof handles nulls
                && value.equals(((DateRange) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}

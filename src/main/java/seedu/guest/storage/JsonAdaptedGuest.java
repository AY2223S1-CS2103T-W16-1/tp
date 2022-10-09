package seedu.guest.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.guest.commons.exceptions.IllegalValueException;
import seedu.guest.model.guest.DateRange;
import seedu.guest.model.guest.Email;
import seedu.guest.model.guest.Guest;
import seedu.guest.model.guest.Name;
import seedu.guest.model.guest.NumberOfGuests;
import seedu.guest.model.guest.Phone;

/**
 * Jackson-friendly version of {@link Guest}.
 */
class JsonAdaptedGuest {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Guest's %s field is missing!";

    private final String name;
    private final String phone;
    private final String email;
    private final String dateRange;
    private final String numberOfGuests;

    /**
     * Constructs a {@code JsonAdaptedGuest} with the given guest details.
     */
    @JsonCreator
    public JsonAdaptedGuest(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
            @JsonProperty("email") String email, @JsonProperty("dateRange") String dateRange,
            @JsonProperty("numberOfGuests") String numberOfGuests) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.dateRange = dateRange;
        this.numberOfGuests = numberOfGuests;
    }

    /**
     * Converts a given {@code Guest} into this class for Jackson use.
     */
    public JsonAdaptedGuest(Guest source) {
        name = source.getName().fullName;
        phone = source.getPhone().value;
        email = source.getEmail().value;
        dateRange = source.getDateRange().value;
        numberOfGuests = source.getNumberOfGuests().value;
    }

    /**
     * Converts this Jackson-friendly adapted guest object into the model's {@code Guest} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted guest.
     */
    public Guest toModelType() throws IllegalValueException {

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidPhone(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        if (dateRange == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    DateRange.class.getSimpleName()));
        }
        if (!DateRange.isValidDateRange(dateRange)) {
            throw new IllegalValueException(DateRange.MESSAGE_CONSTRAINTS);
        }
        final DateRange modelDateRange = new DateRange(dateRange);

        if (numberOfGuests == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    NumberOfGuests.class.getSimpleName()));
        }
        if (!NumberOfGuests.isValidNumberOfGuests(numberOfGuests)) {
            throw new IllegalValueException(NumberOfGuests.MESSAGE_CONSTRAINTS);
        }
        final NumberOfGuests modelNumberOfGuests = new NumberOfGuests(numberOfGuests);

        return new Guest(modelName, modelPhone, modelEmail, modelDateRange, modelNumberOfGuests);
    }
}

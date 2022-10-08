package seedu.guest.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.guest.storage.JsonAdaptedGuest.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.guest.testutil.Assert.assertThrows;
import static seedu.guest.testutil.TypicalGuests.BENSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.guest.commons.exceptions.IllegalValueException;
import seedu.guest.model.guest.Address;
import seedu.guest.model.guest.Email;
import seedu.guest.model.guest.Name;
import seedu.guest.model.guest.NumberOfGuests;
import seedu.guest.model.guest.Phone;

public class JsonAdaptedGuestTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_NUMBER_OF_GUESTS = "-1";
    private static final String INVALID_TAG = "#friend";

    private static final String VALID_NAME = BENSON.getName().toString();
    private static final String VALID_PHONE = BENSON.getPhone().toString();
    private static final String VALID_EMAIL = BENSON.getEmail().toString();
    private static final String VALID_NUMBER_OF_GUESTS = BENSON.getNumberOfGuests().toString();
    private static final String VALID_ADDRESS = BENSON.getAddress().toString();
    private static final List<JsonAdaptedTag> VALID_TAGS = BENSON.getTags().stream()
            .map(JsonAdaptedTag::new)
            .collect(Collectors.toList());

    @Test
    public void toModelType_validPersonDetails_returnsPerson() throws Exception {
        JsonAdaptedGuest guest = new JsonAdaptedGuest(BENSON);
        assertEquals(BENSON, guest.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedGuest guest =
                new JsonAdaptedGuest(INVALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_NUMBER_OF_GUESTS,
                        VALID_ADDRESS, VALID_TAGS);
        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, guest::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedGuest guest = new JsonAdaptedGuest(null, VALID_PHONE, VALID_EMAIL, VALID_NUMBER_OF_GUESTS,
                VALID_ADDRESS, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, guest::toModelType);
    }

    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        JsonAdaptedGuest guest =
                new JsonAdaptedGuest(VALID_NAME, INVALID_PHONE, VALID_EMAIL, VALID_NUMBER_OF_GUESTS,
                        VALID_ADDRESS, VALID_TAGS);
        String expectedMessage = Phone.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, guest::toModelType);
    }

    @Test
    public void toModelType_nullPhone_throwsIllegalValueException() {
        JsonAdaptedGuest guest = new JsonAdaptedGuest(VALID_NAME, null, VALID_EMAIL, VALID_NUMBER_OF_GUESTS,
                VALID_ADDRESS, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, guest::toModelType);
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        JsonAdaptedGuest guest =
                new JsonAdaptedGuest(VALID_NAME, VALID_PHONE, INVALID_EMAIL, VALID_NUMBER_OF_GUESTS,
                        VALID_ADDRESS, VALID_TAGS);
        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, guest::toModelType);
    }

    @Test
    public void toModelType_nullEmail_throwsIllegalValueException() {
        JsonAdaptedGuest guest = new JsonAdaptedGuest(VALID_NAME, VALID_PHONE, null, VALID_NUMBER_OF_GUESTS,
                VALID_ADDRESS, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, guest::toModelType);
    }

    @Test
    public void toModelType_invalidNumberOfGuests_throwsIllegalValueException() {
        JsonAdaptedGuest guest =
                new JsonAdaptedGuest(VALID_NAME, VALID_PHONE, VALID_EMAIL, INVALID_NUMBER_OF_GUESTS,
                        VALID_ADDRESS, VALID_TAGS);
        String expectedMessage = NumberOfGuests.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, guest::toModelType);
    }

    @Test
    public void toModelType_nullNumberOfGuests_throwsIllegalValueException() {
        JsonAdaptedGuest guest = new JsonAdaptedGuest(VALID_NAME, VALID_PHONE, VALID_EMAIL, null,
                VALID_ADDRESS, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, NumberOfGuests.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, guest::toModelType);
    }

    @Test
    public void toModelType_invalidAddress_throwsIllegalValueException() {
        JsonAdaptedGuest guest =
                new JsonAdaptedGuest(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_NUMBER_OF_GUESTS,
                        INVALID_ADDRESS, VALID_TAGS);
        String expectedMessage = Address.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, guest::toModelType);
    }

    @Test
    public void toModelType_nullAddress_throwsIllegalValueException() {
        JsonAdaptedGuest guest = new JsonAdaptedGuest(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_NUMBER_OF_GUESTS,
                null, VALID_TAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, guest::toModelType);
    }

    @Test
    public void toModelType_invalidTags_throwsIllegalValueException() {
        List<JsonAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
        invalidTags.add(new JsonAdaptedTag(INVALID_TAG));
        JsonAdaptedGuest guest =
                new JsonAdaptedGuest(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_NUMBER_OF_GUESTS,
                        VALID_ADDRESS, invalidTags);
        assertThrows(IllegalValueException.class, guest::toModelType);
    }

}

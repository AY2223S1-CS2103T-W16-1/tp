package seedu.guest.testutil;

import static seedu.guest.logic.commands.CommandTestUtil.VALID_DATE_RANGE_AMY;
import static seedu.guest.logic.commands.CommandTestUtil.VALID_DATE_RANGE_BOB;
import static seedu.guest.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.guest.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.guest.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.guest.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.guest.logic.commands.CommandTestUtil.VALID_NUMBER_OF_GUESTS_AMY;
import static seedu.guest.logic.commands.CommandTestUtil.VALID_NUMBER_OF_GUESTS_BOB;
import static seedu.guest.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.guest.logic.commands.CommandTestUtil.VALID_PHONE_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.guest.model.GuestBook;
import seedu.guest.model.guest.Guest;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {
    public static final Guest ALICE = new GuestBuilder().withName("Alice Pauline")
            .withEmail("alice@example.com")
            .withDateRange("13/09/22 - 15/09/22").withNumberOfGuests("1")
            .withPhone("94351253")
            .build();
    public static final Guest BENSON = new GuestBuilder().withName("Benson Meier")
            .withEmail("johnd@example.com")
            .withDateRange("30/09/22 - 02/10/22").withNumberOfGuests("2").withPhone("98765432")
            .build();
    public static final Guest CARL = new GuestBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withDateRange("30/12/22 - 02/01/23").withNumberOfGuests("3")
            .build();
    public static final Guest DANIEL = new GuestBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withDateRange("29/05/23 - 03/06/23").withNumberOfGuests("4")
            .build();
    public static final Guest ELLE = new GuestBuilder().withName("Elle Meyer").withPhone("9482224")
            .withEmail("werner@example.com").withDateRange("08/04/23 - 22/04/23").withNumberOfGuests("1")
            .build();
    public static final Guest FIONA = new GuestBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withEmail("lydia@example.com").withDateRange("21/10/22 - 22/10/22").withNumberOfGuests("2")
            .build();
    public static final Guest GEORGE = new GuestBuilder().withName("George Best").withPhone("9482442")
            .withEmail("anna@example.com").withDateRange("01/01/23 - 07/01/23").withNumberOfGuests("3")
            .build();

    // Manually added
    public static final Guest HOON = new GuestBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").withDateRange("01/05/23 - 01/01/24").withNumberOfGuests("1")
            .build();
    public static final Guest IDA = new GuestBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").withDateRange("11/11/23 - 12/11/23").withNumberOfGuests("4")
            .build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Guest AMY = new GuestBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withDateRange(VALID_DATE_RANGE_AMY)
            .withNumberOfGuests(VALID_NUMBER_OF_GUESTS_AMY)
            .build();
    public static final Guest BOB = new GuestBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withDateRange(VALID_DATE_RANGE_BOB)
            .withNumberOfGuests(VALID_NUMBER_OF_GUESTS_BOB)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static GuestBook getTypicalAddressBook() {
        GuestBook ab = new GuestBook();
        for (Guest guest : getTypicalPersons()) {
            ab.addGuest(guest);
        }
        return ab;
    }

    public static List<Guest> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
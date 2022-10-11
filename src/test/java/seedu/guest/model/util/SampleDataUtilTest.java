package seedu.guest.model.util;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import seedu.guest.model.GuestBook;
import seedu.guest.model.guest.DateRange;
import seedu.guest.model.guest.Email;
import seedu.guest.model.guest.Guest;
import seedu.guest.model.guest.Name;
import seedu.guest.model.guest.NumberOfGuests;
import seedu.guest.model.guest.Phone;

public class SampleDataUtilTest {

    @Test
    public void getSampleGuests() {
        // New Guest[] -> return false
        assertNotEquals(SampleDataUtil.getSampleGuests(),
                new Guest[]{
                    new Guest(new Name("Alex Yooh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                            new DateRange("13/09/22 - 15/09/22"),
                            new NumberOfGuests("1")),
                    new Guest(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                            new DateRange("01/01/23 - 07/01/23"),
                            new NumberOfGuests("4")),
                    new Guest(new Name("Charlotte Oliveiro"), new Phone("93210283"),
                            new Email("charlotte@example.com"), new DateRange("21/10/22 - 22/10/22"),
                            new NumberOfGuests("2")),
                    new Guest(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                            new DateRange("08/04/23 - 22/04/23"),
                            new NumberOfGuests("3")),
                    new Guest(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                            new DateRange("29/05/23 - 03/06/23"),
                            new NumberOfGuests("1")),
                    new Guest(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                            new DateRange("30/12/22 - 02/01/23"),
                            new NumberOfGuests("4"))
                });
    }

    @Test
    public void getSampleGuestBook() {
        GuestBook exceptedGb = new GuestBook();
        exceptedGb.addGuest(new Guest(new Name("Alex Yooh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new DateRange("13/09/22 - 15/09/22"),
                new NumberOfGuests("1")));
        exceptedGb.addGuest(new Guest(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new DateRange("01/01/23 - 07/01/23"),
                new NumberOfGuests("4")));
        exceptedGb.addGuest(new Guest(new Name("Charlotte Oliveiro"), new Phone("93210283"),
                new Email("charlotte@example.com"), new DateRange("21/10/22 - 22/10/22"),
                new NumberOfGuests("2")));
        exceptedGb.addGuest(new Guest(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new DateRange("08/04/23 - 22/04/23"),
                new NumberOfGuests("3")));
        exceptedGb.addGuest(new Guest(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new DateRange("29/05/23 - 03/06/23"),
                new NumberOfGuests("1")));
        exceptedGb.addGuest(new Guest(new Name("Roy Balakrishnan"), new Phone("92624417"),
                new Email("royb@example.com"), new DateRange("30/12/22 - 02/01/23"), new NumberOfGuests("4")));

        // New GuestBook -> return false
        assertNotEquals(SampleDataUtil.getSampleGuestBook(), exceptedGb);
    }
}

package seedu.guest.testutil;

import java.util.Optional;
import seedu.guest.model.guest.Bill;
import seedu.guest.model.guest.DateRange;
import seedu.guest.model.guest.Email;
import seedu.guest.model.guest.Guest;
import seedu.guest.model.guest.IsRoomClean;
import seedu.guest.model.guest.Name;
import seedu.guest.model.guest.NumberOfGuests;
import seedu.guest.model.guest.Phone;
import seedu.guest.model.guest.Request;

/**
 * A utility class to help with building Guest objects.
 */
public class GuestBuilder {
    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_DATE_RANGE = "13/09/22 - 15/09/22";
    public static final String DEFAULT_NUMBER_OF_GUESTS = "1";
    public static final String DEFAULT_IS_ROOM_CLEAN = "yes";
    public static final String DEFAULT_REQUESTS = "Room service";
    public static final String DEFAULT_BILL = "0.00";

    private Name name;
    private Phone phone;
    private Email email;
    private DateRange dateRange;
    private NumberOfGuests numberOfGuests;
    private IsRoomClean isRoomClean;
    private Request request;
    private Bill bill;

    /**
     * Creates a {@code GuestBuilder} with the default details.
     */
    public GuestBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        dateRange = new DateRange(DEFAULT_DATE_RANGE);
        numberOfGuests = new NumberOfGuests(DEFAULT_NUMBER_OF_GUESTS);
        isRoomClean = new IsRoomClean(DEFAULT_IS_ROOM_CLEAN);
        request = new Request(DEFAULT_REQUESTS);
        bill = new Bill(DEFAULT_BILL);
    }

    /**
     * Initializes the GuestBuilder with the data of {@code guestToCopy}.
     */
    public GuestBuilder(Guest guestToCopy) {
        name = guestToCopy.getName();
        phone = guestToCopy.getPhone();
        email = guestToCopy.getEmail();
        dateRange = guestToCopy.getDateRange();
        numberOfGuests = guestToCopy.getNumberOfGuests();
        isRoomClean = guestToCopy.getIsRoomClean();
        request = guestToCopy.getRequests();
        bill = guestToCopy.getBill();
    }

    /**
     * Sets the {@code Name} of the {@code Guest} that we are building.
     */
    public GuestBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Guest} that we are building.
     */
    public GuestBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Guest} that we are building.
     */
    public GuestBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code DateRange} of the {@code Guest} that we are building.
     */
    public GuestBuilder withDateRange(String dateRange) {
        this.dateRange = new DateRange(dateRange);
        return this;
    }

    /**
     * Sets the {@code NumberOfGuests} of the {@code Guest} that we are building.
     */
    public GuestBuilder withNumberOfGuests(String numberOfGuests) {
        this.numberOfGuests = new NumberOfGuests(numberOfGuests);
        return this;
    }

    /**
     * Sets the {@code IsRoomClean} of the {@code Guest} that we are building.
     */
    public GuestBuilder withIsRoomClean(String isRoomClean) {
        this.isRoomClean = new IsRoomClean(isRoomClean);
        return this;
    }

    /**
     * Sets the {@code requests} of the {@code Request} that we are building.
     */
    public GuestBuilder withRequests(String requests) {
        this.request = new Request(requests);
        return this;
    }
    /**
     * Sets the {@code Bill} of the {@code Guest} that we are building.
     */
    public GuestBuilder withBill(String bill) {
        this.bill = new Bill(bill);
        return this;
    }

    public Guest build() {
        return new Guest(name, phone, email, dateRange, numberOfGuests, isRoomClean, bill, request);
    }

}

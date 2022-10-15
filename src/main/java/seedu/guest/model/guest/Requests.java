package seedu.guest.model.guest;

import static java.util.Objects.requireNonNull;
import static seedu.guest.commons.util.AppUtil.checkArgument;

public class Requests {
    public static final String MESSAGE_CONSTRAINTS =
            "Requests should only contain alphanumeric characters and spaces, and it should not be blank";
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";
    public String requests;

    public Requests(String requests) {
        requireNonNull(requests);
        checkArgument(isValidRequests(requests), MESSAGE_CONSTRAINTS);
        this.requests = requests;
    }

    public static boolean isValidRequests(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public int hashCode() {
        return requests.hashCode();
    }

    @Override
    public String toString() {
        return requests;
    }
}

package seedu.guest.model.guest;

import static seedu.guest.commons.util.AppUtil.checkArgument;

public class Request {
    public static final String MESSAGE_CONSTRAINTS = "Request should not be blank";
    public String requests;

    public Request(String request) {
        checkArgument(isValidRequests(request), MESSAGE_CONSTRAINTS);
        this.requests = request;
    }

    public static boolean isValidRequests(String test) {
        return !(test.trim().equals(""));
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

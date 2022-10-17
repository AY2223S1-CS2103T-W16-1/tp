package seedu.guest.model.guest;

import static seedu.guest.commons.util.AppUtil.checkArgument;

/**
 * Class Request.
 */
public class Request {
    public static final String MESSAGE_CONSTRAINTS = "Request should not be blank";
    public final String requests;

    /**
     * The constructor of request.
     * @param request
     */
    public Request(String request) {
        checkArgument(isValidRequests(request), MESSAGE_CONSTRAINTS);
        this.requests = request;
    }

    /**
     * To check whether the request format is valid
     * @param test input
     * @return boolean
     */
    public static boolean isValidRequests(String test) {
        return !(test.trim().equals(""));
    }

    /**
     * convert Request object to corresponding integer
     * @return int
     */
    @Override
    public int hashCode() {
        return requests.hashCode();
    }

    /**
     * The String representation of request
     * @return String
     */
    @Override
    public String toString() {
        return requests;
    }
}

package seedu.guest.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.guest.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.guest.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.guest.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.guest.logic.parser.CliSyntax.PREFIX_NUMBER_OF_GUESTS;
import static seedu.guest.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.guest.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.guest.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.guest.commons.core.index.Index;
import seedu.guest.logic.commands.exceptions.CommandException;
import seedu.guest.model.GuestBook;
import seedu.guest.model.Model;
import seedu.guest.model.guest.Guest;
import seedu.guest.model.guest.NameContainsKeywordsPredicate;
import seedu.guest.testutil.EditGuestDescriptorBuilder;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    public static final String VALID_NAME_AMY = "Amy Bee";
    public static final String VALID_NAME_BOB = "Bob Choo";
    public static final String VALID_PHONE_AMY = "11111111";
    public static final String VALID_PHONE_BOB = "22222222";
    public static final String VALID_EMAIL_AMY = "amy@example.com";
    public static final String VALID_EMAIL_BOB = "bob@example.com";
    public static final String VALID_NUMBER_OF_GUESTS_AMY = "1";
    public static final String VALID_NUMBER_OF_GUESTS_BOB = "2";
    public static final String VALID_ADDRESS_AMY = "Block 312, Amy Street 1";
    public static final String VALID_ADDRESS_BOB = "Block 123, Bobby Street 3";
    public static final String VALID_TAG_HUSBAND = "husband";
    public static final String VALID_TAG_FRIEND = "friend";

    public static final String NAME_DESC_AMY = " " + PREFIX_NAME + VALID_NAME_AMY;
    public static final String NAME_DESC_BOB = " " + PREFIX_NAME + VALID_NAME_BOB;
    public static final String PHONE_DESC_AMY = " " + PREFIX_PHONE + VALID_PHONE_AMY;
    public static final String PHONE_DESC_BOB = " " + PREFIX_PHONE + VALID_PHONE_BOB;
    public static final String EMAIL_DESC_AMY = " " + PREFIX_EMAIL + VALID_EMAIL_AMY;
    public static final String EMAIL_DESC_BOB = " " + PREFIX_EMAIL + VALID_EMAIL_BOB;
    public static final String NUMBER_OF_GUESTS_DESC_AMY = " " + PREFIX_NUMBER_OF_GUESTS + VALID_NUMBER_OF_GUESTS_AMY;
    public static final String NUMBER_OF_GUESTS_DESC_BOB = " " + PREFIX_NUMBER_OF_GUESTS + VALID_NUMBER_OF_GUESTS_BOB;
    public static final String ADDRESS_DESC_AMY = " " + PREFIX_ADDRESS + VALID_ADDRESS_AMY;
    public static final String ADDRESS_DESC_BOB = " " + PREFIX_ADDRESS + VALID_ADDRESS_BOB;
    public static final String TAG_DESC_FRIEND = " " + PREFIX_TAG + VALID_TAG_FRIEND;
    public static final String TAG_DESC_HUSBAND = " " + PREFIX_TAG + VALID_TAG_HUSBAND;

    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + "James&"; // '&' not allowed in names
    public static final String INVALID_PHONE_DESC = " " + PREFIX_PHONE + "911a"; // 'a' not allowed in phones
    public static final String INVALID_EMAIL_DESC = " " + PREFIX_EMAIL + "bob!yahoo"; // missing '@' symbol
    public static final String INVALID_NUMBER_OF_GUESTS_DESC = " " + PREFIX_NUMBER_OF_GUESTS
            + "-1"; // -1 numbers of guests
    public static final String INVALID_ADDRESS_DESC = " " + PREFIX_ADDRESS; // empty string not allowed for addresses
    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "hubby*"; // '*' not allowed in tags

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final EditCommand.EditGuestDescriptor DESC_AMY;
    public static final EditCommand.EditGuestDescriptor DESC_BOB;

    static {
        DESC_AMY = new EditGuestDescriptorBuilder().withName(VALID_NAME_AMY)
                .withPhone(VALID_PHONE_AMY).withEmail(VALID_EMAIL_AMY).withNumberOfGuests(VALID_NUMBER_OF_GUESTS_AMY)
                .withAddress(VALID_ADDRESS_AMY).withTags(VALID_TAG_FRIEND).build();
        DESC_BOB = new EditGuestDescriptorBuilder().withName(VALID_NAME_BOB)
                .withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB).withNumberOfGuests(VALID_NUMBER_OF_GUESTS_BOB)
                .withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the guest book, filtered guest list and selected guest in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        GuestBook expectedGuestBook = new GuestBook(actualModel.getGuestBook());
        List<Guest> expectedFilteredList = new ArrayList<>(actualModel.getFilteredGuestList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedGuestBook, actualModel.getGuestBook());
        assertEquals(expectedFilteredList, actualModel.getFilteredGuestList());
    }
    /**
     * Updates {@code model}'s filtered list to show only the guest at the given {@code targetIndex} in the
     * {@code model}'s guest book.
     */
    public static void showGuestAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredGuestList().size());

        Guest guest = model.getFilteredGuestList().get(targetIndex.getZeroBased());
        final String[] splitName = guest.getName().fullName.split("\\s+");
        model.updateFilteredGuestList(new NameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredGuestList().size());
    }

}
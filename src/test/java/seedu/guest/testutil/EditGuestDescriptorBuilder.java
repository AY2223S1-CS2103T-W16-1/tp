package seedu.guest.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.guest.logic.commands.EditCommand.EditGuestDescriptor;
import seedu.guest.model.guest.Address;
import seedu.guest.model.guest.Email;
import seedu.guest.model.guest.Guest;
import seedu.guest.model.guest.Name;
import seedu.guest.model.guest.NumberOfGuests;
import seedu.guest.model.guest.Phone;
import seedu.guest.model.tag.Tag;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditGuestDescriptorBuilder {

    private EditGuestDescriptor descriptor;

    public EditGuestDescriptorBuilder() {
        descriptor = new EditGuestDescriptor();
    }

    public EditGuestDescriptorBuilder(EditGuestDescriptor descriptor) {
        this.descriptor = new EditGuestDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
    public EditGuestDescriptorBuilder(Guest guest) {
        descriptor = new EditGuestDescriptor();
        descriptor.setName(guest.getName());
        descriptor.setPhone(guest.getPhone());
        descriptor.setEmail(guest.getEmail());
        descriptor.setNumberOfGuests(guest.getNumberOfGuests());
        descriptor.setAddress(guest.getAddress());
        descriptor.setTags(guest.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditGuestDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditGuestDescriptorBuilder withPhone(String phone) {
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditGuestDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code NumberOfGuests} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditGuestDescriptorBuilder withNumberOfGuests(String numberOfGuests) {
        descriptor.setNumberOfGuests(new NumberOfGuests(numberOfGuests));
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditGuestDescriptorBuilder withAddress(String address) {
        descriptor.setAddress(new Address(address));
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditGuestDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet = Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    public EditGuestDescriptor build() {
        return descriptor;
    }
}

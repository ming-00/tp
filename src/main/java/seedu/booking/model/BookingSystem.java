package seedu.booking.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.booking.model.booking.Booking;
import seedu.booking.model.booking.NonOverlappingBookingList;
import seedu.booking.model.person.Person;
import seedu.booking.model.person.UniquePersonList;
import seedu.booking.model.venue.UniqueVenueList;
import seedu.booking.model.venue.Venue;

/**
 * Wraps all data at the booking-system level
 * Duplicates and overlaps are not allowed (by .isSame/isOverlapping comparison)
 */
public class BookingSystem implements ReadOnlyBookingSystem {

    private final UniquePersonList persons;
    private final NonOverlappingBookingList bookings;
    private final UniqueVenueList venues;


    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        persons = new UniquePersonList();

        bookings = new NonOverlappingBookingList();

        venues = new UniqueVenueList();

    }

    public BookingSystem() {}

    /**
     * Creates an BookingSystem using the Persons in the {@code toBeCopied}
     */
    public BookingSystem(ReadOnlyBookingSystem toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the person list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setPersons(List<Person> persons) {
        this.persons.setPersons(persons);
    }


    /**
     * Replaces the contents of the venue list with {@code venues}.
     * {@code venues} must not contain duplicate venues.
     */
    public void setVenues(List<Venue> venues) {
        this.venues.setVenues(venues);
    }
    /**
     * Resets the existing data of this {@code BookingSystem} with {@code newData}.
     */
    public void resetData(ReadOnlyBookingSystem newData) {
        requireNonNull(newData);

        setPersons(newData.getPersonList());
        setVenues(newData.getVenueList());
    }

    //// person-level operations

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    public boolean hasPerson(Person person) {
        requireNonNull(person);
        return persons.contains(person);
    }

    /**
     * Adds a person to the address book.
     * The person must not already exist in the address book.
     */
    public void addPerson(Person p) {
        persons.add(p);
    }

    /**
     * Adds a booking to the address book.
     * The booking must not already exist in the address book.
     */
    public void addBooking(Booking b) {
        bookings.add(b);
    }

    /**
     * Replaces the given person {@code target} in the list with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    public void setPerson(Person target, Person editedPerson) {
        requireNonNull(editedPerson);

        persons.setPerson(target, editedPerson);
    }

    /**
     * Removes {@code key} from this {@code BookingSystem}.
     * {@code key} must exist in the address book.
     */
    public void removePerson(Person key) {
        persons.remove(key);
    }

    /**
     * Removes {@code key} from this {@code BookingSystem}.
     * {@code key} must exist in the address book.
     */
    public void removeVenue(Venue key) {
        venues.remove(key);
    }


    //// booking-level operations
    /**
     * Removes {@code bookingId} from this {@code BookingSystem}.
     * {@code bookingId} must exist in the address book.
     */
    public void removeBooking(int bookingId) {
        bookings.removeById(bookingId);
    }

    //// util methods

    @Override
    public String toString() {
        return persons.asUnmodifiableObservableList().size() + " persons";
        // TODO: refine later
    }

    @Override
    public ObservableList<Person> getPersonList() {
        return persons.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<Venue> getVenueList() {
        return venues.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof BookingSystem // instanceof handles nulls
                && persons.equals(((BookingSystem) other).persons));
    }

    @Override
    public int hashCode() {
        return persons.hashCode();
    }


    @Override
    public ObservableList<Booking> getBookingList() {
        return bookings.asUnmodifiableObservableList();
    }


    /**
     * Returns true if a booking with the same identity as {@code booking} exists in the address book.
     */
    public boolean hasBooking(Booking booking) {
        requireNonNull(booking);
        return bookings.contains(booking);
    }

    /**
     * Returns true if a venue with the same identity as {@code venue} exists in the system.
     */
    public boolean hasVenue(Venue venue) {
        requireNonNull(venue);
        return venues.contains(venue);
    }

    /**
     * Adds a venue to the system.
     * The venue must not already exist in the system.
     */
    public void addVenue(Venue v) {
        venues.add(v);
    }

    /**
     * Replaces the given venue {@code target} in the list with {@code editedVenue}.
     * {@code target} must exist in the booking system.
     * The venue identity of {@code editedVenue} must not be the same as another existing venue in the booking system.
     */
    public void setVenue(Venue target, Venue editedVenue) {
        requireNonNull(editedVenue);

        venues.setVenue(target, editedVenue);
    }

}
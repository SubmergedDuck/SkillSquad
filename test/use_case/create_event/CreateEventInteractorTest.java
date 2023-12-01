package use_case.create_event;

import data_access.InMemoryEventsDataAccessObject;
import data_access.InMemoryUsersDataAccessObject;
import entity.Events.*;
import entity.Location.CommonLocationFactory;
import entity.Location.LocationFactory;
import entity.Users.CommonUserFactory;
import entity.Users.User;
import entity.Users.UserFactory;
import interface_adapter.create_event.MockCreateEventPresenter;
import use_case.create_event.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Used for testing the create event interactor.
 */
public class CreateEventInteractorTest {
    private InMemoryUsersDataAccessObject inMemoryUsersDataAccessObject = new InMemoryUsersDataAccessObject();
    private InMemoryEventsDataAccessObject inMemoryEventsDataAccessObject = new InMemoryEventsDataAccessObject();
    /**
     * Initializes instances that will be used for the test.
     */
    @Before
    public void init() {
        UserFactory userFactory = new CommonUserFactory();
        User testCreator = userFactory.create("Bob", "123", 20, "m", "bob@gmail.com");
        inMemoryUsersDataAccessObject.save(testCreator);
    }

    /**
     * Tests if the presenter correctly indicates if an invalid input was passed into the interactor.
     */
    @Test
    public void invalidInput() throws IOException {
        //Detects if an invalid input for create event was done.
        CreateEventOutputBoundary mockPresenter = new CreateEventOutputBoundary() {
            @Override
            public void prepareFailView(String error) {
            }

            @Override
            public void prepareSuccessView(CreateEventOutputData output) {
                fail();
            }
        };
        //Creates regular event with an invalid input. Here, there is no owner.
        CreateEventInputData testInput = new CreateEventInputData("Bob", "", "(47.64054,-122.12934)", "2016-03-04 11:30",
                "Movie night", "Have fun!", false, "10");
        CreateEventInteractor createEventInteractor = new CreateEventInteractor(inMemoryEventsDataAccessObject,
                inMemoryUsersDataAccessObject,mockPresenter,new CommonEventFactory(), new CommonInviteOnlyEventFactory(),
                new CommonRestrictedEventFactory(), new CommonLocationFactory());
        createEventInteractor.execute(testInput);
    }

    /**
     * Tests if the presenter correctly indicates if a valid input was passed into the interactor
     */
    @Test
    public void validInput() throws IOException {
        CreateEventOutputBoundary mockPresenter = new CreateEventOutputBoundary() {
            @Override
            public void prepareFailView(String error) {
                fail();
            }

            @Override
            public void prepareSuccessView(CreateEventOutputData output) {

            }
        };
        CreateEventInputData testInput = new CreateEventInputData("Bob", "Movie", "(47.64054,-122.12934)", "2016-03-04 11:30",
                "Movie night", "Have fun!", false, "10", "5", "");
        CreateEventInteractor createEventInteractor = new CreateEventInteractor(inMemoryEventsDataAccessObject,
                inMemoryUsersDataAccessObject,mockPresenter,new CommonEventFactory(), new CommonInviteOnlyEventFactory(),
                new CommonRestrictedEventFactory(), new CommonLocationFactory());
    }

    /**
     * Tests if an event was added to the event DAO.
     */
    @Test
    public void addsEvent() throws IOException {
        //Checks if the event was added to the DAO.
        CreateEventOutputBoundary mockPresenter = new CreateEventOutputBoundary() {
            @Override
            public void prepareFailView(String error) {
                fail();
            }

            @Override
            public void prepareSuccessView(CreateEventOutputData output) {
                assertEquals(1, inMemoryEventsDataAccessObject.getEventMap().size());
            }
        };
        CreateEventInputData testInput = new CreateEventInputData("Bob", "Movie", "(47.64054,-122.12934)", "2016-03-04 11:30",
                "Movie night", "Have fun!", false, "10", "5", "");
        CreateEventInteractor createEventInteractor = new CreateEventInteractor(inMemoryEventsDataAccessObject,
                inMemoryUsersDataAccessObject,mockPresenter,new CommonEventFactory(), new CommonInviteOnlyEventFactory(),
                new CommonRestrictedEventFactory(), new CommonLocationFactory());
        createEventInteractor.execute(testInput);
    }

    /**
     * Tests if a user's created events was updated after they create the event
     */
    @Test
    public void updatesUser() throws IOException {
        CreateEventOutputBoundary mockPresenter = new CreateEventOutputBoundary() {
            @Override
            public void prepareFailView(String error) {
                fail();
            }

            @Override
            public void prepareSuccessView(CreateEventOutputData output) {
                User userTest = inMemoryUsersDataAccessObject.getUser("Bob");
                assertEquals(1, userTest.getCreatedEvents().size());
            }
        };
        CreateEventInputData testInput = new CreateEventInputData("Bob", "Movie", "(47.64054,-122.12934)", "2016-03-04 11:30",
                "Movie night", "Have fun!", false, "10", "5", "");
        CreateEventInteractor createEventInteractor = new CreateEventInteractor(inMemoryEventsDataAccessObject,
                inMemoryUsersDataAccessObject,mockPresenter,new CommonEventFactory(), new CommonInviteOnlyEventFactory(),
                new CommonRestrictedEventFactory(), new CommonLocationFactory());
        createEventInteractor.execute(testInput);
        InMemoryUsersDataAccessObject userDAO =  (InMemoryUsersDataAccessObject)inMemoryUsersDataAccessObject;

    }

}
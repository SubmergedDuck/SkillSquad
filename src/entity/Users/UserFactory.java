package entity.Users;

import entity.Events.Event;
import entity.Location.Location;

import java.util.ArrayList;

public interface UserFactory {
    User create(String username, String password, ArrayList<Event> joinedEvents,
                ArrayList<Event> createdEvents, int age, String sex, int userid, String contact,
                Location location);
}

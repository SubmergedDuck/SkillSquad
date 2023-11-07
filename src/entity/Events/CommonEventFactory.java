package entity.Events;

import entity.Location.Location;
import entity.Users.Organizer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CommonEventFactory implements EventFactory {
    public Event create(Integer eventID, String eventName, Integer owner, Location location,
                        ArrayList<Integer> peopleJoined, ArrayList<Integer> peopleWaitlisted, LocalDateTime time,
                        String type, String description, Boolean privacy, Integer capacity){
        return new CommonEvent(eventID, eventName, owner, location, peopleJoined,
                peopleWaitlisted, time, type, description, privacy, capacity);


    }
}

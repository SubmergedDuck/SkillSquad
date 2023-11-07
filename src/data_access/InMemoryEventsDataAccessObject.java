package data_access;

import entity.Events.Event;
import entity.Location.Location;
import use_case.create_event.CreateEventDataAccessInterface;
import use_case.get_direction.GetDirectionDataAccessInterface;
import use_case.join_event.JoinEventDataAccessInterface;
import use_case.search_event.SearchEventDataAccessInterface;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryEventsDataAccessObject implements GetDirectionDataAccessInterface,
        CreateEventDataAccessInterface,
        SearchEventDataAccessInterface,
        JoinEventDataAccessInterface {
    /**
     * This is an in-memory event DAO to allow testing with the relevant interactors.
     * @param
     * @return
     */
    private final Map<Event, Integer> EventstoID = new HashMap<>();

    public void save(Event event){
        EventstoID.put(event, event.getEventID());
    }

    private boolean withinRange(Event event, LocalDateTime start, LocalDateTime end) {
        return start.isAfter(event.getTime()) && end.isBefore(event.getTime());
    }

    @Override
    public ArrayList<Integer> returnByName(String name) {
        /**
         * Return an array list of eventIDs associated with events that match with the search by name
         */
        ArrayList<Integer> eligibleEvents = new ArrayList<>();
        for (Event event: EventstoID.keySet()) {
            if (event.getEventName().equals(name)){
                eligibleEvents.add(EventstoID.get(event));
            }
        }
        return eligibleEvents;
    }

    @Override
    public ArrayList<Integer> returnByLocation(Location location) {
        ArrayList<Integer> eligibleEvents = new ArrayList<>();
        for (Event event: EventstoID.keySet()) {
            if (event.getLocation().equals(location)){
                eligibleEvents.add(EventstoID.get(event));
            }
        }
        return eligibleEvents;
    }

    @Override
    public ArrayList<Integer> returnByTime(LocalDateTime start, LocalDateTime end) {
        ArrayList<Integer> eligibleEvents = new ArrayList<>();
        for (Event event: EventstoID.keySet()) {
            if (withinRange(event, start, end)){
                eligibleEvents.add(EventstoID.get(event));
            }
        }
        return eligibleEvents;
    }

    @Override
    public ArrayList<Integer> returnByType(String type) {
        ArrayList<Integer> eligibleEvents = new ArrayList<>();
        for (Event event: EventstoID.keySet()) {
            if (event.getType().equals(type)){
                eligibleEvents.add(EventstoID.get(event));
            }
        }
        return eligibleEvents;
    }
}

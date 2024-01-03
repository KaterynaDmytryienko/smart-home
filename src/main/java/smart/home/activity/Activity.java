package smart.home.activity;

import smart.home.event.Event;

public interface Activity {
    /**
     * Method generates random events on a random floor in a random room.
     *
     * @param sportEvent A boolean flag indicating whether the generated event is sport-related.
     * @return An instance of the Event representing the randomly generated event.
     */
    Event doSomething(boolean sportEvent);
}

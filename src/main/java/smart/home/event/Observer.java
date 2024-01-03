package smart.home.event;

public interface Observer {
    /**
     * This method is called to notify the observer about an occurring event.
     *
     * @param event the event that has occurred and needs to be handled
     */
     void update(Event event);

}
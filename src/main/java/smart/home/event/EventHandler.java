package smart.home.event;

public interface EventHandler {
    /**
     * Assigns the next handler in the chain to be invoked if the current handler
     * cannot handle the event.
     *
     * @param eventHandler the next handler in the chain.
     */
    void assignToNext(EventHandler eventHandler);

    /**
     * Handles the given event. If the current handler cannot handle the event,
     * it should pass the event to the next handler in the chain.
     *
     * @param event the event to be handled
     */
    void handleEvent(Event event);
}

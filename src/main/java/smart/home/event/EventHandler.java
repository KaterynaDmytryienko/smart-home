package smart.home.event;

public interface EventHandler {
    void assignToNext(EventHandler eventHandler);
    void handleEvent(Event event);
}

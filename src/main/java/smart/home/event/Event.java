package smart.home.event;

public class Event {
    private Even_Types type;
    private Object source;

    public Event(Even_Types type, Object source) {
        this.type = type;
        this.source = source;
    }
}

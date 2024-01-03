package smart.home.event;

import smart.home.model.Device;
import smart.home.model.Inhabitant;
import smart.home.model.Room;

public class Event {
    private EventTypes type;
    private Inhabitant source;
    private Device device;
    private Room room;

    public boolean isHandled = false;

    public Event() {
    }

    public Event(EventTypes type, Inhabitant source, Room room) {
        this.type = type;
        this.source = source;
        this.room = room;
    }

    public Event(EventTypes type, Device device, Room room) {
        this.type = type;
        this.device = device;
        this.room = room;
    }

    public void setType(EventTypes type) {
        this.type = type;
    }

    public void setSource(Inhabitant source) {
        this.source = source;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Device getDevice() {
        return device;
    }

    public EventTypes getType() {
        return type;
    }

    public Inhabitant getSource() {
        return source;
    }

    public Room getRoom() {
        return room;
    }
}

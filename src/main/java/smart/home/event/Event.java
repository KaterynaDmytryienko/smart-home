package smart.home.event;

import smart.home.model.Device;
import smart.home.model.Entity;
import smart.home.model.Person;
import smart.home.model.Room;

public class Event {
    public Event() {

    }

    public void setType(Even_Types type) {
        this.type = type;
    }

    public void setSource(Entity source) {
        this.source = source;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    private Even_Types type;
    private Entity source;

    public Device getDevice() {
        return device;
    }

    private Device device;
    private Room room;

    public boolean isHandled=false;

    public Event(Even_Types type, Entity source, Room room) {
        this.type = type;
        this.source = source;
        this.room = room;
    }
    public Event(Even_Types type, Device device, Room room) {
        this.type = type;
        this.device = device;
        this.room = room;
    }

    public Even_Types getType() {
        return type;
    }


    public Entity getSource() {
        return source;
    }

    public Room getRoom() {
        return room;
    }
}

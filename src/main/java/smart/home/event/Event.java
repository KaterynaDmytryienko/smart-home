package smart.home.event;

import smart.home.model.Entity;
import smart.home.model.Person;
import smart.home.model.Room;

public class Event {
    private Even_Types type;
    private Entity source;
    private Room room;

    public boolean isHandled=false;

    public Event(Even_Types type, Entity source, Room room) {
        this.type = type;
        this.source = source;
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

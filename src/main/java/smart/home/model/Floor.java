package smart.home.model;

import java.util.List;

public class Floor {

    public Floor(int level) {
        this.level = level;
    }

    private int level;
    private List<Room> rooms;

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }


}

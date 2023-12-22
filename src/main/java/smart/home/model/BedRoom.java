package smart.home.model;

import java.util.List;

public class BedRoom extends Room{
    public BedRoom(List<Device> devices){
        super(devices);
        setName("Bedroom");
    }
    public BedRoom(){
        super();
        setName("Bedroom");
    }
}

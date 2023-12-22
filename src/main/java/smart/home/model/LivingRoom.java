package smart.home.model;

import java.util.List;

public class LivingRoom extends Room{
    public LivingRoom(){
        super();
        setName("Living Room");
    }

    public LivingRoom(List<Device>devices){
        super(devices);
        setName("Living Room");
    }

}

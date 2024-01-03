package smart.home.model;


import java.util.List;

public class Garage extends Room {
    public Garage(List<Device> devices) {
        super(devices);
        setName("Garage");
    }
}

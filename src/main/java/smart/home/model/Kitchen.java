package smart.home.model;

import java.util.List;

public class Kitchen extends Room{
    private FloodSensor floodSensor;


    public Kitchen(List<Device> devices){
        super(devices);
        setFloodSensor(new FloodSensor());
        setName("Kitchen");

    }

    public Kitchen(){
        super();
        setFloodSensor(new FloodSensor());
        setName("Kitchen");

    }
    public FloodSensor getFloodSensor() {
        return floodSensor;
    }

    public void setFloodSensor(FloodSensor floodSensor) {
        this.floodSensor = floodSensor;
    }
}

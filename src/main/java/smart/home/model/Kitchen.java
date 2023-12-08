package smart.home.model;

public class Kitchen extends Room{
    private FloodSensor floodSensor;


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

package smart.home.model;

public abstract class Room {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room(){
        setLightDevice(new LightDevice());
        setMotionSensor(new MotionSensor());
        setThermostatSensor(new ThermostatSensor());
    }
    private boolean isEmpty = false;

    private MotionSensor motionSensor;
    private LightDevice lightDevice;
    private ThermostatSensor thermostatSensor;


    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public MotionSensor getMotionSensor() {
        return motionSensor;
    }

    public void setMotionSensor(MotionSensor motionSensor) {
        this.motionSensor = motionSensor;
    }

    public LightDevice getLightDevice() {
        return lightDevice;
    }

    public void setLightDevice(LightDevice lightDevice) {
        this.lightDevice = lightDevice;
    }

    public ThermostatSensor getThermostatSensor() {
        return thermostatSensor;
    }

    public void setThermostatSensor(ThermostatSensor thermostatSensor) {
        this.thermostatSensor = thermostatSensor;
    }


}

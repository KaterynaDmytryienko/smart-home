package smart.home.model;

import java.util.List;

public abstract class Room {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room(List<Device>devices){
        setLightDevice(new LightDevice());
        setMotionSensor(new MotionSensor());
        setThermostatSensor(new ThermostatSensor());
        setWindow(new Window());

        this.devices = devices;
    }
    public Room(){

    }
    private boolean isEmpty = false;

    public List<Device> getDevices() {
        return devices;
    }

    private List<Device>devices;
    private MotionSensor motionSensor;
    private LightDevice lightDevice;
    private ThermostatSensor thermostatSensor;

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    private Window window;


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

package smart.home.model;

import smart.home.controller.DeviceAPI;
import smart.home.controller.DeviceAPIImpl;
import smart.home.event.Event;

public class LightDevice extends Device {
    private boolean isTurnedOn = false;
    private DeviceAPI deviceAPI = new DeviceAPIImpl();

    public LightDevice() {
        super();
        Consumption activeConsumption = new Consumption(100, 0, 0);
        setActiveConsumption(activeConsumption);
        Consumption offConsumption = new Consumption(0, 0, 0);
        setOffConsumption(offConsumption);
        Consumption idleConsumption = new Consumption(60, 0, 0);
        setIdleConsumption(idleConsumption);

        this.setCurrentState(DeviceState.IDLE);
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void setTurnedOn(boolean turnedOn) {
        isTurnedOn = turnedOn;
    }

    @Override
    public void update(Event event) {
    }

    public void turnLightOn(Event event) {
        event.getRoom().getLightDevice().isTurnedOn = true;
        this.setCurrentState(DeviceState.ACTIVE);
        deviceAPI.turnOn(event, event.getRoom().getLightDevice());
    }

    public void turnLightOff(Event event) {
        this.setCurrentState(DeviceState.OFF);
        event.getRoom().getLightDevice().isTurnedOn = false;
        deviceAPI.turnOff(event, event.getRoom().getLightDevice());
    }

}

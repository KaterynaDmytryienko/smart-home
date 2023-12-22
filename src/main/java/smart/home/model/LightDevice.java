package smart.home.model;

import smart.home.controller.DeviceAPI;
import smart.home.controller.DeviceApiImpl;
import smart.home.event.Even_Types;
import smart.home.event.Event;

import java.util.logging.Logger;

public class LightDevice extends Device{
    private boolean isTurnedOn = false;
    private DeviceAPI deviceAPI = new DeviceApiImpl();

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void setTurnedOn(boolean turnedOn) {
        isTurnedOn = turnedOn;
    }

    @Override
    public void update(Event event) {
    }

    public void turnLightOn(Event event){
        event.getRoom().getLightDevice().isTurnedOn = true;
        deviceAPI.turnOn(event,event.getRoom().getLightDevice());
    }

    public void turnLightOff(Event event){
        event.getRoom().getLightDevice().isTurnedOn = false;
        deviceAPI.turnOff(event,event.getRoom().getLightDevice());
    }

    @Override
    public void updateConsumption() {

    }

    @Override
    public void getsBroken() {

    }
}

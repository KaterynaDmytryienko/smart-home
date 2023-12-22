package smart.home.controller;

import smart.home.SmartHouseSimulation;
import smart.home.event.Event;
import smart.home.model.Device;
import smart.home.model.LightDevice;

import java.util.logging.Logger;

public class DeviceApiImpl<T extends Device> implements DeviceAPI<T>{
    private static final Logger LOGGER = Logger.getLogger(DeviceApiImpl.class.getName());

    @Override
    public void turnOn(Event event, T device) {
        if (device instanceof LightDevice) {

           if(event.getRoom().getLightDevice().isTurnedOn()) LOGGER.info("Light is turned on in " + event.getRoom().getName());
        }
        // Add logic for other types of devices if needed
    }

    @Override
    public void turnOff(Event event, T device) {
        if (device instanceof LightDevice) {
           // ((LightDevice) device).setTurnedOn(false);
            if(!event.getRoom().getLightDevice().isTurnedOn()) LOGGER.info("Light is turned off in " + event.getRoom().getName());
        }
        // Add logic for other types of devices if needed
    }

    @Override
    public void collectDeviceData(T device) {

    }

}

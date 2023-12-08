package smart.home.controller;

import smart.home.event.Event;
import smart.home.model.Device;

public interface DeviceAPI<T extends Device> {
    public interface DeviceCollectDataAPI<Device>{
        public void collectData(Device device);
    }

    public void turnOn(Event event, T device);
    public void turnOff(Event event, T device);
}

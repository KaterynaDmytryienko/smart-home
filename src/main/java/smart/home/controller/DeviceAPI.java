package smart.home.controller;

import smart.home.model.Device;

public interface DeviceAPI<T extends Device> {
    public interface DeviceCollectDataAPI<Device>{
        public void collectData(Device device);
    }

    public void turnOn(Device device);
    public void turnOff(Device device);
}

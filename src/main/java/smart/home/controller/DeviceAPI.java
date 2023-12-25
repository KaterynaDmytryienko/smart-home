package smart.home.controller;

import smart.home.event.Event;
import smart.home.model.Device;

public interface DeviceAPI<T extends Device> {
    public interface DeviceCollectDataAPI<Device>{
        public void collectData(Device device);
    }

    public void turnOn(Event event, T device);
    public void turnOff(Event event, T device);

    public void collectDeviceData(T device);
    public double getTotalElectricityConsumption(T device);
    public double getTotalGasConsumption(T device);
    public double getTotalWaterConsumption(T device) ;
    public double getTotalFunctionality(T device) ;
    public double getFinancialCost(T device) ;
}

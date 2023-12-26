package smart.home.controller;

import smart.home.event.Event;
import smart.home.model.Device;
import smart.home.model.LightDevice;

import java.util.List;
import java.util.logging.Logger;

public class DeviceAPII<T extends Device> implements DeviceAPI<T>{
    // rates for each utility
    private static final double ELECTRICITY_RATE = 0.12;
    private static final double GAS_RATE = 1.50;
    private static final double WATER_RATE = 0.05;
    List<Device.ConsumptionRecord> consumptionRecords;
    //////
    private static final Logger LOGGER = Logger.getLogger(DeviceAPII.class.getName());

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
        consumptionRecords = device.getConsumptionHistory();
    }

    @Override
    public double getTotalElectricityConsumption(T device) {
        double totalElectricity = 0;
        for (Device.ConsumptionRecord record : consumptionRecords) {
            totalElectricity += record.getElectricityConsumption();
        }
        return totalElectricity;
    }
@Override
    public double getTotalGasConsumption(T device) {
        double totalGas = 0;
        for (Device.ConsumptionRecord record : consumptionRecords) {
            totalGas += record.getGasConsumption();
        }
        return totalGas;
    }

    @Override
    public double getTotalWaterConsumption(T device) {
        double totalWater = 0;
        for (Device.ConsumptionRecord record : consumptionRecords) {
            totalWater += record.getWaterConsumption();
        }
        return totalWater;
    }
    @Override
    public double getTotalFunctionality(T device) {
        double totalFunctionality = 0;
        for (Device.ConsumptionRecord record : consumptionRecords) {
            totalFunctionality += record.getFunctionality();
        }
        return totalFunctionality;
    }
    @Override
    public double getFinancialCost(T device) {
        double totalElectricityCost = getTotalElectricityConsumption(device) * ELECTRICITY_RATE;
        double totalGasCost = getTotalGasConsumption(device) * GAS_RATE;
        double totalWaterCost = getTotalWaterConsumption(device) * WATER_RATE;

        return totalElectricityCost + totalGasCost + totalWaterCost;
    }

}

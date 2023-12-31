package smart.home.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import smart.home.activity.PersonActivity;
import smart.home.event.Event;
import smart.home.model.Device;
import smart.home.model.LightDevice;

import java.util.List;

public class DeviceAPII<T extends Device> implements DeviceAPI<T>{
    private static final double ELECTRICITY_RATE = 0.12;
    private static final double GAS_RATE = 1.50;
    private static final double WATER_RATE = 0.05;
    List<Device.ConsumptionRecord> consumptionRecords;
    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceAPII.class);

    /**
     * Method turns on lights when Entity enters a room.
     * @param event
     * @param device
     */
    @Override
    public void turnOn(Event event, T device) {
        if (device instanceof LightDevice) {

           if(event.getRoom().getLightDevice().isTurnedOn()) LOGGER.info("Light is turned on in " + event.getRoom().getName());
        }
    }

    /**
     * Method turns off lights when Entity leaves a room.
     * @param event
     * @param device
     */
    @Override
    public void turnOff(Event event, T device) {
        if (device instanceof LightDevice) {
            if(!event.getRoom().getLightDevice().isTurnedOn()) LOGGER.info("Light is turned off in " + event.getRoom().getName());
        }
    }


    @Override
    public void collectDeviceData(T device) {
        consumptionRecords = device.getConsumptionHistory();
    }

    /**
     * Methods returns total electricity consumption as a double value.
     * @param device
     * @return double
     */
    @Override
    public double getTotalElectricityConsumption(T device) {
        double totalElectricity = 0;
        for (Device.ConsumptionRecord record : consumptionRecords) {
            totalElectricity += record.getElectricityConsumption();
        }
        return totalElectricity;
    }

    /**
     * Methods returns total gas consumption as a double value.
     * @param device
     * @return double
     */
@Override
    public double getTotalGasConsumption(T device) {
        double totalGas = 0;
        for (Device.ConsumptionRecord record : consumptionRecords) {
            totalGas += record.getGasConsumption();
        }
        return totalGas;
    }

    /**
     * Methods returns total water consumption as a double value.
     * @param device
     * @return double
     */
    @Override
    public double getTotalWaterConsumption(T device) {
        double totalWater = 0;
        for (Device.ConsumptionRecord record : consumptionRecords) {
            totalWater += record.getWaterConsumption();
        }
        return totalWater;
    }

    /**
     * Method returns total functionality value of a device.
     * @param device
     * @return double
     */
    @Override
    public double getTotalFunctionality(T device) {
        double totalFunctionality = 0;
        for (Device.ConsumptionRecord record : consumptionRecords) {
            totalFunctionality += record.getFunctionality();
        }
        return totalFunctionality;
    }

    /**
     * Method returns total financial cost of water, electricity and gas consumption.
     * @param device
     * @return double
     */
    @Override
    public double getFinancialCost(T device) {
        double totalElectricityCost = getTotalElectricityConsumption(device) * ELECTRICITY_RATE;
        double totalGasCost = getTotalGasConsumption(device) * GAS_RATE;
        double totalWaterCost = getTotalWaterConsumption(device) * WATER_RATE;

        return totalElectricityCost + totalGasCost + totalWaterCost;
    }

    /**
     * Method downgrade performance of a device.
     * @param device
     */
@Override
    public void performActionByState(T device){
        device.downgradePerformance();
    }

    /**
     * Method records device consumption.
     * @param device
     */
    @Override
    public void recordConsumption(T device) {
        device.recordConsumption();
    }


}

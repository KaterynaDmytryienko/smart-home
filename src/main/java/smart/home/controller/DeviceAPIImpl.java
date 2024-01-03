package smart.home.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import smart.home.event.Event;
import smart.home.model.Device;
import smart.home.model.LightDevice;

import java.util.List;

public class DeviceAPIImpl<T extends Device> implements DeviceAPI<T> {
    private static final double ELECTRICITY_RATE = 0.12;
    private static final double GAS_RATE = 1.50;
    private static final double WATER_RATE = 0.05;
    List<Device.ConsumptionRecord> consumptionRecords;
    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceAPIImpl.class);

    /**
     * Method turns on lights when Entity enters a room.
     *
     * @param event  event that triggered method.
     * @param device device The device to be controlled,
     */
    @Override
    public void turnOn(Event event, T device) {
        if (device instanceof LightDevice) {

            if (event.getRoom().getLightDevice().isTurnedOn())
                LOGGER.info("Light is turned on in " + event.getRoom().getName());
        }
    }

    /**
     * Method turns off lights when Entity leaves a room.
     *
     * @param event  event that triggered method.
     * @param device device The device to be controlled,
     */
    @Override
    public void turnOff(Event event, T device) {
        if (device instanceof LightDevice) {
            if (!event.getRoom().getLightDevice().isTurnedOn())
                LOGGER.info("Light is turned off in " + event.getRoom().getName());
        }
    }


    /**
     * Method allows to collect consumption data from the specified device.
     *
     * @param device The device from which consumption data is collected.
     */
    @Override
    public void collectDeviceData(T device) {
        consumptionRecords = device.getConsumptionHistory();
    }

    /**
     * Methods returns total electricity consumption as a double value.
     *
     * @param device The device from which consumption data is collected.
     * @return The total electricity consumption as a double value.
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
     *
     * @param device The device from which consumption data is collected.
     * @return The total gas consumption as a double value.
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
     *
     * @param device The device from which consumption data is collected.
     * @return The total water consumption as a double value.
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
     *
     * @param device The device from which functionality data is collected.
     * @return The total functionality as a double value.
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
     *
     * @param device The device from which financial data are collected.
     * @return The total financial cost as a double value.
     */
    @Override
    public double getFinancialCost(T device) {
        double totalElectricityCost = getTotalElectricityConsumption(device) * ELECTRICITY_RATE;
        double totalGasCost = getTotalGasConsumption(device) * GAS_RATE;
        double totalWaterCost = getTotalWaterConsumption(device) * WATER_RATE;

        return totalElectricityCost + totalGasCost + totalWaterCost;
    }

    /**
     * Method downgrades performance of a device.
     *
     * @param device The device on which action will be performed.
     */
    @Override
    public void performActionByState(T device) {
        device.downgradePerformance();
    }

    /**
     * Method records device consumption.
     *
     * @param device The device from which consumption will be recorded.
     */
    @Override
    public void recordConsumption(T device) {
        device.recordConsumption();
    }


}

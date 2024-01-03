package smart.home.controller;

import smart.home.event.Event;
import smart.home.model.Device;

public interface DeviceAPI<T extends Device> {
    /**
     * Method downgrades performance of a device.
     *
     * @param device The device on which action will be performed.
     */
    void performActionByState(T device);

    /**
     * Method records device consumption.
     *
     * @param device The device from which consumption will be recorded.
     */
    void recordConsumption(T device);


    /**
     * Method turns on lights when Entity enters a room.
     *
     * @param event  event that triggered method.
     * @param device device The device to be controlled,
     */
     void turnOn(Event event, T device);

    /**
     * Method turns off lights when Entity leaves a room.
     *
     * @param event  event that triggered method.
     * @param device device The device to be controlled,
     */
    void turnOff(Event event, T device);


    /**
     * Method allows to collect consumption data from the specified device.
     *
     * @param device The device from which consumption data is collected.
     */
     void collectDeviceData(T device);

    /**
     * Methods returns total electricity consumption as a double value.
     *
     * @param device The device from which consumption data is collected.
     * @return The total electricity consumption as a double value.
     */
     double getTotalElectricityConsumption(T device);

    /**
     * Methods returns total electricity consumption as a double value.
     *
     * @param device The device from which consumption data is collected.
     * @return The total gas consumption as a double value.
     */
     double getTotalGasConsumption(T device);

    /**
     * Methods returns total water consumption as a double value.
     *
     * @param device The device from which consumption data is collected.
     * @return The total water consumption as a double value.
     */
     double getTotalWaterConsumption(T device);

    /**
     * Method returns total functionality value of a device.
     *
     * @param device The device from which functionality data is collected.
     * @return The total functionality as a double value.
     */
     double getTotalFunctionality(T device);

    /**
     * Method returns total financial cost of water, electricity and gas consumption.
     *
     * @param device The device from which financial data are collected.
     * @return The total financial cost as a double value.
     */
     double getFinancialCost(T device);
}

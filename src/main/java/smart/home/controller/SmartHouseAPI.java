//package smart.home.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import smart.home.activity.PersonActivity;
//import smart.home.event.EventGenerator;
//import smart.home.event.EventManager;
//import smart.home.model.*;
//
//import java.util.Random;
//import java.util.logging.Level;
//
//public class SmartHouseAPI {
//    private static final Logger LOGGER = LoggerFactory.getLogger(SmartHouseAPI.class);
//    EventManager eventManager;
//    House house = House.getHouse();
//    public SmartHouseAPI(EventManager eventManager) {
//        this.eventManager = eventManager;
//    }
//
//    /**
//     * Method sets simulation parameters(time, pauses).
//     * @param eventGenerator
//     */
//    public void startSimulation(EventGenerator eventGenerator){
//        final long startTime = 6;
//        final long endTime = 18;
//        long currentTime = startTime;
//
//        final long simulationSpeed = 1; // Speed factor (10x, 100x, etc.)
//
//        while (currentTime < endTime){
//            if(currentTime == 6){
//                openBlinds();
//            }
//            if(currentTime == 17){
//                closeBlinds();
//            }
//            LOGGER.info("Simulated time: " +  currentTime + ":00");
//            //rand event generated
//            eventGenerator.generateEvent();
//
//            //update device consumption
//            collectDeviceData();
//            updatePerformance();
//            currentTime += 1 * simulationSpeed;
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /**
//     * Method subscribes all devices as observers.
//     */
//public void subscribeDevices(){
//
//    for(Floor floor : house.getFloors()){
//        for(Room room : floor.getRooms()){
//            eventManager.subscribe(room.getLightDevice());
//            eventManager.subscribe(room.getMotionSensor());
//            eventManager.subscribe(room.getThermostatSensor());
//
//
//            if(room instanceof Bathroom){
//                eventManager.subscribe(((Bathroom) room).getFloodSensor());
//            }
//            if(room instanceof Kitchen){
//                eventManager.subscribe(((Kitchen) room).getFloodSensor());
//            }
//            if(room.getDevices()!=null) {
//                for (Device d : room.getDevices()) {
//                    eventManager.subscribe(d);
//                }
//            }
//        }
//    }
//}
//
//
//    /**
//     * Method allows to collect device`s consumption.
//     */
//    public void collectDeviceData() {
//        DeviceAPI<Device> deviceAPI = new DeviceAPII<>();
//        for(Device d: house.getDevices()){
//            deviceAPI.recordConsumption(d);
//        }
//    }
//
//    /**
//     * Method randomly updates performance of a device.
//     */
//    public void updatePerformance(){
//        DeviceAPI<Device> deviceAPI = new DeviceAPII<>();
//        Random rand = new Random();
//        int devIndex= rand.nextInt(house.getDevices().size());
//
//        for(Device d: house.getDevices()){
//            if(rand.nextBoolean()){
//                //pick random ones
//                deviceAPI.performActionByState(d);
//                break;
//            }
//
//        }
//    }
//
//    /**
//     * Method allows to open blinds.
//     */
//    public void openBlinds(){
//    LOGGER.info("Blinds are open!");
//}
//
//    /**
//     * Method allows to close blinds .
//     */
//    public void closeBlinds(){
//        LOGGER.info("Blinds are closed!");
//    }
//}
package smart.home.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import smart.home.activity.PersonActivity;
import smart.home.event.EventGenerator;
import smart.home.event.EventManager;
import smart.home.model.*;
import smart.home.util.HouseConfig;
import smart.home.util.Report;

import java.util.Random;
import java.util.logging.Level;

public class SmartHouseAPI {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmartHouseAPI.class);
    EventManager eventManager;
    House house ;
    public SmartHouseAPI() {
        // this.eventManager = new EventManager();
    }

    /**
     * runs Simulation , subscribes devices, calls generation of events
     * at the end of simulation generates reports
     */
    public void runSimulation(){
        HouseConfig houseConfig1 = new HouseConfig();
        houseConfig1.setFirstHouseConfig();
        EventManager eventManager = new EventManager();
        this.eventManager=eventManager;
        house=House.getHouse();
        subscribeDevices();
        EventGenerator eventGenerator=new EventGenerator(eventManager);

        house.setEventManager(eventManager);

        final long startTime = 6;
        final long endTime = 18;
        long currentTime = startTime;

        final long simulationSpeed = 1; // Speed factor (10x, 100x, etc.)

        while (currentTime < endTime){
            if(currentTime == 6){
                openBlinds();
            }
            if(currentTime == 17){
                closeBlinds();
            }
            LOGGER.info("Simulated time: " +  currentTime + ":00");
            //rand event generated
            eventGenerator.generateEvent();

            //update device consumption
            collectDeviceData();
            updatePerformance();
            currentTime += 1 * simulationSpeed;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Report.loadReports(eventGenerator, eventManager);
    }

    /**
     * Method subscribes all devices and sensors as observers.
     */
    public void subscribeDevices(){

        for(Floor floor : house.getFloors()){
            for(Room room : floor.getRooms()){
                eventManager.subscribe(room.getLightDevice());
                eventManager.subscribe(room.getMotionSensor());
                eventManager.subscribe(room.getThermostatSensor());


                if(room instanceof Bathroom){
                    eventManager.subscribe(((Bathroom) room).getFloodSensor());
                }
                if(room instanceof Kitchen){
                    eventManager.subscribe(((Kitchen) room).getFloodSensor());
                }
                if(room.getDevices()!=null) {
                    for (Device d : room.getDevices()) {
                        eventManager.subscribe(d);
                    }
                }
            }
        }
    }


    /**
     * Method allows to collect device`s consumption data.
     */
    public void collectDeviceData() {
        DeviceAPI<Device> deviceAPI = new DeviceAPIImpl<>();
        for(Device d: house.getDevices()){
            deviceAPI.recordConsumption(d);
        }
    }

    /**
     * Method randomly updates performance of a device.
     */
    public void updatePerformance(){
        DeviceAPI<Device> deviceAPI = new DeviceAPIImpl<>();
        Random rand = new Random();
        int devIndex= rand.nextInt(house.getDevices().size());

        for(Device d: house.getDevices()){
            if(rand.nextBoolean()){
                //pick random ones
                deviceAPI.performActionByState(d);
                break;
            }

        }
    }

    /**
     * Method allows to open blinds.
     */
    public void openBlinds(){
        LOGGER.info("Blinds are open!");
    }

    /**
     * Method allows to close blinds .
     */
    public void closeBlinds(){
        LOGGER.info("Blinds are closed!");
    }
}



package smart.home.controller;

import smart.home.activity.PersonActivity;
import smart.home.event.EventGenerator;
import smart.home.event.EventManager;
import smart.home.model.*;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SmartHouseAPI {
    private static final Logger LOGGER = Logger.getLogger(SmartHouseAPI.class.getName());
    EventManager eventManager;
    public SmartHouseAPI(EventManager eventManager) {
        this.eventManager = eventManager;
    }


House house = House.getHouse();

    public void startSimulation(EventGenerator eventGenerator){
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
            LOGGER.log(Level.INFO,"Simulated time: " +  currentTime + ":00");
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
    }

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


    public void collectDeviceData() {
        DeviceAPI<Device> deviceAPI = new DeviceAPII<>();
        for(Device d: house.getDevices()){
//            d.recordConsumption();
            deviceAPI.recordConsumption(d);
        }
    }
    public void updatePerformance(){
        DeviceAPI<Device> deviceAPI = new DeviceAPII<>();
        Random rand = new Random();
        int devIndex= rand.nextInt(house.getDevices().size());

        for(Device d: house.getDevices()){
            if(rand.nextBoolean()){
                //pick random ones
//                d.downgradePerformance();
                deviceAPI.performActionByState(d);
                break;
            }

        }
    }

public void openBlinds(){
    LOGGER.info("Blinds are open!");
}

    public void closeBlinds(){
        LOGGER.info("Blinds are closed!");
    }
}

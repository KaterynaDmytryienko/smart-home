package smart.home.controller;

import smart.home.activity.PersonActivity;
import smart.home.event.EventManager;
import smart.home.model.*;

import java.util.Random;
import java.util.logging.Logger;

public class SmartHouseAPI {
    private static final Logger LOGGER = Logger.getLogger(SmartHouseAPI.class.getName());
    EventManager eventManager;
    public SmartHouseAPI(EventManager eventManager) {
        this.eventManager = eventManager;
    }


House house = House.getHouse();

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
        for(Device d: house.getDevices()){
            d.recordConsumption();
        }
    }
    public void updatePerformance(){
        Random rand = new Random();
        int devIndex= rand.nextInt(house.getDevices().size());

        for(Device d: house.getDevices()){
            if(rand.nextBoolean()){
                //pick random ones
                d.downgradePerformance();
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

package smart.home;

import smart.home.activity.PersonActivity;
import smart.home.controller.SmartHouseAPI;
import smart.home.event.EventGenerator;
import smart.home.event.EventManager;
import smart.home.event.Observer;
import smart.home.model.House;
import smart.home.util.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class  SmartHouseSimulation {
    public static void main(String[] args) {

        HouseConfig houseConfig1 = new HouseConfig();
        houseConfig1.setFirstHouseConfig();
        EventManager eventManager = new EventManager();
        SmartHouseAPI smartHouseAPI=new SmartHouseAPI(eventManager);
        smartHouseAPI.subscribeDevices();
        EventGenerator eventGenerator=new EventGenerator(eventManager);
        House house=House.getHouse();
        house.setEventManager(eventManager);

        smartHouseAPI.startSimulation(eventGenerator);
        Report.loadReports(eventGenerator, eventManager);
    }

}

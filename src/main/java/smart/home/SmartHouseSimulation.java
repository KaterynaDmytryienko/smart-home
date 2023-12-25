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
    private static final Logger LOGGER = Logger.getLogger(SmartHouseSimulation.class.getName());
    public static void main(String[] args) {

        HouseConfig houseConfig1 = new HouseConfig();
        houseConfig1.setFirstHouseConfig();
        EventManager eventManager = new EventManager();
        SmartHouseAPI smartHouseAPI=new SmartHouseAPI(eventManager);
        smartHouseAPI.subscribeDevices();
        EventGenerator eventGenerator=new EventGenerator(eventManager);
        House house=House.getHouse();
        house.setEventManager(eventManager);

        final long startTime = 6;
        final long endTime = 18;
        long currentTime = startTime;

        final long simulationSpeed = 1; // Speed factor (10x, 100x, etc.)

        while (currentTime < endTime){
            if(currentTime == 6){
                smartHouseAPI.openBlinds();
            }
            if(currentTime == 17){
                smartHouseAPI.closeBlinds();
            }
            LOGGER.log(Level.INFO,"Simulated time: " +  currentTime + ":00");
            //rand event generated
            eventGenerator.generateEvent();

            //update device consumption
            smartHouseAPI.collectDeviceData();
            smartHouseAPI.updatePerformance();
            currentTime += 1 * simulationSpeed;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //generating
        Report houseConfigReport = new HouseConfigurationReport();
        houseConfigReport.generateReport("HouseConfigurationReport.txt");

        Report eventReport = new EventReport(eventGenerator, eventManager);
        eventReport.generateReport("EventReport.txt");

        Report activitiesAndUsageReport = new ActivityAndUsageReport(eventGenerator, eventManager);
        activitiesAndUsageReport.generateReport("ActivityAndUsageReport.txt");

        Report deviceConsumptionReport = new ConsumptionReport();
        deviceConsumptionReport.generateReport("ConsumptionReport.txt");
    }

}

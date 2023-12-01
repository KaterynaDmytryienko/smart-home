package smart.home;

import smart.home.activity.PersonActivity;
import smart.home.controller.SmartHouseAPI;
import smart.home.event.EventGenerator;
import smart.home.event.Observer;
import smart.home.model.House;
import smart.home.util.EventLogger;
import smart.home.util.HouseConfig;

public class  SmartHouseSimulation {
    public static void main(String[] args) {
        House house = House.getHouse();
        SmartHouseAPI smartHouseAPI=new SmartHouseAPI();
        HouseConfig houseConfig1 = new HouseConfig();
        houseConfig1.setFirstHouseConfig();
        EventLogger eventLogger;
        EventGenerator eventGenerator=new EventGenerator();
        PersonActivity personActivity = new PersonActivity();


        final long startTime = 6;
        final long endTime = 18;
        long currentTime = startTime;

        final long simulationSpeed = 10; // Speed factor (10x, 100x, etc.)

        while (currentTime < endTime){
            if(currentTime == 6){
                //open blinds
            }
            if(currentTime == 17){
                //close blinds
            }
            System.out.println("Simulated time: " + currentTime + ":00");
            //rand event generated
            eventGenerator.generateEvent();

            //check event status and move on to the next

            currentTime += 1 * simulationSpeed;



            try {
                Thread.sleep(1000); // Adjust as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

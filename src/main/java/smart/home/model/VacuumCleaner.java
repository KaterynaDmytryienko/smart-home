package smart.home.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import smart.home.event.EventTypes;
import smart.home.event.Event;

import java.util.Random;

public class VacuumCleaner extends Device{
    private static final Logger LOGGER = LoggerFactory.getLogger(VacuumCleaner.class);
    public VacuumCleaner() {
        super();
        Consumption activeConsumption=new Consumption(240,0,150);
        setActiveConsumption(activeConsumption);
        Consumption offConsumption=new Consumption(0,0,0);
        setOffConsumption(offConsumption);
        Consumption idleConsumption=new Consumption(90,0,10);
        setIdleConsumption(idleConsumption);
        this.setCurrentState(DeviceState.IDLE);
    }

    /**
     * Method picks VacuumCleaner from a random room.
     */
    public void getRandomDevice(){
        Random random = new Random();
        if (random.nextBoolean()) {
            for (Device d : house.getDevices()) {
                if (d instanceof VacuumCleaner) {
                    d.setCurrentState(DeviceState.ACTIVE);
                    break;
                }
            }
        }
        else {
            for(int i = house.getDevices().size()-1; i >=0 ; i--){
                if (house.getDevices().get(i) instanceof VacuumCleaner) {
                    house.getDevices().get(i).setCurrentState(DeviceState.ACTIVE);
                    break;
                }
            }
        }
    }
    @Override
    public void update(Event event) {
        if (this.getFunctionality() <= 0 && event.getDevice() == this && event.getRoom() == this.getCurrentRoom()) {
            LOGGER.info(this.getName(this) + " is broken in the " + event.getRoom().getName() + "!!!");
        }
        if(event.getType() == EventTypes.CLEAN){
            System.out.println(event.getRoom().getName()+ " is currently being cleaned.");
            getRandomDevice();
            event.isHandled=true;
        }
    }


}

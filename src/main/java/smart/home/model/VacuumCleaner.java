package smart.home.model;

import smart.home.event.Even_Types;
import smart.home.event.Event;

import java.util.Random;
import java.util.logging.Logger;

public class VacuumCleaner extends Device{
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
            Logger logger = Logger.getLogger(VacuumCleaner.class.getName());
            logger.info(this.getName(this) + " is broken in the " + event.getRoom().getName() + "!!!");
        }
        if(event.getType() == Even_Types.CLEAN){
            System.out.println(event.getRoom().getName()+ " is currently being cleaned.");
            getRandomDevice();
            event.isHandled=true;
        }
    }


}

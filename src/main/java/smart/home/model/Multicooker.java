package smart.home.model;

import smart.home.event.Even_Types;
import smart.home.event.Event;

import java.util.Random;
import java.util.logging.Logger;

public class Multicooker extends Device{

    public Multicooker() {
        super();
        Consumption activeConsumption=new Consumption(200,0,100);
        setActiveConsumption(activeConsumption);
        Consumption offConsumption=new Consumption(0,0,0);
        setOffConsumption(offConsumption);
        Consumption idleConsumption=new Consumption(50,0,0);
        setIdleConsumption(idleConsumption);
        this.setCurrentState(DeviceState.IDLE);
    }

    public void getRandomDevice(String animalName){
        Random random = new Random();
        if (random.nextBoolean()) {
            for (Device d : house.getDevices()) {
                if (d instanceof Multicooker) {
                    d.setCurrentState(DeviceState.ACTIVE);
                    d.addUser(animalName);
                    break;
                }
            }
        }
        else {
            for(int i = house.getDevices().size()-1; i >=0 ; i--){
                if (house.getDevices().get(i) instanceof Multicooker) {
                    house.getDevices().get(i).setCurrentState(DeviceState.ACTIVE);
                    house.getDevices().get(i).addUser(animalName);
                    break;
                }
            }
        }
    }

    @Override
    public void update(Event event) {
        if (this.getFunctionality() <= 0 && event.getDevice() == this && event.getRoom() == this.getCurrentRoom()) {
            Logger logger = Logger.getLogger(Multicooker.class.getName());
            logger.info(this.getName(this) + " is broken in the " + event.getRoom().getName() + "!!!");
        }

         if( event.getType()== Even_Types.COOK_IN_MULTICOOKER) {
                    System.out.println(event.getSource().getName()+ " is using the multi-cooker.");
                    getRandomDevice(event.getSource().getName());
                    event.isHandled=true;
         }
    }
}

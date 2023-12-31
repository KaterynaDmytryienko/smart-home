package smart.home.model;

import org.slf4j.LoggerFactory;
import smart.home.activity.PersonActivity;
import smart.home.event.Even_Types;
import smart.home.event.Event;

import java.util.Random;
import java.util.logging.Logger;

public class Multicooker extends Device{

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Multicooker.class);

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

    /**
     * Method picks Multicooker from a random room and assigns user that has used it.
     * @param personName
     */
    public void getRandomDevice(String personName){
        Random random = new Random();
        if (random.nextBoolean()) {
            for (Device d : house.getDevices()) {
                if (d instanceof Multicooker) {
                    d.setCurrentState(DeviceState.ACTIVE);
                    d.addUser(personName);
                    break;
                }
            }
        }
        else {
            for(int i = house.getDevices().size()-1; i >=0 ; i--){
                if (house.getDevices().get(i) instanceof Multicooker) {
                    house.getDevices().get(i).setCurrentState(DeviceState.ACTIVE);
                    house.getDevices().get(i).addUser(personName);
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

         if( event.getType()== Even_Types.COOK_IN_MULTICOOKER) {
                    LOGGER.info(event.getSource().getName()+ " is using the multi-cooker.");
                    getRandomDevice(event.getSource().getName());
                    event.isHandled=true;
         }
    }
}

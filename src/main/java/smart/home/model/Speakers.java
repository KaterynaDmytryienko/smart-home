package smart.home.model;

import org.slf4j.LoggerFactory;
import smart.home.activity.PersonActivity;
import smart.home.event.Event;

import java.util.logging.Logger;

public class Speakers extends Device{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Speakers.class);
    public Speakers() {
        super();
        Consumption activeConsumption=new Consumption(127,0,0);
        setActiveConsumption(activeConsumption);
        Consumption offConsumption=new Consumption(0,0,0);
        setOffConsumption(offConsumption);
        Consumption idleConsumption=new Consumption(32,0,0);
        setIdleConsumption(idleConsumption);
        this.setCurrentState(DeviceState.IDLE);
    }
    @Override
    public void update(Event event) {
        if (this.getFunctionality() <= 0 && event.getDevice() == this && event.getRoom() == this.getCurrentRoom()) {
            LOGGER.info(this.getName(this) + " is broken in the " + event.getRoom().getName() + "!!!");
        }
    }
}

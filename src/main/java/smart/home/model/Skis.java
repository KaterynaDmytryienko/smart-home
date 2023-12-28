package smart.home.model;

import smart.home.event.Event;

import java.util.logging.Logger;

public class Skis extends Device {
    public Skis() {
        super();
        Consumption activeConsumption=new Consumption(0,0,0);
        setActiveConsumption(activeConsumption);
        Consumption offConsumption=new Consumption(0,0,0);
        setOffConsumption(offConsumption);
        Consumption idleConsumption=new Consumption(0,0,0);
        setIdleConsumption(idleConsumption);
        this.setCurrentState(DeviceState.OFF);
    }

    @Override
    public void update(Event event) {
        if (this.getFunctionality() <= 0 && event.getDevice() == this && event.getRoom() == this.getCurrentRoom()) {
            Logger logger = Logger.getLogger(Skis.class.getName());
            logger.info(this.getName(this) + " is broken in the " + event.getRoom().getName() + "!!!");
        }
    }
}

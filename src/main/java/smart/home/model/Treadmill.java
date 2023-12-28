package smart.home.model;

import smart.home.event.Event;

import java.util.logging.Logger;

public class Treadmill extends Device{
    public Treadmill() {
        super();
        Consumption activeConsumption=new Consumption(400,0,0);
        setActiveConsumption(activeConsumption);
        Consumption offConsumption=new Consumption(0,0,0);
        setOffConsumption(offConsumption);
        Consumption idleConsumption=new Consumption(200,0,0);
        setIdleConsumption(idleConsumption);
        this.setCurrentState(DeviceState.OFF);
    }

    @Override
    public void update(Event event) {
        if (this.getFunctionality() <= 0 && event.getDevice() == this && event.getRoom() == this.getCurrentRoom()) {
            Logger logger = Logger.getLogger(Treadmill.class.getName());
            logger.info(this.getName(this) + " is broken in the " + event.getRoom().getName() + "!!!");
        }
    }
}

package smart.home.model;

import smart.home.event.Event;

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
    @Override
    public void update(Event event) {
        if (this.getFunctionality() <= 0 && event.getDevice() == this && event.getRoom() == this.getCurrentRoom()) {
            Logger logger = Logger.getLogger(Multicooker.class.getName());
            logger.info(this.getName(this) + " is broken in the " + event.getRoom().getName() + "!!!");
        }
    }
}

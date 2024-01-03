package smart.home.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import smart.home.event.Event;

public class Skis extends Device {
    private static final Logger LOGGER = LoggerFactory.getLogger(Skis.class);

    public Skis() {
        super();
        Consumption activeConsumption = new Consumption(0, 0, 0);
        setActiveConsumption(activeConsumption);
        Consumption offConsumption = new Consumption(0, 0, 0);
        setOffConsumption(offConsumption);
        Consumption idleConsumption = new Consumption(0, 0, 0);
        setIdleConsumption(idleConsumption);
        this.setCurrentState(DeviceState.OFF);
    }

    @Override
    public void update(Event event) {
        if (this.getFunctionality() <= 0 && event.getDevice() == this && event.getRoom() == this.getCurrentRoom()) {
            LOGGER.info(this.getName(this) + " is broken in the " + event.getRoom().getName() + "!!!");
        }
    }
}

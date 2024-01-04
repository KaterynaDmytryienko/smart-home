package smart.home.model;

import org.slf4j.LoggerFactory;
import smart.home.event.Event;

public class Bicycle extends Device {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Bicycle.class);
    private String type = "regular";

    public Bicycle() {
        super();
        Consumption activeConsumption = new Consumption(400, 0, 127);
        setActiveConsumption(activeConsumption);
        Consumption offConsumption = new Consumption(200, 0, 0);
        setOffConsumption(offConsumption);
        Consumption idleConsumption = new Consumption(300, 0, 100);
        setIdleConsumption(idleConsumption);
        this.setCurrentState(DeviceState.ACTIVE);
    }

    public String getType() {
        return type;
    }

    @Override
    public void update(Event event) {

        if (this.getFunctionality() <= 0 && event.getDevice() == this && event.getRoom() == this.getCurrentRoom()) {
            LOGGER.info(this.getName(this) + " is broken in the " + event.getRoom().getName() + "!!!");
        }
    }


}

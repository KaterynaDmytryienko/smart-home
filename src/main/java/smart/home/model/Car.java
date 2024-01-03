package smart.home.model;

import org.slf4j.LoggerFactory;
import smart.home.event.Event;

public class Car extends Device {
    private String type = "regular";
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Car.class);

    public Car() {
        super();
        Consumption activeConsumption = new Consumption(400, 300, 100);
        setActiveConsumption(activeConsumption);
        Consumption offConsumption = new Consumption(200, 0, 0);
        setOffConsumption(offConsumption);
        Consumption idleConsumption = new Consumption(300, 0, 200);
        setIdleConsumption(idleConsumption);
        this.setCurrentState(DeviceState.ACTIVE);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void update(Event event) {
        if (this.getFunctionality() <= 0 && event.getDevice() == this && event.getRoom() == this.getCurrentRoom()) {
            LOGGER.info(this.getName(this) + " is broken in the " + event.getRoom().getName() + "!!!");

        }

    }

}

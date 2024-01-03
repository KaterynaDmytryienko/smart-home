package smart.home.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import smart.home.event.EventTypes;
import smart.home.event.Event;

public class ThermostatSensor implements Sensor {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThermostatSensor.class);

    @Override
    public void update(Event event) {
        if (event.getType() == EventTypes.HEAT) {
            LOGGER.info("Temperature is high ..\n opening the window in " + event.getRoom().getName());
            event.getRoom().getWindow().setOpened(true);
            event.isHandled = true;
        }
    }
}

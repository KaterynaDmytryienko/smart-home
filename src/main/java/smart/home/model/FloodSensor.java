package smart.home.model;

import org.slf4j.LoggerFactory;
import smart.home.event.EventTypes;
import smart.home.event.Event;

public class FloodSensor implements Sensor {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(FloodSensor.class);

    @Override
    public void update(Event event) {
        if (event.getType() == EventTypes.FLOOD) {
            LOGGER.info("Alerting!!Flood in " + event.getRoom().getName());
            event.isHandled = true;
        }
    }
}

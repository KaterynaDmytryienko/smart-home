package smart.home.model;

import org.slf4j.LoggerFactory;
import smart.home.activity.PersonActivity;
import smart.home.controller.SmartHouseAPI;
import smart.home.event.Even_Types;
import smart.home.event.Event;

import java.util.logging.Logger;

public class FloodSensor implements Sensor{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(FloodSensor.class);

    @Override
    public void update(Event event) {
        if (event.getType()== Even_Types.FLOOD){
            LOGGER.info("Alerting!!Flood in "+event.getRoom().getName());
            event.isHandled=true;
        }

    }
}

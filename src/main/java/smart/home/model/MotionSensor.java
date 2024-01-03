package smart.home.model;

import org.slf4j.LoggerFactory;
import smart.home.event.Event;

public class MotionSensor implements Sensor {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MotionSensor.class);

    @Override
    public void update(Event event) {
        switch (event.getType()) {
            case ENTER_ROOM:
                if (event.getRoom().getMotionSensor() == this) {
                    LOGGER.info("Entered " + event.getSource().getName());
                    event.getRoom().getLightDevice().turnLightOn(event);
                    event.isHandled = true;
                }

                break;
            case EXIT_ROOM:
                if (event.getRoom().getMotionSensor() == this) {
                    LOGGER.info("Exit " + event.getSource().getName());
                    event.getRoom().getLightDevice().turnLightOff(event);
                    event.isHandled = true;
                }
                break;
        }
    }
}

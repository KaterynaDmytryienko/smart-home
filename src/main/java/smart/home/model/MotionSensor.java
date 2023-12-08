package smart.home.model;

import smart.home.event.Event;

import java.util.logging.Logger;

public class MotionSensor implements Sensor{
    private static final Logger LOGGER = Logger.getLogger(MotionSensor.class.getName());

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

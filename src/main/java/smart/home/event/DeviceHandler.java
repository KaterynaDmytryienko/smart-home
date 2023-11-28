package smart.home.event;

public class DeviceHandler implements EventHandler{
    private EventHandler eventHandler;
    @Override
    public void assignToNext(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public void handleEvent(Event event) {
        if (canHandleLightDevice(event)) {
            // Handle with light device logic
        } else if (canHandleThermostat(event)) {
            // Handle with thermostat logic
        } else if (eventHandler != null) {
            eventHandler.handleEvent(event);
        }
    }

    private boolean canHandleLightDevice(Event event) {
        // Logic to determine if a light device should handle the event
        return false;
    }

    private boolean canHandleThermostat(Event event) {
        // Logic to determine if a thermostat should handle the event
        return false;
    }
}

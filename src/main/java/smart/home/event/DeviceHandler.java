package smart.home.event;

public class DeviceHandler implements EventHandler{
    private EventHandler eventHandler;
    private EventManager eventManager;

    public DeviceHandler(EventManager eventManager){
        this.eventManager = eventManager;
    }
    @Override
    public void assignToNext(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public void handleEvent(Event event) {
        eventManager.alertObservers(event);
            if (!event.isHandled){
                eventHandler.handleEvent(event);
            }else{
                eventManager.addToEvents(event);
            }


//        if (canHandleLightDevice(event)) {
//
////            eventManager.alertObservers(event);
//        } else if (canHandleThermostat(event)) {
//            // Handle with thermostat logic
//        } else if (eventHandler != null) {
//            eventHandler.handleEvent(event);
//        }
        //}
    }

    private boolean canHandleLightDevice(Event event) {
       if(event.getType() == Even_Types.ENTER_ROOM || event.getType() == Even_Types.EXIT_ROOM){
           return true;
       }
       return false;
    }

    private boolean canHandleThermostat(Event event) {
        // Logic to determine if a thermostat should handle the event
        return false;
    }
}

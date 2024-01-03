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

    /**
     * Method allows to handle an event.
     * @param event The event to handle.
     */

    @Override
    public void handleEvent(Event event) {
        try {
            eventManager.alertObservers(event);
            if (!event.isHandled) {
                eventHandler.handleEvent(event);
            } else {
                eventManager.addToEvents(event);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


}

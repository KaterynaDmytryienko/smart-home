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
    }

}

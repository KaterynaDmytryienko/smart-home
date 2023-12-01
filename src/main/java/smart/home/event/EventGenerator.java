package smart.home.event;

import smart.home.activity.PersonActivity;

public class EventGenerator {
    private EventManager eventManager;
    private PersonActivity personActivity;

    public EventGenerator() {
        eventManager = new EventManager();
        runSimulation();
        personActivity = new PersonActivity();
    }

    private void runSimulation() {
        // Simulate events
        dispatchEvent(Even_Types.HEAT, "Living Room Light");
        dispatchEvent(Even_Types.TEMPERATURE_CHANGE, "Thermostat");
    }

    private void dispatchEvent(Even_Types eventType, String source) {
        Event event = new Event(eventType, source);
        eventManager.alertObservers(event);
    }


    public void generateEvent(){
        //rand
        personActivity.enterTheRoom();
    }


}

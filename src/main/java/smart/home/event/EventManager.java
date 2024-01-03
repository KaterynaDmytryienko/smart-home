package smart.home.event;

import smart.home.model.Room;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Event> events = new ArrayList<>();
    private List<String> handledEventsList = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private EventHandler firstHandler;

    public EventManager() {
        EventHandler deviceHandler = new DeviceHandler(this);
        EventHandler personHandler = new PersonHandler(this);
        EventHandler animalHandler = new AnimalHandler(this);
        deviceHandler.assignToNext(personHandler);
        personHandler.assignToNext(animalHandler);

        this.firstHandler = deviceHandler;
    }

    public List<String> getHandledEventsList() {
        return handledEventsList;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void subscribe(Observer observer) {
        if (observer != null) observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    protected void alertObservers(Event event) {
        for (Observer observer : observers) {
            if (!event.isHandled && observer != null) observer.update(event);

        }
    }

    /**
     * Method archives event in order to track history for reports.
     *
     * @param event Event to be added.
     */
    public void addToEvents(Event event) {
        events.add(event);
    }

    public void handleEvent(Event event) {
        if (firstHandler != null) {
            firstHandler.handleEvent(event);
        }
    }
}



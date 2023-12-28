package smart.home.event;

import smart.home.model.Room;

import java.util.ArrayList;
import java.util.List;

public class EventManager{
    public List<Event> getEvents() {
        return events;
    }

    private List<Event>events = new ArrayList<>();

    List<Room> rooms;

    private EventHandler firstHandler;

    public List<String> getHandledEventsList() {
        return handledEventsList;
    }

    private List<String>handledEventsList = new ArrayList<>();

    public EventManager(){
        EventHandler deviceHandler = new DeviceHandler(this);
        EventHandler personHandler = new PersonHandler(this);
        EventHandler animalHandler=new AnimalHandler(this);
        deviceHandler.assignToNext(personHandler);
        personHandler.assignToNext(animalHandler);

        this.firstHandler = deviceHandler;
    }
    private List<Observer> observers = new ArrayList<>();
    public void subscribe(Observer observer) {
        if(observer!=null) observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    protected void alertObservers(Event event) {
        for (Observer observer : observers) {
              if(observer!=null &&!event.isHandled) observer.update(event);

        }
    }
    public void addToEvents(Event event){
        events.add(event);
    }
    public void handleEvent(Event event){
        if (firstHandler != null) {
            firstHandler.handleEvent(event);
        }
    }
}



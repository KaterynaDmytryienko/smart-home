package smart.home.event;

import smart.home.model.Room;

import java.util.ArrayList;
import java.util.List;

public class EventManager{
    List<Room> rooms;
    private EventHandler firstHandler;

    public EventManager(){
        EventHandler deviceHandler = new DeviceHandler(this);
        EventHandler personHandler = new PersonHandler(this);
        // ... other handlers if needed

        deviceHandler.assignToNext(personHandler);
        // ... link other handlers if needed

        this.firstHandler = deviceHandler;
    }
    private List<Observer> observers = new ArrayList<>();
    public void subscribe(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    protected void alertObservers(Event event) {
        for (Observer observer : observers) {

                observer.update(event);

        }
    }
    protected void handleEvent(Event event){
        if (firstHandler != null) {
            firstHandler.handleEvent(event);
        }
    }
}



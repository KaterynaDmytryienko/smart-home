package smart.home.event;

import smart.home.model.Room;

import java.util.ArrayList;
import java.util.List;

public class EventManager extends Thread{
    List<Room> rooms;

    @Override
    public void run(){

    }

    private List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer observer) {
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
}

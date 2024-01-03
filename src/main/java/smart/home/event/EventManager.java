package smart.home.event;

import smart.home.model.Room;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private int FIRST_ANIMAL_EVENT_INDEX = 14;
    private int LAST_ANIMAL_EVENT_INDEX = 18;
    private int FIRST_PERSON_EVENT_INDEX=2;
    private int LAST_PERSON_EVENT_INDEX = 14;
    private int FIRST_SPORT_EVENT_INDEX=0;
    private int LAST_SPORT_EVENT_INDEX = 3;
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

    /**
     * subscribes all observers that will be alerted in the future
     * @param observer
     */
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

    public int getFIRST_ANIMAL_EVENT_INDEX() {
        return FIRST_ANIMAL_EVENT_INDEX;
    }

    public void setFIRST_ANIMAL_EVENT_INDEX(int FIRST_ANIMAL_EVENT_INDEX) {
        this.FIRST_ANIMAL_EVENT_INDEX = FIRST_ANIMAL_EVENT_INDEX;
    }

    public int getLAST_ANIMAL_EVENT_INDEX() {
        return LAST_ANIMAL_EVENT_INDEX;
    }

    public void setLAST_ANIMAL_EVENT_INDEX(int LAST_ANIMAL_EVENT_INDEX) {
        this.LAST_ANIMAL_EVENT_INDEX = LAST_ANIMAL_EVENT_INDEX;
    }

    public int getFIRST_PERSON_EVENT_INDEX() {
        return FIRST_PERSON_EVENT_INDEX;
    }

    public void setFIRST_PERSON_EVENT_INDEX(int FIRST_PERSON_EVENT_INDEX) {
        this.FIRST_PERSON_EVENT_INDEX = FIRST_PERSON_EVENT_INDEX;
    }

    public int getLAST_PERSON_EVENT_INDEX() {
        return LAST_PERSON_EVENT_INDEX;
    }

    public void setLAST_PERSON_EVENT_INDEX(int LAST_PERSON_EVENT_INDEX) {
        this.LAST_PERSON_EVENT_INDEX = LAST_PERSON_EVENT_INDEX;
    }

    public int getFIRST_SPORT_EVENT_INDEX() {
        return FIRST_SPORT_EVENT_INDEX;
    }

    public void setFIRST_SPORT_EVENT_INDEX(int FIRST_SPORT_EVENT_INDEX) {
        this.FIRST_SPORT_EVENT_INDEX = FIRST_SPORT_EVENT_INDEX;
    }

    public int getLAST_SPORT_EVENT_INDEX() {
        return LAST_SPORT_EVENT_INDEX;
    }

    public void setLAST_SPORT_EVENT_INDEX(int LAST_SPORT_EVENT_INDEX) {
        this.LAST_SPORT_EVENT_INDEX = LAST_SPORT_EVENT_INDEX;
    }
}



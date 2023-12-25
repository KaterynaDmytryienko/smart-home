package smart.home.event;

import smart.home.activity.AnimalActivity;
import smart.home.activity.PersonActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EventGenerator {
    public List<Event> getEvents() {
        return events;
    }

    private List<Event>events = new ArrayList<>();
    private EventManager eventManager;
    private PersonActivity personActivity;
    private AnimalActivity animalActivity;

    public EventGenerator(EventManager eventManager) {
        this.eventManager = eventManager;
        personActivity = new PersonActivity();
        animalActivity  =new AnimalActivity();
    }


    public void generateEvent(){
        Random rand = new Random();
        Event event = personActivity.doSomething();
        events.add(event);
        if (rand.nextBoolean()){
            event=animalActivity.doSomething();
            events.add(event);
        }

        eventManager.handleEvent(event);

    }


}

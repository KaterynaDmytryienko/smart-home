package smart.home.event;

import smart.home.activity.AnimalActivity;
import smart.home.activity.PersonActivity;

import java.util.Random;

public class EventGenerator {
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
        if (rand.nextBoolean()){
            event=animalActivity.doSomething();
        }

        eventManager.handleEvent(event);

    }


}

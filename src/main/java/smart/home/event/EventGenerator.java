package smart.home.event;

import smart.home.activity.AnimalActivity;
import smart.home.activity.PersonActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EventGenerator {

    private EventManager eventManager;
    private PersonActivity personActivity;
    private AnimalActivity animalActivity;
    private int counter = 0;
    public EventGenerator(EventManager eventManager) {
        this.eventManager = eventManager;
        personActivity = new PersonActivity();
        animalActivity  =new AnimalActivity();
    }


    public void generateEvent(){
        Random rand = new Random();
        boolean generateSportEvent = (counter%2!=0);
        Event event = personActivity.doSomething(generateSportEvent);

        if (rand.nextBoolean()&&!generateSportEvent){
            event=animalActivity.doSomething(generateSportEvent);
        }

        eventManager.handleEvent(event);
        counter++;
    }


}

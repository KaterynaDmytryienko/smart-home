package smart.home.event;

import smart.home.activity.AnimalActivity;
import smart.home.activity.PersonActivity;

import java.util.Random;

public class EventGenerator {

    private EventManager eventManager;
    private PersonActivity personActivity;
    private AnimalActivity animalActivity;
    private int counter = 0;

    /**
     * Constructs an {@code EventGenerator} with the specified {@link EventManager}.
     *
     * @param eventManager the event manager to notify about generated events
     */
    public EventGenerator(EventManager eventManager) {
        this.eventManager = eventManager;
        personActivity = new PersonActivity();
        animalActivity  =new AnimalActivity();
    }


    /**
     * Method generates random events (50% - sport events, 50% - regular events).
     */
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

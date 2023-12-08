package smart.home.event;

import smart.home.activity.PersonActivity;
import smart.home.model.Person;

import java.util.List;
import java.util.Random;

public class PersonHandler implements EventHandler {
    private EventHandler eventHandler;
    private EventManager eventManager;

    private PersonActivity personActivity;

    public PersonHandler(EventManager eventManager){
        this.eventManager = eventManager;
    }

    @Override
    public void assignToNext(EventHandler eventHandler) {

    }

    @Override
    public void handleEvent(Event event) {
        List<Person>people = personActivity.getPeople();
        Random rand = new Random();
        Person selectedPerson = people.get(rand.nextInt(people.size()));;
        //enum types go in order from the ones adult only can handle(up to the ordinal 3)
        if(event.getType().ordinal() < 3){
            while (selectedPerson.getAge() < 18){
                selectedPerson = people.get(rand.nextInt(people.size()));
            }
        }
        else if(event.getType().ordinal() >= 3){
            while (selectedPerson.getAge() > 18){
                selectedPerson = people.get(rand.nextInt(people.size()));
            }
        }
        switch (event.getType()){
            case BABY_SCREAM:
                personActivity.helpTheChild(selectedPerson);
                break;
            case FLOOD:break;
            case HEAT:break;

        }
    }



}

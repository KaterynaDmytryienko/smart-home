package smart.home.event;

import smart.home.activity.PersonActivity;
import smart.home.model.Person;

import java.util.List;
import java.util.Queue;
import java.util.Random;

public class PersonHandler implements EventHandler {
    private EventHandler eventHandler;
    private EventManager eventManager;

    private PersonActivity personActivity = new PersonActivity();

    public PersonHandler(EventManager eventManager){
        this.eventManager = eventManager;
    }

    @Override
    public void assignToNext(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    /**
     * Method sets the way how person would react to the event based on age, ect.
     * @param event
     */
    @Override
    public void handleEvent(Event event) {
        Person selectedPerson = null;
        Event eventToArchive = null;
        Event eventToArchive2 = null;
        Person selectedToWait = null;
        if(event.getSource()==null||event.getSource() instanceof Person) {
            List<Person> people = personActivity.getPeople();
            Random rand = new Random();
            selectedPerson = people.get(rand.nextInt(people.size()));

            if (rand.nextBoolean())
                selectedToWait = people.get(rand.nextInt(people.size()));


            //enum types go in order from the ones adult only can handle(up to the ordinal 3)
            if (event.getType().ordinal() < 10) {
                while (selectedPerson.getAge() < 18 && selectedPerson != selectedToWait) {
                    selectedPerson = people.get(rand.nextInt(people.size()));
                    if (selectedToWait != null) selectedToWait = people.get(rand.nextInt(people.size()));
                }
            } else if (event.getType().ordinal() >= 10 && event.getType().ordinal() < 16) {
                while (selectedPerson.getAge() > 18 && selectedPerson != selectedToWait) {
                    selectedPerson = people.get(rand.nextInt(people.size()));
                    if (selectedToWait != null) selectedToWait = people.get(rand.nextInt(people.size()));
                }
            }
            if (selectedToWait == selectedPerson) selectedToWait = null;
              eventToArchive = event;
            eventToArchive.setSource(selectedPerson);

            eventToArchive2 = new Event(event.getType(), selectedToWait, event.getRoom());

            switch (event.getType()) {
                case DEVICE_BREAKAGE:
                    selectedToWait=null;
                    personActivity.fixDevice(selectedPerson, event.getDevice());
                    if (event.getDevice() != null){
                        eventToArchive.setDevice(event.getDevice());
                        event.isHandled=true;
                    }

                    break;
                case BABY_SCREAM:
                    personActivity.helpTheChild(selectedPerson);
                    event.isHandled=true;
                    break;
                case PERSON_HUNGRY:
                    personActivity.eat(selectedPerson, selectedToWait);
                    event.isHandled=true;
                    break;
                case PERSON_THIRSTY:
                    personActivity.openFridge(selectedPerson);
                    personActivity.drink(selectedPerson);
                    event.isHandled=true;
                    break;
                case PLAY:
                    personActivity.play(selectedPerson);
                    event.isHandled=true;
                    break;
                case USE_TREADMILL:
                    personActivity.useTreadmill(selectedPerson, selectedToWait);
                    event.isHandled=true;
                    break;
                case LISTEN_TO_MUSIC:
                    personActivity.listenToMusic(selectedPerson);
                    event.isHandled=true;
                    break;
                case SKI:
                    personActivity.ski(selectedPerson, selectedToWait);
                    event.isHandled=true;
                    break;
                case WORKOUT:
                    personActivity.workout(selectedPerson);
                    event.isHandled=true;
                    break;
                case DRIVE:
                    personActivity.drive(selectedPerson);
                    event.isHandled=true;
                    break;
                case CYCLE:
                    personActivity.cycle(selectedPerson, selectedToWait);
                    event.isHandled=true;
                    break;
            }

        }

        if (!event.isHandled){
            eventHandler.handleEvent(event);
        }else{
            eventManager.addToEvents(eventToArchive);
            if(selectedToWait!=null&&eventToArchive2.getSource()!=null)
                eventManager.addToEvents(eventToArchive2);
        }

    }



}

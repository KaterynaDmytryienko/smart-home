package smart.home.event;

import smart.home.activity.AnimalActivity;
import smart.home.activity.PersonActivity;
import smart.home.model.Animal;

public class AnimalHandler implements EventHandler  {
    private EventManager eventManager;

    private AnimalActivity animalActivity= new AnimalActivity();

    public AnimalHandler(EventManager eventManager){
        this.eventManager = eventManager;
    }

    @Override
    public void assignToNext(EventHandler eventHandler) {

    }

    /**
     * Method allows to handle an event.
     * @param event
     */
    @Override
    public void handleEvent(Event event) {
        Event eventToArchive=event;
        if(!(event.getSource() instanceof Animal)){
            event.isHandled = true;
            return;
        }
        switch (event.getType()) {
            case PLAY:
                animalActivity.play(event.getSource());
                event.isHandled = true;
                break;
        }
        eventManager.addToEvents(eventToArchive);
    }
}

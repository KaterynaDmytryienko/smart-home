package smart.home.model;

import smart.home.event.Event;

import java.util.List;

public class Fridge extends Device{
    List<Item> itemsList;
    public Fridge(){
        super();
        setActiveConsumption(400);
        setPassiveConsumption(100);
        setIdleConsumption(200);
        setCurrentConsumption(getIdleConsumption());
    }

    @Override
    public void update(Event event) {

    }

}

package smart.home.model;

import smart.home.event.Event;

public class PetFeeder extends Device{
    public PetFeeder() {
        super();
        Consumption activeConsumption=new Consumption(200,0,300);
        setActiveConsumption(activeConsumption);
        Consumption offConsumption=new Consumption(0,0,0);
        setOffConsumption(offConsumption);
        Consumption idleConsumption=new Consumption(100,0,100);
        setIdleConsumption(idleConsumption);
        this.setCurrentState(DeviceState.IDLE);
    }

    @Override
    public void update(Event event) {

    }
}

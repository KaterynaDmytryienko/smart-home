package smart.home.model;

import smart.home.event.Event;

public class Skis extends Device {
    public Skis() {
        super();
        Consumption activeConsumption=new Consumption(0,0,0);
        setActiveConsumption(activeConsumption);
        Consumption offConsumption=new Consumption(0,0,0);
        setOffConsumption(offConsumption);
        Consumption idleConsumption=new Consumption(0,0,0);
        setIdleConsumption(idleConsumption);
        this.setCurrentState(DeviceState.OFF);
    }

    @Override
    public void update(Event event) {

    }
}

package smart.home.model;

import smart.home.event.Event;

public class VacuumCleaner extends Device{
    public VacuumCleaner() {
        super();
        Consumption activeConsumption=new Consumption(400,0,10);
        setActiveConsumption(activeConsumption);
        Consumption offConsumption=new Consumption(0,0,0);
        setOffConsumption(offConsumption);
        Consumption idleConsumption=new Consumption(90,0,0);
        setIdleConsumption(idleConsumption);
        this.setCurrentState(DeviceState.IDLE);
    }

    @Override
    public void update(Event event) {

    }
}

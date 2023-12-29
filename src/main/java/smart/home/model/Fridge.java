package smart.home.model;

import smart.home.activity.PersonActivity;
import smart.home.event.Event;
import smart.home.util.ConsumptionReport;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fridge extends Device{
    List<Item> itemsList;
    public Fridge(){
        super();
        Consumption activeConsumption=new Consumption(400,0,100);
        setActiveConsumption(activeConsumption);
        Consumption offConsumption=new Consumption(0,0,0);
        setOffConsumption(offConsumption);
        Consumption idleConsumption=new Consumption(200,0,50);
        setIdleConsumption(idleConsumption);

        this.setCurrentState(DeviceState.IDLE);
    }

    @Override
    public void update(Event event) {
        if (this.getFunctionality() <= 0&&event.getDevice()==this&&event.getRoom()==this.getCurrentRoom()) {
            Logger logger = Logger.getLogger(Fridge.class.getName());
            logger.info(this.getName(this)+ " is broken in the "+event.getRoom().getName()+"!!!");
        }
    }
}

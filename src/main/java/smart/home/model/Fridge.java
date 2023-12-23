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
        setActiveConsumption(400);
        setOffConsumption(100);
        setIdleConsumption(200);
        this.setCurrentState(DeviceState.ACTIVE);
    }

    @Override
    public void updateConsumption() {

    }

    @Override
    public void getsBroken() {
        // Event event=new Event();
    }
    @Override
    public void update(Event event) {
//        ConsumptionRecord latestRecord = this.getLatestConsumptionRecord();
//        if (latestRecord != null && latestRecord.getFunctionality() <= 0&&event.getDevice()==this&&event.getRoom()==this.getCurrentRoom()) {

        if (this.getFunctionality() <= 0&&event.getDevice()==this&&event.getRoom()==this.getCurrentRoom()) {
            Logger logger = Logger.getLogger(Fridge.class.getName());
            logger.log(Level.FINE,this.getName(this)+ " is broken in the "+event.getRoom().getName()+"!!!");
//            if(event.getSource() instanceof Person){
//                personActivity.fixDevice((Person) event.getSource(),this);
//            }
        }
    }
}

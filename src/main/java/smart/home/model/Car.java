package smart.home.model;

import smart.home.activity.PersonActivity;
import smart.home.event.Event;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Car extends Device{
    private String type = "regular";

    public Car() {  super();
        setActiveConsumption(400);
        setOffConsumption(100);
        setIdleConsumption(200);
        this.setCurrentState(DeviceState.ACTIVE);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void update(Event event) {
//        ConsumptionRecord latestRecord = this.getLatestConsumptionRecord();
//        if (latestRecord != null && latestRecord.getFunctionality() <= 0&&event.getDevice()==this) {
//            Logger logger = Logger.getLogger(PersonActivity.class.getName());
//            logger.info(this.getName(this)+ " is broken!");
//        }
        if (this.getFunctionality() <= 0&&event.getDevice()==this&&event.getRoom()==this.getCurrentRoom()) {
            Logger logger = Logger.getLogger(Car.class.getName());
            logger.log(Level.FINE, this.getName(this)+ " is broken in the "+event.getRoom().getName()+"!!!");
//            if(event.getSource() instanceof Person){
//                personActivity.fixDevice((Person) event.getSource(),this);
//            }
        }

    }

    @Override
    public void updateConsumption() {

    }

    @Override
    public void getsBroken() {

    }
}

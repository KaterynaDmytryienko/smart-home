package smart.home.util;

import smart.home.activity.PersonActivity;
import smart.home.event.Even_Types;
import smart.home.event.Event;
import smart.home.event.EventGenerator;
import smart.home.event.EventManager;

import java.util.List;

public class EventReport extends Report{
    private EventGenerator eventGenerator;
    private EventManager eventManager;

    public EventReport(EventGenerator eventGenerator, EventManager eventManager) {
        this.eventGenerator = eventGenerator;
        this.eventManager = eventManager;
    }
    @Override
    protected String prepareReportContent() {
        List<Event>events = eventManager.getEvents();
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Event Report\n\n");


        for (Event e : events) {
            if(e.getSource()!=null) {
                if(e.getType()== Even_Types.BABY_SCREAM||e.getType()==Even_Types.DEVICE_BREAKAGE||e.getType()==Even_Types.FLOOD)
                    reportBuilder.append(e.getSource().getName() +" handled " + e.getType() +" in "+ e.getRoom().getName() + "\n");
                else
                {
                    reportBuilder.append(e.getSource().getName() +" " + e.getType() +" in "+ e.getRoom().getName() + "\n");

                }

            }
            else if(e.getDevice()!=null){
                reportBuilder.append(e.getDevice().getName(e.getDevice())+" -- " + e.getType() +" in "+ e.getRoom().getName() + "\n");
            }

        }

//        for(String s : eventManager.getHandledEventsList()){
//            reportBuilder.append(s+"\n");
//        }

        return reportBuilder.toString();
    }
}

package smart.home.util;

import smart.home.event.EventTypes;
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


    /**
     * Method sets the format of report based on the events.
     * @return Formatted string representing the event report for the household.
     */
    @Override
    protected String prepareReportContent() {
        List<Event>events = eventManager.getEvents();
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Event Report\n\n");


        for (Event e : events) {
            if(e.getSource()!=null) {
                if(e.getType()== EventTypes.BABY_SCREAM||e.getType()== EventTypes.DEVICE_BREAKAGE||e.getType()== EventTypes.FLOOD)
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
        return reportBuilder.toString();
    }
}

package smart.home.util;

import smart.home.activity.PersonActivity;
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
        List<Event>events = eventGenerator.getEvents();
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Event Report\n");


        for (Event e : events) {
            reportBuilder.append(e.getSource().getName() + e.getType() + e.getRoom().getName()+"\n");
        }

        for(String s : eventManager.getHandledEventsList()){
            reportBuilder.append(s+"\n");
        }

        return reportBuilder.toString();
    }
}

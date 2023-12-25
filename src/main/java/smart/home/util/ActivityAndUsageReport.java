package smart.home.util;

import smart.home.event.Event;
import smart.home.event.EventGenerator;
import smart.home.event.EventManager;
import smart.home.model.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ActivityAndUsageReport extends Report{
    private EventGenerator eventGenerator;
    private EventManager eventManager;

    public ActivityAndUsageReport(EventGenerator eventGenerator, EventManager eventManager) {
        this.eventGenerator = eventGenerator;
        this.eventManager = eventManager;
    }
    @Override
    protected String prepareReportContent() {
        List<Event> events = eventManager.getEvents();
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("Activity and Usage Report\n\n");

        House house=House.getHouse();
        List<String>people=house.getPeople().stream().map(person->person.getName()).toList();
        List<String>animals=house.getAnimals().stream().map(animal->animal.getName()).toList();
        List<String>everyone= Stream.concat(people.stream(), animals.stream())
                .collect(Collectors.toList());

        boolean hasEntry=false;
        for(String someone:everyone){
            reportBuilder.append(someone+"\n\n");
            reportBuilder.append("Activities:\n");
            for (Event e : events) {
                if(e.getSource()!=null){
                    if(e.getSource().getName()==someone){
                        reportBuilder.append( "--"+ e.getType()+" in " + e.getRoom().getName()+"\n");
                        hasEntry=true;
                    }
                }

            }
            if(!hasEntry){
                reportBuilder.append("--has done nothing all day ,is currently in depression((\n");
            }
            reportBuilder.append("\n");
            reportBuilder.append("Devices usage:\n");
            hasEntry=false;
            for (Device d : house.getDevices()) {
                if(d.getUsers()!=null){
                    int amountOfTimes=d.getUserCount(someone);
                    if(amountOfTimes>0){
                        reportBuilder.append("--"+d.getName(d)+", "+amountOfTimes+" times.\n");
                        hasEntry=true;
                    }

                }

            }
            if(!hasEntry){
                reportBuilder.append("--used nothing all day ,it's a tough economy.\n");
            }
            reportBuilder.append("\n");
            hasEntry=false;

        }



        return reportBuilder.toString();
    }
}

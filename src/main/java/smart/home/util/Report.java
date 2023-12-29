package smart.home.util;

import smart.home.event.EventGenerator;
import smart.home.event.EventManager;

import java.io.FileWriter;
import java.io.IOException;

public abstract class Report {
    public final void generateReport(String filename) {
        String reportContent = prepareReportContent();

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(reportContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Template method for subclasses to implement
    protected abstract String prepareReportContent();

    public static void loadReports(EventGenerator eventGenerator, EventManager eventManager){
        //generating
        Report houseConfigReport = new HouseConfigurationReport();
        houseConfigReport.generateReport("HouseConfigurationReport.txt");

        Report eventReport = new EventReport(eventGenerator, eventManager);
        eventReport.generateReport("EventReport.txt");

        Report activitiesAndUsageReport = new ActivityAndUsageReport(eventGenerator, eventManager);
        activitiesAndUsageReport.generateReport("ActivityAndUsageReport.txt");

        Report deviceConsumptionReport = new ConsumptionReport();
        deviceConsumptionReport.generateReport("ConsumptionReport.txt");
    }
}

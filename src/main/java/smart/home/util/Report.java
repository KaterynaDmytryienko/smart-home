package smart.home.util;

import smart.home.event.EventGenerator;
import smart.home.event.EventManager;

import java.io.FileWriter;
import java.io.IOException;

public abstract class Report {
    /**
     * Generates a report and writes its content to a specified file.
     *
     * @param filename The name of the file to which the report will be written.
     */
    public final void generateReport(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            String reportContent = prepareReportContent();
            writer.write(reportContent);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Template method for subclasses to implement
    protected abstract String prepareReportContent();

    /**
     * Generates and loads various reports.
     *
     * @param eventGenerator The event generator providing data for the reports.
     * @param eventManager   eventManager The event manager managing events for the reports.
     * @throws NullPointerException If either {@code eventGenerator} or {@code eventManager} is null.
     */
    public static void loadReports(EventGenerator eventGenerator, EventManager eventManager) {
        if (eventGenerator == null || eventManager == null) {
            throw new NullPointerException("EventGenerator and EventManager cannot be null.");
        }
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

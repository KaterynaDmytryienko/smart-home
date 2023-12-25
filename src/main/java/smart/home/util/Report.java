package smart.home.util;

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
}

package smart.home.util.documentation;

import smart.home.model.*;

public class DocumentationLoader {
    /**
     * Retrieves the documentation object for the specified device.
     * @param device The device for which the documentation needs to be loaded.
     * @return Documentation object containing the file path to the appropriate manual. If the device type is not recognized,
     * a Documentation object with an "error.txt" file path is returned.
     */
    public static Documentation loadDocumentation(Device device) {
        String documentationFilePath= "manuals/error.txt";
        if(device instanceof LightDevice){
             documentationFilePath = "manuals/lightManual.txt";
        }else if(device instanceof Fridge)
        {    documentationFilePath = "manuals/fridgeManual.txt";
        }else if(device instanceof Bicycle)
        {    documentationFilePath = "manuals/bicycleManual.txt";
        }else if(device instanceof Car)
        {    documentationFilePath = "manuals/carManual.txt";
        } else if(device instanceof Skis)
        {    documentationFilePath = "manuals/skisManual.txt";
        }else if(device instanceof VacuumCleaner)
        {    documentationFilePath = "manuals/vacuumCleanerManual.txt";
        } else if (device instanceof Treadmill) {
            documentationFilePath = "manuals/treadmillManual.txt";
        } else if (device instanceof Multicooker) {
            documentationFilePath = "manuals/multicookerManual.txt";
        }
        else if(device instanceof Speakers){
            documentationFilePath = "manuals/speakersManual.txt";
        }

        return new Documentation(documentationFilePath);
    }
}

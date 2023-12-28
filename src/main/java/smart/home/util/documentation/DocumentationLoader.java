package smart.home.util.documentation;

import smart.home.model.*;

public class DocumentationLoader {


    public static Documentation loadDocumentation(Device device) {
        String documentationFilePath="error.txt";
        if(device instanceof LightDevice){
             documentationFilePath = "lightManual.txt";
        }else if(device instanceof Fridge)
        {    documentationFilePath = "fridgeManual.txt";
        }else if(device instanceof Bicycle)
        {    documentationFilePath = "bicycleManual.txt";
        }else if(device instanceof Car)
        {    documentationFilePath = "carManual.txt";
        } else if(device instanceof Skis)
        {    documentationFilePath = "skisManual.txt";
        }else if(device instanceof VacuumCleaner)
        {    documentationFilePath = "vacuumCleanerManual.txt";
        } else if (device instanceof Treadmill) {
            documentationFilePath = "treadmillManual.txt";
        } else if (device instanceof Multicooker) {
            documentationFilePath = "multicookerManual.txt";
        }
        else if(device instanceof Speakers){
            documentationFilePath = "speakersManual.txt";
        }

        return new Documentation(documentationFilePath);
    }
}

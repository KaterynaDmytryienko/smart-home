package smart.home.util;

import smart.home.model.Device;
import smart.home.model.LightDevice;

public class DocumentationLoader {
    public static Documentation loadDocumentation(Device device) {
        if(device instanceof LightDevice){
            String documentationFilePath = "path.txt";
            return new LightDocumentation(documentationFilePath);
        }

        return null;
    }
}

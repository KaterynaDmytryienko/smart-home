package smart.home.util;

public class LightDocumentation implements Documentation{
    String documentationFilePath;

    public LightDocumentation(String documentationFilePath) {
        this.documentationFilePath = documentationFilePath;
    }

    public String getDocumentationFilePath(){
        return documentationFilePath;
    };
    public void displayDocumentation() {

    }
}

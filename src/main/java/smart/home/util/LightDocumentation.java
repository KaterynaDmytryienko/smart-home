package smart.home.util;

public class LightDocumentation implements Documentation{
    String documentationFilePath;

    public LightDocumentation(String documentationFilePath) {
        this.documentationFilePath = documentationFilePath;
    }

    public String getDocumentationFilePath(){
        return documentationFilePath;
    };
    public String getDocumentationManual() {
         return "GOT IT";
    }
}

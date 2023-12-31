package smart.home.util.documentation;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Documentation {
    String documentationFilePath;

    public Documentation(String documentationFilePath) {
        this.documentationFilePath = documentationFilePath;
    }

    String getDocumentationFilePath(){
        return documentationFilePath;
    };

    /**
     * @return loads instructions from file using documentationFilePath
     */
    public String getDocumentationManual() {
        try (InputStream inputStream = Documentation.class.getResourceAsStream("/" + documentationFilePath);
             Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8)) {

            if (inputStream != null) {
                StringBuilder content = new StringBuilder();
                while (scanner.hasNextLine()) {
                    content.append(scanner.nextLine()).append("\n");
                }
                return content.toString();
            } else {
                System.out.println("File not found: " + documentationFilePath);
                return "";
            }
        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    };
}

package documenteditor;

import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile implements Persistence {

    @Override
    public void save(Document document, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (DocumentElement element : document.getElements()) {
                writer.write(element.content());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

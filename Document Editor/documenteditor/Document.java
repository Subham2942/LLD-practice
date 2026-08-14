package documenteditor;

import java.util.ArrayList;
import java.util.List;

public class Document {

    private final List<DocumentElement> elements = new ArrayList<>();

    public void addElement(DocumentElement element) {
        elements.add(element);
    }

    public List<DocumentElement> getElements() {
        return elements;
    }

    public void render() {
        for (DocumentElement e : elements) {
            e.render();
        }
    }
    public static void main(String[] args) {
        System.out.println("Document Editor is running.");
    }
}

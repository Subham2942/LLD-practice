package documenteditor;

public class DocumentEditor {
    Document document;

    public DocumentEditor(Document document) {
        this.document = document;
    }

    public void renderDocument() {
        document.render();
    }

    public void addText(String text) {
        document.addElement(new TextElement(text));
    }

    public void addImage(String imagePath) {
        document.addElement(new ImageElement(imagePath));
    }

    public void addNewLine() {
        document.addElement(new NewLineElement());
    }

    public void saveDocument(Persistence persistence, String filename) {
        persistence.save(document, filename);
    }
}

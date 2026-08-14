package documenteditor;

public class Main {

    public static void main(String[] args) {
        DocumentEditor editor = new DocumentEditor(new Document());

        editor.addText("Hello, World!");
        editor.addNewLine();
        editor.addImage("path/to/image.png");
           editor.addNewLine();

        editor.addText("This above is an image to demonstrate the image element.");
     
        editor.renderDocument();
        editor.saveDocument(new SaveToFile(), "document.txt");
    }
}
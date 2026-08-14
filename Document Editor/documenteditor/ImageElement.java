package documenteditor;

public class ImageElement implements DocumentElement {
    private String imagePath;

    public ImageElement(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String content() {
        return "[IMAGE]: {" + imagePath + "}";
    }

    @Override
    public void render() {
        System.out.print(content());
    }
}

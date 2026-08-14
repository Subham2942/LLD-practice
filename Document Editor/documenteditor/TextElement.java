package documenteditor;

public class TextElement implements DocumentElement {
    private final String text;

    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public String content() {
        return text;
    }

    @Override
    public void render() {
        System.out.print(content());
    }
}

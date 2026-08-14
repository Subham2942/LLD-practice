package documenteditor;

public class NewLineElement implements DocumentElement {
    @Override
    public String content() {
        return System.lineSeparator();
    }

    @Override
    public void render() {
        System.out.print(content());
    }
}

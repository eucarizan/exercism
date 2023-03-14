import static java.lang.String.format;

public class Twofer {
    public String twofer(String name) {
        if (name == null) {
            return "One for you, one for me.";
        }
        return format("One for %s, one for me.", name);
    }
}

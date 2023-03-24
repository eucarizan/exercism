import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Robot {
    private static final Set < String > usedNames = new HashSet<>();
    private final static Random random = new Random();
    
    private String name;

    public Robot() {
        reset();
    }

    public String getName() {
        return name;
    }

    public void reset() {
        usedNames.remove(this.name);
        String name;
        while (usedNames.contains(name = generateName())) {
            continue;
        }
        usedNames.add(name);
        this.name = name;
    }

    private static String randomString(char fromChar, char toChar, int len) {
        return random.ints(fromChar, toChar + 1).limit(len)
            .mapToObj(ch -> Character.toString((char) ch))
            .collect(Collectors.joining());
    }
    private static String generateName() {
        return randomString('A', 'Z', 2) + randomString('0', '9', 3);
    }


}
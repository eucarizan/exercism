import java.util.HashMap;

class ResistorColorDuo {
    HashMap<String, Integer> colors = new HashMap<>();

    public ResistorColorDuo() {
        colors.put("black", 0);
        colors.put("brown", 1);
        colors.put("red", 2);
        colors.put("orange", 3);
        colors.put("yellow",4);
        colors.put("green", 5);
        colors.put("blue", 6);
        colors.put("violet", 7);
        colors.put("grey", 8);
        colors.put("white", 9);
    }

    int value(String[] colors) {
        return (10 * this.colors.get(colors[0])) + this.colors.get(colors[1]);
    }
}

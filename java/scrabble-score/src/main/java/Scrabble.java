// import java.util.HashMap;
// import java.util.Map;

class Scrabble {
    // Map<Character, Integer> countMap = new HashMap<>();
    int total = 0;

    Scrabble(String word) {
        // for (char ch : word.toLowerCase().toCharArray()) {
        //     countMap.putIfAbsent(ch, 0);
        //     countMap.put(ch, countMap.get(ch) + 1);
        // }
        // this.total = calculateTotal(word.toLowerCase());
        this.total = word
                .toLowerCase()
                .chars()
                .reduce(0, (sum, ch) -> sum += charGetValue((char)ch));
    }

    int getScore() {
        // for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
        //     char ch = entry.getKey();
        //     int count = entry.getValue();

        //     total += count * charGetValue(ch);
        // }

        // return total;
        return total;
    }

    // private int calculateTotal(String word) {
    //     return word
    //         .chars()
    //         .reduce(0, (sum, ch) -> sum += charGetValue((char)ch));
    // }

    private int charGetValue(char ch) {
        int value = switch (ch) {
            case 'd', 'g' -> 2;
            case 'b', 'c', 'm', 'p' -> 3;
            case 'f', 'h', 'v', 'w', 'y' -> 4;
            case 'k' -> 5;
            case 'j', 'x' -> 8;
            case 'q', 'z' -> 10;
            default -> 1;
        };

        return value;
    }

}

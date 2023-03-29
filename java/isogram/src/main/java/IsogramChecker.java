import java.util.HashMap;
import java.util.Map.Entry;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : phrase.toLowerCase().replaceAll("-|\\s", "").toCharArray()) {
            map.putIfAbsent(ch, 0);
            map.put(ch, map.get(ch)+1);
        }

        for (Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 1) {
                return false;
            }
        }

        return true;
    }

}

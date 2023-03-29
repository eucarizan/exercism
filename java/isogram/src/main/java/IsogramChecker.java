import java.util.HashSet;

// import java.util.HashMap;
// import java.util.Map.Entry;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        // my solution
        // HashMap<Character, Integer> map = new HashMap<>();

        // for (char ch : phrase.toLowerCase().replaceAll("-|\\s", "").toCharArray()) {
        //     map.putIfAbsent(ch, 0);
        //     map.put(ch, map.get(ch)+1);
        // }

        // for (Entry<Character, Integer> entry : map.entrySet()) {
        //     if (entry.getValue() != 1) {
        //         return false;
        //     }
        // }

        // return true;

        // filter() and map() with allMatch() approach
        // add() metthod returns true if value is NOT already in the HashSet or not (false)
        // return phrase.chars()
        //     .filter(Character::isLetter)
        //     .map(Character::toLowerCase)
        //     .allMatch(new HashSet<>()::add);

        phrase = phrase.replaceAll("[\\W]", "").toLowerCase();

        return phrase.length() == phrase.chars().distinct().count();
    }

}

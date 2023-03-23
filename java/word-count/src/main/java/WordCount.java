import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
class WordCount {
    public Map<String,Integer> phrase(String word) {
        return Arrays.stream(word
                .toLowerCase()
                .replaceAll("[^a-z0-9' ]", " ")
                .trim()
                .split("\\s+"))
            .map(it -> it.replaceAll("^'|'$", ""))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, it -> it.getValue().intValue()));
    }
}

// // import java.util.Arrays;
// import java.util.HashMap;
// import java.util.Map;

// class WordCount {
//     Map<String, Integer> map = new HashMap<>();
    
//     public Map<String, Integer> phrase(String input) {

//         for (String word : input.toLowerCase().split("\\s+|,")) {

//             word = word.replaceAll("^\\p{Punct}+|\\p{Punct}+$", "");
//             if (word.length() == 0) {
//                 continue; 
//             }
//                 map.putIfAbsent(word, 0);
//                 map.put(word, map.get(word)+1);
//         }
        

//         return map;
//     }
// }

import java.util.TreeMap;
import java.util.Map;

class RaindropConverter {
    private static final TreeMap<Integer, String> lookup = new TreeMap<Integer, String>(Map.of(3, "Pling", 5, "Plang", 7, "Plong"));

    String convert(int number) {
        var output = new StringBuilder();

        lookup.forEach((divisor, drop) -> {
            if (number % divisor == 0) {
                output.append(drop);
            }
        });

        return output.length() != 0 ? output.toString() : Integer.toString(number);
    }
}

// class RaindropConverter {

//     String convert(int number) {
//         StringBuilder str = new StringBuilder();

//         if (number % 3 == 0) {
//             str.append("Pling");
//         }
        
//         if (number % 5 == 0) {
//             str.append("Plang");
//         }
        
//         if (number % 7 == 0) {
//             str.append("Plong");
//         }
        
//         return str.length()==0 ? Integer.toString(number) : str.toString();
//     }

// }

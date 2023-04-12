import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class BeerSong {
    public String sing(int startingBottles, int verses) {
        return IntStream.rangeClosed(0, verses - 1)
                .mapToObj(i -> singVerse(startingBottles - i))
                .collect(Collectors.joining());
    }
    
    private String singVerse(int bottles) {
        if (bottles == 0) {
            return "No more bottles of beer on the wall, no more bottles of beer.\n" +
                    "Go to the store and buy some more, 99 bottles of beer on the wall.\n\n";
        } else if (bottles == 1) {
            return "1 bottle of beer on the wall, 1 bottle of beer.\n" +
                    "Take it down and pass it around, no more bottles of beer on the wall.\n\n";
        } else if (bottles == 2) {
            return "2 bottles of beer on the wall, 2 bottles of beer.\n" +
                    "Take one down and pass it around, 1 bottle of beer on the wall.\n\n";
        } else {
            return bottles + " bottles of beer on the wall, " + bottles + " bottles of beer.\n" +
                    "Take one down and pass it around, " + (bottles - 1) + " bottles of beer on the wall.\n\n";
        }
    }

    public String singSong() {
        return sing(99, 100);
    }
    
}

// public class BeerSong {
//     private final String GENERIC = "%s bottles of beer on the wall, %s bottles of beer.\nTake one down and pass it around, %s bottles of beer on the wall.\n\n";

//     public String sing(int num, int n) {
//         StringBuilder str = new StringBuilder();
        
//         for (int i = 0; i < n; i++, num--) {
//             if (num == 0) {
//                 str.append("No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n\n");
//             } else if (num == 1) {
//                 str.append(String.format("%s bottle of beer on the wall, %s bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n\n", num, num));
//             }else if (num == 2) {
//                 str.append(String.format("%s bottles of beer on the wall, %s bottles of beer.\nTake one down and pass it around, %s bottle of beer on the wall.\n\n", num, num, num-1));
//             } else {
//                 str.append(String.format(GENERIC, num, num, num-1));
//             }
//         }
        
//         return str.toString();
//     }

//     public String singSong() {
//         return sing(99, 100);
//     }
// }
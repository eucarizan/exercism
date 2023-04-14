import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class House {
    private final String[] VERSES = {
            "the house that Jack built.",
            "the malt that lay in",
            "the rat that ate",
            "the cat that killed",
            "the dog that worried",
            "the cow with the crumpled horn that tossed",
            "the maiden all forlorn that milked",
            "the man all tattered and torn that kissed",
            "the priest all shaven and shorn that married",
            "the rooster that crowed in the morn that woke",
            "the farmer sowing his corn that kept",
            "the horse and the hound and the horn that belonged to"
    };

    public String verse(int line) {
        return "This is " + IntStream.rangeClosed(1, line)
                .mapToObj(i -> line - i)
                .map(i -> VERSES[i])
                .collect(Collectors.joining(" "));
    }

    public String verses(int startVerse, int endVerse) {
        return IntStream.rangeClosed(startVerse, endVerse)
                .mapToObj(i -> verse(i))
                .collect(Collectors.joining("\n"));
    }

    public String sing() {
        return verses(1, 12);
    }
}

// public class House {

//     private final String[] LINES = {
//             "",
//             "the malt ",
//             "the rat ",
//             "the cat ",
//             "the dog ",
//             "the cow with the crumpled horn ",
//             "the maiden all forlorn ",
//             "the man all tattered and torn ",
//             "the priest all shaven and shorn ",
//             "the rooster that crowed in the morn ",
//             "the farmer sowing his corn ",
//             "the horse and the hound and the horn "
//     };
//     private final String[] GENERIC = {
//             "the house that Jack built.",
//             "that lay in ",
//             "that ate ",
//             "that killed ",
//             "that worried ",
//             "that tossed ",
//             "that milked ",
//             "that kissed ",
//             "that married ",
//             "that woke ",
//             "that kept ",
//             "that belonged to "
//     };

//     public String verse(int line) {
//         StringBuilder str = new StringBuilder("This is ");

//         for (int i = 1; i <= line; i++) {
//             str.append(String.format(LINES[line - i])).append(String.format(GENERIC[line - i]));
//         }

//         return str.toString();
//     }

//     public String verses(int startVerse, int endVerse) {
//         StringBuilder str = new StringBuilder();

//         for (int i = startVerse; i <= endVerse; i++) {
//             str.append(verse(i));

//             if (i != endVerse) {
//                 str.append("\n");
//             }
//         }

//         return str.toString();
//     }

//     public String sing() {
//         return verses(1, 12);
//     }

// }
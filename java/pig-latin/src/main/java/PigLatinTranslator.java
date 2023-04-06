import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;

public class PigLatinTranslator {

    private static final HashSet<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    private static final HashSet<String> specials = new HashSet<String>(Arrays.asList("xr", "yt"));

    public String translate(String str) {
        ArrayList<String> piggyfied = new ArrayList<>();
        var words = str.split(" ");

        for (String word : words) {
            if (vowels.contains(word.charAt(0)) || specials.contains(word.substring(0, 2))) {
                piggyfied.add(word + "ay");
                continue;
            }

            var length = word.length();

            for (int pos = 1; pos < length; pos++) {
                var letter = word.charAt(pos);
                if (vowels.contains(letter) || letter == 'y') {
                    if (letter == 'u' && word.charAt(pos - 1) == 'q') pos += 1;
                    piggyfied.add(word.substring(pos) + word.substring(0, pos) + "ay");
                    break;
                }
            }
        }

        return String.join(" ", piggyfied);
    }
}

// public class PigLatinTranslator {
//     public String translate(String str) {
//         String[] words = str.split(" ");

//         StringBuilder out = new StringBuilder();

//         for (String word : words) {
//             out.append(byWord(word)).append(" ");
//         }

//         return out.toString().trim();
//     }

//     private String byWord(String str) {
//         char ch = str.charAt(0);

//         StringBuilder out = new StringBuilder();

//         if (str.equals("my")) {
//             return "ymay";
//         }

//         if (isVowel(ch)) {
//             out.append(str);
//         } else {
//             String cons = "";
//             int idx = 0;

//             while (!isVowel(ch) && idx < str.length()) {
//                 cons += ch;

//                 if (ch == 'q' && str.charAt(idx + 1) == 'u') {
//                     idx += 2;
//                     cons += 'u';
//                     break;
//                 } else if (ch == 'y' && !isVowel(str.charAt(idx + 1))) {
//                     if (!cons.equals("rhy")) {
//                         cons = "";
//                     } else {
//                         cons = "rh";
//                     }
//                     break;
//                 } else if (ch == 'x' && idx == 0 && !isVowel(str.charAt(idx + 1))) {
//                     cons = "";
//                     break;
//                 }

//                 idx++;
//                 ch = str.charAt(idx);
//             }

//             String subs = str.substring(idx); // debugging
//             out.append(subs).append(cons);
//         }

//         String output = out.append("ay").toString(); // debugging
//         return output;
//     }

//     private boolean isVowel(char ch) {
//         return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
//     }
// }

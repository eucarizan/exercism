import java.util.function.Predicate;
import java.util.regex.Pattern;

class Bob {
    final private static String[] answers = {
        "Whatever.",
        "Sure.",
        "Whoa, chill out!",
        "Calm down, I know what I'm doing!"
    };
    final private static Pattern isAlpha = Pattern.compile("[a-zA-Z]");
    final private static Predicate < String > isShout = msg -> isAlpha.matcher(msg).find() && msg == msg.toUpperCase();

    public String hey(String message) {
        var speech = message.trim();
        if (speech.isEmpty()) {
            return "Fine. Be that way!";
        }
        var questioning = speech.endsWith("?") ? 1 : 0;
        var shouting = isShout.test(speech) ? 2 : 0;
        return answers[questioning + shouting];
    }
}


// import java.util.function.Predicate;
// import java.util.regex.Pattern;

// class Bob {

//     final private static Pattern isAlpha = Pattern.compile("[a-zA-Z]");
//     final private static Predicate < String > isShout = msg -> isAlpha.matcher(msg).find() && msg == msg.toUpperCase();

//     public String hey(String message) {
//         var speech = message.trim();
//         if (speech.isEmpty()) {
//             return "Fine. Be that way!";
//         }
//         var questioning = speech.endsWith("?");
//         var shouting = isShout.test(speech);
//         if (questioning) {
//             if (shouting) {
//                 return "Calm down, I know what I'm doing!";
//             }
//             return "Sure.";
//         }
//         if (shouting) {
//             return "Whoa, chill out!";
//         }
//         return "Whatever.";
//     }
// }

// public class Bob {
//     public String hey(String str) {
//         if (str.matches("[\\s]+") || str == "") {
//             return "Fine. Be that way!";
//         }

//         if (isUpper(str) && isQuestion(str)) {
//             return "Calm down, I know what I'm doing!";
//         }

//         if (isUpper(str)) {
//             return "Whoa, chill out!";
//         }

//         if (isQuestion(str)) {
//             return "Sure.";
//         }

//         return "Whatever.";
//     }

//     private boolean isUpper(String input) {
//         String str = input.replaceAll("[^a-zA-Z]", "");

//         if (str == "") {
//             return false;
//         }

//         // for (int i = 0; i < str.length(); i++) {
//         //     if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
//         //         return false;
//         //     }
//         // }

//         // return true;
//         return str.chars().allMatch(ch -> Character.isUpperCase(ch));
//     }

//     private boolean isQuestion(String str) {
//         return str.trim().charAt(str.trim().length() - 1) == '?';
//     }
// }
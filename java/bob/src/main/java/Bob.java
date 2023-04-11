public class Bob {
    public String hey(String str) {
        if (str.matches("[\\s]+") || str == "") {
            return "Fine. Be that way!";
        }

        if (isUpper(str) && isQuestion(str)) {
            return "Calm down, I know what I'm doing!";
        }

        if (isUpper(str)) {
            return "Whoa, chill out!";
        }

        if (isQuestion(str)) {
            return "Sure.";
        }

        return "Whatever.";
    }

    private boolean isUpper(String input) {
        String str = input.replaceAll("[^a-zA-Z]", "");

        if (str == "") {
            return false;
        }

        // for (int i = 0; i < str.length(); i++) {
        //     if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
        //         return false;
        //     }
        // }

        // return true;
        return str.chars().allMatch(ch -> Character.isUpperCase(ch));
    }

    private boolean isQuestion(String str) {
        return str.trim().charAt(str.trim().length() - 1) == '?';
    }
}
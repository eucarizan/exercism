class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        String num = stringToVerify.replace("-", "").toUpperCase();
        
        if (num.length() != 10) {
            return false;
        }

        int sum = 0;
        for (int i = 0, j = 10; i < num.length(); i++, j--) {
            int digit = 0;
            char ch = num.charAt(i);
            
            if (ch == 'X' && i == 9) {
                digit = 10;
            } else if (ch >= 'A' && ch <= 'Z'){
                return false;
            } else {
                digit = Character.getNumericValue(ch);
            }

            sum += j * digit;
        }

        if (sum % 11 != 0) {
            return false;
        }

        return true;
    }
}

// map() with sum()
/*
import java.util.stream.IntStream;

class IsbnVerifier {

    public boolean isValid(String s) {
        String scrubbed = s.replace("-", "");

        return scrubbed.matches("^([0-9]{10}|[0-9]{9}X)$") &&
            IntStream.range(0, scrubbed.length())
            .map(pos -> {
                var chr = scrubbed.charAt(pos);
                return (chr != 'X' ? chr - '0' : 10) * (10 - pos);
            })
            .sum() % 11 == 0;
    }
}
 */

// for-each
/*
class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        int sum = 0;
        int pos = 0;
        
        for (var chr: stringToVerify.toCharArray()) {
            if (Character.isDigit(chr)) {
                sum += (chr - '0') * (10 - pos);
                pos++;
                continue;
            }
            if (chr == '-')
                continue;
            if (chr == 'X' && pos == 9) {
                sum += 10;
                pos++;
                continue;
            }
            return false;
        }
        
        return pos == 10 && sum % 11 == 0;
    }

}
 */

 // chars() with foreach()
 /*
class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        var acc = new IsbnAcc();
        stringToVerify.chars().forEach(acc::calc);
        return acc.isIsbn();
    }

}

class IsbnAcc {
    int sum = 0;
    int pos = 0;
    boolean allValidChars = true;

    boolean isIsbn() {
        return allValidChars && pos == 10 && sum % 11 == 0;
    }

    void calc(int codePoint) {
        if (Character.isDigit(codePoint)) {
            sum += (codePoint - '0') * (10 - pos);
            pos++;
            return;
        }
        if (codePoint == '-')
            return;
        if (codePoint == 'X' && pos == 9) {
            sum += 10;
            pos++;
            return;
        }
        allValidChars = false;
    }
}

  */
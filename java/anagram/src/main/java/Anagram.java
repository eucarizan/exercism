import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Anagram {
    String baseWord;

    public Anagram(String baseWord) {
        this.baseWord = baseWord.toLowerCase();
    }

    public List<String> match(List<String> words) {
        List<String> out = new ArrayList<String>();

        for (String word : words) {
            if (word.length() != baseWord.length()) {
                continue;
            }
            
            char[] a1 = baseWord.toCharArray();
            char[] a2 = word.toLowerCase().toCharArray();
            Arrays.sort(a1);
            Arrays.sort(a2);
            
            if (Arrays.equals(a1, a2) && !baseWord.equals(word.toLowerCase())) {
                out.add(word);
            }
        }

        return out;
    }
}
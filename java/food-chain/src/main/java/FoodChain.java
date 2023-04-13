public class FoodChain {
    private final String[] ANIMALS = { "", "fly", "spider", "bird", "cat", "dog", "goat", "cow", "horse" };
    private final String FIRSTLINE = "I know an old lady who swallowed a %s.\n";
    private final String LASTLINE = "I don't know why she swallowed the fly. Perhaps she'll die.";
    private final String[] COMMENTS = {
            "",
            "",
            "It wriggled and jiggled and tickled inside her.\n",
            "How absurd to swallow a bird!\n",
            "Imagine that, to swallow a cat!\n",
            "What a hog, to swallow a dog!\n",
            "Just opened her throat and swallowed a goat!\n",
            "I don't know how she swallowed a cow!\n",
            "She's dead, of course!"
    };
    private final String[] RESPONSES = {
        "",
        "",
        "She swallowed the spider to catch the fly.\n",
        "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her.\n",
        "She swallowed the cat to catch the bird.\n",
        "She swallowed the dog to catch the cat.\n",
        "She swallowed the goat to catch the dog.\n",
        "She swallowed the cow to catch the goat.\n"
    };

    public String verse(int num) {
        StringBuilder str = new StringBuilder();

        str.append(String.format(FIRSTLINE, ANIMALS[num]));
        str.append(String.format(COMMENTS[num]));

        for (int i = 0; i < num && num != 8; i++) {
            str.append(RESPONSES[num-i]);
        }

        if (num != 8) {
            str.append(LASTLINE);
        }

        return str.toString();
    }

    public String verses(int start, int end) {
        StringBuilder str = new StringBuilder();

        for (int i = start; i <= end; i++) {
            str.append(verse(i));

            if (i < end) {
                str.append("\n\n");
            }
        }

        return str.toString();
    }
}
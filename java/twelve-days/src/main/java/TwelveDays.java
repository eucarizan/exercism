import java.util.stream.IntStream;
import java.util.stream.Collectors;

class TwelveDays {
    private final String GENERIC = "On the %s day of Christmas my true love gave to me: ";
    private final String[] DAYS = { "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"};
    private final String[] GIFTS = { "a Partridge in a Pear Tree.\n",
            "two Turtle Doves, ",
            "three French Hens, ",
            "four Calling Birds, ",
            "five Gold Rings, ",
            "six Geese-a-Laying, ",
            "seven Swans-a-Swimming, ",
            "eight Maids-a-Milking, ",
            "nine Ladies Dancing, ",
            "ten Lords-a-Leaping, ",
            "eleven Pipers Piping, ",
            "twelve Drummers Drumming, " };

    String verse(int verseNumber) {
        StringBuilder str = new StringBuilder();
        str.append(String.format(GENERIC, DAYS[verseNumber - 1]));

        for (int i = verseNumber - 1; i >= 0; i--) {
            if (i == 0 && verseNumber != 1) {
                str.append("and ");
            }

            str.append(GIFTS[i]);

            // if (i == 0) {
            //     str.append(".\n");
            // } else if (i == 1) {
            //     str.append(", and ");
            // } else {
            //     str.append(", ");
            // }
        }

        return str.toString();
    }

    String verses(int startVerse, int endVerse) {
        // StringBuilder verse = new StringBuilder();

        // for (int i = startVerse; i <= endVerse; i++) {
        //     verse.append(verse(i));

        //     if (i < endVerse) {
        //         verse.append("\n");
        //     }
        // }

        // return verse.toString();
        return IntStream.rangeClosed(startVerse, endVerse)
                        .mapToObj(this::verse)
                        .collect(Collectors.joining("\n"));
    }

    String sing() {
        return verses(1, 12);
    }
}

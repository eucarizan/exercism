import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

final class DiamondPrinter {
    public static final char FROM = 'A';
    public static String line(int x, int y) {
        final int i = x - FROM;
        return IntStream.rangeClosed(FROM - i, FROM + i)
                .map(j -> FROM + Math.abs(FROM - j) == y? y: ' ')
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
    }
    public List<String> printToList(char x) {
        return IntStream.concat(
                IntStream.rangeClosed(FROM, x),
                IntStream.iterate(x - 1, y -> y - 1).limit(x - FROM))
                .mapToObj(y -> line(x, y))
                .collect(Collectors.toList());
    }
}

// import java.util.Arrays;
// import java.util.List;

// public class DiamondPrinter {
//     public List<String> printToList(char letter) {
//         int number = letter - 'A' + 1;
//         int size = 2 * (number - 1) + 1;
//         String[] lines = new String[size];

//         for (int i=0; i<size / 2 + 1; i++) {
//             char c = (char) ('A' + i);
//             int leftPosition = size / 2 + 1 - i - 1;
//             int rightPosition = size - leftPosition - 1;
//             char[] buffer = new char[size];
//             Arrays.fill(buffer, ' ');
//             buffer[leftPosition] = c;
//             buffer[rightPosition] = c;
//             String line = new String(buffer);
//             lines[i] = line;
//             lines[size - 1 - i] = line;
//         }

//         return Arrays.asList(lines);
//     }
// }

// import java.util.List;
// import java.util.ArrayList;

// class DiamondPrinter {

//     public List<String> printToList(char maxChar) {
//         int diamondSize = (maxChar - 'A') * 2 + 1;
//         List<String> diamond = new ArrayList<>();

//         // Upper half of diamond
//         for (int i = 0; i < diamondSize / 2 + 1; i++) {
//             char currentChar = (char) ('A' + i);
//             String line = createDiamondLine(currentChar, i, diamondSize);
//             diamond.add(line);
//         }

//         // Lower half of diamond (in reverse order)
//         for (int i = diamondSize / 2 - 1; i >= 0; i--) {
//             char currentChar = (char) ('A' + i);
//             String line = createDiamondLine(currentChar, i, diamondSize);
//             diamond.add(line);
//         }

//         return diamond;
//     }

//     private String createDiamondLine(char currentChar, int index, int diamondSize) {
//         StringBuilder sb = new StringBuilder();
//         int spaces = diamondSize / 2 - index;
//         sb.append(" ".repeat(spaces));
//         sb.append(currentChar);
//         if (currentChar != 'A') {
//             int padding = (index * 2) - 1;
//             sb.append(" ".repeat(padding));
//             sb.append(currentChar);
//         }
//         sb.append(" ".repeat(spaces));
//         return sb.toString();
//     }

// }

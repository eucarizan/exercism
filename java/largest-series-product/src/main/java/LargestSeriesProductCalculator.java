import java.util.stream.IntStream;

class LargestSeriesProductCalculator {

    private String num;

    LargestSeriesProductCalculator(String inputNumber) {
        if (inputNumber == null) {
            throw new IllegalArgumentException("String to search must be non-null.");
        }

        if (!inputNumber.matches("\\d*")) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }

        num = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {

        if (numberOfDigits > num.length()) {
            throw new IllegalArgumentException(
                    "Series length must be less than or equal to the length of the string to search.");
        }

        if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }

        return IntStream.range(0, num.length() - numberOfDigits + 1)
                .mapToLong(i -> IntStream.range(i, i + numberOfDigits)
                        .map(j -> Character.getNumericValue(num.charAt(j)))
                        .mapToLong(Long::valueOf)
                        .reduce(1, (a, b) -> (long) a * b))
                .max().orElse(0);

        // For debbuging
        // return IntStream.range(0, num.length() - numberOfDigits + 1).peek(x -> System.out.println("stream: " + x))
        //         .mapToLong(i -> IntStream.range(i, i + numberOfDigits).peek(x -> System.out.println("mapToLong1: " + x))
        //                 .map(j -> Character.getNumericValue(num.charAt(j))).peek(x -> System.out.println("map: " + x))
        //                 .mapToLong(Long::valueOf).peek(x -> System.out.println("mapToLong2: " + x))
        //                 .reduce(1, (a, b) -> (long) a * b))
        //         .peek(x -> System.out.println("reduced: " + x + "\n"))
        //         .max().orElse(0);

        // Original solution
        // Long maxProduct = 0L;

        // for (int l = 0, r = numberOfDigits - 1; r < num.length(); l++, r++) {
        //     Long product = 1L;
        //     for (int i = l; i <= r; i++) {
        //         Long multiplier = Long.valueOf(Character.getNumericValue(num.charAt(i)));
        //         product *= multiplier;
        //     }
        //     maxProduct = Math.max(product, maxProduct);
        // }

        // return maxProduct;
    }
}

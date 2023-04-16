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

        // return IntStream.rangeClosed(0, num.length() - numberOfDigits)
        //     .mapToLong(i -> IntStream.range(0, numberOfDigits)
        //     .mapToLong(j -> ))
        Long maxProduct = 0L;

        for (int l = 0, r = numberOfDigits - 1; r < num.length(); l++, r++) {
            Long product = 1L;
            for (int i = l; i <= r; i++) {
                Long multiplier = Long.valueOf(Character.getNumericValue(num.charAt(i)));
                product *= multiplier;
            }
            maxProduct = Math.max(product, maxProduct);
        }

        return maxProduct;
    }
}

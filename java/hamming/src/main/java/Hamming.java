public class Hamming {
    private int diff = 0;

    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
    
        if (!leftStrand.isEmpty() && rightStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
    
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }

        // for loop
        for (int i = 0; i<leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                diff++;
            }
        }

        // IntStream with filter() and count()
        // difference = IntStream
        //     .range(0, leftStrand.length())
        //     .filter(i -> leftStrand.charAt(i) != rightStrand.charAt(i))
        //     .count();

        // IntStream with map() and sum()
        // difference = IntStream
        //     .range(0, leftStrand.length())
        //     .map(i -> leftStrand.charAt(i) != rightStrand.charAt(i) ? 1 : 0)
        //     .sum();

        // IntStream with reduce() // might be the fastest
        // difference = IntStream.range(0, leftStrand.length()).reduce(0,
        //     (hamcount, index) -> hamcount + (leftStrand.charAt(index) != rightStrand.charAt(index) ? 1 : 0));

    }

    public int getHammingDistance() {
        return diff;
    }
}

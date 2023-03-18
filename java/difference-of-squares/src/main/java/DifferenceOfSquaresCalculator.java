import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        // int num = 0;

        // for (int i = 1; i <= input; i++) {
        //     num += i;
        // } 
        int num = IntStream.rangeClosed(1, input).sum();

        return num * num;
    }

    int computeSumOfSquaresTo(int input) {
        // int num = 0;

        // for (int i = 1; i <= input; i++) {
        //     num += i*i;
        // }
        
        // return num;
        return IntStream.rangeClosed(1, input)
            .map(num -> num * num)
            .sum();
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}

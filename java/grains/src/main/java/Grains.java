import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        if (square > 64 || square < 1) throw new IllegalArgumentException("square must be between 1 and 64");

        return BigInteger.TWO.pow(square - 1);
    }

    BigInteger grainsOnBoard() {
        // BigInteger out = BigInteger.ZERO;
        // BigInteger num;

        // for (int i = 1; i < 65; i++) {
        //     num = grainsOnSquare(i);
        //     out = out.add(num);
        // }

        // return out;
        return BigInteger.valueOf(2).pow(64).subtract(BigInteger.ONE);
    }

}

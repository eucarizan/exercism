import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class HandshakeCalculator {
    List<Signal> actions = new LinkedList<>();
    boolean reverse = true;

    List<Signal> calculateHandshake(int number) {
        if (number > 63) {
            number -= 64;
        }

        if (number > 31) {
            number -= 32;
        }

        if (number > 15) {
            reverse = false;
            number -= 16;
        }

        if (number > 7) {
            actions.add(Signal.JUMP);
            number -= 8;
        }

        if (number > 3) {
            actions.add(Signal.CLOSE_YOUR_EYES);
            number -= 4;
        }

        if (number > 1) {
            actions.add(Signal.DOUBLE_BLINK);
            number -= 2;
        }

        if (number > 0) {
            actions.add(Signal.WINK);
        }

        if (reverse) {
            Collections.reverse(actions);
        }

        // simpleSolution(number);

        return actions;
    }

    private void simpleSolution(int number) {
        if ((number & 1) == 1) {
            actions.add(Signal.WINK);
        }
        if ((number & 2) == 2) {
            actions.add(Signal.DOUBLE_BLINK);
        }
        if ((number & 4) == 4) {
            actions.add(Signal.CLOSE_YOUR_EYES);
        }
        if ((number & 8) == 8) {
            actions.add(Signal.JUMP);
        }
        if ((number & 16) == 16) {
            Collections.reverse(actions);
        }
    }

}

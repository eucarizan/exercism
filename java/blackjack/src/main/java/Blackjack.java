public class Blackjack {

    public int parseCard(String card) {
        int num = 0;

        switch (card) {
            case "ace":
                num = 11;
                break;
            case "two":
                num = 2;
                break;
            case "three":
                num = 3;
                break;
            case "four":
                num = 4;
                break;
            case "five":
                num = 5;
                break;
            case "six":
                num = 6;
                break;
            case "seven":
                num = 7;
                break;
            case "eight":
                num = 8;
                break;
            case "nine":
                num = 9;
                break;
            case "ten":
            case "jack":
            case "queen":
            case "king":
                num = 10;
                break;
        }

        return num;
    }

    public boolean isBlackjack(String card1, String card2) {
        return 21 == (parseCard(card1) + parseCard(card2));
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        if (isBlackjack && (dealerScore != 11 && dealerScore != 10)) {
            return "W";
        }
        return "S";
    }

    public String smallHand(int handScore, int dealerScore) {
        if (handScore <= 11) {
            return "H";
        } else if ((handScore >= 12 && handScore <= 16) && dealerScore >= 7) {
            return "H";
        }
        return "S";
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the
    // cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls
    // the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (handScore == 22) {
            return "P";
        } else if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}

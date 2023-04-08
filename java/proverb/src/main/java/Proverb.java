class Proverb {
    private final String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        StringBuilder str = new StringBuilder();

        if (words.length == 0) {
            return "";
        }

        for (int i = 0; i < words.length - 1; i++) {
            str.append("For want of a ")
                .append(words[i])
                .append(" the ")
                .append(words[i+1])
                .append(" was lost.\n");
        }

        str.append("And all for the want of a ")
            .append(words[0])
            .append(".");

        return str.toString();
    }

    // String recite() {
    //     StringBuilder str = new StringBuilder();

    //     for (int i = 0; i < words.length; i++) {
    //         if (words.length == i+1) {
    //             str.append("And all for the want of a " + words[0] + ".");
    //             break;
    //         }
            
    //         str.append("For want of a " + words[i] + " the " + words[i+1] + " was lost.\n");
    //     }

    //     return str.toString();
    // }

}

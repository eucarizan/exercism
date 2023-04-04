class ResistorColor {
    String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

    int colorCode(String color) {
        int i = 0;
        for (;i < colors.length; i++) {
            if (colors[i].equals(color)) {
                break;
            }
        }

        return i;
    }

    String[] colors() {
        return colors;
    }
}

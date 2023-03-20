class RotationalCipher {
    int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        StringBuilder str = new StringBuilder();

        for (char ch : data.toCharArray()) {

            if (ch <= 122 && ch >= 97) {
                str.append((char)('a' + (ch - 'a' + shiftKey) % 26));
            } else if (ch <= 90 && ch >= 65) {
                str.append((char)('A' + (ch - 'A' + shiftKey) % 26));
            } else {
                str.append(ch);
            }
        }

        return str.toString();
    }
}

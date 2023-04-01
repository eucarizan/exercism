class Darts {
    int score(double xOfDart, double yOfDart) {
        double y = Math.abs(yOfDart);
        double x = Math.abs(xOfDart);
        double hyp = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        if (hyp - 1 <= 0) {
            return 10;
        } else if (hyp - 5 <= 0) {
            return 5;
        } else if (hyp -10 <= 0) {
            return 1;
        }

        return 0;
    }
}

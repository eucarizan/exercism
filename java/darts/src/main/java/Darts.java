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
/*
class Darts {

    int score(double x, double y) {
        var radius = (Math.sqrt((x * x) + (y * y)));
        
        if (radius > 10)
            return 0;
        if (radius > 5)
            return 1;
        if (radius > 1)
            return 5;
        return 10;
    }
}
 */
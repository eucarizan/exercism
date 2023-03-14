public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        double multiplier = 1;

        switch (speed) {
            case 5:
            case 6:
            case 7:
            case 8:
                multiplier = .9;
                break;
            case 9:
                multiplier = .8;
                break;
            case 10:
                multiplier = .77;
                break;
        }

        return speed * multiplier * 221.0;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) productionRatePerHour(speed) / 60;
    }
}

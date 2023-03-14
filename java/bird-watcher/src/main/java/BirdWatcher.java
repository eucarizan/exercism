
class BirdWatcher {
    private final int[] birdsPerDay;
    private final int len;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
        this.len = birdsPerDay.length;
    }

    public int[] getLastWeek() {
        return birdsPerDay;
    }

    public int getToday() {
        return birdsPerDay[len - 1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[len - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        for (int bird : birdsPerDay) {
            if (bird == 0) {
                return true;
            }
        }

        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int totalBirds = 0;

        for (int i = 0; i < numberOfDays && i < len; i++) {
            totalBirds += birdsPerDay[i];
        }

        return totalBirds;
    }

    public int getBusyDays() {
        int busyDays = 0;

        for (int birds : birdsPerDay) {
            if (birds > 4) {
                busyDays++;
            }
        }

        return busyDays;
    }
}

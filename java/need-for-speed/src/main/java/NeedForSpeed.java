class NeedForSpeed {
    private int speed;
    private int battery;
    private int batteryDrain;
    private int distance;

    public NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.battery = 100;
        this.batteryDrain = batteryDrain;
        this.distance = 0;
    }

    public boolean batteryDrained() {
        return this.battery == 0;
    }

    public int distanceDriven() {
        return this.distance;
    }

    public void drive() {
        if (this.battery>0) {
            this.distance+=this.speed;
            this.battery-=this.batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {

    private int distance;

    public RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean tryFinishTrack(NeedForSpeed car) {
        while (this.distance>0) {
            car.drive();
            this.distance-=car.distanceDriven();
        }

        return this.distance==0;
    }
}

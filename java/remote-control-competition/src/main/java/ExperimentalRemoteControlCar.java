public class ExperimentalRemoteControlCar implements RemoteControlCar {
    private int speed = 20;
    private int distanceTraveled = 0;

    public void drive() {
        this.distanceTraveled+=this.speed;
    }

    public int getDistanceTravelled() {
        return this.distanceTraveled;
    }
}

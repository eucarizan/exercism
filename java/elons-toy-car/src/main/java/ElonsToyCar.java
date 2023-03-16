import static java.lang.String.format;

public class ElonsToyCar {
    private int distance = 0;
    private int battery = 100;

    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return format("Driven %d meters", this.distance);
    }

    public String batteryDisplay() {
        return this.battery > 0 ? format("Battery at %s%%", this.battery) : format("Battery empty");
    }

    public void drive() {
        if (this.battery>0) {
            this.battery--;
            this.distance+=20;
        }
    }
}

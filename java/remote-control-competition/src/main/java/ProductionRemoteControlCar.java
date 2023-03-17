class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    private int speed = 10;
    private int victories = 0;
    private int distanceTraveled = 0;

    public ProductionRemoteControlCar() {
    }

    public void drive() {
        this.distanceTraveled+= this.speed;
    }

    public int getDistanceTravelled() {
        return this.distanceTraveled;
    }

    public int getNumberOfVictories() {
        return this.victories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.victories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar o) {
        return getNumberOfVictories() - o.getNumberOfVictories();
    }
}

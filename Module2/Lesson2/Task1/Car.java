public class Car {
    private String name;
    private Engine engine;
    private Climate climate;
    private int speed; //км в час
    private GasTank gasTank;
    private int maxSpeed = 100;
    private double sessionMileage;
    private double sessionConsumeFuel;

    public Car(String name, double capacity){
        this.name = name;
        engine = new Engine(capacity);
        gasTank = new GasTank();
        climate = new Climate();
    }

    public Car(String name, double capacity, int mileage) {
        this.name = name;
        engine = new Engine(capacity, mileage);
        climate = new Climate();
        gasTank = new GasTank();
    }

    public double getSessionConsumeFuel() {
        return sessionConsumeFuel;
    }

    public double getSessionMileage() {
        return sessionMileage;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public double getMileage(){
        return engine.getMileage();
    }

    public void turnOn(){
        engine.turnOn();
        climate.turnOn();
        climate.setTemperature(21);
    }

    public void turnOff(){
        engine.turnOff();
        climate.turnOff();
        reset();
    }

    public void addGas(){
        if (engine.isStarted()) {
            speed += 10;
            isReachedMaxSpeed();
        }
    }

    public boolean isFuel(){
        if (!(gasTank.getFuel() <= 0)){
            return true;
        }
        return false;
    }

    public void isReachedMaxSpeed(){
        if (speed >= maxSpeed){
            speed = maxSpeed;
            System.out.println("Максимальная скорость!");
        }
    }

    public double getFuel(){
        return gasTank.getFuel();
    }

    public void addFuel(int fuel){
        gasTank.addFuel(fuel);
    }

    public void reset(){
        sessionMileage = 0;
        sessionConsumeFuel = 0;
    }

    public void changes(){
        engine.setConsumption(speed);
        gasTank.consumeFuel(engine.getConsumption(), speed);
        engine.addMileage(speed / 60);
        sessionConsumeFuel += Math.abs((engine.getConsumption() / 100) * (double)(speed / 60));
        sessionMileage += (double)speed / 60;
    }


}

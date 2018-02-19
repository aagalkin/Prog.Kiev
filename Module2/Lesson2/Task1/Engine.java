public class Engine {
    private double capacity;
    private double mileage;
    private boolean started;
    private double consumption;//расход на 100км

    public Engine(double capacity){
        mileage = 0;
        this.capacity = capacity;
    }

    public Engine(double capacity, int mileage){
        this.capacity = capacity;
        this.mileage = mileage;
    }

    public void setConsumption(int speed) {
        this.consumption = speed * (getCapacity() / 20);//Придуманный коэффициент расхода топлива.
    }

    public double getConsumption() {
        return consumption;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getMileage() {
        return mileage;
    }

    public void turnOn(){
        started = true;
    }

    public void turnOff(){
        started = false;
    }

    public void addMileage(double mileage){
        if (started){
            this.mileage += mileage;
        }
    }

    public boolean isStarted(){
        return started;
    }




}

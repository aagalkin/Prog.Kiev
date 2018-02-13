package com.company;

public class Main {

    private static final String NAME = "BMW";
    private static final double CAPACITY = 4.0;
    private static final Car bmw = new Car(NAME, CAPACITY);

    private static int min;

    public static void main(String[] args) {
        Car bmw = new Car("BMW", 4.0);


        bmw.turnOn();


        while (true){
            if(bmw.isFuel()) {
                bmw.addGas();

                try {
                    Thread.sleep(1000);
                }
                catch (Exception e){

                }

                min += 1;
                bmw.changes();
                System.out.println("Вы проехали " + bmw.getSessionMileage() + " за " + min + " минут");
            }
            else {
                System.out.println("Бензин закончился");
                System.out.println("Вы проехали " + bmw.getSessionMileage() + " за " + min + " минут. \n" +
                        " Потрачено " + bmw.getSessionConsumeFuel() + " топлива. \n" +
                        "Топливо в баке было: " + (bmw.getFuel() + bmw.getSessionConsumeFuel()) + ", \n" +
                        " осталось: " + bmw.getFuel() +
                        " Был пробег: " + bmw.getMileage() + ", \n" +
                        " стал: " + (bmw.getMileage() + bmw.getSessionMileage()));
                bmw.turnOff();
                break;
            }
        }

    }
}

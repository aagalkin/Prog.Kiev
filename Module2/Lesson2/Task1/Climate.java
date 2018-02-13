package com.company;

public class Climate {
    private boolean on;
    private int temperature;

    public void turnOn(){
        on = true;
    }

    public void turnOff(){
        on = false;
        setTemperature(0);
    }

    public boolean isOn(){
        return on;
    }

    public int getTemperature(){
        return temperature;
    }

    public void setTemperature(int temperature){
        if (isOn()) {
            this.temperature = temperature;
        }
    }
}

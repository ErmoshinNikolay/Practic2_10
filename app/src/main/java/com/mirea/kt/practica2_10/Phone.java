package com.mirea.kt.practica2_10;

public class Phone {
    private String model;
    private String serial_number;
    private int price;

    public Phone(String model, String serial_number, int price) {
        this.model = model;
        this.serial_number = serial_number;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

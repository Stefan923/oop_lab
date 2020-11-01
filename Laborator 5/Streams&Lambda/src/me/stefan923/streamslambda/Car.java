package me.stefan923.streamslambda;

public class Car implements Comparable<Car> {

    private String brand;
    private int year;
    private String colour;
    private double price;

    public Car(String brand, int year, String colour, double price) {
        this.brand = brand;
        this.year = year;
        this.colour = colour;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public int compareTo(Car o) {
        if (price > o.price)
            return -1;
        else if (price == o.price)
            return 0;
        return 1;
    }
}

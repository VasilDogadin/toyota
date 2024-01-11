package ru.toyota.deals;

import ru.toyota.cars.Car;

public class Buyer {
    private final String name;
    private float budget;
    private Car car;

    public Buyer(String name, float budget) {
        this.name = name;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public float getBudget() {
        return budget;
    }

    public Car getCar() {
        return car;
    }

    public void buyCar(Car car) {
        this.car = car;
        if (car != null) {
            budget -= car.getPriceInDollars();
        }
    }
}

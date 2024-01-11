package ru.toyota.deals;

import ru.toyota.cars.Car;

public class Cashier {

    private int totalIncome;

    public int getTotalIncome() {
        return totalIncome;
    }

    public void acceptCar(Car car) {
        if (car != null) {
            totalIncome += car.getPriceInDollars();
        }
    }
}

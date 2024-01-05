package ru.toyota.cars;

import ru.toyota.cars.parts.CarPart;

@SuppressWarnings("SpellCheckingInspection")
public final class HiaceCar extends FreightCar {

    public static final int WHEEL_DIAMETER = 20;

    @Override
    public String getName() {
        return "Hiace";
    }

    public HiaceCar(CarColor color, CarGearbox gearbox, int topSpeed, int priceInCents, int loadCapacity, CarPart[] parts) {
        super(color, gearbox, topSpeed, priceInCents, loadCapacity, parts);
    }
}

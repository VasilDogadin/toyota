package ru.toyota.cars;

import ru.toyota.cars.parts.CarPart;

public abstract class FreightCar extends Car {

    private final int loadCapacity;

    protected FreightCar(CarColor color, CarGearbox gearbox, int topSpeed, int priceInCents, int loadCapacity, CarPart[] parts) {
        super(color, gearbox, topSpeed, priceInCents, parts);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    @SuppressWarnings("StringBufferReplaceableByString")
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Грузовой: ");
        sb.append(super.toString());
        sb.append("\n");

        sb.append("Грузоподъемность (кг): ");
        sb.append(getLoadCapacity());

        return sb.toString();
    }
}

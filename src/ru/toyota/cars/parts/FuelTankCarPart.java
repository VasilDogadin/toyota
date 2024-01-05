package ru.toyota.cars.parts;

import ru.toyota.cars.Country;

public class FuelTankCarPart extends CarPart {

    private int fuel = 0;

    @Override
    public String getName() {
        return "Топливный бак";
    }

    FuelTankCarPart(Country country) {
        super(country);
    }

    public boolean isEmpty() {
        return fuel <= 0;
    }

    public int getFuelAmount() {
        return fuel;
    }

    public void fillUp(int amount) {
        if (isBroken())
            System.err.println("Бензобак поврежден");
        else {
            this.fuel = amount;
            System.out.println("Машина заправлена");
        }
    }

    @Override
    @SuppressWarnings("StringBufferReplaceableByString")
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(" (");
        sb.append(isBroken() ? "поврежден" : "не поврежден");
        sb.append(", ");
        sb.append(isEmpty() ? "пустой" : ("топливо (л): " + getFuelAmount()));
        sb.append(", производство ");
        sb.append(getCountry());
        sb.append(")");

        return sb.toString();
    }
}

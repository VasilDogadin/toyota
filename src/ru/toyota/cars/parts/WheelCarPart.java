package ru.toyota.cars.parts;

import ru.toyota.cars.Country;

public class WheelCarPart extends CarPart {

    private final int diameter;

    @Override
    public String getName() {
        return "Колесо";
    }

    public WheelCarPart(Country country, int diameter) {
        super(country);
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }

    @Override
    @SuppressWarnings("StringBufferReplaceableByString")
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(" (");
        sb.append(isBroken() ? "проколото" : "не проколото");
        sb.append(", ");
        sb.append("диаметр (дюйм): ");
        sb.append(getDiameter());
        sb.append(", производство ");
        sb.append(getCountry());
        sb.append(")");

        return sb.toString();
    }
}

package ru.toyota.cars.parts;

import ru.toyota.cars.Country;

/**
 * Базовый класс автозапчастей
 */
public abstract class CarPart {

    private final Country country;
    private boolean isBroken = false;

    protected CarPart(Country country) {
        this.country = country;
    }

    // Наименование запчасти
    public abstract String getName();

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    @SuppressWarnings("StringBufferReplaceableByString")
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(" (");
        sb.append(isBroken() ? "поврежден" : "не поврежден");
        sb.append(", производство ");
        sb.append(getCountry());
        sb.append(")");

        return sb.toString();
    }
}

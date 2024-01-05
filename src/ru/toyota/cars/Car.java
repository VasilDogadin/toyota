package ru.toyota.cars;

import ru.toyota.cars.exceptions.StartCarException;
import ru.toyota.cars.parts.CarPart;
import ru.toyota.cars.parts.ElectricalSystemCarPart;
import ru.toyota.cars.parts.FuelTankCarPart;
import ru.toyota.cars.parts.HeadlightCarPart;

public abstract class Car {

    private final CarColor color;
    private final int topSpeed;
    private final CarGearbox gearbox;
    private final CarPart[] parts;
    private final int priceInCents;
    private boolean isMoving;

    public abstract String getName();

    protected Car(CarColor color, CarGearbox gearbox, int topSpeed, int priceInCents, CarPart[] parts) {
        this.color = color;
        this.gearbox = gearbox;
        this.topSpeed = topSpeed;
        this.priceInCents = priceInCents;
        this.isMoving = false;
        this.parts = parts;
    }

    public CarColor getColor() {
        return color;
    }

    public CarGearbox getGearbox() {
        return gearbox;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public float getPriceInDollars() {
        return ((float) priceInCents) / 100.0f;
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    protected boolean isElectricalBroken() {
        for (CarPart part : parts)
            if (part instanceof ElectricalSystemCarPart)
                return part.isBroken();
        throw new RuntimeException("В машине отсутствует электрическая система");
    }

    protected CarPart[] getParts() {
        return parts;
    }

    public void fillUp(int amount) {
        for (CarPart part : parts)
            if (part instanceof FuelTankCarPart) {
                ((FuelTankCarPart) part).fillUp(amount);
                return;
            }
        throw new RuntimeException("В машине отсутствует топливный бак");
    }

    public void move() throws StartCarException {
        if (isMoving) {
            System.err.println("Машина уже едет");
            return;
        }

        for (CarPart part : parts)
            if (part.isBroken() || (part instanceof FuelTankCarPart) && ((FuelTankCarPart) part).isEmpty())
                throw new StartCarException("Невозможно начать движение: " + part);

        isMoving = true;
        System.out.println("Начато движение");
    }

    public void stop() {
        isMoving = false;
        System.out.println("Движение остановлено");
    }

    public void turnOnHeadlights() {
        if (isElectricalBroken())
            System.err.println("Невозможно включить фары: электрика повреждена");
        else for (CarPart part : parts)
            if (part instanceof HeadlightCarPart)
                ((HeadlightCarPart) part).setOn();
    }

    public void turnOffHeadlights() {
        for (CarPart part : parts)
            if (part instanceof HeadlightCarPart)
                ((HeadlightCarPart) part).setOff();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Toyota ");
        sb.append(getName());
        sb.append(" (");
        sb.append(isMoving() ? "движется" : "не движется");
        sb.append(")\n");

        sb.append("Цвет: ");
        sb.append(getColor());
        sb.append("\n");

        sb.append("КПП: ");
        sb.append(getGearbox());
        sb.append("\n");

        sb.append("Максимальная скорость (км/ч): ");
        sb.append(getTopSpeed());

        for (CarPart part : parts) sb.append("\n").append(part);
        return sb.toString();
    }
}

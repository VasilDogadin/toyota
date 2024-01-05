package ru.toyota.cars;

import ru.toyota.cars.parts.CarPart;
import ru.toyota.cars.parts.CruiseControlCarPart;

public abstract class PassengerCar extends Car {

    protected PassengerCar(CarColor color, CarGearbox gearbox, int topSpeed, int priceInCents, CarPart[] parts) {
        super(color, gearbox, topSpeed, priceInCents, parts);
    }

    public void turnOnCruiseControl() {
        for (CarPart part : getParts())
            if (part instanceof CruiseControlCarPart) {
                ((CruiseControlCarPart) part).setOn();
                return;
            }
        throw new RuntimeException("В машине отсутствует круиз-контроль");
    }

    public void turnOffCruiseControl() {
        for (CarPart part : getParts())
            if (part instanceof CruiseControlCarPart) {
                ((CruiseControlCarPart) part).setOff();
                break;
            }
    }

    @Override
    @SuppressWarnings("StringBufferReplaceableByString")
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Легковой: ");
        sb.append(super.toString());

        return sb.toString();
    }
}

package ru.toyota.cars;

import ru.toyota.cars.parts.CarPart;
import ru.toyota.cars.parts.ElectricalOutletCarPart;

public final class DynaCar extends FreightCar {

    public static final int WHEEL_DIAMETER = 20;

    @Override
    public String getName() {
        return "Dyna";
    }

    DynaCar(CarColor color, CarGearbox gearbox, int topSpeed, int priceInCents, int loadCapacity, CarPart[] parts) {
        super(color, gearbox, topSpeed, priceInCents, loadCapacity, parts);
    }

    public void chargePhone() {
        if (isElectricalBroken())
            System.err.println("Невозможно зарядить телефон: электрика повреждена");
        else for (CarPart part : getParts())
            if (part instanceof ElectricalOutletCarPart) {
                if (part.isBroken())
                    System.err.println("Невозможно зарядить телефон: " + part);
                else
                    System.out.println("Телефон заряжен");
                return;
            }
        throw new RuntimeException("В машине отсутствует розетка");
    }
}

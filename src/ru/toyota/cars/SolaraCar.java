package ru.toyota.cars;

import ru.toyota.cars.parts.CarPart;
import ru.toyota.cars.parts.ConvertibleRoofCarPart;
import ru.toyota.cars.parts.FridgeCarPart;

@SuppressWarnings("SpellCheckingInspection")
public final class SolaraCar extends PassengerCar {

    public static final int WHEEL_DIAMETER = 16;

    @Override
    public String getName() {
        return "Solara";
    }

    SolaraCar(CarColor color, CarGearbox gearbox, int topSpeed, int priceInCents, CarPart[] parts) {
        super(color, gearbox, topSpeed, priceInCents, parts);
    }

    public void openRoof() {
        for (CarPart part : getParts())
            if (part instanceof ConvertibleRoofCarPart) {
                ((ConvertibleRoofCarPart) part).setOn();
                return;
            }
        throw new RuntimeException("В машине отстутствует складная крыша");
    }

    public void closeRoof() {
        for (CarPart part : getParts())
            if (part instanceof ConvertibleRoofCarPart) {
                ((ConvertibleRoofCarPart) part).setOff();
                break;
            }
    }

    public void coolDrink() {
        for (CarPart part : getParts())
            if (part instanceof FridgeCarPart) {
                if (part.isBroken())
                    System.err.println("Невозможно охладить напиток: " + part);
                else
                    System.out.println("Напиток охлажден");
                break;
            }
    }
}

package ru.toyota.cars.parts;

import ru.toyota.cars.Country;

public final class CarPartFactory {

    private final Country country;

    public CarPartFactory(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public CarPart[] getBaseParts(int wheelDiameter) {
        return new CarPart[]{
                new EngineCarPart(country), // двигатель
                new ElectricalSystemCarPart(country), // электрическая система
                new FuelTankCarPart(country), // топливный бак
                new HeadlightCarPart(country), // левая фара
                new HeadlightCarPart(country), // правая фара
                new WheelCarPart(country, wheelDiameter), // переднее левое колесо
                new WheelCarPart(country, wheelDiameter), // переднее правое колесо
                new WheelCarPart(country, wheelDiameter), // заднее левое колесо
                new WheelCarPart(country, wheelDiameter), // заднее правое колесо
        };
    }

    public static CarPart[] getParts(CarPart[] parts, CarPart... other) {

        if (parts == null)
            return other;

        if (other == null)
            return parts;

        CarPart[] res = new CarPart[parts.length + other.length];

        System.arraycopy(parts, 0, res, 0, parts.length);
        System.arraycopy(other, 0, res, parts.length, other.length);

        return res;
    }

    public CarPart getConvertibleRoof() {
        return new ConvertibleRoofCarPart(country);
    }

    public CarPart getCruiseControl() {
        return new CruiseControlCarPart(country);
    }

    public CarPart getElectricalOutlet() {
        return new ElectricalOutletCarPart(country);
    }

    public CarPart getEngine() {
        return new EngineCarPart(country);
    }

    public CarPart getFridge() {
        return new FridgeCarPart(country);
    }

    public CarPart getFuelTank() {
        return new FuelTankCarPart(country);
    }

    public CarPart getHeadlight() {
        return new HeadlightCarPart(country);
    }

    public CarPart getUsb() {
        return new UsbCarPart(country);
    }

    public CarPart getWheel(int diameter) {
        return new WheelCarPart(country, diameter);
    }
}

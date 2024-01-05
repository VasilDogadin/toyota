package ru.toyota.cars.parts;

import ru.toyota.cars.Country;

public class UsbCarPart extends CarPart {

    @Override
    public String getName() {
        return "Usb";
    }

    UsbCarPart(Country country) {
        super(country);
    }
}

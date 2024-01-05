package ru.toyota.cars.parts;

import ru.toyota.cars.Country;

public final class FridgeCarPart extends CarPart {

    @Override
    public String getName() {
        return "Авто-холодильник";
    }

    FridgeCarPart(Country country) {
        super(country);
    }
}

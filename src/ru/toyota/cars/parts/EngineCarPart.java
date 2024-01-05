package ru.toyota.cars.parts;

import ru.toyota.cars.Country;

public class EngineCarPart extends OnOffCarPart {

    @Override
    public String getName() {
        return "Двигатель";
    }

    EngineCarPart(Country country) {
        super(country);
    }
}

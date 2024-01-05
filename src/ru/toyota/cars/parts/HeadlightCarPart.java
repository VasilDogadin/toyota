package ru.toyota.cars.parts;

import ru.toyota.cars.Country;

public class HeadlightCarPart extends OnOffCarPart {

    @Override
    public String getName() {
        return "Фара";
    }

    HeadlightCarPart(Country country) {
        super(country);
    }
}

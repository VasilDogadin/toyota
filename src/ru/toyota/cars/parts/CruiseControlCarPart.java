package ru.toyota.cars.parts;

import ru.toyota.cars.Country;

public class CruiseControlCarPart extends OnOffCarPart {

    @Override
    public String getName() {
        return "Круиз-контроль";
    }

    CruiseControlCarPart(Country country) {
        super(country);
    }
}

package ru.toyota.cars.parts;

import ru.toyota.cars.Country;

public class ConvertibleRoofCarPart extends OnOffCarPart {

    @Override
    public String getName() {
        return "Складная крыша";
    }

     ConvertibleRoofCarPart(Country country) {
        super(country);
    }
}

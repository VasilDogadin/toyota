package ru.toyota.cars.parts;

import ru.toyota.cars.Country;

public class ElectricalSystemCarPart extends CarPart {

    @Override
    public String getName() {
        return "Электрическая система";
    }

    ElectricalSystemCarPart(Country country) {
        super(country);
    }
}

package ru.toyota.cars.parts;

import ru.toyota.cars.Country;

public class ElectricalOutletCarPart extends CarPart {

    @Override
    public String getName() {
        return "Электрическая розетка";
    }

    ElectricalOutletCarPart(Country country) {
        super(country);
    }
}

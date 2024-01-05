package ru.toyota.cars;

import ru.toyota.cars.exceptions.CountryFactoryNotEqualException;
import ru.toyota.cars.parts.CarPartFactory;

public final class CountryFactory {

    private CarPartFactory partFactory;
    private final Country country;

    public CountryFactory(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public CarPartFactory getPartFactory() {
        return partFactory;
    }

    public void setPartFactory(CarPartFactory partFactory) throws CountryFactoryNotEqualException {
        if (country == partFactory.getCountry())
            this.partFactory = partFactory;
        else
            throw new CountryFactoryNotEqualException();
    }

    public CamryCar createCamry(CarColor color, float priceInDollars) {

        if (partFactory == null)
            throw new RuntimeException("Не задана фабрика деталей");

        return new CamryCar(color, CarGearbox.AUTO, 200, (int) (priceInDollars * 100.f), CarPartFactory.getParts(

                partFactory.getBaseParts(CamryCar.WHEEL_DIAMETER),

                partFactory.getCruiseControl(),

                partFactory.getUsb()
        ));
    }

    @SuppressWarnings("SpellCheckingInspection")
    public SolaraCar createSolara(CarColor color, float priceInDollars) {

        if (partFactory == null)
            throw new RuntimeException("Не задана фабрика деталей");

        return new SolaraCar(color, CarGearbox.ROBOT, 250, (int) (priceInDollars * 100.f), CarPartFactory.getParts(

                partFactory.getBaseParts(SolaraCar.WHEEL_DIAMETER),

                partFactory.getCruiseControl(),

                partFactory.getConvertibleRoof(),

                partFactory.getFridge()
        ));
    }

    @SuppressWarnings("SpellCheckingInspection")
    public HiaceCar createHiace(CarColor color, float priceInDollars) {

        if (partFactory == null)
            throw new RuntimeException("Не задана фабрика деталей");

        return new HiaceCar(color, CarGearbox.MANUAL, 150, (int) (priceInDollars * 100.f), 1_500, CarPartFactory.getParts(

                partFactory.getBaseParts(HiaceCar.WHEEL_DIAMETER),

                partFactory.getWheel(HiaceCar.WHEEL_DIAMETER)
        ));
    }

    public DynaCar createDyna(CarColor color, float priceInDollars) {

        if (partFactory == null)
            throw new RuntimeException("Не задана фабрика деталей");

        return new DynaCar(color, CarGearbox.MANUAL, 120, (int) (priceInDollars * 100.f), 4_000, CarPartFactory.getParts(

                partFactory.getBaseParts(DynaCar.WHEEL_DIAMETER),

                partFactory.getElectricalOutlet()
        ));
    }
}



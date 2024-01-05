package ru.toyota;

import ru.toyota.cars.*;
import ru.toyota.cars.exceptions.CountryFactoryNotEqualException;
import ru.toyota.cars.exceptions.StartCarException;
import ru.toyota.cars.parts.CarPartFactory;

@SuppressWarnings("SpellCheckingInspection")
public final class Runner {

    public static void main(String... args) throws Exception {

        task1();
        task2();
    }

    static void task1() throws StartCarException, CountryFactoryNotEqualException {

        CarPartFactory partFactory = new CarPartFactory(Country.Japan);
        CountryFactory countryFactory = new CountryFactory(Country.Japan);
        countryFactory.setPartFactory(partFactory);

        // Camry
        CamryCar camry = countryFactory.createCamry(CarColor.SUPER_WHITE, 10_000.00f);

        System.out.println();
        System.out.println("*** Camry ***");

        camry.fillUp(50);
        camry.turnOffHeadlights();
        camry.turnOnCruiseControl();
        camry.move();
        camry.musicOn();

        print(camry);

        // Solara
        SolaraCar solara = countryFactory.createSolara(CarColor.BLUE_FLAME, 12_000.00f);

        System.out.println();
        System.out.println("*** Solara ***");

        solara.fillUp(55);
        solara.turnOffHeadlights();
        solara.turnOnCruiseControl();
        solara.openRoof();
        solara.coolDrink();
        solara.move();

        print(solara);

        // Hiace
        HiaceCar hiace = countryFactory.createHiace(CarColor.RUBY_FLARE_PEARL, 15_000.00f);

        System.out.println();
        System.out.println("*** Hiace ***");

        hiace.fillUp(55);
        hiace.turnOffHeadlights();
        hiace.move();

        print(hiace);

        // Dyna
        DynaCar dyna = countryFactory.createDyna(CarColor.SUPER_WHITE, 22_000.00f);

        System.out.println();
        System.out.println("*** Dyna ***");

        dyna.fillUp(55);
        dyna.turnOffHeadlights();
        dyna.chargePhone();
        dyna.move();

        print(dyna);
    }

    static void task2() throws CountryFactoryNotEqualException {

        CarPartFactory partFactory = new CarPartFactory(Country.Japan);
        CountryFactory countryFactory = new CountryFactory(Country.Japan);
        countryFactory.setPartFactory(partFactory);

        Car[] cars = new Car[]{
                countryFactory.createCamry(CarColor.SUPER_WHITE, 10_000.00f),
                countryFactory.createSolara(CarColor.BLUE_FLAME, 12_000.00f),
                countryFactory.createHiace(CarColor.RUBY_FLARE_PEARL, 15_000.00f),
                countryFactory.createDyna(CarColor.SUPER_WHITE, 22_000.00f),
        };

        print(cars);
    }

    static void print(Car... cars) {

        int i = 0;
        for (Car car : cars) {
            System.out.println();
            System.out.println("*** " + (cars.length > 1 ? "[" + ++i + "] " : "") + car.getName() + " ***");
            System.out.println(car);
        }
    }
}

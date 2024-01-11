package ru.toyota.cars;

import java.lang.reflect.Array;

@SuppressWarnings("SpellCheckingInspection")
public final class CarWarehouse {

    public final static int CAPACITY_OF_CAMRY = 1000;
    public final static int CAPACITY_OF_SOLARA = 1000;
    public final static int CAPACITY_OF_HIACE = 1000;
    public final static int CAPACITY_OF_DYNA = 1000;

    private final CarGroup<CamryCar> camryGroup = new CarGroup<>(CamryCar.class, CAPACITY_OF_CAMRY);
    private final CarGroup<SolaraCar> solaraGroup = new CarGroup<>(SolaraCar.class, CAPACITY_OF_SOLARA);
    private final CarGroup<HiaceCar> heiceGroup = new CarGroup<>(HiaceCar.class, CAPACITY_OF_HIACE);
    private final CarGroup<DynaCar> dynaGroup = new CarGroup<>(DynaCar.class, CAPACITY_OF_DYNA);

    public void addCar(CamryCar... cars) {
        camryGroup.addCar(cars);
    }

    public void addCar(SolaraCar... cars) {
        solaraGroup.addCar(cars);
    }

    public void addCar(HiaceCar... cars) {
        heiceGroup.addCar(cars);
    }

    public void addCar(DynaCar... cars) {
        dynaGroup.addCar(cars);
    }

    public CamryCar getCamryCar() {
        return camryGroup.getCar();
    }

    public SolaraCar getSolaraCar() {
        return solaraGroup.getCar();
    }

    public HiaceCar getHiaceCar() {
        return heiceGroup.getCar();
    }

    public DynaCar getDynaCar() {
        return dynaGroup.getCar();
    }

    public int getCamryAmount() {
        return camryGroup.getAmount();
    }

    public int getSolaraAmount() {
        return solaraGroup.getAmount();
    }

    public int getHiaceAmount() {
        return heiceGroup.getAmount();
    }

    public int getDynaAmount() {
        return dynaGroup.getAmount();
    }


    private static class CarGroup<T extends Car> {

        final int capacity;
        final T[] cars;

        @SuppressWarnings("unchecked")
        CarGroup(Class<T> carClass, int capacity) {
            this.capacity = capacity;
            this.cars = (T[]) Array.newInstance(carClass, capacity);
        }

        int amount = 0;

        int getAmount() {
            return amount;
        }

        T getCar() {
            if (amount < 1)
                throw new RuntimeException("Машин не осталось на складе");
            else {
                T car = cars[--amount];
                cars[amount] = null;
                return car;
            }
        }

        @SafeVarargs
        final void addCar(T... cars) {
            if (cars == null)
                throw new RuntimeException("Машина(ы) не добавлена(ы): передан пустой список");
            else if ((amount + cars.length) < capacity)
                for (T car : cars)
                    cars[amount++] = car;
            else
                throw new RuntimeException("Машина(ы) не добавлена(ы): склад переполнен");
        }
    }

    @Override
    @SuppressWarnings("StringBufferReplaceableByString")
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("*** Склад ***");

        sb.append(String.format("%nCamry  %5d из %5d", getCamryAmount(), CAPACITY_OF_CAMRY));
        sb.append(String.format("%nSolara %5d из %5d", getSolaraAmount(), CAPACITY_OF_SOLARA));
        sb.append(String.format("%nHiace  %5d из %5d", getHiaceAmount(), CAPACITY_OF_HIACE));
        sb.append(String.format("%nDyna   %5d из %5d", getDynaAmount(), CAPACITY_OF_DYNA));

        return sb.toString();
    }
}

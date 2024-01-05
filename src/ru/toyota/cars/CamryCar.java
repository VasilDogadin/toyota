package ru.toyota.cars;

import ru.toyota.cars.parts.CarPart;
import ru.toyota.cars.parts.UsbCarPart;

public final class CamryCar extends PassengerCar {

    public static final int WHEEL_DIAMETER = 17;

    private boolean musicOn = false;

    @Override
    public String getName() {
        return "Camry";
    }

    CamryCar(CarColor color, CarGearbox gearbox, int topSpeed, int priceInCents, CarPart[] parts) {
        super(color, gearbox, topSpeed, priceInCents, parts);
    }

    public boolean isMusicOn() {
        return musicOn;
    }

    public void musicOn() {
        if (isElectricalBroken())
            System.err.println("Невозможно включить музыку: электрика повреждена");
        else for (CarPart part : getParts())
            if (part instanceof UsbCarPart) {
                musicOn = true;
                System.out.println("Музыка включена");
                return;
            }
        throw new RuntimeException("В машине отсутствует USB");
    }

    public void musicOff() {
        musicOn = false;
        System.out.println("Музыка выключена");
    }

    @Override
    @SuppressWarnings("StringBufferReplaceableByString")
    public String toString() {

        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n");
        sb.append("Музыка: ");
        sb.append(isMusicOn() ? "включена" : "выключена");

        return sb.toString();
    }
}

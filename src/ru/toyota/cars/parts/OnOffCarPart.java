package ru.toyota.cars.parts;

import ru.toyota.cars.Country;

public abstract class OnOffCarPart extends CarPart {

    private boolean isOn = false;

    protected OnOffCarPart(Country country) {
        super(country);
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOff() {
        isOn = false;
    }

    public void setOn() {
        if (isBroken())
            System.err.println(getName() + " не работает/повреждена");
        else {
            isOn = true;
            System.out.println(getName() + " включен(а)");
        }
    }

    @Override
    public void setBroken(boolean broken) {
        if (broken) isOn = false;
        super.setBroken(broken);
    }

    @Override
    @SuppressWarnings("StringBufferReplaceableByString")
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(" (");
        sb.append(isBroken() ? "поврежден" : "не поврежден");
        sb.append(", ");
        sb.append(isOn() ? "вкл." : "выкл.");
        sb.append(", производство ");
        sb.append(getCountry());
        sb.append(")");

        return sb.toString();
    }
}

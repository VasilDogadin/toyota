package ru.toyota.cars;

public enum CarGearbox {

    MANUAL("механика"),
    AUTO("автомат"),
    ROBOT("робот");

    private final String desc;

    CarGearbox(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}

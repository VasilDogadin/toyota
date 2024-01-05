package ru.toyota.cars;

/**
 * Цвета автомобилей марки Toyota
 */
@SuppressWarnings("SpellCheckingInspection")
public enum CarColor {

    CLASSIC_SILVER_METALLIC("Classic Silver Metallic"),
    BARCELONA_RED_METALLIC("Barcelona Red Metallic"),
    SUPER_WHITE("Super White"),
    BLUE_CRUSH_METALLIC("Blue Crush Metallic"),
    LUNAR_ROCK("Lunar Rock"),
    MIDNIGHT_BLACK_METALLIC("Midnight Black Metallic"),
    WIND_CHILL_PEARL("Wind Chill Pearl"),
    BLACK_SAND_PEARL("Black Sand Pearl"),
    BLIZZARD_PEARL("Blizzard Pearl"),
    BLUEPRINT("Blueprint"),
    CHAMPAGNE_MICA_METALLIC("Champagne Mica Metallic"),
    MAGNETIC_GRAY_METALLIC("Magnetic Gray Metallic"),
    PEARL_WHITE("Pearl White"),
    RUBY_FLARE_PEARL("Ruby Flare Pearl"),
    BLUE_FLAME("Blue Flame"),
    BLUEPRINT_WITH_MIDNIGHT_BLACK_METALLIC_ROOF("Blueprint With Midnight Black Metallic Roof"),
    CELESTITE_GRAY_METALLIC("Celestite Gray Metallic");

    private final String desc;

    CarColor(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}

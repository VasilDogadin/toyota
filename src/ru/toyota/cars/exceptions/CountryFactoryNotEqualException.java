package ru.toyota.cars.exceptions;

public final class CountryFactoryNotEqualException extends Exception {

    public CountryFactoryNotEqualException() {
        super("Страна расположения сборочного конвеера отличается от страны производства деталей");
    }
}

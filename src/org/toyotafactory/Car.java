package org.toyotafactory;

import org.toyotafactory.сomponents.*;

import java.util.List;

public abstract class Car {
    private String color;
    private int maxSpeed;
    private String transmissionType;
    private boolean isMoving;
    private List<Wheel> wheels;
    private FuelTank fuelTank;
    private Engine engine;
    private ElectricalSystem electricalSystem;
    private Lights lights;
    private double price;

}

package com.github.durakin.infsystems.lab1;

import java.util.Objects;

public class Steamboat extends Vessel {

    private final String fuelType;
    private final int fuelConsumption;

    public Steamboat() {
        super();
        this.fuelType = "Unknown";
        this.fuelConsumption = 0;
    }

    public Steamboat(String name, int tonnage, String fuelType, int fuelConsumption) {
        super(name, tonnage);
        this.fuelType = fuelType;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        if (!super.equals(otherObject)) return false;

        Steamboat steamboat = (Steamboat) otherObject;

        if (fuelConsumption != steamboat.fuelConsumption) return false;
        return Objects.equals(fuelType, steamboat.fuelType);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (fuelType != null ? fuelType.hashCode() : 0);
        result = 31 * result + fuelConsumption;
        return result;
    }

    @Override
    public String toString() {

        return super.toString() + "\nType: Steamboat; Fuel type: " + fuelType + "; Fuel consumption: " +
                fuelConsumption + ';';

    }
}

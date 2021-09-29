package com.github.durakin.infsystems.lab1;

import java.util.Objects;

public class Sailboat extends Vessel {
    private final String sailsPlan;
    private final int gunsInstalled;

    public Sailboat() {
        super();
        this.sailsPlan = "Unknown";
        this.gunsInstalled = 0;
    }

    public Sailboat(String name, int tonnage, String sailsPlan, int gunsInstalled) {
        super(name, tonnage);
        this.sailsPlan = sailsPlan;
        this.gunsInstalled = gunsInstalled;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        if (!super.equals(otherObject)) return false;

        Sailboat sailboat = (Sailboat) otherObject;

        if (gunsInstalled != sailboat.gunsInstalled) return false;
        return Objects.equals(sailsPlan, sailboat.sailsPlan);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (sailsPlan != null ? sailsPlan.hashCode() : 0);
        result = 31 * result + gunsInstalled;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: Sailboat; sails plan: " + sailsPlan + "; Guns installed: " + gunsInstalled +
                ';';
    }
}

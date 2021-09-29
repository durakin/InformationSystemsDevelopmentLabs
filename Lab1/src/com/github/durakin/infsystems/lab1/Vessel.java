package com.github.durakin.infsystems.lab1;

public abstract class Vessel {
    private final String name;
    private final int tonnage;

    public Vessel() {
        this("Unnamed vessel", 0);
    }

    public Vessel(String name, int tonnage) {
        this.name = name;
        this.tonnage = tonnage;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;

        Vessel vessel = (Vessel) otherObject;

        if (tonnage != vessel.tonnage) return false;
        return name.equals(vessel.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + tonnage;
        return result;
    }

    @Override
    public String toString() {
        return "Vessel " + name + "\nTonnage " + tonnage +
                't';
    }
}

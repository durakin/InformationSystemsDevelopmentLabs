package com.github.durakin.infsystems.lab1;

import java.util.Objects;

public class Corvette extends Vessel {
    private final String artillery;
    private final int speed;

    public Corvette() {
        super();
        this.artillery = "Unknown";
        this.speed = 0;
    }

    public Corvette(String name, int tonnage, String artillery, int speed) {
        super(name, tonnage);
        this.artillery = artillery;
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Corvette corvette = (Corvette) o;

        if (speed != corvette.speed) return false;
        return Objects.equals(artillery, corvette.artillery);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (artillery != null ? artillery.hashCode() : 0);
        result = 31 * result + speed;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: Corvette; Installed artillery: " + artillery + "; Maximal speed: " +
                speed + ';';
    }
}

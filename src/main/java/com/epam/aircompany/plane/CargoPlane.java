package com.epam.aircompany.plane;

import com.epam.aircompany.exeption.PlaneException;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Olga Lashkevich
 */
public class CargoPlane extends Airplane {

    private int carryingCapacity;

    public CargoPlane() {
    }

    public CargoPlane(String name, int range, int carryingCapacity) throws PlaneException {
        super(name, range);
        this.carryingCapacity = carryingCapacity;
    }

    @JsonIgnore
    public int getSeatingCapacity() {
        return 0;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public String toString() {
        return super.toString() + " Carring Capacity: " + carryingCapacity;
    }
}

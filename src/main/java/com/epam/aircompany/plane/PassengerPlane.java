package com.epam.aircompany.plane;

import com.epam.aircompany.exeption.CapacityException;
import com.epam.aircompany.exeption.NegativeRangeException;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Olga Lashkevich
 */
public class PassengerPlane extends Airplane {

    private int seatingCapacity;

    public PassengerPlane() {
    }

    public PassengerPlane(String name, int range, int seatingCapacity) throws NegativeRangeException, CapacityException {
        super(name, range);
        if (seatingCapacity < 1000) {
            this.seatingCapacity = seatingCapacity;
        } else {
            throw new CapacityException("Seating capacity is too large", seatingCapacity);
        }
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    @JsonIgnore
    public int getCarryingCapacity() {
        return 0;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String toString() {
        return super.toString() + " Seating Capacity: " + seatingCapacity;
    }
}

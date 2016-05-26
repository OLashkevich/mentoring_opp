package com.epam.aircompany.exeption;

/**
 * @author Olga Lashkevich
 */
public class CapacityException extends PlaneException {

    private int capacity;

    public CapacityException(String message, int capacity) {
        super(message);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}

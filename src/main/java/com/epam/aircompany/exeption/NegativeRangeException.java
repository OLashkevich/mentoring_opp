package com.epam.aircompany.exeption;

/**
 * @author Olga Lashkevich
 */
public class NegativeRangeException extends PlaneException {

    private int range;

    public NegativeRangeException(String message, int range) {
        super(message);
        this.range = range;
    }

    public int getRange() {
        return range;
    }


}

package com.epam.aircompany.filter;

import com.epam.aircompany.plane.IAirplane;

/**
 * @author Olga Lashkevich
 */
public class RangeFilter implements IFilter {

    private int range;

    public RangeFilter(int range) {
        this.range = range;
    }

    public boolean test(IAirplane airplane) {
        return airplane.getRange() >= range;
    }
}

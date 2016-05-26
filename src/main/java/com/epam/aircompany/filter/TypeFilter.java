package com.epam.aircompany.filter;

import com.epam.aircompany.plane.IAirplane;

/**
 * @author Olga Lashkevich
 */
public class TypeFilter implements IFilter {

    private Class type;

    public TypeFilter(Class type) {
        this.type = type;
    }

    public boolean test(IAirplane airplane) {
        return type.isAssignableFrom(airplane.getClass());
    }
}

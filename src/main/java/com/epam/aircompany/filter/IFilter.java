package com.epam.aircompany.filter;

import com.epam.aircompany.plane.IAirplane;

/**
 * @author Olga Lashkevich
 */
public interface IFilter {

    boolean test(IAirplane airplane);
}

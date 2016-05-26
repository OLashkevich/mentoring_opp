package com.epam.aircompany.plane;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author Olga Lashkevich
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "_class")
public interface IAirplane {

    String getName();

    int getSeatingCapacity();

    int getCarryingCapacity();

    int getRange();
}

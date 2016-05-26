package com.epam.aircompany;

import com.epam.aircompany.filter.IFilter;
import com.epam.aircompany.plane.IAirplane;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Olga Lashkevich
 */
public class AirCompany {

    private String companyName;

    private String id;

    private List<IAirplane> airplanes = new ArrayList<IAirplane>();

    public AirCompany() {
    }

    public AirCompany(String companyName) {
        this.companyName = companyName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addPlane(IAirplane airplane) {
        if (airplane != null) {
            airplanes.add(airplane);
        }

    }

    public String getCompanyName() {
        return companyName;
    }

    @JsonIgnore
    public int getPassengerCapacity() {
        int passengerCapacity = 0;
        for (IAirplane airplane : airplanes) {
            passengerCapacity += airplane.getSeatingCapacity();
        }
        return passengerCapacity;
    }

    @JsonIgnore
    public int getCarryingCapacity() {
        int carryingCapacity = 0;
        for (IAirplane airplane : airplanes) {
            carryingCapacity += airplane.getCarryingCapacity();
        }
        return carryingCapacity;
    }

    public List<IAirplane> getSortedAirplanes(Comparator<IAirplane> comparator) {
        Collections.sort(airplanes, comparator);
        return Collections.unmodifiableList(airplanes);
    }

    public List<IAirplane> getAirplanes(IFilter filter) {
        List<IAirplane> airplanesByFilter = new ArrayList<IAirplane>();
        for (IAirplane airplane : airplanes) {
            if (filter.test(airplane)) {
                airplanesByFilter.add(airplane);
            }
        }
        return airplanesByFilter;
    }

    public List<IAirplane> getAirplanes() {
        return airplanes;
    }
}

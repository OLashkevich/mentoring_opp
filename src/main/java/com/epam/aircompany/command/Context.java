package com.epam.aircompany.command;

import com.epam.aircompany.AirCompany;

/**
 * @author Olga Lashkevich
 */
public class Context {

    private AirCompany company;

    public void setAirCompany(AirCompany company) {
        this.company = company;
    }

    public AirCompany getAirCompany() {
        return company;
    }
}

package com.epam.aircompany.dao;

import com.epam.aircompany.AirCompany;
import com.epam.aircompany.exeption.DataAccessException;

/**
 * @author Olga Lashkevich
 */
public interface AirCompanyDAO {

    AirCompany getCompany(String name) throws DataAccessException;
}

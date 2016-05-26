package com.epam.aircompany.dao;

import com.epam.aircompany.AirCompany;
import com.epam.aircompany.exeption.DataAccessException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/**
 * @author Olga Lashkevich
 */
public class JSONAirComapnyDAO implements AirCompanyDAO {

    private String path;

    public JSONAirComapnyDAO(String path) {
        this.path = path;
    }

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public AirCompany getCompany(String name) throws DataAccessException {
        try (InputStream inputStream = new FileInputStream(new File(path));
        ) {
            AirCompany airCompany = objectMapper.readValue(inputStream, AirCompany.class);
            if (airCompany.getCompanyName().equals(name)) {
                return airCompany;
            } else {
                return null;
            }
        } catch (FileNotFoundException e) {
            throw new DataAccessException(e);
        } catch (IOException e) {
            throw new DataAccessException(e);
        }
    }
}

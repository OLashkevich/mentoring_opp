package com.epam.aircompany.dao;

import com.epam.aircompany.AirCompany;
import com.epam.aircompany.exeption.DataAccessException;
import com.epam.aircompany.exeption.PlaneException;
import com.epam.aircompany.plane.CargoPlane;
import com.epam.aircompany.plane.IAirplane;
import com.epam.aircompany.plane.PassengerPlane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Olga Lashkevich
 */
public class JDBCAirCompanyDAO implements AirCompanyDAO {

    @Override
    public AirCompany getCompany(String name) throws DataAccessException {
        try (Connection connection = DbUtils.getConnection();
             PreparedStatement companyStatement = connection.prepareStatement("select id, name from aircompany where name = ?");
             PreparedStatement planeStatement = connection.prepareStatement("select NAME ,TYPE ,SEATING_CAPACITY ,CARRYING_CAPACITY, RANGE from plane where aircompany_id = ?")) {
            companyStatement.setString(1, name);
            try (ResultSet resultSet = companyStatement.executeQuery()) {
                if (resultSet.next()) {
                    AirCompany airCompany = new AirCompany(resultSet.getString(2));
                    int airCompanyId = resultSet.getInt(1);
                    airCompany.setId(String.valueOf(airCompanyId));

                    planeStatement.setInt(1, airCompanyId);
                    try (ResultSet planeResultSet = planeStatement.executeQuery()) {
                        while (planeResultSet.next()) {
                            IAirplane plane;
                            if ("Passenger Plane".equals(planeResultSet.getString(2))) {
                                plane = new PassengerPlane(planeResultSet.getString(1), planeResultSet.getInt(5), planeResultSet.getInt(3));
                            } else {
                                plane = new CargoPlane(planeResultSet.getString(1), planeResultSet.getInt(5), planeResultSet.getInt(4));
                            }
                            airCompany.addPlane(plane);
                        }
                    }
                    return airCompany;
                }
            }
        } catch (SQLException | PlaneException ex) {
            throw new DataAccessException(ex);
        }
        return null;
    }
}

package com.epam.aircompany;

import com.epam.aircompany.command.*;
import com.epam.aircompany.dao.JDBCAirCompanyDAO;
import com.epam.aircompany.dao.JSONAirComapnyDAO;

/**
 * @author Olga Lashkevich
 */
public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.addCommand(new CreateAirCompany());
        menu.addCommand(new CreatePlane());
        menu.addCommand(new PrintPlanes());
        menu.addCommand(new ReadFromFile());
        menu.addCommand(new ReadFromDataSource(new JDBCAirCompanyDAO()));
        menu.addCommand(new ReadFromDataSource(new JSONAirComapnyDAO("/users/olga/AirCompany.json")));
        menu.addCommand(new WriteToFile());
        menu.addCommand(new Exit());
        menu.start();

    }
}

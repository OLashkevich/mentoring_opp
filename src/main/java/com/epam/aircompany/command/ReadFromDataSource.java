package com.epam.aircompany.command;

import com.epam.aircompany.dao.AirCompanyDAO;
import com.epam.aircompany.exeption.DataAccessException;

import java.util.Scanner;

/**
 * @author Olga Lashkevich
 */
public class ReadFromDataSource implements ICommand {
    private AirCompanyDAO airCompanyDAO;
    private Scanner scanner = new Scanner(System.in);

    public ReadFromDataSource(AirCompanyDAO airCompanyDAO) {
        this.airCompanyDAO = airCompanyDAO;
    }

    @Override
    public String getCommand() {
        return "Read from Data Source: " + airCompanyDAO.getClass().getSimpleName();
    }

    @Override
    public void doCommand(Context context) {
        System.out.println("Enter a company name");
        String name = scanner.next();
        try {
            context.setAirCompany(airCompanyDAO.getCompany(name));
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

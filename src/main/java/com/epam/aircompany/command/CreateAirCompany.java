package com.epam.aircompany.command;

import com.epam.aircompany.AirCompany;

import java.util.Scanner;
import java.util.UUID;

/**
 * @author Olga Lashkevich
 */
public class CreateAirCompany implements ICommand {

    private Scanner scanner = new Scanner(System.in);

    public String getCommand() {
        return "Create AirCompany";
    }

    public void doCommand(Context context) {
        System.out.println("Enter a company name");
        String name = scanner.next();

        AirCompany airCompany = new AirCompany(name);
        airCompany.setId(UUID.randomUUID().toString());

        context.setAirCompany(airCompany);
    }
}

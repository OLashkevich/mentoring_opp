package com.epam.aircompany.command;

import com.epam.aircompany.AirCompany;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Scanner;

/**
 * @author Olga Lashkevich
 */
public class ReadFromFile implements ICommand {

    private Scanner scanner = new Scanner(System.in);
    private ObjectMapper objectMapper = new ObjectMapper();

    public String getCommand() {
        return "Read from file";
    }

    public void doCommand(Context context) {
        System.out.println("Enter the path to a file");
        String path = scanner.next();
        try (InputStream inputStream = new FileInputStream(new File(path));
        ) {
            AirCompany airCompany = objectMapper.readValue(inputStream, AirCompany.class);
            context.setAirCompany(airCompany);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Cannot read airCompany from file");
        }
    }
}

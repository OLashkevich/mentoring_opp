package com.epam.aircompany.command;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Scanner;

/**
 * @author Olga Lashkevich
 */
public class WriteToFile implements ICommand {
    private Scanner scanner = new Scanner(System.in);
    private ObjectMapper objectMapper = new ObjectMapper();

    public String getCommand() {
        return "Write to file";
    }

    public void doCommand(Context context) {
        System.out.println("Enter the path to a file");
        String path = scanner.next();
        try (OutputStream outputStream = new FileOutputStream(new File(path));
        ) {
            objectMapper.writeValue(outputStream, context.getAirCompany());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Cannot write airCompany to file");
        } catch (NullPointerException e) {
            System.out.println("AirCompany is not created yet");
        }
    }
}

package com.epam.aircompany.command;

import com.epam.aircompany.PlaneFactory;
import com.epam.aircompany.PlaneModel;
import com.epam.aircompany.exeption.PlaneCreationException;
import com.epam.aircompany.plane.IAirplane;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Olga Lashkevich
 */
public class CreatePlane implements ICommand {
    Scanner scanner = new Scanner(System.in);

    public String getCommand() {
        return "Create new plane";
    }

    public void doCommand(Context context) {
        System.out.println("Enter a plane type: ");
        System.out.println(Arrays.toString(PlaneModel.values()));
        String planeType = scanner.next();
        try {
            IAirplane airplane = PlaneFactory.createPlane(PlaneModel.valueOf(planeType));
            context.getAirCompany().addPlane(airplane);
        } catch (IllegalArgumentException e) {
            System.out.println("Plane model not found");
        } catch (NullPointerException e) {
            System.out.println("AirCompany is not created yet");
        } catch (PlaneCreationException e) {
            System.out.println("Cannot create plane: " + e.getMessage());
        }

    }
}

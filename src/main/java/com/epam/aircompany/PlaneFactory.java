package com.epam.aircompany;

import com.epam.aircompany.exeption.CapacityException;
import com.epam.aircompany.exeption.PlaneCreationException;
import com.epam.aircompany.exeption.PlaneException;
import com.epam.aircompany.plane.CargoPlane;
import com.epam.aircompany.plane.IAirplane;
import com.epam.aircompany.plane.PassengerPlane;

import java.util.NoSuchElementException;

/**
 * @author Olga Lashkevich
 */
public class PlaneFactory {

    public static IAirplane createPlane(PlaneModel model) {
        IAirplane airplane = null;
        try {
            switch (model) {
                case BOEING_777:
                    airplane = new PassengerPlane("Boeing 777", 11000, 300);
                    break;
                case AIRBUS_A380:
                    airplane = new PassengerPlane("Airbus a380", 10000, 350);
                    break;
                case BOEING_C17:
                    airplane = new CargoPlane("Boeing C-17", 5190, 77500);
                    break;
                case TO_LARGE_PLANE_1:
                    airplane = new PassengerPlane("To Large Plane", 2000, 1001);
                    break;
                case NO_ENGINE_PLANE_2:
                    airplane = new CargoPlane("Boeing C-170", 0, 77500);
                    break;
                default:
                    throw new NoSuchElementException("Unknown plane: " + model);
            }
        } catch (CapacityException e) {
            System.out.println("WARN: " + e.getMessage() + " ; Capacity: " + e.getCapacity());
        } catch (PlaneException e) {
            throw new PlaneCreationException(e);
        }
        return airplane;

    }
}

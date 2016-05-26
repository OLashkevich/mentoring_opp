package com.epam.aircompany.command;

import com.epam.aircompany.filter.RangeFilter;

/**
 * @author Olga Lashkevich
 */
public class PrintPlanes implements ICommand {
    public String getCommand() {
        return "Print planes";
    }

    public void doCommand(Context context) {
        try {
            System.out.println(context.getAirCompany().getAirplanes(new RangeFilter(0)));
        } catch (NullPointerException e) {
            System.out.println("AirCompany is not created yet");
        }
    }
}

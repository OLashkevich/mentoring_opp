package com.epam.aircompany.command;

/**
 * @author Olga Lashkevich
 */
public class Exit implements ICommand {

    public String getCommand() {
        return "Exit";
    }

    public void doCommand(Context context) {
        System.exit(0);
    }
}

package com.epam.aircompany.command;

/**
 * @author Olga Lashkevich
 */
public interface ICommand {

    String getCommand();

    void doCommand(Context context);


}

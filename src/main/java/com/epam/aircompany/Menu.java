package com.epam.aircompany;

import com.epam.aircompany.command.Context;
import com.epam.aircompany.command.ICommand;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Olga Lashkevich
 */
public class Menu {

    private List<ICommand> listCommand = new ArrayList<ICommand>();

    public void addCommand(ICommand command) {
        listCommand.add(command);
    }

    private void printCommands() {
        for (int i = 0; i < listCommand.size(); i++) {
            System.out.println(i + " " + listCommand.get(i).getCommand());
        }

        System.out.println("Choose a command: ");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Context context = new Context();
        while (true) {
            printCommands();

            try {
                int i = scanner.nextInt();
                listCommand.get(i).doCommand(context);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Command is not found");
            } catch (NoSuchElementException ex) {
                System.out.println("Command is not found");
                scanner.next();
            }

        }
    }

}

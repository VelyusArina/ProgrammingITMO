package org.velus.commands;

import org.velus.Interpreter;
import org.velus.model.SpaceMarine;

public class ShowCommand extends Command {
    public ShowCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        for (SpaceMarine marine : collection.getAll()) {
            ioManager.writeLine(marine.toString());
        }
    }

    @Override
    public String getDescription() {
        return ": вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    @Override
    public String getName() {
        return "show";
    }
}

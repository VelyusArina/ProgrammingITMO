package org.velus.commands;

import org.velus.Interpreter;
import org.velus.model.SpaceMarine;

public class MinByCoordinates extends Command {
    public MinByCoordinates(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        SpaceMarine best = collection.getMinByCoordinates();
        if (best == null) {
            ioManager.writeLine("Элементы отсутствуют.");
        } else {
            ioManager.writeLine(best.toString());
        }
    }

    @Override
    public String getDescription() {
        return "вывести любой объект из коллекции, значение поля creationDate которого является максимальным";
    }

    @Override
    public String getName() {
        return "max_by_creation_date ";
    }
}

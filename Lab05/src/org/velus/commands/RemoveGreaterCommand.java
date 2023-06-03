package org.velus.commands;

import org.velus.Interpreter;
import org.velus.model.SpaceMarine;
import org.velus.readers.complex.SpaceMarineReader;

public class RemoveGreaterCommand extends Command {
    public RemoveGreaterCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        SpaceMarine element = new SpaceMarineReader(ioManager).setNullable(false).read();
        if (collection.removeGreater(element)) {
            ioManager.writeLine("Элементы, большие указанного, были удалены.");
        } else {
            ioManager.writeLine("Элементы, большие указанного, отсутствуют.");
        }
    }

    @Override
    public String getDescription() {
        return "{element} : удалить из коллекции все элементы, большие, чем заданный";
    }

    @Override
    public String getName() {
        return "remove_greater";
    }
}

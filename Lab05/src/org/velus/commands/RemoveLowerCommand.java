package org.velus.commands;

import org.velus.Interpreter;
import org.velus.model.SpaceMarine;
import org.velus.readers.complex.SpaceMarineReader;

public class RemoveLowerCommand extends Command {
    public RemoveLowerCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        SpaceMarine element = new SpaceMarineReader(ioManager).setNullable(false).read();
        if (collection.removeLower(element)) {
            ioManager.writeLine("Элементы, меньшие указанного, были удалены.");
        } else {
            ioManager.writeLine("Элементы, меньшие указанного, отсутствуют.");
        }
    }

    @Override
    public String getDescription() {
        return "{element} : удалить из коллекции все элементы, меньшие, чем заданный";
    }

    @Override
    public String getName() {
        return "remove_lower";
    }
}

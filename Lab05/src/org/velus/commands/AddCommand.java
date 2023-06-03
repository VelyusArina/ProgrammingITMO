package org.velus.commands;

import org.velus.Interpreter;
import org.velus.model.SpaceMarine;
import org.velus.readers.complex.SpaceMarineReader;

public class AddCommand extends Command {
    public AddCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        SpaceMarine marine = new SpaceMarineReader(ioManager).setNullable(false).read();
        collection.add(marine);
        ioManager.writeLine("Добавлен объект: " + marine.toString());
    }

    @Override
    public String getDescription() {
        return "{element} : добавить новый элемент в коллекцию";
    }

    @Override
    public String getName() {
        return "add";
    }
}

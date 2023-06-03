package org.velus.commands;

import org.velus.Interpreter;
import org.velus.model.SpaceMarine;
import org.velus.readers.complex.SpaceMarineReader;

public class AddIfMinCommand extends Command {
    public AddIfMinCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        SpaceMarine marine = new SpaceMarineReader(ioManager).setNullable(false).read();
        SpaceMarine min = collection.getMin();
        if (min == null || marine.compareTo(min) < 0) {
            collection.add(marine);
            ioManager.writeLine("Добавлен объект: " + marine.toString());
        } else {
            ioManager.writeLine("Значение введенного объекта не меньше, чем у наименьшего элемента этой коллекции");
        }
    }

    @Override
    public String getDescription() {
        return "{element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }

    @Override
    public String getName() {
        return "add_if_min";
    }
}

package org.velus.commands;

import org.velus.Interpreter;
import org.velus.readers.complex.SpaceMarineReader;
import org.velus.readers.simple.number.IntegerReader;
import org.velus.model.SpaceMarine;
import org.velus.readers.simple.number.LongReader;

public class UpdateCommand extends Command {
    public UpdateCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        Long id = new LongReader(ioManager).setNullable(false).read();
        SpaceMarine value = new SpaceMarineReader(ioManager).setNullable(false).read();
        SpaceMarine element = collection.get(id);
        if (element == null) {
            ioManager.writeLine("Элемент с данным ключём не найден");
        } else {
            collection.remove(id);
            collection.add(value);
            ioManager.writeLine("Значение обновлено: " + value.toString());
        }
    }

    @Override
    public String getDescription() {
        return "id {element} : обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public String getName() {
        return "update";
    }
}

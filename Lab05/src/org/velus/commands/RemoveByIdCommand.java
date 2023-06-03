package org.velus.commands;

import org.velus.Interpreter;
import org.velus.readers.simple.number.IntegerReader;
import org.velus.readers.simple.number.LongReader;

public class RemoveByIdCommand extends Command {
    public RemoveByIdCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        Long id = new LongReader(ioManager).setNullable(false).read();
        if (collection.get(id) == null) {
            ioManager.writeLine("Элемент с заданным ключём отстутствует.");
        } else {
            collection.remove(id);
            ioManager.writeLine("Элемент удалён.");
        }
    }

    @Override
    public String getDescription() {
        return "id : удалить элемент из коллекции по его id";
    }

    @Override
    public String getName() {
        return "remove_by_id";
    }
}

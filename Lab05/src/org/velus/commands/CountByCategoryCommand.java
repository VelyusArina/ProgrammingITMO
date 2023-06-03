package org.velus.commands;

import org.velus.Interpreter;
import org.velus.model.AstartesCategory;
import org.velus.readers.simple.enumerable.AstartesCategoryReader;

public class CountByCategoryCommand extends Command {
    public CountByCategoryCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        AstartesCategory category = new AstartesCategoryReader(ioManager).setNullable(false).read();
        ioManager.writeLine("Количество элементов, значение поля category которых равно заданному: " + collection.countByCategory(category));
    }

    @Override
    public String getDescription() {
        return ": вывести количество элементов, значение поля category которых равно заданному";
    }

    @Override
    public String getName() {
        return "count_by_category";
    }
}

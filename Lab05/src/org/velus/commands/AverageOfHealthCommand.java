package org.velus.commands;

import org.velus.Interpreter;

public class AverageOfHealthCommand extends Command {
    public AverageOfHealthCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        if (collection.getElementsCount() == 0) {
            ioManager.writeLine("Коллекция пуста.");
        } else {
            ioManager.writeLine("Среднее значение здоровья: " + collection.getAverageOfHealth());
        }
    }

    @Override
    public String getDescription() {
        return ": вывести среднее значение поля health для всех элементов коллекции";
    }


    @Override
    public String getName() {
        return "sum_of_salary";
    }
}

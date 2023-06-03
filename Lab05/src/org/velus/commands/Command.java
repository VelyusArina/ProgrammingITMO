package org.velus.commands;

import org.velus.IOManager;
import org.velus.Interpreter;
import org.velus.CollectionManager;

/**
 * Класс, позволяющий определять поведение и свойства комманд.
 */
public abstract class Command {
    protected final Interpreter interpreter;
    protected final IOManager ioManager;
    protected final CollectionManager collection;

    public Command(Interpreter interpreter) {
        this.interpreter = interpreter;
        this.ioManager = interpreter.getIOManager();
        this.collection = interpreter.getCollection();
    }

    public abstract void execute();

    public abstract String getDescription();

    public abstract String getName();
}

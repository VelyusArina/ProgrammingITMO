package org.velus.commands;

import org.velus.Interpreter;
import org.velus.InterpreterMode;
import org.velus.readers.simple.StringReader;

public class ExecuteScriptCommand extends Command {
    public ExecuteScriptCommand(Interpreter interpreter) {
        super(interpreter);
    }

    @Override
    public void execute() {
        String filename = new StringReader(ioManager).setCanBeEmpty(false).setNullable(false).read();
        if (interpreter.getMode() == InterpreterMode.CONSOLE) {
            Interpreter interpreter = new Interpreter(filename);
            interpreter.run();
        } else {
            ioManager.writeLine("Исполнять скрипты можно только из консоли во избежание зацикливания!");
        }
    }

    @Override
    public String getDescription() {
        return "file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }

    @Override
    public String getName() {
        return "execute_script";
    }
}

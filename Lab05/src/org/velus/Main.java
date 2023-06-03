package org.velus;

public class Main {

    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();
        if (args.length > 0) {
            interpreter.loadCollectionFromFile(args[0]);
        }
        interpreter.run();
    }
}

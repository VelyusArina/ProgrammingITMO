package org.velus.readers.simple;

import org.velus.IOManager;
import org.velus.readers.ValueReader;

/**
 * Класс, позволяющий определить правила чтения простых значений.
 */
public abstract class ValueSimpleReader<T> extends ValueReader<T> {
    protected ValueSimpleReader(IOManager ioManager) {
        super(ioManager);
    }
}

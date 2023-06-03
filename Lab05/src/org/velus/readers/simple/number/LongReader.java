package org.velus.readers.simple.number;

import org.velus.IOManager;
import org.velus.readers.ValueFormatException;

public class LongReader extends NumberReader<Long> {
    public LongReader(IOManager ioManager) {
        super(ioManager);
        this.setNullable(true);
    }

    @Override
    Long parseValue(String argument) throws ValueFormatException {
        try {
            return Long.parseLong(argument);
        } catch (Exception e) {
            throw new ValueFormatException("Некорректный формат числа!");
        }
    }

    public LongReader setLowerBound(Long lowerBound) {
        super.setLowerBound(lowerBound);
        return this;
    }

    @Override
    int compareValues(Long a, Long b) {
        return a.compareTo(b);
    }
}

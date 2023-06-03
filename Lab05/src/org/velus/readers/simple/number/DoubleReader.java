package org.velus.readers.simple.number;

import org.velus.IOManager;
import org.velus.readers.ValueFormatException;

public class DoubleReader extends NumberReader<Double> {
    public DoubleReader(IOManager ioManager) {
        super(ioManager);
    }

    @Override
    Double parseValue(String argument) throws ValueFormatException {
        try {
            return Double.parseDouble(argument);
        } catch (Exception e) {
            throw new ValueFormatException("Некорректный формат числа!");
        }
    }

    @Override
    int compareValues(Double a, Double b) {
        return a.compareTo(b);
    }

    public DoubleReader setLowerBound(Double lowerBound) {
        super.setLowerBound(lowerBound);
        return this;
    }
}
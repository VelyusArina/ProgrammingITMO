package org.velus.readers.simple.enumerable;

import org.velus.IOManager;
import org.velus.readers.ValueFormatException;
import org.velus.readers.simple.ValueSimpleReader;

abstract class EnumReader<T extends Enum<T>> extends ValueSimpleReader<T> {
    EnumReader(IOManager ioManager) {
        super(ioManager);
    }

    @Override
    protected T parseNotNull(String argument) throws ValueFormatException {
        try {
            return valueOf(argument);
        } catch (Exception e) {
            throw new ValueFormatException("Некорректное значение!");
        }
    }

    @Override
    protected void writeFieldName(String fieldName) {
        ioManager.writeLine(getFieldNameMessage());
        super.writeFieldName(fieldName);
    }

    private String getFieldNameMessage() {
        StringBuilder builder = new StringBuilder("Доступные значения: ");
        for (T value : getEnumValues()) {
            builder.append(value.toString()).append(" ");
        }
        return builder.toString();
    }

    abstract T[] getEnumValues();

    abstract T valueOf(String name) throws ValueFormatException;
}

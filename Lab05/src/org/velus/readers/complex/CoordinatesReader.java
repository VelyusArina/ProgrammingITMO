package org.velus.readers.complex;

import org.velus.IOManager;
import org.velus.model.Coordinates;
import org.velus.readers.simple.number.DoubleReader;

public class CoordinatesReader extends ValueComplexReader<Coordinates> {
    public CoordinatesReader(IOManager ioManager) {
        super(ioManager);
    }

    @Override
    protected Coordinates readFields() {
        Double x = new DoubleReader(ioManager).setNullable(false).read("x");
        double y = new DoubleReader(ioManager).setNullable(false).read("y");
        return new Coordinates(x, y);
    }

    @Override
    protected String getTypeName() {
        return Coordinates.class.getSimpleName();
    }
}

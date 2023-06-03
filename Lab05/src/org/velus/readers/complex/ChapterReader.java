package org.velus.readers.complex;

import org.velus.IOManager;
import org.velus.model.Chapter;
import org.velus.readers.simple.StringReader;

public class ChapterReader extends ValueComplexReader<Chapter> {
    public ChapterReader(IOManager ioManager) {
        super(ioManager);
    }

    @Override
    protected Chapter readFields() {
        String name = new StringReader(ioManager).setCanBeEmpty(false).setNullable(false).read("название");
        String parentLegion = new StringReader(ioManager).read("родительский легион");
        return new Chapter(name, parentLegion);
    }

    @Override
    protected String getTypeName() {
        return Chapter.class.getSimpleName();
    }
}

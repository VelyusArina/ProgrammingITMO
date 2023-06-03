package org.velus.readers.simple.enumerable;

import org.velus.IOManager;
import org.velus.model.AstartesCategory;

public class AstartesCategoryReader extends EnumReader<AstartesCategory> {
    public AstartesCategoryReader(IOManager ioManager) {
        super(ioManager);
    }

    @Override
    AstartesCategory[] getEnumValues() {
        return AstartesCategory.values();
    }

    @Override
    AstartesCategory valueOf(String name) {
        return AstartesCategory.valueOf(name);
    }
}
package org.velus;

import org.velus.model.AstartesCategory;
import org.velus.model.SpaceMarine;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Класс, предоставляющий методы для манипуляций над коллекцией объектов класса 'marine'.
 */
public class CollectionManager {
    private final Set<SpaceMarine> collection = new TreeSet<>();
    private final LocalDate initializationDate;

    public CollectionManager() {
        initializationDate = LocalDate.now();
    }

    public void add(SpaceMarine element) {
        collection.add(element);
    }

    public void remove(Long key) {
        SpaceMarine element = get(key);
        collection.remove(element);
    }

    public SpaceMarine get(Long id) {
        for (SpaceMarine element : collection) {
            if (element.getId() == id) {
                return element;
            }
        }
        return null;
    }

    public List<SpaceMarine> getAll() {
        return new LinkedList<>(collection);
    }

    public void clear() {
        collection.clear();
    }

    public boolean removeLower(SpaceMarine element) {
        return collection.removeIf(marine -> marine.compareTo(element) < 0);
    }

    public boolean removeGreater(SpaceMarine element) {
        return collection.removeIf(marine -> marine.compareTo(element) > 0);
    }

    public SpaceMarine getMinByCoordinates() {
        if (collection.isEmpty()) return null;
        return collection.stream().min(Comparator.comparing(SpaceMarine::getCoordinates)).get();
    }

    public double getAverageOfHealth() {
        double sum = 0;

        for (SpaceMarine element : collection) {
            sum += element.getHealth();
        }
        return sum / collection.size();
    }

    public LocalDate getInitializationDate() {
        return initializationDate;
    }

    public String getType() {
        return collection.getClass().getSimpleName();
    }

    public int getElementsCount() {
        return collection.size();
    }

    public int countByCategory(AstartesCategory category) {
        int count = 0;

        for (SpaceMarine element : collection) {
            if (element.getCategory().equals(category)) count++;
        }
        return count;
    }

    public void loadFromFile(String filename) {
        collection.clear();
        try {
            IOManager ioManager = new IOManager();
            ioManager.setInputFile(filename);
            while (true) {
                try {
                    collection.add(SpaceMarine.fromCSV(ioManager));
                } catch (Exception ignored) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveToFile(String filename) {
        try {
            IOManager ioManager = new IOManager();
            ioManager.setOutputFile(filename);
            for (SpaceMarine marine : collection) {
                marine.toCSV(ioManager);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SpaceMarine getMin() {
        if (collection.isEmpty()) return null;
        return collection.stream().min(SpaceMarine::compareTo).get();
    }
}

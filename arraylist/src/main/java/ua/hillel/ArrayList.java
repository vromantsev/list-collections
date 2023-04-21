package ua.hillel;

import java.util.Objects;

/**
 * Implement a list that is based on array. This resizable data structure
 * is based on an array and is a simplified version of {@link java.util.ArrayList}.
 */
public class ArrayList<T> implements List<T> {
    private static final double MULTIPLIER = 1.5;
    private static final int DEFAULT_SIZE = 10;
    private int size;
    private Object[] array;

    public ArrayList() {
        this.array = new Object[DEFAULT_SIZE];
    }

    @Override
    public void add(T element) {
        if (array.length == size) {
            sizeUpper();
        }
        array[size] = element;
        size++;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index >= size) {
            return;
        }
        if (array.length == size) {
            sizeUpper();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return (T) array[index];
    }

    @Override
    public T get(T element) {
        for (Object object : array) {
            if (Objects.equals(object, element)) {
                return (T) object;
            }
        }
        return null;
    }

    @Override
    public T getFirst() {
        if (size > 0) {
            return (T) array[0];
        }
        return null;
    }

    @Override
    public T getLast() {
        if (size > 0) {
            return (T) array[size - 1];
        }
        return null;
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            return;
        }
        array[index] = element;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return true;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals((T) array[i], element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
    }

    private void sizeUpper() {
        Object[] objects = new Object[(int) (array.length * MULTIPLIER)];
        System.arraycopy(array, 0, objects, 0, array.length);
        array = objects;
    }
}

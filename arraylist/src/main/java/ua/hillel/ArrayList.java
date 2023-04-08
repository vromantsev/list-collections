package ua.hillel;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Implement a list that is based on array. This resizable data structure
 * is based on an array and is a simplified version of {@link java.util.ArrayList}.
 */
public class ArrayList<T> implements List<T> {
    private Object[] arrayElements;
    private int size;

    public ArrayList() {
        this.arrayElements = new Object[3];
        this.size = 0;
    }

    private void createNewArrIfNeed() {
        if (arrayElements.length == size) {
            int newCapacity = arrayElements.length * 2;
            arrayElements = Arrays.copyOf(arrayElements, newCapacity);
        }
    }

    @Override
    public void add(T element) {
        createNewArrIfNeed();
        arrayElements[size] = element;
        size++;
    }

    @Override
    public void add(int index, T element) {
        Objects.checkIndex(index, size);
        createNewArrIfNeed();
        System.arraycopy(arrayElements, index, arrayElements, index + 1, size - index);
        arrayElements[index] = element;
        size++;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return (T) arrayElements[i];
            }
        }
        return null;
    }

    @Override
    public T get(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(arrayElements[i])) {
                return (T) arrayElements[i];
            }
        }
        return null;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(0);
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(size - 1);
    }

    @Override
    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        arrayElements[index] = element;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index > size - 1) {
            return false;
        }
        System.arraycopy(arrayElements, index + 1, arrayElements, index, size - index - 1);
        size--;
        return true;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(arrayElements[i])) {
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
        for (int i = 0; i < size; i++) {
            arrayElements[i] = null;
        }
        size = 0;
    }
}

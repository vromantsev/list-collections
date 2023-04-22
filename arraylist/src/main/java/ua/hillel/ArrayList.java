package ua.hillel;

import java.util.Objects;

/**
 * Implement a list that is based on array. This resizable data structure
 * is based on an array and is a simplified version of {@link java.util.ArrayList}.
 */
public class ArrayList<T> implements List<T> {

    private Object[] elements;

    @Override
    public void add(T element) {
        if (elements.length == size()) {
            Object[] newElements = new Object[size() * 2];
            System.arraycopy(element, 0, newElements, 0, size());
            elements = newElements;
        }
        elements[size()] = element;
    }

    @Override
    public void add(int index, T element) {
        if (elements.length == size()) {
            Object[] newElements = new Object[size() * 2];
            System.arraycopy(element, 0, newElements, 0, size());
            elements = newElements;
        }
        elements[index] = element;
    }

    @Override
    public T get(int index) {
        if (index < 0 ||index >= elements.length) {
            throw new IndexOutOfBoundsException("Input correct index!");
        }
        return (T) elements[index];
    }

    @Override
    public T get(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Input correct data!");
        }

        int index = -1;

        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(element)) {
                index = i;
            }
        }

        if (index == -1) {
            return null;
        }
        return (T) elements[index];
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return get(size() - 1);
    }

    @Override
    public void set(int index, T element) {
        if ( index < 0 ||index >= elements.length) {
            throw new IndexOutOfBoundsException("Input correct index!");
        }
        elements[index] = element;
    }

    @Override
    public T remove(int index) {
        if ( index < 0 ||index >= elements.length) {
            throw new IndexOutOfBoundsException("Input correct index!");
        }
        T removedEl = (T) elements[index];

        for (int i = 0; i < elements.length; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size() - 1] = null;
        return removedEl;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return elements.length == 0;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            remove(i);
        }
    }
}
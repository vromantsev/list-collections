package ua.hillel;

import com.sun.source.tree.BreakTree;

import java.util.Arrays;
import java.util.Objects;

/**
 * Implement a list that is based on array. This resizable data structure
 * is based on an array and is a simplified version of {@link java.util.ArrayList}.
 */
public class ArrayList<T> implements List<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTS = {};
    private Object[] elements;
    private int size;


    public ArrayList(Object[] elements) {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(T element) {
        int index = size;
        elements = size == EMPTY_ELEMENTS.length ? new Object[DEFAULT_CAPACITY] :
                size == elements.length ? Arrays.copyOf(elements, size + 1) :
                        elements;
        elements[index] = element;
        size = size + 1;
    }

    @Override
    public void add(int index, T element) {
        Objects.requireNonNull(element);
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is not exist. Check input parameters");
        }
        elements = size == elements.length ? Arrays.copyOf(elements, size + 1) : elements;
        System.arraycopy(this.elements, index, this.elements, index + 1, size - index);
        this.elements[index] = element;
        size = size + 1;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("This index doesn`t exist. Check input parameters");
        }
        return (T) elements[index];
    }

    @Override
    public T get(T element) {
        return (T) Arrays.stream(elements)
                .filter(e -> e.equals(element))
                .findFirst()
                .orElse(null);
    }

    @Override
    public T getFirst() {
        return elements[0] == null ? null : get(0);
    }

    @Override
    public T getLast() {
        return elements[size - 1] == null ? null : get(size - 1);

    }

    @Override
    public void set(int index, T element) {
        elements[index] = element;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) return false;

        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return true;

    }

    @Override
    public boolean contains(T element) {
        return Arrays.asList(elements).contains(element);
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
        Arrays.fill(elements, null);
        size = 0;
    }
}

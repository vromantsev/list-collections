package ua.hillel;

import javax.print.attribute.standard.Finishings;
import java.util.Arrays;
import java.util.Objects;

/**
 * Implement a list that is based on array. This resizable data structure
 * is based on an array and is a simplified version of {@link java.util.ArrayList}.
 */
public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elementData;
    private static Object[] emptyArray = {};
    private int size;

    public ArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public Object[] getElementData() {
        return elementData;
    }

    @Override
    public void add(T element) {
        Objects.requireNonNull(element);
        int indexElement = size;
        if (size == emptyArray.length) {
            elementData = new Object[DEFAULT_CAPACITY];
        }
        if (size == elementData.length) {
            resize();
        }

        elementData[indexElement] = element;
        size = size + 1;
    }

    private Object[] resize() {
        int sizeList = size;
        int newLength = sizeList + ((sizeList + 1) >> 1);
        return elementData = Arrays.copyOf(elementData, newLength);
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Such index does not exist in this array does not exist");
        }
        Objects.requireNonNull(element);
        if (size == elementData.length) {
            resize();
        }
        System.arraycopy(this.elementData, index, this.elementData, index + 1, size - index);
        this.elementData[index] = element;
        size = size + 1;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("The requested index is not in the range of the array");
        }
        return (T) elementData[index];
    }

    @Override
    public T get(T element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                return element;
            }
        }
        return null;
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        elementData[index] = element;
    }

    @Override
    public boolean remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index %s out of bounds for length %s".formatted(index, size));
        }
        if (elementData[index] == null) {
            throw new NullPointerException("Index requested for deletion contains null");
        }
        int newSize = size - 1;
        System.arraycopy(this.elementData, index + 1, this.elementData, index, newSize - index);
        elementData[newSize] = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
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
            elementData[i] = null;
        }
        size = 0;
    }
}

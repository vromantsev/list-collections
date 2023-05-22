package ua.hillel;

/**
 * Implement a list that is based on array. This resizable data structure
 * is based on an array and is a simplified version of {@link java.util.ArrayList}.
 */
public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;
    public ArrayList(int initialCapacity) {
        elements = new Object[initialCapacity];
        size = 0;
    }
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void add(T element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    @Override
    public T get(T element) {
        for (int i = 0; i < size; i++) {
            if (elements.equals(elements[i])) {
                return (T) elements[i];
            }
        }
        return null;
    }

    @Override
    public T getFirst() {
        if (size == 0) {
            return null;
        }
        return (T) elements[0];
    }

    @Override
    public T getLast() {
        if (size == 0) {
            return null;
        }
        return (T) elements[size -1];
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsExceprion;
        }
        elements[index] = element;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size){
            return false;
        }
        System.arraycopy (elements, index + 1, elements, index, size - index - 1);
        size--;
        elements[size] = null;
        return true;
    }

    @Override
    public boolean contains(T element) {
        return get(element) != null;
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
            elements[i] = null;
        }
        size = 0;
    }
    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elements.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }
}

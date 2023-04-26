package ua.hillel;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Implement doubly linked list that is based on {@link Node<T>} class (you should implement it as well).
 * This is a simplified version of {@link java.util.LinkedList}.
 */
public class LinkedList<T> implements List<T> {

    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    public LinkedList() {
    }

    private void linkLast(T element) {
        Node<T> temp = last;
        Node<T> newNode = new Node<>(temp, element, null);
        last = newNode;
        if (temp == null) {
            first = newNode;
        } else {
            temp.next = newNode;
        }
        size++;
    }

    private void linkBefore(Node<T> currentLink, T element) {
        Node<T> early = currentLink.prev;
        Node<T> newNode = new Node<>(early, element, currentLink);
        currentLink.prev = newNode;
        if (early == null) {
            first = newNode;
        } else {
            early.next = newNode;
        }
        size++;
    }

    @Override
    public void add(T element) {
        linkLast(element);
    }

    Node<T> node(int index) {
        if (index < (size >> 1)) {
            Node<T> temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            Objects.requireNonNull(temp);
            return temp;
        } else {
            Node<T> temp = last;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
            Objects.requireNonNull(temp);
            return temp;
        }
    }

    @Override
    public void add(int index, T element) {
        if (index == size) {
            throw new IndexOutOfBoundsException("Index %s out of bounds for length %s".formatted(index, size));
        }
        linkBefore(node(index), element);
    }

    @Override
    public T get(int index) {
        if (index == size || size == 0) {
            throw new IndexOutOfBoundsException("Index %s out of bounds for length %s".formatted(index, size));
        }
        return node(index).element;
    }

    @Override
    public T get(T element) {
        Node<T> actual = first;
        for (int i = 0; i < size - 1; i++) {
            if (actual.element.equals(element)) {
                return actual.element;
            }
            actual = actual.next;
        }
        throw new NoSuchElementException("No such element found in the list");
    }

    @Override
    public T getFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.element;
    }

    @Override
    public T getLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        return last.element;
    }

    @Override
    public void set(int index, T element) {
        if (node(index) == null) {
            throw new NullPointerException("index %s is null".formatted(index));
        }
        if (index == size) {
            throw new IndexOutOfBoundsException("Index %s out of bounds for length %s".formatted(index, size));
        }
        node(index).element = element;
    }

    boolean unlink(Node<T> item) {
        Node<T> prev = item.prev;
        Node<T> next = item.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            item.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            item.next = null;
        }
        item.element = null;
        size--;
        return true;
    }

    @Override
    public boolean remove(int index) {
        return unlink(node(index));
    }

    @Override
    public boolean contains(T element) {
        Node<T> actual = first;
        for (int i = 0; i < size; i++) {
            if (actual.element.equals(element)) {
                return true;
            }
            actual = actual.next;
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
        Node<T> firstNode = first;
        for (int i = 0; i < size; i++) {
            Node<T> cleaning = firstNode.next;
            firstNode.element = null;
            firstNode.prev = null;
            firstNode.next = null;
            firstNode = cleaning;
        }
        first = last = null;
        size = 0;
    }
}

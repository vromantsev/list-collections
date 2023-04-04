package ua.hillel;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Implement doubly linked list that is based on {@link Node<T>} class (you should implement it as well).
 * This is a simplified version of {@link java.util.LinkedList}.
 */
public class LinkedList<T> implements List<T> {

    static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T element) {
        Objects.checkIndex(index, size + 1);
        Node<T> newNode = new Node<>(element);
        if (first == null) {
            first = last = newNode;
        } else if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else if (index == size) {
            last.next = newNode;
            last = newNode;
        } else {
            Node<T> previousIndex = getNode(index - 1);
            newNode.next = previousIndex.next;
            previousIndex.next = newNode;
        }
        size++;
    }

    private Node<T> getNode(int index) {
        Node<T> curr = first;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> node = getNode(index);
        return (T) node;
    }

    @Override
    public T get(T element) {
        Node<T> curr = first;
        for (int i = 0; i < size; i++) {
            if (curr.element.equals(element)) {
            }
            curr = curr.next;
        }
        return element;
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
        Node<T> node = getNode(index);
        node.element = element;

    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index > size) {
            return false;
        } else if (index == 0) {
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node<T> previous = getNode(index - 1);
            previous.next = previous.next.next;
            size--;
            if (index == size - 1) {
                last = previous;
            }
        }
        return true;
    }

    @Override
    public boolean contains(T element) {
        Node<T> curr = first;
        for (int i = 0; i < size; i++) {
            if (curr.element.equals(element)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (first == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }
}

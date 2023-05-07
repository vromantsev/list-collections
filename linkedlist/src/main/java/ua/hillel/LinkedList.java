package ua.hillel;

import java.util.NoSuchElementException;

/**
 * Implement doubly linked list that is based on {@link Node<T>} class (you should implement it as well).
 * This is a simplified version of {@link java.util.LinkedList}.
 */
public class LinkedList<T> implements List<T> {
    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(T item) {
            this.item = item;
        }
    }


    private Node<T> first;
    private Node<T> last;
    private int size;

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (size == 0) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
        }
        last = newNode;
        size++;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(element);
        } else {
            Node<T> newNode = new Node<>(element);
            Node<T> currNode = getNode(index);
            newNode.prev = currNode.prev;
            newNode.next = currNode;
            if (currNode.prev == null) {
                first = newNode;
            } else {
                currNode.prev.next = newNode;
            }
            currNode.prev = newNode;
            size++;
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return getNode(index).item;
    }

    public T get(T element) {
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            if (current.item.equals(element)) {
                return current.item;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public T getFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return first.item;
    }

    @Override
    public T getLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return last.item;
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        getNode(index).item = element;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        Node<T> currNode = getNode(index);
        if (currNode.prev == null) {
            first = currNode.next;
        } else {
            currNode.prev.next = currNode.next;
        }
        if (currNode.next == null) {
            last = currNode.prev;
        } else {
            currNode.next.prev = currNode.prev;
        }
        size--;
        return true;
    }

    @Override
    public boolean contains(T element) {
        Node<T> current = first;
        while (current != null) {
            if (current.item.equals(element)) {
                return true;
            }
            current = current.next;
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
        first = null;
        last = null;
        size = 0;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> currentNode;
        if (index < size / 2) {
            currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = last;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }
}

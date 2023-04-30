package ua.hillel;

import java.util.Objects;

/**
 * Implement doubly linked list that is based on {@link Node<T>} class (you should implement it as well).
 * This is a simplified version of {@link java.util.LinkedList}.
 */
public class LinkedList<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    @Override
    public void add(T element) {
        Node<T> node = new Node<>(element);
        if (last == null) {
            first = node;
        } else {
            last.next = node;
            node.previous = last;
        }
        last = node;
        size++;
    }

    @Override
    public void add(int index, T element) {
        if (index > size || index < 0) {
            return;
        }
        Node<T> node = new Node<>(element);
        if (index == size) {
            add(element);
            return;
        }
        if (index == 0) {
            first.previous = node;
            node.next = first;
            first = node;
            size++;
            return;
        }
        Node<T> currentNode = getNode(index);
        node.previous = currentNode.previous;
        node.next = currentNode;
        currentNode.previous.next = node;
        currentNode.previous = node;
        size++;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return getNode(index).element;
    }

    @Override
    public T get(T element) {
        Node<T> node = first;
        while (node != null) {
            if (Objects.equals(node.element, element)) {
                return node.element;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public T getFirst() {
        return first.element;
    }

    @Override
    public T getLast() {
        return last.element;
    }

    @Override
    public void set(int index, T element) {
        if (index >= size || index < 0) {
            return;
        }
        Node<T> node = getNode(index);
        node.element = element;
    }

    @Override
    public boolean remove(int index) {
        if (index >= size || index < 0) {
            return false;
        }
        Node<T> node = getNode(index);
        if (index != 0) {
            node.previous.next = node.next;
        }
        if (index < size - 1) {
            node.next.previous = node.previous;
        }
        if (index == 0) {
            first = node.next;
        }
        if (index == size - 1) {
            last = node.previous;
        }
        size--;
        return true;
    }

    @Override
    public boolean contains(T element) {
        Node<T> node = first;
        while (node != null) {
            if (Objects.equals(node.element, element)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
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
        int count = 0;
        Node<T> node = first;
        while (index > count) {
            node = node.next;
            count++;
        }
        return node;
    }


    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> previous;

        public Node(E element) {
            this.element = element;
        }
    }
}

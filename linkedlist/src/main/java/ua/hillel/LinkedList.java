package ua.hillel;

/**
 * Implement doubly linked list that is based on {@link Node<T>} class (you should implement it as well).
 * This is a simplified version of {@link java.util.LinkedList}.
 */
public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Input correct index!");
        }
        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            Node<T> currentNode = getNode(index);
            Node<T> newNode = new Node<>(element);
            newNode.prev = currentNode.prev;
            newNode.next = currentNode;
            currentNode.prev.next = newNode;
            currentNode.prev = newNode;
            size++;
        }
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Input correct index");
        }
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    private void addLast(T element) {
        add(element);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Input correct index!");
        }
        Node<T> currentNode = getNode(index);
        return currentNode.data;
    }

    @Override
    public T get(T element) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(element)) {
                return currentNode.data;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    @Override
    public T getFirst() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (tail == null) {
            return null;
        }
        return tail.data;
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Input correct index!");
        }
        Node<T> currentNode = getNode(index);
        currentNode.data = element;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> currentNode = getNode(index);
        if (head == currentNode) {
            head = currentNode.next;
        }
        if (tail == currentNode) {
            tail = currentNode.prev;
        }
        if (currentNode.prev != null) {
            currentNode.prev.next = currentNode.next;
        }
        if (currentNode.next != null) {
            currentNode.next.prev = currentNode.prev;
        }
        size--;
        return currentNode.data;
    }

    @Override
    public boolean contains(T element) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(element)) {
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
        head = null;
        size = 0;
    }
}
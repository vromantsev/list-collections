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
        private T data;
        private Node<T> prev;
        private Node<T> next;
        public Node(T data) {
            this.data = data;
        }
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<> (element);
        if (isEmpty ()) {
            head = newNode;
            tail = newNode;
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
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            Node<T> newNode = new Node<> (element);
            Node<T> current = getNode(index);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException;
        }
        Node<T> node = getNode(index);
        return node.data;
    }

    @Override
    public T get(T element) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public T getFirst() {
        if (isEmpty ()){
            return null;
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (isEmpty ()) {
            return null;
        }
        return tail.data;
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = getNode(index);
        node.data = element;
    }

    @Override
    public boolean remove(int index) {
        if (index <0 || index >= size) {
            return false;
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node<T> current = getNode(index);
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
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
        head = null;
        tail = null;
        size = 0;
    }
    private void addFirst(T element) {
        Node<T> newNode = new Node<> (element);
        if (isEmpty ()) {
            head = newNode;
            tail = newNode;
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
    private void removeFirst() {
        if (isEmpty ()) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }
    private void removeLast() {
        if (isEmpty ()) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else  {
            tail = tail.next;
            tail.prev = null;
        }
        size--;
    }
    private Node<T> getNode(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}



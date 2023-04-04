package ua.hillel;

import java.util.NoSuchElementException;

/**
 * Implement doubly linked list that is based on {@link Node<T>} class (you should implement it as well).
 * This is a simplified version of {@link java.util.LinkedList}.
 */
public class LinkedList<T> implements List<T> {


    public class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }



        private Node<T> head;
        private Node<T> tail;
        private int size;

        public LinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        @Override
        public void add(T element) {
            Node<T> newNode = new Node<>(element);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.setNext(newNode);
                newNode.setPrev(tail);
                tail = newNode;
            }
            size++;
        }

        @Override
        public void add(int index, T element) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }
            Node<T> newNode = new Node<>(element);
            if (index == 0) {
                newNode.setNext(head);
                head.setPrev(newNode);
                head = newNode;
            } else if (index == size) {
                tail.setNext(newNode);
                newNode.setPrev(tail);
                tail = newNode;
            } else {
                Node<T> current = head;
                for (int i = 0; i < index; i++) {
                    current = current.getNext();
                }
                Node<T> prev = current.getPrev();
                prev.setNext(newNode);
                newNode.setPrev(prev);
                newNode.setNext(current);
                current.setPrev(newNode);
            }
            size++;
        }

        @Override
        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getData();
        }

        @Override
        public T get(T element) {
            Node<T> current = head;
            while (current != null) {
                if (current.getData().equals(element)) {
                    return current.getData();
                }
                current = current.getNext();
            }
            return null;
        }

        @Override
        public T getFirst() {
            if (head == null) {
                throw new NoSuchElementException();
            }
            return head.getData();
        }

        @Override
        public T getLast() {
            if (tail == null) {
                throw new NoSuchElementException();
            }
            return tail.getData();
        }


    @Override
    public void set(int index, T element) {

    }

    @Override
    public boolean remove(int index) {
        return false;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {
            


    }
}

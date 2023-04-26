package ua.hillel;

public class Node<T> {
    Node<T> prev;
    T element;
    Node<T> next;

    public Node(Node<T> prev, T element, Node<T> next) {
        this.prev = prev;
        this.element = element;
        this.next = next;
    }
}

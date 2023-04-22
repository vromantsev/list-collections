package ua.hillel;

public interface List<T> {

    void add(T element);

    void add(int index, T element);

    T get(int index);

    T get(T element);

    T getFirst();

    T getLast();

    void set(int index, T element);

    T remove(int index);

    boolean contains(T element);

    boolean isEmpty();

    int size();

    void clear();

}

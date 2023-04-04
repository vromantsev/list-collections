package ua.hillel;

public class Demo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("apple");
        list.add("banana");
        list.add("orange");

        System.out.println("Size of list: " + list.size());
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());
        System.out.println("Element at index 1: " + list.get(1));
        System.out.println("Removing element at index 1: " + list.remove(1));
        System.out.println("List contains 'banana': " + list.contains("banana"));

        list.clear();

        System.out.println("List is empty: " + list.isEmpty());
    }
}

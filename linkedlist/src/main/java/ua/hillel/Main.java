package ua.hillel;


public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(12);
        list.add(11);

        list.add(1, 123);
        list.set(2, 99);
        System.out.println(list.contains(121));
        list.clear();
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(" " + list.get(i));
        }
    }
}

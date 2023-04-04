package ua.hillel;

public class Demo {

        public static void main(String[] args) {
            LinkedList<String> list = new LinkedList<>();
            list.add("apple");
            list.add("banana");
            list.add("cherry");

            System.out.println( list.size());

            System.out.println( list.get(1));

            System.out.println(list.remove(2));

            System.out.println(list.contains("banana"));

            list.clear();
            System.out.println(list.size());
        }
    }


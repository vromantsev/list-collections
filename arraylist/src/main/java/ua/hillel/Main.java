package ua.hillel;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println(arrayList.size());
        arrayList.add(12);
        arrayList.add(1);
        arrayList.add(32);
        System.out.println(arrayList.size());
        System.out.println(arrayList.getFirst());
       arrayList.clear();
        System.out.println(arrayList.contains(1));
        printElements(arrayList);
        arrayList.set(1, 123);
        printElements(arrayList);
        arrayList.add(2, 421);
        printElements(arrayList);
    }

    private static void printElements(ArrayList<?> arrayList) {
        System.out.print("Array [ ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println(" ]");
    }
}

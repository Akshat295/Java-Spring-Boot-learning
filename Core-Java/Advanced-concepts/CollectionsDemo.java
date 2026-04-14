import java.util.*;

public class CollectionsDemo {

    public static void main(String[] args) {

        // 1. ArrayList (Dynamic Array)
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Mango");

        System.out.println("ArrayList: " + list);

        // Access
        System.out.println("First Element: " + list.get(0));

        // Remove
        list.remove("Banana");

        // Loop
        for (String item : list) {
            System.out.println(item);
        }

        // 2. LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.addFirst(5);

        System.out.println("LinkedList: " + linkedList);

        // 3. HashSet (No duplicates)
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(2); // duplicate ignored

        System.out.println("HashSet: " + set);

        // 4. TreeSet (Sorted)
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(30);
        treeSet.add(10);
        treeSet.add(20);

        System.out.println("TreeSet (Sorted): " + treeSet);

        // 5. HashMap (Key-Value)
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Akshat");
        map.put(2, "Rahul");

        System.out.println("HashMap: " + map);

        // Access value
        System.out.println("Key 1: " + map.get(1));

        // Loop map
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 6. Sorting
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(50);
        numbers.add(10);
        numbers.add(30);

        Collections.sort(numbers);

        System.out.println("Sorted List: " + numbers);
    }
}
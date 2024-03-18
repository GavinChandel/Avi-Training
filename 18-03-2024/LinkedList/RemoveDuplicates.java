package javaBasics.date_18_03_24.LinkedList;

import java.util.LinkedList;

public class RemoveDuplicates {

    public static void removeDuplicates(LinkedList<Integer> list) {
        LinkedList<Integer> uniqueList = new LinkedList<>();

        for (Integer value : list) {
            if (!uniqueList.contains(value)) {
                uniqueList.add(value);
            }
        }
        list.clear();
        list.addAll(uniqueList);
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(3);

        System.out.println("Original Linked List: " + linkedList);
        removeDuplicates(linkedList);
        System.out.println("Linked List after removing duplicates: " + linkedList);
    }
}


package javaBasics.date_18_03_24.LinkedList;

import java.util.LinkedList;

public class SumOfLinkedList {
    public LinkedList<Integer> addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 0;

        while (!l1.isEmpty() || !l2.isEmpty() || carry != 0) {
            int val1 = (!l1.isEmpty()) ? l1.removeLast() : 0;
            int val2 = (!l2.isEmpty()) ? l2.removeLast() : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            result.addFirst(sum % 10);
        }

        return result;
    }

    public static void printLinkedList(LinkedList<Integer> list) {
        for (int num : list) {
            System.out.print(num + " -> ");
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(4);
        l2.add(5);

        SumOfLinkedList solution = new SumOfLinkedList();
        LinkedList<Integer> result = solution.addTwoNumbers(l1, l2);
        printLinkedList(result);
    }
}

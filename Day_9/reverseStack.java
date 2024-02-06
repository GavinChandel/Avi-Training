package javaBasics.day9;
import java.util.Stack;

public class reverseStack{

    public static <T extends Comparable<T>> void sortStack(Stack<T> stack) {
        if (stack.isEmpty()) {
            return; // Base case: empty stack
        }

        T top = stack.pop();
        sortStack(stack); // Sort remaining elements
        insertSorted(stack, top); // Insert top element at its correct position
    }

    private static <T extends Comparable<T>> void insertSorted(Stack<T> stack, T element) {
        if (stack.isEmpty() || element.compareTo(stack.peek()) >= 0) {
            stack.push(element);
            return;
        }

        T temp = stack.pop();
        insertSorted(stack, element);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        sortStack(stack);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}

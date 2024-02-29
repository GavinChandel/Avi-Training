package javaBasics.date_28_02_24;

import java.util.Stack;

public class SimplifyAbsolutePath {
    // Method to simplify the absolute path
    public static String simplifyPath(String A) {
        // If the input path is null or empty, return the root directory "/"
        if (A == null || A.isEmpty()) {
            return "/";
        }

        Stack<String> stack = new Stack<>(); // Create a stack to keep track of directories
        String[] components = A.split("/"); // Split the input path by "/"

        // Traverse through each component of the path
        for (String component : components) {
            if (component.equals("..")) { // If the component is ".."
                if (!stack.isEmpty()) { // If stack is not empty, pop the top directory (move up a level)
                    stack.pop();
                }
            } else if (!component.isEmpty() && !component.equals(".")) { // If the component is not empty or "."
                stack.push(component); // Push valid directory to the stack
            }
        }

        StringBuilder simplifiedPath = new StringBuilder("/"); // Initialize StringBuilder for simplified path
        for (String dir : stack) {
            simplifiedPath.append(dir).append("/"); // Reconstruct simplified path by appending directories
        }

        // Remove trailing slash if not root directory
        if (simplifiedPath.length() > 1) {
            simplifiedPath.setLength(simplifiedPath.length() - 1);
        }

        return simplifiedPath.toString(); // Return the simplified absolute path
    }

    public static void main(String[] args) {
        String absolutePath = "/home//foo/"; // Example absolute path
        System.out.println("Original Path: " + absolutePath);
        System.out.println("Simplified Path: " + simplifyPath(absolutePath)); // Call simplifyPath method and print result
    }
}

package datastructures.stack;

import java.util.*;

/**
 * Stack Implementation
 * 
 * This class contains essential stack operations and algorithms
 * commonly used in technical interviews and competitive programming.
 * 
 * @author DSA Mastery
 * @version 1.0
 */
public class StackOperations {
    
    /**
     * Generic Stack implementation using ArrayList
     * 
     * @param <T> Type of elements in stack
     */
    public static class Stack<T> {
        private List<T> stack;
        
        public Stack() {
            this.stack = new ArrayList<>();
        }
        
        /**
         * Push element onto stack
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @param item Element to push
         */
        public void push(T item) {
            stack.add(item);
        }
        
        /**
         * Pop element from stack
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Top element
         * @throws EmptyStackException if stack is empty
         */
        public T pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return stack.remove(stack.size() - 1);
        }
        
        /**
         * Peek at top element without removing
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Top element
         * @throws EmptyStackException if stack is empty
         */
        public T peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return stack.get(stack.size() - 1);
        }
        
        /**
         * Check if stack is empty
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return True if empty, false otherwise
         */
        public boolean isEmpty() {
            return stack.isEmpty();
        }
        
        /**
         * Get size of stack
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Number of elements in stack
         */
        public int size() {
            return stack.size();
        }
        
        /**
         * Convert stack to array
         * 
         * Time Complexity: O(n)
         * Space Complexity: O(n)
         * 
         * @return Array representation of stack
         */
        public Object[] toArray() {
            return stack.toArray();
        }
    }
    
    /**
     * MinStack implementation that supports O(1) min operation
     */
    public static class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        
        public MinStack() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }
        
        /**
         * Push element onto stack
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @param val Value to push
         */
        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }
        
        /**
         * Pop element from stack
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Top element
         */
        public int pop() {
            int val = stack.pop();
            if (val == minStack.peek()) {
                minStack.pop();
            }
            return val;
        }
        
        /**
         * Get top element
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Top element
         */
        public int top() {
            return stack.peek();
        }
        
        /**
         * Get minimum element
         * 
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         * 
         * @return Minimum element
         */
        public int getMin() {
            return minStack.peek();
        }
    }
    
    /**
     * Check if parentheses are valid
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param s String containing parentheses
     * @return True if valid, false otherwise
     */
    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    /**
     * Find next greater element for each element
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param nums Input array
     * @return Array of next greater elements
     */
    public static int[] nextGreaterElement(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }
    
    /**
     * Find next greater element in circular array
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param nums Input array
     * @return Array of next greater elements
     */
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            result[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return result;
    }
    
    /**
     * Find daily temperatures (days until warmer temperature)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param temperatures Array of temperatures
     * @return Array of days until warmer temperature
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
    
    /**
     * Find largest rectangle in histogram
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param heights Array of heights
     * @return Area of largest rectangle
     */
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];
            
            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
    
    /**
     * Calculate trapped rain water
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param height Array of heights
     * @return Amount of trapped water
     */
    public static int trap(int[] height) {
        if (height.length < 3) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                
                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                water += distance * boundedHeight;
            }
            stack.push(i);
        }
        return water;
    }
    
    /**
     * Evaluate postfix expression
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param tokens Postfix expression tokens
     * @return Result of expression
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    
    /**
     * Convert infix to postfix expression
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param infix Infix expression
     * @return Postfix expression
     */
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Remove '('
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }
    
    /**
     * Get precedence of operator
     * 
     * @param op Operator
     * @return Precedence value
     */
    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
    
    /**
     * Basic Calculator (supports +, -, (, ))
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param s Expression string
     * @return Result of expression
     */
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // sign
                result += stack.pop(); // previous result
            }
        }
        return result + sign * number;
    }
    
    /**
     * Main method for testing stack operations
     */
    public static void main(String[] args) {
        System.out.println("=== Stack Operations Examples ===");
        
        // Test basic stack operations
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack: " + Arrays.toString(stack.toArray()));
        System.out.println("Top: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size());
        
        // Test MinStack
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Min: " + minStack.getMin());
        minStack.pop();
        System.out.println("Top: " + minStack.top());
        System.out.println("Min: " + minStack.getMin());
        
        // Test parentheses validation
        System.out.println("Valid parentheses '()[]{}': " + isValidParentheses("()[]{}"));
        System.out.println("Valid parentheses '([)]': " + isValidParentheses("([)]"));
        
        // Test next greater element
        int[] nums = {2, 1, 2, 4, 3, 1};
        int[] nextGreater = nextGreaterElement(nums);
        System.out.println("Next greater elements: " + Arrays.toString(nextGreater));
        
        // Test daily temperatures
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] dailyTemps = dailyTemperatures(temperatures);
        System.out.println("Daily temperatures: " + Arrays.toString(dailyTemps));
        
        // Test largest rectangle
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest rectangle area: " + largestRectangleArea(heights));
        
        // Test trapped water
        int[] trapHeights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped water: " + trap(trapHeights));
        
        // Test postfix evaluation
        String[] postfix = {"2", "1", "+", "3", "*"};
        System.out.println("Postfix evaluation: " + evalRPN(postfix));
        
        // Test infix to postfix
        String infix = "a+b*c-d/e";
        System.out.println("Infix to postfix: " + infixToPostfix(infix));
        
        // Test basic calculator
        String expression = "1 + 1";
        System.out.println("Basic calculator: " + calculate(expression));
    }
}

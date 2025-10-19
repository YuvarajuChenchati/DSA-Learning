# Stacks 📚

> **Master stack operations and common stack-based algorithms**

## 🎯 Learning Objectives

- Understand stack fundamentals
- Master stack operations
- Learn stack-based algorithms
- Apply stack patterns to solve problems

## 📚 Theory

### Stack Basics

#### Properties
- **LIFO**: Last In, First Out principle
- **Dynamic size**: Can grow and shrink during runtime
- **Sequential access**: Only access top element
- **Memory efficient**: Only stores necessary elements

#### Common Operations
- **Push**: O(1) time - add element to top
- **Pop**: O(1) time - remove element from top
- **Peek/Top**: O(1) time - view top element
- **IsEmpty**: O(1) time - check if stack is empty
- **Size**: O(1) time - get number of elements

### Stack Applications

#### Expression Evaluation
- **Infix to Postfix**: Convert infix expressions
- **Postfix Evaluation**: Evaluate postfix expressions
- **Prefix Evaluation**: Evaluate prefix expressions

#### Parentheses Matching
- **Valid Parentheses**: Check if parentheses are balanced
- **Nested Parentheses**: Handle nested structures

#### Monotonic Stack
- **Next Greater Element**: Find next greater element
- **Largest Rectangle**: Find largest rectangle in histogram
- **Trapping Rain Water**: Calculate trapped water

## 🔧 Implementation

### Basic Stack Operations

```java
// Stack using ArrayList
public class Stack<T> {
    private List<T> stack;
    
    public Stack() {
        this.stack = new ArrayList<>();
    }
    
    public void push(T item) {
        stack.add(item);
    }
    
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }
    
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    
    public int size() {
        return stack.size();
    }
}
```

### Monotonic Stack

```java
// Next greater element using monotonic stack
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
```

## 📝 Practice Problems

### Easy
1. **Valid Parentheses** - O(n) time, O(n) space
2. **Min Stack** - O(1) time for all operations
3. **Implement Queue using Stacks** - O(1) amortized time
4. **Implement Stack using Queues** - O(n) time for pop
5. **Baseball Game** - O(n) time, O(n) space

### Medium
1. **Daily Temperatures** - O(n) time, O(n) space
2. **Next Greater Element I** - O(n) time, O(n) space
3. **Next Greater Element II** - O(n) time, O(n) space
4. **Largest Rectangle in Histogram** - O(n) time, O(n) space
5. **Trapping Rain Water** - O(n) time, O(n) space

### Hard
1. **Basic Calculator** - O(n) time, O(n) space
2. **Basic Calculator II** - O(n) time, O(n) space
3. **Basic Calculator III** - O(n) time, O(n) space
4. **Remove Duplicate Letters** - O(n) time, O(n) space
5. **Create Maximum Number** - O(n²) time, O(n) space

## 💡 Key Insights

- **LIFO principle**: Last in, first out
- **Monotonic stack**: Maintains monotonic order
- **Expression evaluation**: Use stack for postfix/prefix
- **Parentheses matching**: Natural stack application
- **Histogram problems**: Use monotonic stack

## 🎯 Interview Tips

- Think about LIFO when solving problems
- Use stack for expression evaluation
- Apply monotonic stack for next greater/smaller problems
- Consider space complexity for stack operations
- Use stack for backtracking problems

## 📚 Additional Resources

- [Stack Data Structure](https://www.geeksforgeeks.org/stack-data-structure/)
- [Monotonic Stack](https://www.geeksforgeeks.org/next-greater-element/)
- [Expression Evaluation](https://www.geeksforgeeks.org/expression-evaluation/)
- [Stack Applications](https://www.geeksforgeeks.org/applications-of-stack-data-structure/)

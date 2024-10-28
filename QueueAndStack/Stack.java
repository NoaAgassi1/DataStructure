package QueueAndStack;

import java.util.ArrayList;

class Stack<T> {
    private ArrayList<T> stack;
    private int size = 0;

    public Stack(int capacity) {
        stack = new ArrayList<>(capacity);
    }

    public Stack() {
        stack = new ArrayList<>();
    }

    public void push(T element) {
        stack.add(size, element);
        size++;
    }

    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Queue.Stack is empty");
        }
        size--;
        return stack.remove(size);
    }

    public T top() {
        if (size == 0) {
            throw new IllegalStateException("Queue.Stack is empty");
        }
        return stack.get(size - 1);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
    }


    public String toString() {
        return stack.toString(); // החזרת התוכן של המחסנית כמחרוזת
    }
}
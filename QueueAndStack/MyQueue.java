package QueueAndStack;

import java.util.NoSuchElementException;

public class MyQueue<TypeName> {
    private TypeName[] arr;  // array to store queue elements
    private int size;       // size of the queue
    private int head;       // front points to front element in the queue

    public static void main(String[] args) {
        String st = "abba";
        System.out.println(isPalindrom(st));
    }


    public MyQueue(int size){
        this.arr = (TypeName[]) new Object[size];
        this.size = 0;
        this.head = 0;
    }

    public void enQueue(TypeName element) {
        ensureCapacity();
        arr[(head + size) % arr.length] = element;
        size ++;
    }

    private void ensureCapacity() {
        if (size >= arr.length){
            TypeName [] n = (TypeName[]) new Object[2*arr.length+1];
            for (int i = 0; i <arr.length ; i++) {
                n[i] = arr[i];
            }
            this.arr = (TypeName[]) n;
        }
    }

    // Utility function to remove front element from the queue
    public TypeName deQueue() {
        if (arr.length == 0){
            throw new NoSuchElementException("No elements present in Stack");
        }
        TypeName ans = arr[head];
        size--;
        head = (head + 1) % arr.length; // Next Position
        return ans;
    }

    /* Returns the FIRST element in the queue */
    public TypeName peek() {
        if (arr.length == 0){
            throw new NoSuchElementException("No elements present in Stack");
        }
        return arr[head];
    }

    /* returns true iff the element is in the queue */
    public boolean contains(TypeName element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]== element){
                return true;
            }
        }
        return false;
    }

    /* Returns the size of the queue */
    public int size() { return size; }

    /* Returns string that represent the stack */
    public String toString()  {
        String ans = "The queue: [ <- ";
        for(int i=head; i<size; i++) {
            ans += arr[i];
            if(i != size - 1)
                ans += ", ";
        }
        return ans += "]";
    }
    public boolean isEmpty(){
        return size ==0;
    }

    public static boolean isPalindrom(String st){
        Stack<Character> stack = new Stack<>();
        MyQueue<Character> queue = new MyQueue<>(st.length());
        for (int i = 0; i < st.length(); i++) {
            stack.push(st.charAt(i));
            queue.enQueue(st.charAt(i));
        }
       while (!stack.isEmpty()){
           if (stack.pop() != queue.deQueue())
            return false;
        }
        return queue.isEmpty() && stack.isEmpty();
    }


}
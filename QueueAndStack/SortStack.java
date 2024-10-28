package QueueAndStack;//import java.util.Stack;

public class SortStack<T extends Comparable<T>> extends Stack<T> {

    public SortStack(int capacity) {
        super(capacity);
    }


    public static void main(String[] args) {
        double input = 246.642;
        boolean ans = Question3(input);
        System.out.println(ans);

        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        SortStack<Integer> sortStack = new SortStack<>(stack.getSize());
        Stack<Integer> sortedStack = sortStack.sortStack1(stack);
        System.out.println(sortedStack); // Expected sorted stack
    }


    public Stack<T> sortStack1(Stack<T> input) {
        Stack<T> helperStack = new Stack<>(input.getSize());
        while (!input.isEmpty()) {
            T curr = input.pop();
            while (!helperStack.isEmpty() && helperStack.top().compareTo(curr) > 0) {
                input.push(helperStack.pop());
            }
            helperStack.push(curr);
        }
        return helperStack;
    }

    private static boolean Question3(double input) {
        Stack<Character> s = new Stack<>();
        String inputString = input + "";
        System.out.println(inputString);

        int index = inputString.indexOf('.') + 1;

        for(int i=0; inputString.charAt(i) != '.' ; i++)
            s.push(inputString.charAt(i));

        for(int i=index; i<inputString.length(); i++)
            if(s.pop() != inputString.charAt(i)) return false;

        return s.isEmpty();
    }
}

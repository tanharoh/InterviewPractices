import java.util.Stack;

/**
 * Created by ilyar on 17-10-20
 */
public class A05_SortStackByStack {

    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() > cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }

        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(7);
        stack.push(2);
        stack.push(9);

        System.out.println("stack: " + stack);

        sortStackByStack(stack);

        System.out.println("stack: " + stack);

    }
}

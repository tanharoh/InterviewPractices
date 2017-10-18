import java.util.Stack;

/**
 * Created by ilyar on 17-10-18
 */
public class A03_ReverseStackByRecusion {
    private static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }


    private static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        reverse(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());



    }
}

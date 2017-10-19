import java.util.Stack;

/**
 * Created by ilyar on 17-10-18
 */
public class A03_ReverseStackByRecursion {
    private static int getAndRemoveLastElement(Stack<Integer> stack, int removeCount) {
        System.out.println("Remove: stack = " + stack + ", removeCount = " + removeCount);
        removeCount++;
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }else {
            int last = getAndRemoveLastElement(stack, removeCount);
            stack.push(result);
            return last;
        }
    }


    private static void reverse(Stack<Integer> stack, int reverseCount) {
        System.out.println("ReverseA: stack = " + stack + ", reverseCount = " + reverseCount);
        reverseCount++;
        if (stack.isEmpty()) {
            return;
        }
        int removeCount = 1;
        int i = getAndRemoveLastElement(stack, removeCount);
        reverse(stack, reverseCount);
        stack.push(i);
        System.out.println("ReverseB: stack = " + stack + ", reverseCount = " + reverseCount);
    }


    public static void main(String[] args) {
        System.out.println("main");

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        int reverseCount = 1;
        reverse(stack, reverseCount);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        
    }
}

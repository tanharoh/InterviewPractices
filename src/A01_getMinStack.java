import java.util.Stack;

/**
 * Created by ilyar on 17-10-16
 * 有getMin功能的栈
 * 压栈: stackData 压入所有新数字，stackMin只压入比栈中小的数字
 * 弹栈: 如果stackData和stackMin栈顶中的元素相同则都弹栈，反之只有stackData弹栈
 */
public class A01_getMinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public A01_getMinStack() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum) {
        if (this.stackMin.empty() || newNum <= this.getMin()) {
            this.stackMin.push(newNum);
        }
        stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("ERROR: StackData is empty.");
        }
        int value = this.stackData.pop();
        if (value == this.
                getMin()) {
            this.stackMin.pop();
        }
        return value;
    }

    private int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("ERROR: StackMin is empty.");
        }
        return this.stackMin.peek();
    }


    public static void main(String args[]){
        System.out.println("test");
        A01_getMinStack getMinStack = new A01_getMinStack();
        int nums[] = {4, 9, 2, 5, 1};
        for (int num: nums) {
            getMinStack.push(num);
        }

        System.out.println(getMinStack.getMin());

        getMinStack.pop();

        System.out.println(getMinStack.getMin());

    }
}

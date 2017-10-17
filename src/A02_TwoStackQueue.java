import java.util.Stack;

/**
 * Created by ilyar on 17-10-17
 * 用两个栈实现队列，支持队列基本操作, add poll peek
 * 只有stackPush输入数据
 * 只有stackPop输出数据
 * stackPop 压入从stackPush弹出的数据
 */
public class A02_TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public A02_TwoStackQueue() {
        this.stackPush = new Stack<Integer>();
        this.stackPop = new Stack<Integer>();
    }

    public void add(int newNum) {
        stackPush.push(newNum);
    }

    public int poll() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("ERROR: Queue is empty.");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("ERROR: Queue is empty...");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        A02_TwoStackQueue twoStackQueue = new A02_TwoStackQueue();
        twoStackQueue.add(1);
        twoStackQueue.add(2);
        twoStackQueue.add(3);

        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.peek());
        System.out.println(twoStackQueue.peek());
    }
}

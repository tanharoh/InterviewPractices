package A08_GetMaxTree;

import java.util.HashMap;
import java.util.Stack;

public class GetMaxTree {
    public static Node getMaxTree(int[] arr) {
        int arr_len = arr.length;
        Node[] nodeArr = new Node[arr_len];
        for (int i = 0; i < arr_len; i++) {
            nodeArr[i] = new Node(arr[i]);
        }
        Stack<Node> stack = new Stack<>();
        HashMap<Node, Node> lBigMap = new HashMap<>();
        HashMap<Node, Node> rBigMap = new HashMap<>();
        for (Node curNode : nodeArr) {
            while (!stack.isEmpty() && stack.peek().value < curNode.value) {
                popStackSetMap(stack, lBigMap);
            }
            stack.push(curNode);
        }

        while (!stack.isEmpty()) {
            popStackSetMap(stack, lBigMap);
        }

        for (int i = nodeArr.length - 1; i != -1; i--) {
            Node curNode = nodeArr[i];
            while (!stack.isEmpty() && stack.peek().value < curNode.value) {
                popStackSetMap(stack, rBigMap);
            }
            stack.push(curNode);
        }

        while (!stack.isEmpty()) {
            popStackSetMap(stack, rBigMap);
        }

        Node head = null;

        for (int i = 0; i != nodeArr.length; i++) {
            Node curNode = nodeArr[i];
            Node left = lBigMap.get(curNode);
            Node right = rBigMap.get(curNode);
            if (left == null & right == null) {
                head = curNode;
            } else if (left == null) {
                if (right.left == null) {
                    right.left = curNode;
                } else {
                    right.right = curNode;
                }
            } else if (right == null) {
                if (left.left == null) {
                    left.left = curNode;
                } else {
                    left.right = curNode;
                }
            } else {
                Node parrent = left.value < right.value ? left : right;
                if (parrent.left == null) {
                    parrent.left = curNode;
                } else {
                    parrent.right = curNode;
                }
            }
        }

        return head;
    }

    private static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
        Node popNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popNode, null);
        } else {
            map.put(popNode, stack.peek());
        }
    }

    public static void printNode(Node node) {
        int value = node.value;
        Node left = node.left;
        Node right = node.right;


    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2};
        System.out.println(getMaxTree(arr).value);
    }

}
